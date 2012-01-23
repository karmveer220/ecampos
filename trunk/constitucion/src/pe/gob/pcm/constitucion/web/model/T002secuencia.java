/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.gob.pcm.constitucion.web.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author elvis
 */
@Entity
@Table(name = "t002secuencia")
public class T002secuencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NOM_SECUENCIA")
    private String nomSecuencia;
    @Column(name = "NUM_INCREMENTO")
    private Short numIncremento;
    @Column(name = "NUM_MINVAL")
    private Short numMinval;
    @Column(name = "NUM_MAXVAL")
    private BigInteger numMaxval;
    @Column(name = "NUM_ACTVAL")
    private BigInteger numActval;
    @Column(name = "IND_CIRCULAR")
    private Boolean indCircular;

    public T002secuencia() {
    }

    public T002secuencia(String nomSecuencia) {
        this.nomSecuencia = nomSecuencia;
    }

    public String getNomSecuencia() {
        return nomSecuencia;
    }

    public void setNomSecuencia(String nomSecuencia) {
        this.nomSecuencia = nomSecuencia;
    }

    public Short getNumIncremento() {
        return numIncremento;
    }

    public void setNumIncremento(Short numIncremento) {
        this.numIncremento = numIncremento;
    }

    public Short getNumMinval() {
        return numMinval;
    }

    public void setNumMinval(Short numMinval) {
        this.numMinval = numMinval;
    }

    public BigInteger getNumMaxval() {
        return numMaxval;
    }

    public void setNumMaxval(BigInteger numMaxval) {
        this.numMaxval = numMaxval;
    }

    public BigInteger getNumActval() {
        return numActval;
    }

    public void setNumActval(BigInteger numActval) {
        this.numActval = numActval;
    }

    public Boolean getIndCircular() {
        return indCircular;
    }

    public void setIndCircular(Boolean indCircular) {
        this.indCircular = indCircular;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomSecuencia != null ? nomSecuencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T002secuencia)) {
            return false;
        }
        T002secuencia other = (T002secuencia) object;
        if ((this.nomSecuencia == null && other.nomSecuencia != null) || (this.nomSecuencia != null && !this.nomSecuencia.equals(other.nomSecuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T002secuencia[nomSecuencia=" + nomSecuencia + "]";
    }

}
