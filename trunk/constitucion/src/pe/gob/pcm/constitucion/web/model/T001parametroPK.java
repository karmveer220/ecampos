package pe.gob.pcm.constitucion.web.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author elvis
 */
@Embeddable
public class T001parametroPK implements Serializable {
    
	@Basic(optional = false)
    @Column(name = "COD_GRUPO")
    private String codGrupo;
    @Basic(optional = false)
    @Column(name = "COD_PARAM")
    private String codParam;

    public T001parametroPK() {
    }

    public T001parametroPK(String codGrupo, String codParam) {
        this.codGrupo = codGrupo;
        this.codParam = codParam;
    }

    public String getCodGrupo() {
        return codGrupo;
    }

    public void setCodGrupo(String codGrupo) {
        this.codGrupo = codGrupo;
    }

    public String getCodParam() {
        return codParam;
    }

    public void setCodParam(String codParam) {
        this.codParam = codParam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codGrupo != null ? codGrupo.hashCode() : 0);
        hash += (codParam != null ? codParam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T001parametroPK)) {
            return false;
        }
        T001parametroPK other = (T001parametroPK) object;
        if ((this.codGrupo == null && other.codGrupo != null) || (this.codGrupo != null && !this.codGrupo.equals(other.codGrupo))) {
            return false;
        }
        if ((this.codParam == null && other.codParam != null) || (this.codParam != null && !this.codParam.equals(other.codParam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T001parametroPK[codGrupo=" + codGrupo + ", codParam=" + codParam + "]";
    }

}
