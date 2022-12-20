package com.ipartek.formacion.controladores;

import com.ipartek.formacion.accesodatos.Dao;
import com.ipartek.formacion.accesodatos.DaoMySqlProducto;
import com.ipartek.formacion.accesodatos.DaoMySqlUsuarios;
import com.ipartek.formacion.accesodatos.DaoMysqlCategoria;
import com.ipartek.formacion.accesodatos.DaoMysqlCliente;
import com.ipartek.formacion.accesodatos.DaoMysqlEmpleado;
import com.ipartek.formacion.accesodatos.DaoMysqlFacturas;
import com.ipartek.formacion.accesodatos.DaoUsuario;
import com.ipartek.formacion.modelos.Categoria;
import com.ipartek.formacion.modelos.Cliente;
import com.ipartek.formacion.modelos.Empleado;
import com.ipartek.formacion.modelos.Factura;
import com.ipartek.formacion.modelos.Producto;

public class Globales {
	private Globales() {
	}
	public static final DaoUsuario DAO_USUARIOS = DaoMySqlUsuarios.getInstancia();
	public static final Dao<Producto> DAO_PRODUCTO = DaoMySqlProducto.getInstancia();
	public static final Dao<Categoria> DAO_CATEGORIA = DaoMysqlCategoria.getInstancia();
	public static final Dao<Empleado> DAO_EMPLEADO = DaoMysqlEmpleado.getInstancia();
	public static final Dao<Cliente> DAO_CLIENTE = DaoMysqlCliente.getInstancia();
	public static final Dao<Factura> DAO_FACTURA = DaoMysqlFacturas.getInstancia();

}
