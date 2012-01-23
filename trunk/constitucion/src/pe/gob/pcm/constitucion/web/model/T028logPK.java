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
public class T028logPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ANN_LOG")
    private short annLog;
    @Basic(optional = false)
    @Column(name = "NUM_LOG")
    private int numLog;

    public T028logPK() {
    }

    public T028logPK(short annLog, int numLog) {
        this.annLog = annLog;
        this.numLog = numLog;
    }

    public short getAnnLog() {
        return annLog;
    }

    public void setAnnLog(short annLog) {
        this.annLog = annLog;
    }

    public int getNumLog() {
        return numLog;
    }

    public void setNumLog(int numLog) {
        this.numLog = numLog;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) annLog;
        hash += (int) numLog;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T028logPK)) {
            return false;
        }
        T028logPK other = (T028logPK) object;
        if (this.annLog != other.annLog) {
            return false;
        }
        if (this.numLog != other.numLog) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.gob.pcm.constitucion.web.model.T028logPK[annLog=" + annLog + ", numLog=" + numLog + "]";
    }

}
