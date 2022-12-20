package com.ipartek.formacion.accesodatos;

import com.ipartek.formacion.modelos.Empleado;

public interface DAOEmpleado  extends Dao<Empleado>{
	Empleado obtenerPorIdFacturas(Long id);

}
