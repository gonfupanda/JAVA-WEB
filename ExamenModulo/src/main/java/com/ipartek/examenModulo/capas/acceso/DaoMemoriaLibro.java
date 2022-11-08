package com.ipartek.examenModulo.capas.acceso;

import java.math.BigDecimal;
import java.util.Random;
import java.util.TreeMap;
import java.util.logging.Logger;

import com.ipartek.examenModulo.capas.entidades.EntidadesException;
import com.ipartek.examenModulo.capas.entidades.Libro;

public class DaoMemoriaLibro implements Dao<Libro> {

	private TreeMap<Long, Libro> libros = new TreeMap<>();

	private DaoMemoriaLibro() {
		for (Long l = 1L; l <= 1; l++) {
			libros.put(l, new Libro("1", "Nombre" + l, "433", "3", "gonza", "aaa"));
		}
	}

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
		try {
			libros.remove(id);
		}catch(EntidadesException e) {
			e.getCause();
		}
		

	}

}
