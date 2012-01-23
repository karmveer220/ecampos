/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class T031plantillaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_NOTARIA")
    private String codNotaria;
    @Basic(optional = false)
    @Column(name = "COD_TIPSOC")
    private String codTipsoc;

    public T031plantillaPK() {
    }

    public T031plantillaPK(String codNotaria, String codTipsoc) {
        this.codNotaria = codNotaria;
        this.codTipsoc = codTipsoc;
    }

    public String getCodNotaria() {
        return codNotaria;
    }

    public void setCodNotaria(String codNotaria) {
        this.codNotaria = codNotaria;
    }

    public String getCodTipsoc() {
        return codTipsoc;
    }

    public void setCodTipsoc(String codTipsoc) {
        this.codTipsoc = codTipsoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codNotaria != null ? codNotaria.hashCode() : 0);
        hash += (codTipsoc != null ? codTipsoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T031plantillaPK)) {
            return false;
        }
        T031plantillaPK other = (T031plantillaPK) object;
        if ((this.codNotaria == null && other.codNotaria != null) || (this.codNotaria != null && !this.codNotaria.equals(other.codNotaria))) {
            return false;
        }
        if ((this.codTipsoc == null && other.codTipsoc != null) || (this.codTipsoc != null && !this.codTipsoc.equals(other.codTipsoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T031plantillaPK[codNotaria=" + codNotaria + ", codTipsoc=" + codTipsoc + "]";
    }

}
