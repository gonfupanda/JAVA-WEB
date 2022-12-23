package com.ipartek.formacion.spring.repos;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.ipartek.formacion.spring.pojos.Factura;

@RepositoryRestResource(path = "facturas", collectionResourceRel = "facturas")
public interface FacturaRepo extends PagingAndSortingRepository<Factura, Long>, CrudRepository<Factura,Long>{

}
