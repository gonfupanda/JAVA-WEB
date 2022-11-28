package com.ipartek.formacion.mf0966ejemplo.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.mf0966ejemplo.modelos.Categoria;

public class DaoMysqlCategoria implements Dao<Categoria>{

private static final String SQL_SELECT = "SELECT id, nombre, descripcion FROM categorias";
private static final String SQL_SELECT_ID = "SELECT * FROM categorias WHERE id=?";

	
	// SINGLETON
	private DaoMysqlCategoria() {}
	private static final Dao<Categoria> INSTANCIA = new DaoMysqlCategoria();

	public static Dao<Categoria> getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Categoria> obtenerTodos() {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			List<Categoria> categorias = new ArrayList<>();
			
			while(rs.next()) {
				categorias.add(new Categoria(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion")));
			}
			
			return categorias;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido recibir las categorias", e);
		}
	}
	@Override
	public Categoria obtenerPorId(Long idd) {
		try (Connection con = getConexion();PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);){
				
				

				pst.setLong(1, idd);
				ResultSet rs = pst.executeQuery();
				Categoria c = null;
			
			while(rs.next()) {
				c=new Categoria(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion"));
			}
			
			return c;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido recibir las categorias", e);
		}
	
	}
}
