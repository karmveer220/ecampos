/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.gob.pcm.constitucion.web.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author elvis
 */
@Entity
@Table(name = "t030inserto")
public class T030inserto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_INSERTO")
    private Integer idInserto;
    @Column(name = "NUM_INSERTO")
    private Short numInserto;
    @Column(name = "IND_TIPINSERTO")
    private Character indTipinserto;
    
    @Lob
    @Column(name = "DES_INSERTO")
    private String desInserto;
    
    @JoinColumn(name = "NUM_TRAMITE", referencedColumnName = "NUM_TRAMITE")
    @ManyToOne(optional = false)
    private T020tramite t020tramite;

    public T030inserto() {
    }

    public T030inserto(Integer idInserto) {
        this.idInserto = idInserto;
    }

    public Integer getIdInserto() {
        return idInserto;
    }

    public void setIdInserto(Integer idInserto) {
        this.idInserto = idInserto;
    }

    public Short getNumInserto() {
        return numInserto;
    }

    public void setNumInserto(Short numInserto) {
        this.numInserto = numInserto;
    }

    public Character getIndTipinserto() {
        return indTipinserto;
    }

    public void setIndTipinserto(Character indTipinserto) {
        this.indTipinserto = indTipinserto;
    }

    public String getDesInserto() {
        return desInserto;
    }

    public void setDesInserto(String desInserto) {
        this.desInserto = desInserto;
    }

    public T020tramite getT020tramite() {
        return t020tramite;
    }

    public void setT020tramite(T020tramite t020tramite) {
        this.t020tramite = t020tramite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInserto != null ? idInserto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T030inserto)) {
            return false;
        }
        T030inserto other = (T030inserto) object;
        if ((this.idInserto == null && other.idInserto != null) || (this.idInserto != null && !this.idInserto.equals(other.idInserto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T030inserto[idInserto=" + idInserto + "]";
    }

}
