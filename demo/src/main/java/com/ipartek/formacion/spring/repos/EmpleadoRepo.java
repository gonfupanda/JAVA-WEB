package com.ipartek.formacion.spring.repos;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.ipartek.formacion.spring.pojos.Empleado;

@RepositoryRestResource(path = "empleados", collectionResourceRel = "empleados")
public interface EmpleadoRepo extends PagingAndSortingRepository<Empleado, Long>, CrudRepository<Empleado,Long>{
	

	public Empleado findByNombre(String nombre);
	
	@Query("from Empleado where nombre = :nombre")
	public Empleado getByNombre(String nombre);
	

	
	

}
