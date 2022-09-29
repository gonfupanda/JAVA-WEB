package com.ipartek.doscapas.acceso;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;
import java.util.TreeMap;

import com.ipartek.doscapas.entidad.Producto;

public class DaoMemoriaProducto implements Dao<Producto> {
	
	private TreeMap<Long,Producto> productos = new TreeMap<>();

	//SINGLETON
	private DaoMemoriaProducto() {
		
		for(Long l = 1L;l<=10;l++) {
			
			productos.put(l, new Producto(l,"nombre"+l,LocalDate.now().plusYears(l),
							new BigDecimal(new Random().nextInt(1, 100)),l.intValue()));
		}
		
	}
	private static final DaoMemoriaProducto INSTANCIA= new DaoMemoriaProducto();
	
	public static DaoMemoriaProducto getInstancia() {
		return INSTANCIA;
	}
	//FIN SINGLETON
	
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
