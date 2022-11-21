package com.ipartek.formacion.mf0966ejemplo.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.ipartek.formacion.mf0966ejemplo.modelos.Categoria;
import com.ipartek.formacion.mf0966ejemplo.modelos.Cliente;
import com.ipartek.formacion.mf0966ejemplo.modelos.Empleado;
import com.ipartek.formacion.mf0966ejemplo.modelos.Factura;
import com.ipartek.formacion.mf0966ejemplo.modelos.Factura.Linea;
import com.ipartek.formacion.mf0966ejemplo.controladores.Globales;


public class DaoMysqlFacturas  implements Dao<Factura> {
	
	private static final String SQL_SELECT_ALL = "SELECT f.id,f.codigo,f.fecha,f.clientes_id,f.empleados_id FROM facturas f ";
	private static final String SQL_SELECT_LINEAS_FACTURA = "SELECT fp.facturas_id,fp.productos_id,fp.cantidad from facturas_has_productos fp, facturas f "
															+ "where fp.facturas_id=f.id and f.id=?";
	private static final String SQL_SELECT_ID = "SELECT f.id, f.codigo, f.fecha, f.clientes_id,f.empleados_id"
												+ " FROM facturas f where f.id=?";

	// SINGLETON

	private DaoMysqlFacturas() {
	}

	private static final DaoMysqlFacturas INSTANCIA = new DaoMysqlFacturas();

	public static DaoMysqlFacturas getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON
	public Iterable<Factura> obtenerTodos(){
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ALL)) {
			
			
			ResultSet rs = pst.executeQuery();
			
			Factura fact = null;
			ArrayList<Factura> li = new ArrayList();
			Set<Linea>lineas = new HashSet<>();
			Linea lin;
			
			while(rs.next()) {		
				fact = new Factura(rs.getLong("f.id"),rs.getString("f.codigo"),rs.getDate("f.fecha").toLocalDate(),
						Globales.DAO_CLIENTE.obtenerPorId(rs.getLong("f.clientes_id")),
						Globales.DAO_EMPLEADO.obtenerPorId(rs.getLong("f.empleados_id")),lineas);
				
				
				PreparedStatement pst2 = con.prepareStatement(SQL_SELECT_LINEAS_FACTURA);
				pst2.setLong(1, rs.getLong("f.id"));
				ResultSet rs2 = pst2.executeQuery();
				while(rs2.next()) {
					lin = new Linea(obtenerPorId(rs2.getLong("fp.facturas_id")),Globales.DAO_PRODUCTO.obtenerPorId(rs2.getLong("fp.productos_id")),rs2.getInt("fp.cantidad"));
					fact.getLineas().add(lin);
				}
				li.add(fact);
			}
			
			return li;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el producto", e);
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
						Globales.DAO_EMPLEADO.obtenerPorId(rs.getLong("f.empleados_id")),null);
			}
			
			return em;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el producto", e);
		}
	}
}
