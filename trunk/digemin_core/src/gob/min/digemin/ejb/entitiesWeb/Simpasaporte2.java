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
public class Simpasaporte2 extends Simpasaporte1{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sMaterno;
    private String sNombre;
    private Calendar dFechaNacimiento;
    private String sPaterno;
    private String sSexo;
    private String sIdPaisNacimiento;    
    private String bColectivo;
    private String bConsular;
    private String bFallaControl;
    private String bManual;
    private String bVencido;
    private Integer nIdMotAnulacion;
    private Integer nIdSesion;
    private String sIdUbigeoNacimiento;   
    private String sNumeroTramite;
    private String sObservaciones;    
    private String sTipoControl;
    private String sTramiteAnu;
    private String sTramiteEmi;
    private String sTramiteRev;
    
    
    public Simpasaporte2() {
    }
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this,ToStringStyle.SIMPLE_STYLE);
    }
}
