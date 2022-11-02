package com.ipartek.formacion.gonzaPrueba;

import java.io.IOException;

import com.ipartek.formacion.mf0967.doscapas.accesodatos.Dao;
import com.ipartek.formacion.mf0967.doscapas.accesodatos.DaoMemoriaProducto;
import com.ipartek.formacion.mf0967.doscapas.entidades.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrincipalServlet
 */
@WebServlet("/principal")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Dao<Producto> dao = DaoMemoriaProducto.getInstancia();
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = (String) request.getSession().getAttribute("usuario");
        
        if(user == null) {
            //response.sendRedirect("login.jsp");
            request.setAttribute("error", "No se puede acceder a principal sin autenticarse");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.setAttribute("productos", dao.obtenerTodos());
            request.getRequestDispatcher("/WEB-INF/vistas/principal.jsp").forward(request, response);
        }
    }

}
