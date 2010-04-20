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
public class Simcarnetextranjeria2 extends Simcarnetextranjeria1{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bAnulado;
    private String bDuplicado;
    private String bEntregado;
    private String bImpreso;
    private Calendar dFechaAnulacion;
    private Calendar dFechaHoraAud;
    private Calendar dFechaInscripcion;
    private Integer nIdFicha;
    private Integer nIdInscripcion;
    private Integer nIdSesion;
    private String sNumeroTramite;
    
    public Simcarnetextranjeria2() {
    
    }
    
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this,ToStringStyle.SIMPLE_STYLE);
    }
}
