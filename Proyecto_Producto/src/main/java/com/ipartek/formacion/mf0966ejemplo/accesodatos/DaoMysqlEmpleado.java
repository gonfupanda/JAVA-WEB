package com.ipartek.formacion.mf0966ejemplo.accesodatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.mf0966ejemplo.modelos.Empleado;

public class DaoMysqlEmpleado implements DAOEmpleado {
	
	private static final String SQL_SELECT_ID_FACTURAS = "SELECT e.id, e.nombre, e.nif, e.jefe_id FROM empleados e, facturas f "
											+ "WHERE f.empleados_id = e.id "
											+ "AND e.id = ?";
	
	private static final String SQL_SELECT_ID = "SELECT id, nombre, nif, jefe_id FROM empleados WHERE id = ?";
	

	private static final String SQL_INSERT = "call mf0966ejemplo.empleados_insertar(?,?,?)";
	private static final String SQL_UPDATE = "call mf0966ejemplo.empleados_modificar(?,?,?,?)";
	private static final String SQL_DELETE = "call mf0966ejemplo.empleados_borrar(?)";
	private static final String SQL_SELECT = "call mf0966ejemplo.empleados_obtener_todos()";

	// SINGLETON

	private DaoMysqlEmpleado() {
	}

	private static final DaoMysqlEmpleado INSTANCIA = new DaoMysqlEmpleado();

	public static DaoMysqlEmpleado getInstancia() {
		return INSTANCIA;
	}
	//////
	
	@Override
	public Empleado obtenerPorIdFacturas(Long id) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID_FACTURAS)) {
			pst.setLong(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			Empleado em = null;
			
			if(rs.next()) {
				em = new Empleado(rs.getLong("e.id"),rs.getString("e.nombre"),rs.getString("e.nif"),null);
			}
			
			return em;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el producto", e);
		}
	}
	@Override
	public Empleado obtenerPorId(Long id) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID)) {
			pst.setLong(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			Empleado em = null;
			
			if(rs.next()) {
				em = new Empleado(rs.getLong("id"),rs.getString("nombre"),rs.getString("nif"),obtenerPorId(rs.getLong("jefe_id")));
			}
			
			return em;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el producto", e);
		}
	}
	@Override
	public Iterable<Empleado> obtenerTodos() {
		try (Connection con = getConexion();
				CallableStatement cst = con.prepareCall(SQL_SELECT);
				ResultSet rs = cst.executeQuery()) {

			ArrayList<Empleado> empleados = new ArrayList<>();
			
			Empleado e;
			Empleado j;

			while (rs.next()) {
				j = new Empleado(rs.getLong("j.id"), rs.getString("j.nombre"), rs.getString("j.nif"), null);
				e = new Empleado(rs.getLong("e.id"), rs.getString("e.nombre"), rs.getString("e.nif"), j);
				
				empleados.add(e);
			}
			
			return empleados;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener todos los registros", e);
		}
	}
	private Empleado obtenerEmpleado(CallableStatement cst, ResultSet rs) throws SQLException {
		boolean tieneJefe;

		if (!rs.next()) {
			return null;
		}
		
		Empleado empleado = new Empleado(rs.getLong("e_id"), rs.getString("e_nombre"), rs.getString("e_nif"), null);
		
		rs.close();

		tieneJefe = cst.getMoreResults();
		
		if(!tieneJefe) {
			return empleado;
		}
		
		rs = cst.getResultSet();

		empleado.setJefe(obtenerEmpleado(cst, rs));
		
		return empleado; 
	}
	
	@Override
	public Empleado insertar(Empleado empleado) {
		try (Connection con = getConexion(); CallableStatement cst = con.prepareCall(SQL_INSERT);) {
			cst.setString(1, empleado.getNombre());
			cst.setString(2, empleado.getNif());
			cst.setLong(3, empleado.getJefe().getId());
			
			ResultSet rs = cst.executeQuery();
			
			if(rs.next()) {
				empleado.setId(rs.getLong(1));
			}
				
			return empleado;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido insertar el empleado", e);
		}
	}
	@Override
	public Empleado modificar(Empleado empleado) {
		try (Connection con = getConexion(); CallableStatement cst = con.prepareCall(SQL_UPDATE);) {
			cst.setString(1, empleado.getNombre());
			cst.setString(2, empleado.getNif());
			cst.setLong(3, empleado.getJefe().getId());
			cst.setLong(4,  empleado.getId());
			
			cst.executeUpdate();
			
			return empleado;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido modificar el empleado", e);
		}	
	}

	@Override
	public void borrar(Long id) {
		try (Connection con = getConexion(); CallableStatement cst = con.prepareCall(SQL_DELETE);) {
			cst.setLong(1, id);
			
			cst.executeUpdate();
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido borrar el empleado", e);
		}
	}
}
