package com.ipartek.formacion.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.modelos.Cliente;
import com.ipartek.formacion.modelos.Rol;
import com.ipartek.formacion.modelos.Usuario;

public class DaoMySqlUsuarios implements DaoUsuario {


	private static final String SQL_SELECT = "SELECT id, email, password FROM usuarios";
	
	private static final String SQL_SELECT_EMAIL = "SELECT u.id, u.email, u.password, r.id, r.nombre, r.descripcion,u.clientes_id FROM usuarios u JOIN roles r ON r.id = u.roles_id WHERE u.email = ?";
	
	private static final String SQL_SELECT_CLIENTE = "SELECT c.id,c.nombre,c.nif,c.email FROM usuarios u, clientes c where u.clientes_id=c.id and c.id= ?";
	
	// SINGLETON
	private DaoMySqlUsuarios() {
	}

	private static final DaoMySqlUsuarios INSTANCIA = new DaoMySqlUsuarios();

	public static DaoMySqlUsuarios getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha podido encontrar el driver");
		}
	}
	
	
	@Override
	public Iterable<Usuario> obtenerTodos() {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			final ArrayList<Usuario> usuarios = new ArrayList<>();
			
			while(rs.next()) {
				usuarios.add(new Usuario(rs.getLong("id"), rs.getString("email"), rs.getString("password"),null,null));
			}
			
			return usuarios;
		} catch (SQLException e) {
			throw new AccesoDatosException("La aplicación no puede realizar esta operación", e);
		}
	}


	@Override
	public Usuario obtenerPorEmail(String email) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_EMAIL);
				) {
			
			pst.setString(1, email);
			
			ResultSet rs = pst.executeQuery();
			
			Usuario usuario = null;
			Rol rol = null;
			
			if(rs.next()) {
				rol = new Rol(rs.getLong("r.id"), rs.getString("r.nombre"), rs.getString("r.descripcion"));
				usuario = new Usuario(rs.getLong("u.id"), rs.getString("u.email"), rs.getString("u.password"), rol, obtenerClienteUsuario(rs.getInt("u.clientes_id")));
			}
			
			return usuario;
		} catch (SQLException e) {
			throw new AccesoDatosException("La aplicación no puede realizar esta operación", e);
		}
	}
	
	
	public Cliente obtenerClienteUsuario(int id) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_CLIENTE);
				) {
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			Cliente c=null;
			
			if(rs.next()) {
				c = new Cliente(rs.getLong("c.id"), rs.getString("c.nombre"), rs.getString("c.nif"),rs.getString("c.email"));
			}
			
			return c;
		} catch (SQLException e) {
			throw new AccesoDatosException("La aplicación no puede realizar esta operación", e);
		}
		
	}
	
	
}
