 	package com.ipartek.examen.capas.acceso;

import java.math.BigDecimal;
import java.util.Random;
import java.util.TreeMap;

import com.ipartek.examen.capas.entidades.Libro;

public class DaoMemoriaLibro implements Dao<Libro> {

	private TreeMap<Long, Libro> libros = new TreeMap<>();

	/*
	 * private DaoMemoriaLibro() { for (Long l = 1L; l <= 2; l++) { libros.put(l,
	 * new Libro(l, "Nombre" + l,"433",23)); } }
	 */

	private static final DaoMemoriaLibro INSTANCIA = new DaoMemoriaLibro();

	public static DaoMemoriaLibro getInstancia() {
		return INSTANCIA;
	}

	@Override
	public Iterable<Libro> obtenerTodos() {
		return libros.values();
	}

	@Override
	public Libro obtenerPorId(Long id) {
		return libros.get(id);
	}

	@Override
	public Libro insertar(Libro objeto) {
		// Long id = libros.size() == 0 ? 1L : libros.lastKey() + 1L;
		// objeto.setId(id);
		// libros.put(id, objeto);
		libros.put(objeto.getId(), objeto);

		return objeto;
	}

	@Override
	public Libro modificar(Libro objeto) {
		libros.put(objeto.getId(), objeto);

		return objeto;
	}

	@Override
	public void borrar(Long id) {
		libros.remove(id);

	}

}
