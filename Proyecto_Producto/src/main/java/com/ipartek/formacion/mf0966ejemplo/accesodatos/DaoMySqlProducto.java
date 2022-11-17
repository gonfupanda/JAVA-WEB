package com.ipartek.formacion.mf0966ejemplo.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipartek.formacion.mf0966ejemplo.modelos.Categoria;
import com.ipartek.formacion.mf0966ejemplo.modelos.Producto;

public class DaoMySqlProducto implements Dao<Producto> {

	private static final String SQL_SELECT_ID = "SELECT p.id, p.nombre, p.precio, p.descripcion, c.id, c.nombre, c.descripcion FROM productos p, categorias c WHERE p.categorias_id = c.id AND p.id = ?";
	private static final String sqlInsert = "INSERT INTO productos (id, nombre,precio,descripcion,categorias_id) VALUES ( null,?,?,?,?)";
	// SINGLETON
	
	
	private DaoMySqlProducto() {
	}

	private static final DaoMySqlProducto INSTANCIA = new DaoMySqlProducto();

	public static DaoMySqlProducto getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

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
			throw new AccesoDatosException("No se ha podido obtener el producto", e);
		}
	}
	public Producto insertar(Producto objeto) {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(sqlInsert)) {
			
			pst.setString(1, objeto.getNombre());
			pst.setDouble(2, objeto.getPrecio().doubleValue());
			pst.setString(3, objeto.getDescripcion());
			pst.setLong(4, objeto.getCategoria().getId());
			
			pst.executeUpdate();
			

		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el producto", e);
		}
		return objeto;
	}
	
	
}
