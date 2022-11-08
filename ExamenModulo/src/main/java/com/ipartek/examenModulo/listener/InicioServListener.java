package com.ipartek.examenModulo.listener;



import com.ipartek.examenModulo.capas.acceso.DaoMemoriaLibro;
import com.ipartek.examenModulo.ladoServ.Globales;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

//carga el DAO nada mas cargar el servidor
@WebListener
public class InicioServListener implements ServletContextListener {

	 public void contextInitialized(ServletContextEvent sce)  { 
		 Globales.dao = DaoMemoriaLibro.getInstancia();
    }
	
}
