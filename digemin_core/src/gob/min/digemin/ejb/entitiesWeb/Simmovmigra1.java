package gob.min.digemin.ejb.entitiesWeb;

import java.io.Serializable;
import java.util.Calendar;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Mayo 2009
 * @version 1.0
 */
public class Simmovmigra1 implements Serializable{

    /**
     * Identificador unico del movimiento migratorio
     */
    private String sIdMovMigratorio;
    /**
     * Identificador unico de la calidad migratoria con la cual se realizo el movimiento.</br>
     * Asignada al llegar al Peru
     */
    private Simcalidadmigratoria1 nIdCalidad;
    /**
     * Fecha en la que se realizo el control del movimiento migratorio.</br>
     * Fecha del movimietno migratorio
     */
    private Calendar dFechaControl;
    /**
     * Numero del documento de la persona con el que realizo del movimiento</br>
     * Num. Pasaporte, Num Carnet Ext., etc.
     */
    private String sNumeroDoc;
    //TODO: eliminar este q no se usa
    /**
     * Numero del documento presentado cuando se realizo el control del movimiento</br>
     * Num. Pasaporte, Num Carnet Ext., etc.
     */     
     @Deprecated
    private String sNumDocControl;
    /**
     * Observaciones
     */
    private String sObservaciones;
    /**
     * Pais de donde vino la persona
     */
    private Simpais1 sIdPaisMov;
    /**
     * Direccion a la cual debia llegar la persona
     */
    private String sDireccionDestino;
    /**
     * Identificador del documento que presento la persona
     */
    private Simdocumento1 sIdDocumento;
    /**
     * Tipo de movimietno migratorio
     */
    private String sTipo;
    
    public Simmovmigra1() {
    }
    /**
     * Constructor con parametros
     * @param sIdMovMigratorio Identificador unico del movimiento migratorio
     * @param nIdCalidad Identificador unico de la calidad migratoria
     * @param dFechaControl Fecha en la que se realizo el control migratorio
     * @param sNumeroDoc Numero del documento de la persona con el que realizo del movimiento
     * @param sNumDocControl Numero del documento presentado cuando se realizo el control del movimiento
     * @param sObservaciones Observaciones
     * @param sIdPaisMov Pais de donde vino la persona
     * @param sDireccionDestino Direccion a la cual debia llegar la persona
     * @param sIdDocumento Identificador del documento que presento la persona
     * @param sTipo Tipo de movimietno migratorio
     */
    public Simmovmigra1(String sIdMovMigratorio,Simcalidadmigratoria1 nIdCalidad,Calendar dFechaControl,
                        String sNumeroDoc,String sNumDocControl,
                        String sObservaciones,Simpais1 sIdPaisMov,
                        String sDireccionDestino,Simdocumento1 sIdDocumento,String sTipo) {
        this.sIdMovMigratorio=sIdMovMigratorio;
        this.nIdCalidad=nIdCalidad;
        this.dFechaControl=dFechaControl;
        this.sNumeroDoc=sNumeroDoc;
        this.sNumDocControl=sNumDocControl;
        this.sObservaciones=sObservaciones;
        this.sIdPaisMov=sIdPaisMov;
        this.sDireccionDestino=sDireccionDestino;
        this.sIdDocumento=sIdDocumento;
        this.sTipo=sTipo;
        
    }
    
    public void setSIdMovMigratorio(String sIdMovMigratorio) {
        this.sIdMovMigratorio = sIdMovMigratorio;
    }

    public String getSIdMovMigratorio() {
        return sIdMovMigratorio;
    }

    public void setNIdCalidad(Simcalidadmigratoria1 nIdCalidad) {
        this.nIdCalidad = nIdCalidad;
    }

    public Simcalidadmigratoria1 getNIdCalidad() {
        return nIdCalidad;
    }

    public void setDFechaControl(Calendar dFechaControl) {
        this.dFechaControl = dFechaControl;
    }

    public Calendar getDFechaControl() {
        return dFechaControl;
    }

    public void setSNumeroDoc(String sNumeroDoc) {
        this.sNumeroDoc = sNumeroDoc;
    }

    public String getSNumeroDoc() {
        return sNumeroDoc;
    }

    public void setSNumDocControl(String sNumDocControl) {
        this.sNumDocControl = sNumDocControl;
    }

    public String getSNumDocControl() {
        return sNumDocControl;
    }

    public void setSObservaciones(String sObservaciones) {
        this.sObservaciones = sObservaciones;
    }

    public String getSObservaciones() {
        return sObservaciones;
    }

    public void setSIdPaisMov(Simpais1 sIdPaisMov) {
        this.sIdPaisMov = sIdPaisMov;
    }

    public Simpais1 getSIdPaisMov() {
        return sIdPaisMov;
    }

    public void setSDireccionDestino(String sDireccionDestino) {
        this.sDireccionDestino = sDireccionDestino;
    }

    public String getSDireccionDestino() {
        return sDireccionDestino;
    }

    public void setSIdDocumento(Simdocumento1 sIdDocumento) {
        this.sIdDocumento = sIdDocumento;
    }

    public Simdocumento1 getSIdDocumento() {
        return sIdDocumento;
    }

    public void setSTipo(String sTipo) {
        this.sTipo = sTipo;
    }

    public String getSTipo() {
        return sTipo;
    }
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this,ToStringStyle.SIMPLE_STYLE);
    }
}
