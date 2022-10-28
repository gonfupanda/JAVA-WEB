package com.ipartek.formacion.gonzaPrueba;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//En caso de recoger un caracter especial
        
        String user = request.getParameter("user");//RECOGE POR EL NAME DEL HTML/JSP
        String pass = request.getParameter("pass");//RECOGE POR EL NAME DEL HTML/JSP
        
        if(validarUsuario(user, pass)) {
            request.getSession().setAttribute("usuario", user);//Introducir a SESION
            response.sendRedirect("principal.jsp");
        } else {
            //response.sendRedirect("login.jsp");
            request.setAttribute("error", "El usuario o la contraseña son incorrectos");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private boolean validarUsuario(String user, String pass) {
        return "javier".equals(user) && "lete".equals(pass);
    }

}
