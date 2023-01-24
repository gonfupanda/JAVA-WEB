package com.example.examen.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.examen.entidades.Inmueble;

@Repository
public interface InmuebleRepo extends CrudRepository<Inmueble, Long> {
	
	public Iterable<Inmueble> findByNombreOrDireccion(String nombre,String direccion);
	
	@Query(value="select * from inmuebles i where i.estado='alquiler'",nativeQuery=true)
	public Iterable<Inmueble> findAllAlquiler();
	
	@Query(value="select * from inmuebles i where i.estado='venta'",nativeQuery=true)
	public Iterable<Inmueble> findAllVenta();
	
	@Query(value="select * from inmuebles i where precio between :min and :max",nativeQuery=true)
	public Iterable<Inmueble> obtenerPorPrecio(int min,int max);
	
	@Query(value="select * from inmuebles i order by i.nombre",nativeQuery=true)
	public Iterable<Inmueble> obtenerPorNombreOrdenado();
	
	@Query(value="SELECT i.* FROM inmuebles i ,servicios s where i.servicios_id=s.id and s.nombre='cocina' limit 1",nativeQuery=true)
	public Inmueble primeroConCocina();
	
	@Query(value="select * from inmuebles i where i.nombre=?1 or i.direccion=?1",nativeQuery=true)
	public Iterable<Inmueble> obtenerNombre(String nom);
	
	@Query(value="select sum(i.precio) from inmuebles i where i.habitaciones>=3",nativeQuery=true)
	public Double totalHabitaciones3();
	


}
