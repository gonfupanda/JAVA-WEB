package com.ipartek.formacion.mf0966ejemplo.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ipartek.formacion.mf0966ejemplo.modelos.Cliente;

public class DaoMysqlCliente implements Dao<Cliente> {
	private static final String SQL_SELECT_ID = "SELECT c.id, c.nombre, c.nif, c.email FROM clientes c, facturas f"
											+ " WHERE f.clientes_id = c.id"
											+ " AND c.id = ?";
									
	// SINGLETON

	private DaoMysqlCliente() {
	}

	private static final DaoMysqlCliente INSTANCIA = new DaoMysqlCliente();

	public static DaoMysqlCliente getInstancia() {
		return INSTANCIA;
	}
	//////
	
	
	@Override
	public Cliente obtenerPorId(Long id) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID)) {
			pst.setLong(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			Cliente cli = null;
			
			if(rs.next()) {
				cli = new Cliente(rs.getLong("c.id"),rs.getString("c.nombre"),rs.getString("c.nif"),rs.getString("c.email"));
			}
			
			return cli;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el producto", e);
		}
	}

}
