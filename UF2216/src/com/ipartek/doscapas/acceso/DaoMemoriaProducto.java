package com.ipartek.doscapas.acceso;

import java.util.TreeMap;

import com.ipartek.doscapas.entidad.Producto;

public class DaoMemoriaProducto implements Dao<Producto> {
	
	private TreeMap<Long,Producto> productos = new TreeMap<>();

	@Override
	public Iterable obtenerTodos() {
		return productos.values();
	}

	@Override
	public Producto obtenerPorId(Long id) {
		
		return productos.get(id);
	}

	@Override
	public Producto insertar(Producto objeto) {
		
		Long id = productos.size()==0?1L:productos.lastKey()+1L;
		objeto.setId(id);
		productos.put(id, objeto);
		return objeto;
	}

	@Override
	public Producto modificar(Producto objeto) {
		productos.put(objeto.getId(), objeto);
		
		return objeto;
	}

	@Override
	public void borrar(Long id) {
		productos.remove(id);
		
		
	}

}
