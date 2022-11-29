package filtros;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.ipartek.formacion.mf0966ejemplo.modelos.Usuario;

@WebFilter("/checkout")
public class CheckOutFilter extends HttpFilter implements Filter {
       

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpSession session = req.getSession();

		Usuario usuario = (Usuario) session.getAttribute("usuario");

		if (usuario != null) {
			chain.doFilter(request, response);
		} else {
			req.setAttribute("alertaMensaje", "Debes estar logeado para acceder a esa zona");
			req.setAttribute("alertaNivel", "danger");

			req.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
		}
	}



}
