package com.ipartek.formacion.spring.repos;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.pojos.*;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
	

}
