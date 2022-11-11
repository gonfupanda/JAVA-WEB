package com.ipartek.examen.capas.acceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

import com.ipartek.examen.capas.entidades.Libro;

public class Crud implements Dao{
	
	
	private static final String url = "jdbc:mysql://localhost:3306/mf0966";
	private static final String user="root";
	private static final String passwd="abcd*1234";
	
	private static final String sql = "SELECT * FROM libros";
	private static final String sqlId = "SELECT * FROM libros WHERE id = ?";
	private static final String sqlInsert = "INSERT INTO libros (id, nombre,precio,descuento) VALUES (?, ?,?,?)";
	private static final String sqlDelete = "DELETE FROM libros WHERE id=?";
	private static final String sqlUpdate = "UPDATE libros SET nombre=?,precio=?,descuento=? WHERE id=?";
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	
	private static final Crud INSTANCIA = new Crud();
	


	public static Crud getInstancia() {
		return INSTANCIA;
	}
	
	
	private static ArrayList<Libro> selectAll() {//GET ALL the BOOKS FRON DE DATABASE
		ArrayList<Libro> l = new ArrayList() ;
		try {
			Class.forName(driver);
	
			try (Connection con = DriverManager.getConnection(url, user, passwd);
					PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery()) {
					
				while (rs.next()) {
					Libro li = new Libro(rs.getString("id"),rs.getString("nombre"),rs.getString("precio"),rs.getString("descuento"));
					l.add(li);
				}		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return l;
	}
	
	public static Libro getById(Long id) {//GET BOOK FRON DE DATABASE BY Id
		Libro l = null;
		try {
			Connection con = DriverManager.getConnection(url, user, passwd);
			PreparedStatement pst = con.prepareStatement(sqlId);
			
			Class.forName(driver);
	
			pst.setLong(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				l = new Libro(rs.getString("id"),rs.getString("nombre"),rs.getString("precio"),rs.getString("descuento"));	
			}
	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return l;
	}
	
	public static Libro InsertLibro(Libro lib) {//INSERT BOOK 

		try {
			Connection con = DriverManager.getConnection(url, user, passwd);
			PreparedStatement pst = con.prepareStatement(sqlInsert);
			
			Class.forName(driver);
	
			pst.setLong(1, lib.getId());
			pst.setString(2, lib.getNombre());
			pst.setString(3, lib.getPrecio());
			pst.setInt(4, lib.getDescuento());
			
			pst.executeUpdate();
				
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return lib;
	}
	
	public static void deleteLibro(Long id) {//DELETE BOOK 

		try {
			Connection con = DriverManager.getConnection(url, user, passwd);
			PreparedStatement pst = con.prepareStatement(sqlDelete);
			
			Class.forName(driver);
	
			pst.setLong(1, id);
			
			int rs = pst.executeUpdate();			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Object modifyLibro(Libro lib)  {//MODIFY BOOK 

		try {
			Connection con = DriverManager.getConnection(url, user, passwd);
			PreparedStatement pst = con.prepareStatement(sqlUpdate);
			
			Class.forName(driver);

			pst.setString(1, lib.getNombre());
			pst.setString(2, lib.getPrecio());
			pst.setInt(3, lib.getDescuento());
			pst.setLong(4, lib.getId());
			
			int numRegMod = pst.executeUpdate();
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return lib;
	}

	@Override
	public Iterable obtenerTodos() {
		
		return selectAll();
	}

	@Override
	public Object obtenerPorId(Long id) {

		return getById(id);
	}

	@Override
	public Object insertar(Object objeto) {
		return InsertLibro((Libro) objeto);
	}

	@Override
	public Object modificar(Object objeto) {
		return modifyLibro((Libro) objeto);
	}

	@Override
	public void borrar(Long id) {
		deleteLibro(id);
		
	}

}
