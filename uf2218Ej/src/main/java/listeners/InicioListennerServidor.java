package listeners;

import capas.acceso.DaoMemoriaProducto;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import pruebas.clases.Globales;

/**
 * Application Lifecycle Listener implementation class InicioListennerServidor
 *
 */
@WebListener
public class InicioListennerServidor implements ServletContextListener {

	 public void contextInitialized(ServletContextEvent sce)  { 
		 Globales.dao = DaoMemoriaProducto.getInstancia();
    }
	
}
