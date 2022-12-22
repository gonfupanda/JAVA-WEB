package com.ipartek.formacion.accesodatos;

public interface Dao<T> {
	
	default Iterable<T> obtenerTodos(){
		throw new UnsupportedOperationException();
	}
	default T findId(Long id){
		throw new UnsupportedOperationException();
	}
	default T insertar(T o){
		throw new UnsupportedOperationException();
	}
	default T modificar(T o){
		throw new UnsupportedOperationException();
	}
	default T delete(Long id){
		throw new UnsupportedOperationException();
	}

}
