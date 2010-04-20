package org.cnl.digemin.utiles;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Mayo 2009
 * @version 1.0
 */
public class Autentica implements Filter{

	public static String USR_LOGIN = "usrLogin";
	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		try {
			
			String metodo = request.getParameter("method");
			
			if(metodo!=null)
			if(!metodo.equals("login")){			
				if(session.getAttribute(USR_LOGIN)==null){
					request.setAttribute("msgError", "Necesita ingresar su usuario y clave");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					return;
				}
			}
			
			chain.doFilter(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msgError", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		 
	}

	
	public void init(FilterConfig arg0) throws ServletException {
			
	}

}
