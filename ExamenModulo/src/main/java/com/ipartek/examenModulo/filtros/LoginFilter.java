package com.ipartek.examenModulo.filtros;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//solo con la sesion se puede acceder a la carpeta admin
@WebFilter("/admin/*")
public class LoginFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		
		String usuario = (String) session.getAttribute("usuario");
		
		if(usuario == null) {
			req.setAttribute("alertaNivel", "danger");
			req.setAttribute("alertaMensaje", "Debes estar logueado para entrar en administración");
			
			req.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(req, res);
		} else {
			chain.doFilter(request, response);
		}
	}

}
