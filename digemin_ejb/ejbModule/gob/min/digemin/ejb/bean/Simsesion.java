package gob.min.digemin.ejb.bean;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Entity
@NamedQuery(name = "Simsesion.findAll", query = "select o from Simsesion o")
@Table(name = "\"SimSesion\"")
public class Simsesion implements Serializable {
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean bActivo;
    private Calendar dFechaFin;
    private Calendar dFechaInicio;
    private Integer nIdEstacion;
    private Integer nIdOperador;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nIdSesion;
    private Integer nIdSesionMigra;
    private String sAppServer;
    private String sIPAddress;
    private String sIdDependencia;
    private String sIdModulo;
    private String sIdSubDependencia;
    private String sMacAddress;
    private String sPuerto;
    private String sUsuarioRed;
    private String sVersionModulo;
    private byte[] xToken;

    public Simsesion() {
    }

    public boolean getBActivo() {
        return bActivo;
    }

    public void setBActivo(boolean bActivo) {
        this.bActivo = bActivo;
    }

    public Calendar getDFechaFin() {
        return dFechaFin;
    }

    public void setDFechaFin(Calendar dFechaFin) {
        this.dFechaFin = dFechaFin;
    }

    public Calendar getDFechaInicio() {
        return dFechaInicio;
    }

    public void setDFechaInicio(Calendar dFechaInicio) {
        this.dFechaInicio = dFechaInicio;
    }

    public Integer getNIdEstacion() {
        return nIdEstacion;
    }

    public void setNIdEstacion(Integer nIdEstacion) {
        this.nIdEstacion = nIdEstacion;
    }

    public Integer getNIdOperador() {
        return nIdOperador;
    }

    public void setNIdOperador(Integer nIdOperador) {
        this.nIdOperador = nIdOperador;
    }

    public Integer getNIdSesion() {
        return nIdSesion;
    }

    public void setNIdSesion(Integer nIdSesion) {
        this.nIdSesion = nIdSesion;
    }

    public Integer getNIdSesionMigra() {
        return nIdSesionMigra;
    }

    public void setNIdSesionMigra(Integer nIdSesionMigra) {
        this.nIdSesionMigra = nIdSesionMigra;
    }

    public String getSAppServer() {
        return sAppServer;
    }

    public void setSAppServer(String sAppServer) {
        this.sAppServer = sAppServer;
    }

    public String getSIPAddress() {
        return sIPAddress;
    }

    public void setSIPAddress(String sIPAddress) {
        this.sIPAddress = sIPAddress;
    }

    public String getSIdDependencia() {
        return sIdDependencia;
    }

    public void setSIdDependencia(String sIdDependencia) {
        this.sIdDependencia = sIdDependencia;
    }

    public String getSIdModulo() {
        return sIdModulo;
    }

    public void setSIdModulo(String sIdModulo) {
        this.sIdModulo = sIdModulo;
    }

    public String getSIdSubDependencia() {
        return sIdSubDependencia;
    }

    public void setSIdSubDependencia(String sIdSubDependencia) {
        this.sIdSubDependencia = sIdSubDependencia;
    }

    public String getSMacAddress() {
        return sMacAddress;
    }

    public void setSMacAddress(String sMacAddress) {
        this.sMacAddress = sMacAddress;
    }

    public String getSPuerto() {
        return sPuerto;
    }

    public void setSPuerto(String sPuerto) {
        this.sPuerto = sPuerto;
    }

    public String getSUsuarioRed() {
        return sUsuarioRed;
    }

    public void setSUsuarioRed(String sUsuarioRed) {
        this.sUsuarioRed = sUsuarioRed;
    }

    public String getSVersionModulo() {
        return sVersionModulo;
    }

    public void setSVersionModulo(String sVersionModulo) {
        this.sVersionModulo = sVersionModulo;
    }

    public byte[] getXToken() {
        return xToken;
    }

    public void setXToken(byte[] xToken) {
        this.xToken = xToken;
    }
    @Override
                public String toString(){
                    return ToStringBuilder.reflectionToString(this,ToStringStyle.SIMPLE_STYLE);
                }
}
