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
public class Simpasaporte3 extends Simpasaporte2{

    private Calendar dFechaAnulacion;
    private Calendar dFechaHoraAud;
    private Calendar dFechaHoraReg;    
    private Calendar dFechaRevalidacion;
    private Calendar dFechaTramite;
    private String sIdDepAnu;
    private String sIdDepEmi;
    private String sIdDepRev;
    private String sIdDependencia;
    private Integer nIntentosOCRB;
    
    public Simpasaporte3() {
    }
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this,ToStringStyle.SIMPLE_STYLE);
    }
}
