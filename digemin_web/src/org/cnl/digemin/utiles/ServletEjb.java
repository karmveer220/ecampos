package org.cnl.digemin.utiles;

import gob.min.digemin.ejb.EjbDigeminLocal;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet demo para obtener un EJB local
 * @author CEDETEC
 *
 */
public class ServletEjb  extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EjbDigeminLocal ejbDigeminLocal;
	
	public ServletEjb(){
		 final Context context;
	        try {
	            context = new InitialContext();
	            ejbDigeminLocal = (EjbDigeminLocal)context.lookup("EjbDigemin/local");

	        } catch (NamingException e) {
	            e.printStackTrace();
	        }

	}
	 public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

	        try {
	        	String ii = ejbDigeminLocal.autenticaSession("elvis", "123456");
	            System.out.println(ii);
	                        
	        } catch (Exception e) {
	            System.out.println(" El error dice: " + e.getMessage());
	        }
	    }

	 
}
