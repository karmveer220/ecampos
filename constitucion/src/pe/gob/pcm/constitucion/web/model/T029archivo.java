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
import javax.persistence.Lob;
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
    @Basic(optional = false)
    @Column(name = "NUM_TRAMITE")
    private int numTramite;
    @Basic(optional = false)
    @Column(name = "NUM_ARCHIVO")
    private int numArchivo;
    @Basic(optional = false)
    @Column(name = "IND_TIPARCH")
    private char indTiparch;
    @Basic(optional = false)
    @Column(name = "NOM_ARCHIVO")
    private String nomArchivo;
    @Basic(optional = false)
    @Lob
    @Column(name = "ARC_CONTENIDO")
    private byte[] arcContenido;

    public T029archivo() {
    }

    public T029archivo(Integer idArchivo) {
        this.idArchivo = idArchivo;
    }

    public T029archivo(Integer idArchivo, int numTramite, int numArchivo, char indTiparch, String nomArchivo, byte[] arcContenido) {
        this.idArchivo = idArchivo;
        this.numTramite = numTramite;
        this.numArchivo = numArchivo;
        this.indTiparch = indTiparch;
        this.nomArchivo = nomArchivo;
        this.arcContenido = arcContenido;
    }

    public Integer getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(Integer idArchivo) {
        this.idArchivo = idArchivo;
    }

    public int getNumTramite() {
        return numTramite;
    }

    public void setNumTramite(int numTramite) {
        this.numTramite = numTramite;
    }

    public int getNumArchivo() {
        return numArchivo;
    }

    public void setNumArchivo(int numArchivo) {
        this.numArchivo = numArchivo;
    }

    public char getIndTiparch() {
        return indTiparch;
    }

    public void setIndTiparch(char indTiparch) {
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
        return "pe.gob.pcm.constitucion.model.T029archivo[idArchivo=" + idArchivo + "]";
    }

}
