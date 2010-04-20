package gob.min.digemin.ejb.bean;

import java.io.Serializable;
/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public class SimpasperuPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String sPasNumero;
    public String uIdPersona;

    public SimpasperuPK() {
    }

    public SimpasperuPK(String sPasNumero, String uIdPersona) {
        this.sPasNumero = sPasNumero;
        this.uIdPersona = uIdPersona;
    }

    public boolean equals(Object other) {
        if (other instanceof SimpasperuPK) {
            final SimpasperuPK otherSimpasperuPK = (SimpasperuPK) other;
            final boolean areEqual = 
                (otherSimpasperuPK.sPasNumero.equals(sPasNumero) && otherSimpasperuPK.uIdPersona.equals(uIdPersona));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
