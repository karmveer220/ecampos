package pe.org.cnc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
public class Usuario extends User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUsuario;
	private String apellidos;
	private String clave;	
	@Transient
	private String claveNueva;	
	private int estado;
	private String nombres;
	private String email;
	private String username;

	  @Transient
	    private List<String> lPermisos;
	   
	  
	 	public Usuario() {
	    	super("default", "default", true, true, true, true , uno() );		
	    }
		
		public static List<GrantedAuthority> uno(){
			List<GrantedAuthority> oo = new ArrayList<GrantedAuthority>(); 
			oo.add(new GrantedAuthorityImpl("IS_AUTHENTICATED_ANONYMOUSLY") );
			return oo;
		}
		
	    public static Usuario getUsuarioBean() {
	    	Usuario nu = (Usuario)(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
			if(nu != null) {
				return nu;
			}
			else return null;
		}
		
	    public Usuario(String username, String password, boolean enabled,Collection<GrantedAuthority> authorities) {
			super(username, password, enabled, true, true, true, authorities);
			this.estado = enabled==true ? 1 : 0;
			this.username = username;
			this.clave = password;
		}
	    
	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getClaveNueva() {
		return claveNueva;
	}

	public void setClaveNueva(String claveNueva) {
		this.claveNueva = claveNueva;
	}
	public List<String> getlPermisos() {
		return lPermisos;
	}
	public void setlPermisos(List<String> lPermisos) {
		this.lPermisos = lPermisos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}