package pe.gob.mininter.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class Users extends User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String clave;
    private String usrapematernovh;
    private String usrapepaternovh;
    private String usrcargovh;
    private String usrcelularpersonalvh;
    private String usrcelulartrabajovh;
    private String usremailvh;
    private Integer usrestadonu;
    private Date usrfechanacimientodt;
    private Date usrfecregistrodt;
    private String usrnombrevh;
    private String usrusuariomodificacionvh;
    private String usuario;
    private List<Authorities> authoritiesList;
        
	
	public Users(String username, String password, boolean enabled,Collection<GrantedAuthority> authorities) {
		super(username, password, enabled, true, true, true, authorities);
		this.usrestadonu = enabled==true ? 1 : 0;
		this.usuario = username;
		this.clave = password;
	}
	
	public Users(String username, String password, boolean enabled,List<GrantedAuthority> authorities,
			String usrnombrevh,String usrapepaternovh, String usrapematernovh,
			Date usrfechanacimientodt,Integer estado) {
		super(username, password, enabled, true, true, true, authorities);
		this.usuario = username;
		this.clave = password;
		this.usrnombrevh=usrnombrevh;
		this.usrapepaternovh = usrapepaternovh;
		this.usrapematernovh = usrapematernovh;
	    this.usrfechanacimientodt = usrfechanacimientodt;
		this.usrestadonu = enabled==true ? 1 : 0;
	}

	public static Users getUsuarioBean() {
		Users nu = (Users)(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		if(nu != null) {
			return nu;
		}
		else return null;
	}
	
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getUsrapematernovh() {
        return usrapematernovh;
    }

    public void setUsrapematernovh(String usrapematernovh) {
        this.usrapematernovh = usrapematernovh;
    }

    public String getUsrapepaternovh() {
        return usrapepaternovh;
    }

    public void setUsrapepaternovh(String usrapepaternovh) {
        this.usrapepaternovh = usrapepaternovh;
    }

    public String getUsrcargovh() {
        return usrcargovh;
    }

    public void setUsrcargovh(String usrcargovh) {
        this.usrcargovh = usrcargovh;
    }

    public String getUsrcelularpersonalvh() {
        return usrcelularpersonalvh;
    }

    public void setUsrcelularpersonalvh(String usrcelularpersonalvh) {
        this.usrcelularpersonalvh = usrcelularpersonalvh;
    }

    public String getUsrcelulartrabajovh() {
        return usrcelulartrabajovh;
    }

    public void setUsrcelulartrabajovh(String usrcelulartrabajovh) {
        this.usrcelulartrabajovh = usrcelulartrabajovh;
    }

    public String getUsremailvh() {
        return usremailvh;
    }

    public void setUsremailvh(String usremailvh) {
        this.usremailvh = usremailvh;
    }

    public Integer getUsrestadonu() {
        return usrestadonu;
    }

    public void setUsrestadonu(Integer usrestadonu) {
        this.usrestadonu = usrestadonu;
    }

    public Date getUsrfechanacimientodt() {
        return usrfechanacimientodt;
    }

    public void setUsrfechanacimientodt(Date usrfechanacimientodt) {
        this.usrfechanacimientodt = usrfechanacimientodt;
    }

    public Date getUsrfecregistrodt() {
        return usrfecregistrodt;
    }

    public void setUsrfecregistrodt(Date usrfecregistrodt) {
        this.usrfecregistrodt = usrfecregistrodt;
    }

    public String getUsrnombrevh() {
        return usrnombrevh;
    }

    public void setUsrnombrevh(String usrnombrevh) {
        this.usrnombrevh = usrnombrevh;
    }

    public String getUsrusuariomodificacionvh() {
        return usrusuariomodificacionvh;
    }

    public void setUsrusuariomodificacionvh(String usrusuariomodificacionvh) {
        this.usrusuariomodificacionvh = usrusuariomodificacionvh;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<Authorities> getAuthoritiesList() {
        return authoritiesList;
    }

    public void setAuthoritiesList(List<Authorities> authoritiesList) {
        this.authoritiesList = authoritiesList;
    }

    public Authorities addAuthorities(Authorities authorities) {
        getAuthoritiesList().add(authorities);
        authorities.setUsers(this);
        return authorities;
    }

    public Authorities removeAuthorities(Authorities authorities) {
        getAuthoritiesList().remove(authorities);
        authorities.setUsers(null);
        return authorities;
    }

	public String getEstado(){
        if(usrestadonu==0){return "Inactivo";}
        if(usrestadonu==1){return "Activo";}
        return "";
    }
	
	public static boolean tienePermiso(String permiso) {
		Users us = getUsuarioBean();
		for(GrantedAuthority ga : us.getAuthorities()){
			if(ga.getAuthority().equals(permiso)){
				return true;
			}
		}
		return false;
	}
}
