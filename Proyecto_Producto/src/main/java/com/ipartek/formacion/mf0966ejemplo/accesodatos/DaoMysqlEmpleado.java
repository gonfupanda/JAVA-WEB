package com.ipartek.formacion.mf0966ejemplo.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipartek.formacion.mf0966ejemplo.modelos.Empleado;

public class DaoMysqlEmpleado implements Dao<Empleado> {
	
	private static final String SQL_SELECT_ID = "SELECT e.id, e.nombre, e.nif, e.jefe_id FROM empleados e, facturas f "
											+ "WHERE f.empleados_id = e.id "
											+ "AND e.id = ?";

	// SINGLETON

	private DaoMysqlEmpleado() {
	}

	private static final DaoMysqlEmpleado INSTANCIA = new DaoMysqlEmpleado();

	public static DaoMysqlEmpleado getInstancia() {
		return INSTANCIA;
	}
	//////
	
	@Override
	public Empleado obtenerPorId(Long id) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID)) {
			pst.setLong(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			Empleado em = null;
			
			if(rs.next()) {
				em = new Empleado(rs.getLong("e.id"),rs.getString("e.nombre"),rs.getString("e.nif"),obtenerPorId(rs.getLong("e.jefe_id")));
			}
			
			return em;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el producto", e);
		}
	}
}
