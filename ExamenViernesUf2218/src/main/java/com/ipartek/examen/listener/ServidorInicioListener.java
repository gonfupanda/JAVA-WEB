package com.ipartek.examen.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import com.ipartek.examen.capas.acceso.Crud;
import com.ipartek.examen.capas.acceso.DaoMemoriaLibro;
import com.ipartek.examen.ladoServ.Globales;


@WebListener
public class ServidorInicioListener implements ServletContextListener {

	 public void contextInitialized(ServletContextEvent sce)  { 
		 Globales.dao = DaoMemoriaLibro.getInstancia();
		 Globales.daoCrud = Crud.getInstancia();
    }
	
}
