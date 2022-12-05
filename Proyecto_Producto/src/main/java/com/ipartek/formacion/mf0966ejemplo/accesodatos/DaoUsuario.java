package com.ipartek.formacion.mf0966ejemplo.accesodatos;

import com.ipartek.formacion.mf0966ejemplo.modelos.Cliente;
import com.ipartek.formacion.mf0966ejemplo.modelos.Usuario;

public interface DaoUsuario extends Dao<Usuario> {
	Usuario obtenerPorEmail(String email);
	Cliente obtenerClienteUsuario(int id);
}
