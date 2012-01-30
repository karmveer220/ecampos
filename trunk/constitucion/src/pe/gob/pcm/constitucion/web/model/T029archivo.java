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
@Table(name = "t029archivo")
public class T029archivo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ARCHIVO")
    private Integer idArchivo;
    
    @Column(name = "NUM_ARCHIVO")
    private Integer numArchivo;
    @Column(name = "IND_TIPARCH")
    private String indTiparch;
    @Column(name = "NOM_ARCHIVO")
    private String nomArchivo;
    
    @Lob
    @Column(name = "ARC_CONTENIDO")
    private byte[] arcContenido;
    
    @JoinColumn(name = "NUM_TRAMITE", referencedColumnName = "NUM_TRAMITE")
    @ManyToOne
    private T020tramite t020tramite;

    public T029archivo() {
    }

    public T029archivo(Integer idArchivo) {
        this.idArchivo = idArchivo;
    }

    public Integer getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(Integer idArchivo) {
        this.idArchivo = idArchivo;
    }

    public Integer getNumArchivo() {
        return numArchivo;
    }

    public void setNumArchivo(Integer numArchivo) {
        this.numArchivo = numArchivo;
    }

    public String getIndTiparch() {
        return indTiparch;
    }

    public void setIndTiparch(String indTiparch) {
        this.indTiparch = indTiparch;
    }

    public String getNomArchivo() {
        return nomArchivo;
    }

    public void setNomArchivo(String nomArchivo) {
        this.nomArchivo = nomArchivo;
    }

    public byte[] getArcContenido() {
        return arcContenido;
    }

    public void setArcContenido(byte[] arcContenido) {
        this.arcContenido = arcContenido;
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
        hash += (idArchivo != null ? idArchivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T029archivo)) {
            return false;
        }
        T029archivo other = (T029archivo) object;
        if ((this.idArchivo == null && other.idArchivo != null) || (this.idArchivo != null && !this.idArchivo.equals(other.idArchivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T029archivo[idArchivo=" + idArchivo + "]";
    }

}
