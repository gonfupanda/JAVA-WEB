package com.ipartek.examen.spring.rest;

import java.util.List;

import com.ipartek.examen.spring.pojos.Rol;
import com.ipartek.examen.spring.pojos.Usuario;



public interface UsuarioService {
	List<Usuario> obtenerTodos();
	Usuario obtenerPorId(Long id);
	Usuario obtenerPorEmail(String email);
	
	Usuario insertar(Usuario usuario);
	Usuario modificar(Usuario usuario);
	void borrar(Long id);
	
	List<Rol> obtenerRoles();
	List<Usuario> buscarPorRol(String rol);
}
