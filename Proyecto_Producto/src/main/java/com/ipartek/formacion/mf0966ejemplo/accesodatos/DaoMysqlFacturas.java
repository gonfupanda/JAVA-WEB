package com.ipartek.formacion.mf0966ejemplo.accesodatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.ipartek.formacion.mf0966ejemplo.modelos.Factura;
import com.ipartek.formacion.mf0966ejemplo.modelos.Factura.Linea;
import com.ipartek.formacion.mf0966ejemplo.carrito.InicializarCarrito.Lista;
import com.ipartek.formacion.mf0966ejemplo.controladores.Globales;


public class DaoMysqlFacturas  implements Dao<Factura> {
	
	private static final String SQL_SELECT_ALL = "SELECT f.id,f.codigo,f.fecha,f.clientes_id,f.empleados_id FROM facturas f ";
	private static final String SQL_SELECT_LINEAS_FACTURA = "SELECT fp.facturas_id,fp.productos_id,fp.cantidad from facturas_has_productos fp, facturas f "
															+ "where fp.facturas_id=f.id and f.id=?";
	private static final String SQL_SELECT_ID = "SELECT f.id, f.codigo, f.fecha, f.clientes_id,f.empleados_id"
												+ " FROM facturas f where f.id=?";
	
	
	private static final String SQL_INSERT = "INSERT INTO facturas (codigo, fecha, clientes_id, empleados_id) VALUES (?,?,?,?)";
	private static final String SQL_INSERT_LINEA = "INSERT INTO facturas_has_productos (facturas_id, productos_id, cantidad) VALUES (?,?,?)";
	

	private static final String GET_LAST_COD = "SELECT codigo FROM facturas order by id desc limit 1";
	private static final String SQL_ULTIMO_CODIGO = "SELECT MAX(codigo) FROM facturas WHERE SUBSTRING(codigo, 1, 4) = ?";


	
	private static final String PROD_EXCEPTION = "No se ha podido obtener el producto";
	// SINGLETON

	private DaoMysqlFacturas() {
	}

	private static final DaoMysqlFacturas INSTANCIA = new DaoMysqlFacturas();

	public static DaoMysqlFacturas getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON
	@Override
	public Iterable<Factura> obtenerTodos(){
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ALL)) {
			
			
			ResultSet rs = pst.executeQuery();
			
			Factura fact = null;
			ArrayList<Factura> li = new ArrayList<>();

			
			while(rs.next()) {		
				fact = new Factura(rs.getLong("f.id"),rs.getString("f.codigo"),rs.getDate("f.fecha").toLocalDate(),
						Globales.DAO_CLIENTE.obtenerPorId(rs.getLong("f.clientes_id")),
						Globales.DAO_EMPLEADO.obtenerPorId(rs.getLong("f.empleados_id")));		
				li.add(fact);
			}
			
			return li;
		} catch (SQLException e) {
			throw new AccesoDatosException(PROD_EXCEPTION, e);
		}
		
	}
	
	@Override
	public Factura obtenerPorId(Long id) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID)) {
			pst.setLong(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			Factura em = null;
			
			if(rs.next()) {
				em = new Factura(rs.getLong("f.id"),rs.getString("f.codigo"),rs.getDate("f.fecha").toLocalDate(),
						Globales.DAO_CLIENTE.obtenerPorId(rs.getLong("f.clientes_id")),
						Globales.DAO_EMPLEADO.obtenerPorId(rs.getLong("f.empleados_id")));
			}
			
			return em;
		} catch (SQLException e) {
			throw new AccesoDatosException(PROD_EXCEPTION, e);
		}
	}
	@Override
	public Set<Linea> obtenerLineas(Long id){
		Set<Linea>lineas = new HashSet<>();
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_LINEAS_FACTURA)) {
			Linea lin;

			pst.setLong(1,id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				lin = new Linea(obtenerPorId(rs.getLong("fp.facturas_id")),Globales.DAO_PRODUCTO.obtenerPorId(rs.getLong("fp.productos_id")),rs.getInt("fp.cantidad"));
				lineas.add(lin);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException(PROD_EXCEPTION, e);
		}
		
		return lineas;
		
	}
	
	@Override
	public synchronized  Factura insertar(Factura factura) {
		try (Connection con = getConexion()) {
			
			factura.setFecha(LocalDate.now());
			factura.setCodigo(nuevoCodigoFactura(con, factura));
			return insertarImpl(factura, con);
			
		} catch(Exception e) {
			throw new AccesoDatosException("No se ha podido insertar la factura", e);
		}
	}
	private Factura insertarImpl(Factura factura, Connection con) {
		try (PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
			con.setAutoCommit(false);
			con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

			pst.setString(1, newCodigo());
			pst.setDate(2, java.sql.Date.valueOf(factura.getFecha()));
			pst.setLong(3, factura.getCliente().getId());
			pst.setLong(4, factura.getEmpleado().getId());

			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();

			rs.next();

			factura.setId(rs.getLong(1));

			insertarLineasImpl(factura, con);

			con.commit();

		} catch (SQLException e) {
			deshacerTransaccion(con);
		}

		return factura;
	}
	
	private void insertarLineasImpl(Factura factura, Connection con) throws SQLException {
		try (PreparedStatement pstLinea = con.prepareStatement(SQL_INSERT_LINEA)) {
			pstLinea.setLong(1, factura.getId());

			for (Lista linea : factura.getLineas()) {
				pstLinea.setLong(2, linea.getProd().getId());
				pstLinea.setInt(3, linea.getCantidad());

				pstLinea.executeUpdate();
			}
		}
	}

	private void deshacerTransaccion(Connection con) {
		try {
			con.rollback();
		} catch (SQLException ex) {
			throw new AccesoDatosException("No se ha podido deshacer la transacción", ex);
		}
	}
	
	private String newCodigo() {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(GET_LAST_COD)) {
			
			ResultSet rs = pst.executeQuery();
			
			rs.next();
			String oldCod=rs.getString("codigo");
			
			String[] parts = oldCod.split("-");
			String part1 = parts[0]; // 004
			String part2 = parts[1]; // 034556
			
			int year = LocalDate.now().getYear();
			if(Integer.parseInt(part1)<year) {
				part1=String.valueOf(year);
				part2="000";
			}else {
				int a=Integer.parseInt(part2)+1;
				if(a<10) {
					part2="00"+a;
				}else if(a<100) {
					part2="0"+a;
				}else {
					part2=""+a;
				}
				
			}
			
			return part1 +"-"+ part2;

		
		} catch (SQLException e) {
			throw new AccesoDatosException(PROD_EXCEPTION, e);
		}
		
	}
	
	private String nuevoCodigoFactura(Connection con, Factura factura) {
		String codigo = ultimoCodigoFactura(con, factura);

		if(codigo == null) {
			return factura.getFecha().getYear() + "-001";
		}

		String numeroTexto = codigo.substring(5);
		int numero = Integer.parseInt(numeroTexto);
		numero++;

		return String.format("%tY-%03d", factura.getFecha(), numero);
	}

	private String ultimoCodigoFactura(Connection con, Factura factura) {
		try (PreparedStatement pst = con.prepareStatement(SQL_ULTIMO_CODIGO)) {
			pst.setString(1, String.valueOf(factura.getFecha().getYear()));

			ResultSet rs = pst.executeQuery();

			if(rs.next()) {
				return rs.getString(1);
			}

			return null;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido buscar el último código de factura", e);
		}
	}
}
