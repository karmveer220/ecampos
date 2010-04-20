package gob.min.digemin.ejb.entitiesWeb;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public class Simpersona2 extends Simpersona1 {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String notas;
    private String bActivo;
    private String bEnElPais;
    private Integer nPermanencia;
    private String sBusqueda;
    private String sCodAnterior;
    private String sIdDocViaje;
    private String sIdEstadoCivil;
    private String sNumDocViaje;
    
    public Simpersona2() {
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getBActivo() {
        return bActivo;
    }

    public void setBActivo(String bActivo) {
        this.bActivo = bActivo;
    }

    public String getBEnElPais() {
        return bEnElPais;
    }

    public void setBEnElPais(String bEnElPais) {
        this.bEnElPais = bEnElPais;
    }

    public Integer getNPermanencia() {
        return nPermanencia;
    }

    public void setNPermanencia(Integer nPermanencia) {
        this.nPermanencia = nPermanencia;
    }

    public String getSBusqueda() {
        return sBusqueda;
    }

    public void setSBusqueda(String sBusqueda) {
        this.sBusqueda = sBusqueda;
    }

    public String getSCodAnterior() {
        return sCodAnterior;
    }

    public void setSCodAnterior(String sCodAnterior) {
        this.sCodAnterior = sCodAnterior;
    }
  
    public String getSIdDocViaje() {
        return sIdDocViaje;
    }

    public void setSIdDocViaje(String sIdDocViaje) {
        this.sIdDocViaje = sIdDocViaje;
    }

    public String getSIdEstadoCivil() {
        return sIdEstadoCivil;
    }

    public void setSIdEstadoCivil(String sIdEstadoCivil) {
        this.sIdEstadoCivil = sIdEstadoCivil;
    }

    public String getSNumDocViaje() {
        return sNumDocViaje;
    }

    public void setSNumDocViaje(String sNumDocViaje) {
        this.sNumDocViaje = sNumDocViaje;
    }
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this,ToStringStyle.SIMPLE_STYLE);
    }
}
