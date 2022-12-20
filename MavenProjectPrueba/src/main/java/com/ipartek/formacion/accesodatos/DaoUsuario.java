package com.ipartek.formacion.accesodatos;

import com.ipartek.formacion.modelos.Cliente;
import com.ipartek.formacion.modelos.Usuario;

public interface DaoUsuario extends Dao<Usuario> {
	Usuario obtenerPorEmail(String email);
	Cliente obtenerClienteUsuario(int id);
}
