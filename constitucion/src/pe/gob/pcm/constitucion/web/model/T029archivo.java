/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.gob.pcm.constitucion.web.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
    @EmbeddedId
    protected T029archivoPK t029archivoPK;
    @Column(name = "IND_TIPARCH")
    private Character indTiparch;
    @Column(name = "NOM_ARCHIVO")
    private String nomArchivo;
    @Lob
    @Column(name = "ARC_CONTENIDO")
    private byte[] arcContenido;
    @JoinColumns({
        @JoinColumn(name = "ANN_TRAMITE", referencedColumnName = "ANN_TRAMITE", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_TRAMITE", referencedColumnName = "NUM_TRAMITE", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private T020tramite t020tramite;

    public T029archivo() {
    }

    public T029archivo(T029archivoPK t029archivoPK) {
        this.t029archivoPK = t029archivoPK;
    }

    public T029archivo(short annTramite, int numTramite, short numArchivo) {
        this.t029archivoPK = new T029archivoPK(annTramite, numTramite, numArchivo);
    }

    public T029archivoPK getT029archivoPK() {
        return t029archivoPK;
    }

    public void setT029archivoPK(T029archivoPK t029archivoPK) {
        this.t029archivoPK = t029archivoPK;
    }

    public Character getIndTiparch() {
        return indTiparch;
    }

    public void setIndTiparch(Character indTiparch) {
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
        hash += (t029archivoPK != null ? t029archivoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T029archivo)) {
            return false;
        }
        T029archivo other = (T029archivo) object;
        if ((this.t029archivoPK == null && other.t029archivoPK != null) || (this.t029archivoPK != null && !this.t029archivoPK.equals(other.t029archivoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T029archivo[t029archivoPK=" + t029archivoPK + "]";
    }

}
