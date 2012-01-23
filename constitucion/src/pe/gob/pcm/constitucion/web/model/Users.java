/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.gob.pcm.constitucion.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author elvis
 */
@Entity
@Table(name = "users")
public class Users extends User implements Serializable {
	
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    
    @Basic(optional = false)
    @Column(name = "ENABLED")
    private boolean enabled;
    
    @Basic(optional = false)
    @Column(name = "FEC_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegistro;
    
    @Column(name = "COD_USUMODIF")
    private String codUsumodif;
    
    @Basic(optional = false)
    @Column(name = "FEC_MODIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModif;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private List<Authorities> authoritiesList;

    
    public Users() {		
		super("default", "default", true, true, true, true , uno() );		
	}
    
	public static List<GrantedAuthority> uno(){
		List<GrantedAuthority> oo = new ArrayList<GrantedAuthority>(); 
		oo.add(new GrantedAuthorityImpl("IS_AUTHENTICATED_ANONYMOUSLY") );
		return oo;
	}
	
	public Users(String username, String password, boolean enabled,Collection<GrantedAuthority> authorities) {
		super(username, password, enabled, true, true, true, authorities);
		this.enabled = enabled;
		this.username = username;
		this.password = password;
	}
	
  
  	public Users(String username, String password, boolean enabled,List<GrantedAuthority> authorities, Integer estado) {

		super(username, password, enabled, true, true, true, authorities);
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		
	}

	public static Users getUsuarioBean() {
		Users nu = (Users)(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		if(nu != null) {
			return nu;
		}
		else return null;
	}
	
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getFecRegistro() {
        return fecRegistro;
    }

    public void setFecRegistro(Date fecRegistro) {
        this.fecRegistro = fecRegistro;
    }

    public String getCodUsumodif() {
        return codUsumodif;
    }

    public void setCodUsumodif(String codUsumodif) {
        this.codUsumodif = codUsumodif;
    }

    public Date getFecModif() {
        return fecModif;
    }

    public void setFecModif(Date fecModif) {
        this.fecModif = fecModif;
    }

    public List<Authorities> getAuthoritiesList() {
        return authoritiesList;
    }

    public void setAuthoritiesList(List<Authorities> authoritiesList) {
        this.authoritiesList = authoritiesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.Users[username=" + username + "]";
    }

}
