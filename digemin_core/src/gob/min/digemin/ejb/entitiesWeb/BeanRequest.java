package gob.min.digemin.ejb.entitiesWeb;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * En cada pedido que se haga al WebService se debe enviar el idSession para 
 * registrarlo en el log
 * @author Elvis Ruben Campos Mori
 *
 */
public class BeanRequest implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uIdPersona;
    private String sUsuario;
    private String sClave;
    private String sNombre;
    private String sApePaterno;
    private String sApeMaterno;
    private String sIdPaisNacionalidad;
    private boolean bPeruano;
    private boolean bAproximado; 
    private String sNumPasaporte;
    private String sNumCE;
    private String sNumDocMovimiento;
    private String sPersLlave;
    private String[] sTipoImagen;
    private String sIdSession;
    
    public BeanRequest(){
    
    }
    
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this,ToStringStyle.SIMPLE_STYLE);
    }

    public String getUIdPersona() {
        return uIdPersona;
    }

    public void setUIdPersona(String uIdPersona) {
        this.uIdPersona = uIdPersona;
    }

    public String getSUsuario() {
        return sUsuario;
    }

    public void setSUsuario(String sUsuario) {
        this.sUsuario = sUsuario;
    }

    public String getSClave() {
        return sClave;
    }

    public void setSClave(String sClave) {
        this.sClave = sClave;
    }

    public String getSNombre() {
        return sNombre;
    }

    public void setSNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getSApePaterno() {
        return sApePaterno;
    }

    public void setSApePaterno(String sApePaterno) {
        this.sApePaterno = sApePaterno;
    }

    public String getSApeMaterno() {
        return sApeMaterno;
    }

    public void setSApeMaterno(String sApeMaterno) {
        this.sApeMaterno = sApeMaterno;
    }

    public String getSIdPaisNacionalidad() {
        return sIdPaisNacionalidad;
    }

    public void setSIdPaisNacionalidad(String sIdPaisNacionalidad) {
        this.sIdPaisNacionalidad = sIdPaisNacionalidad;
    }

    public boolean isBPeruano() {
        return bPeruano;
    }

    public void setBPeruano(boolean bPeruano) {
        this.bPeruano = bPeruano;
    }

    public boolean isBAproximado() {
        return bAproximado;
    }

    public void setBAproximado(boolean bAproximado) {
        this.bAproximado = bAproximado;
    }

    public String getSNumPasaporte() {
        return sNumPasaporte;
    }

    public void setSNumPasaporte(String sNumPasaporte) {
        this.sNumPasaporte = sNumPasaporte;
    }

    public String getSNumCE() {
        return sNumCE;
    }

    public void setSNumCE(String sNumCE) {
        this.sNumCE = sNumCE;
    }

    public String getSPersLlave() {
        return sPersLlave;
    }

    public void setSPersLlave(String sPersLlave) {
        this.sPersLlave = sPersLlave;
    }

    public String[] getSTipoImagen() {
        return sTipoImagen;
    }

    public void setSTipoImagen(String[] sTipoImagen) {
        this.sTipoImagen = sTipoImagen;
    }

    public String getSIdSession() {
        return sIdSession;
    }

    public void setSIdSession(String sIdSession) {
        this.sIdSession = sIdSession;
    }

	public String getSNumDocMovimiento() {
		return sNumDocMovimiento;
	}

	public void setSNumDocMovimiento(String numDocMovimiento) {
		sNumDocMovimiento = numDocMovimiento;
	}
    
    
}
