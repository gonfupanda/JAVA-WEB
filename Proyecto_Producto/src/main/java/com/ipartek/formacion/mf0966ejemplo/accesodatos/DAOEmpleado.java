package com.ipartek.formacion.mf0966ejemplo.accesodatos;

import com.ipartek.formacion.mf0966ejemplo.modelos.Empleado;

public interface DAOEmpleado  extends Dao<Empleado>{
	Empleado obtenerPorIdFacturas(Long id);

}
