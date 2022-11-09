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
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	
	private static final Crud INSTANCIA = new Crud();
	
	/*public static void main(String[] args) {
		ArrayList<Libro> libross = selectAll();
		for(int i=0;i<libross.size();i++) {
			System.out.println(libross.get(i));
		}
	}*/
	public static void main(String[] args) {
		ArrayList<Libro> libross = selectAll();
		for(int i=0;i<libross.size();i++) {
			System.out.println(libross.get(i));
		}
	}

	public static Crud getInstancia() {
		return INSTANCIA;
	}
	
	
	private static ArrayList<Libro> selectAll() {
		ArrayList<Libro> l = new ArrayList() ;
		try {
			Class.forName(driver);
	
			try (Connection con = DriverManager.getConnection(url, user, passwd);
					PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery()) {
					
				while (rs.next()) {
					System.out.printf("%s: %s, %s\n", rs.getLong("id"), rs.getString("nombre"), rs.getString("precio"));
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

	@Override
	public Iterable obtenerTodos() {
		
		return selectAll();
	}

	@Override
	public Object obtenerPorId(Long id) throws SQLException {

		return null;
	}

	@Override
	public Object insertar(Object objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object modificar(Object objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
