package com.ipartek.formacion.mf0966ejemplo.controladores;

import com.ipartek.formacion.mf0966ejemplo.accesodatos.Dao;
import com.ipartek.formacion.mf0966ejemplo.accesodatos.DaoMySqlProducto;
import com.ipartek.formacion.mf0966ejemplo.accesodatos.DaoMySqlUsuarios;
import com.ipartek.formacion.mf0966ejemplo.accesodatos.DaoMysqlCategoria;
import com.ipartek.formacion.mf0966ejemplo.accesodatos.DaoMysqlCliente;
import com.ipartek.formacion.mf0966ejemplo.accesodatos.DaoMysqlEmpleado;
import com.ipartek.formacion.mf0966ejemplo.accesodatos.DaoMysqlFacturas;
import com.ipartek.formacion.mf0966ejemplo.accesodatos.DaoUsuario;
import com.ipartek.formacion.mf0966ejemplo.modelos.Categoria;
import com.ipartek.formacion.mf0966ejemplo.modelos.Cliente;
import com.ipartek.formacion.mf0966ejemplo.modelos.Empleado;
import com.ipartek.formacion.mf0966ejemplo.modelos.Factura;
import com.ipartek.formacion.mf0966ejemplo.modelos.Producto;
import com.ipartek.formacion.mf0966ejemplo.modelos.Usuario;

public class Globales {
	public static final DaoUsuario DAO_USUARIOS = DaoMySqlUsuarios.getInstancia();
	public static final Dao<Producto> DAO_PRODUCTO = DaoMySqlProducto.getInstancia();
	public static final Dao<Categoria> DAO_CATEGORIA = DaoMysqlCategoria.getInstancia();
	public static final Dao<Empleado> DAO_EMPLEADO = DaoMysqlEmpleado.getInstancia();
	public static final Dao<Cliente> DAO_CLIENTE = DaoMysqlCliente.getInstancia();
	public static final Dao<Factura> DAO_FACTURA = DaoMysqlFacturas.getInstancia();
}
