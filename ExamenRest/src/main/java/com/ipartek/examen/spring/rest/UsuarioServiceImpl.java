package com.ipartek.examen.spring.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.examen.spring.pojos.Rol;
import com.ipartek.examen.spring.pojos.Usuario;
import com.ipartek.examen.spring.repo.RolRepository;
import com.ipartek.examen.spring.repo.UsuarioRepository;



@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private RolRepository repoRol;
	
	@Override
	public List<Usuario> obtenerTodos() {
		return repo.findAll();
	}

	@Override
	public Usuario obtenerPorId(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Usuario obtenerPorEmail(String email) {
		return repo.findByEmail(email).orElse(null);
	}

	@Override
	public Usuario insertar(Usuario usuario) {
		if(usuario.getId() != null) {
			throw new ServiciosException("No se puede insertar un usuario con id");
		}
		return repo.save(usuario);
	}

	@Override
	public Usuario modificar(Usuario usuario) {
		if(usuario.getId() == null) {
			throw new ServiciosException("No se puede insertar un usuario con id");
		}
		return repo.save(usuario);
	}

	@Override
	public void borrar(Long id) {
		if(!repo.existsById(id)) {
			throw new ServiciosException("No se ha encontrado ese usuario: " + id);
		}
		repo.deleteById(id);
	}

	@Override
	public List<Rol> obtenerRoles() {
		return repoRol.findAll();
	}

	@Override
	public List<Usuario> buscarPorRol(String rol) {
		return repo.findByRol(rol);
	}

}
