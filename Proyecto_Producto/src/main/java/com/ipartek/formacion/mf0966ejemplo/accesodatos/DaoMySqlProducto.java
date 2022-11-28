package com.ipartek.formacion.mf0966ejemplo.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.mf0966ejemplo.modelos.Categoria;
import com.ipartek.formacion.mf0966ejemplo.modelos.Producto;

public class DaoMySqlProducto implements Dao<Producto> {

	private static final String SQL_SELECT_ID = "SELECT p.id, p.nombre, p.precio, p.descripcion, c.id, c.nombre, c.descripcion FROM productos p, categorias c WHERE p.categorias_id = c.id AND p.id = ?";
	private static final String SQL_INSERT = "INSERT INTO productos (id, nombre,precio,descripcion,categorias_id) VALUES ( null,?,?,?,?)";
	private static final String SQL_UPDATE_PROD = "UPDATE productos SET nombre=?,precio=?,descripcion=?,categorias_id=? WHERE id=?";
	private static final String SQL_SELECT_ALL = "SELECT p.id,p.nombre,p.precio,p.descripcion,p.categorias_id FROM productos p ";
	private static final String SQL_DELETE_PROD = "DELETE  FROM productos p  WHERE id=?";
	private static final String SQL_LAST_NUM_PROD = "SELECT id  FROM productos order by id desc limit 1";
	
	private static final String PROD_EXCEPTION = "No se ha podido obtener el producto";
	
	// SINGLETON

	private DaoMySqlProducto() {
	}

	private static final DaoMySqlProducto INSTANCIA = new DaoMySqlProducto();

	public static DaoMySqlProducto getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON
	@Override
	public Iterable<Producto> obtenerTodos(){
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ALL)) {
			
			
			ResultSet rs = pst.executeQuery();
			
			Producto producto = null;
			ArrayList<Producto> li = new ArrayList<>();
			
			while(rs.next()) {
				Categoria categoria = new Categoria(rs.getLong("p.categorias_id"), null, null);
				producto = new Producto(rs.getLong("p.id"), rs.getString("p.nombre"), rs.getBigDecimal("p.precio"), rs.getString("p.descripcion"), categoria);
				li.add(producto);
			}
			
			return li;
		} catch (SQLException e) {
			throw new AccesoDatosException(PROD_EXCEPTION, e);
		}
		
	}

	@Override
	public Producto obtenerPorId(Long id) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID)) {
			pst.setLong(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			Producto producto = null;
			
			if(rs.next()) {
				Categoria categoria = new Categoria(rs.getLong("c.id"), rs.getString("c.nombre"), rs.getString("c.descripcion"));
				producto = new Producto(rs.getLong("p.id"), rs.getString("p.nombre"), rs.getBigDecimal("p.precio"), rs.getString("p.descripcion"), categoria);
			}
			
			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException(PROD_EXCEPTION, e);
		}
	}
	@Override
	public Producto insertar(Producto objeto) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT)) {
			
			pst.setString(1, objeto.getNombre());
			pst.setDouble(2, objeto.getPrecio().doubleValue());
			pst.setString(3, objeto.getDescripcion());
			pst.setLong(4, objeto.getCategoria().getId());
			
			pst.executeUpdate();
			

		} catch (SQLException e) {
			throw new AccesoDatosException(PROD_EXCEPTION, e);
		}
		return objeto;
	}
	@Override
	public Producto modificar(Producto objeto) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE_PROD)) {
			
			pst.setString(1, objeto.getNombre());
			pst.setDouble(2, objeto.getPrecio().doubleValue());
			pst.setString(3, objeto.getDescripcion());
			pst.setLong(4, objeto.getCategoria().getId());
			
			pst.setLong(5, objeto.getId());
			
			pst.executeUpdate();
			

		} catch (SQLException e) {
			throw new AccesoDatosException(PROD_EXCEPTION, e);
		}
		return objeto;
	}
	
	@Override
	public void borrar(Long id) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE_PROD)) {
			pst.setLong(1, id);

			pst.executeUpdate();		

		} catch (SQLException e) {
			throw new AccesoDatosException(PROD_EXCEPTION, e);
		}
	
		
		
	}
	@Override
	public int obtenerNumProd() {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_LAST_NUM_PROD)) {

			ResultSet rs=pst.executeQuery();
			int i=0;
			if(rs.next()) {
				i=rs.getInt("id");
			}
			return i;
			

		} catch (SQLException e) {
			throw new AccesoDatosException(PROD_EXCEPTION, e);
		}
	}
	
}
