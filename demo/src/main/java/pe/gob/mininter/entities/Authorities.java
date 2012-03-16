package pe.gob.mininter.entities;

import java.io.Serializable;

public class Authorities implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String authority;
    private String usuario;
    private Users users;

    public Authorities() {
    }

    public Authorities(String usuario,String authority) {
    	this.usuario=usuario;
    	this.authority=authority;
    }
    
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
