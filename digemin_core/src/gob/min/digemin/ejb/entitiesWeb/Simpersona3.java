package gob.min.digemin.ejb.entitiesWeb;

import java.util.Calendar;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public class Simpersona3 extends Simpersona2{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sIdPaisResidencia;
    private String nIdCalidad;
    private Calendar dUltimoIngreso;
    private Calendar dFechaHoraAud;
    private String sUltimoPasaporte;
    private String sIdProfesion;
    private Integer nIdSesion;
    private String sObservaciones;
    
    public Simpersona3() {
    }

    public String getSIdPaisResidencia() {
        return sIdPaisResidencia;
    }

    public void setSIdPaisResidencia(String sIdPaisResidencia) {
        this.sIdPaisResidencia = sIdPaisResidencia;
    }

    public String getNIdCalidad() {
        return nIdCalidad;
    }

    public void setNIdCalidad(String nIdCalidad) {
        this.nIdCalidad = nIdCalidad;
    }

    public Calendar getDUltimoIngreso() {
        return dUltimoIngreso;
    }

    public void setDUltimoIngreso(Calendar dUltimoIngreso) {
        this.dUltimoIngreso = dUltimoIngreso;
    }

    public Calendar getDFechaHoraAud() {
        return dFechaHoraAud;
    }

    public void setDFechaHoraAud(Calendar dFechaHoraAud) {
        this.dFechaHoraAud = dFechaHoraAud;
    }

    public String getSUltimoPasaporte() {
        return sUltimoPasaporte;
    }

    public void setSUltimoPasaporte(String sUltimoPasaporte) {
        this.sUltimoPasaporte = sUltimoPasaporte;
    }

    public String getSIdProfesion() {
        return sIdProfesion;
    }

    public void setSIdProfesion(String sIdProfesion) {
        this.sIdProfesion = sIdProfesion;
    }

    public Integer getNIdSesion() {
        return nIdSesion;
    }

    public void setNIdSesion(Integer nIdSesion) {
        this.nIdSesion = nIdSesion;
    }

    public String getSObservaciones() {
        return sObservaciones;
    }

    public void setSObservaciones(String sObservaciones) {
        this.sObservaciones = sObservaciones;
    }
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this,ToStringStyle.SIMPLE_STYLE);
    }
}
