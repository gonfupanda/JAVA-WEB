package com.ipartek.formacion.spring.repos;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.pojos.Factura;

@RepositoryRestResource(path = "facturas", collectionResourceRel = "facturas")
public interface FacturaRepo extends  CrudRepository<Factura,Long>{
	
	@Query("select f.codigo from Factura f where f.codigo like :anno% order by f.codigo desc limit 1")
	String buscarUltimoCodigo(String anno);

}
