package org.cnl.digemin.bean;

import java.io.Serializable;
import java.util.Calendar;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * Representa a un usuario logueado en el sistema
 * 
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public class BeanPersona implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long ncodigo;
    private BeanPerfil nperfil;
    /**Bean Notaria*/
    private BeanNotaria nnotaria;
    private Long perfil;
    /**Id de notaria*/
    private Long notaria;
    private String snombre;
    private String spaterno;
    private String smaterno;
    private String dnacimiento;
    private Calendar nacimiento;
    private String snum_doc;
    private String susuario;
    private String sclave;
    private String semail;
    private String nacionalidad;
    private Integer fclave;
    private String idSession;
    
    public BeanPersona() {
    }

    public BeanPersona(Long ncodigo,String snombre,String spaterno,String smaterno,BeanPerfil nperfil) {
        this.ncodigo=ncodigo;
        this.snombre=snombre;
        this.spaterno=spaterno;
        this.smaterno=smaterno;
        this.nperfil=nperfil;
    }

    public Long getNcodigo() {
        return ncodigo;
    }

    public void setNcodigo(Long ncodigo) {
        this.ncodigo = ncodigo;
    }

    public BeanPerfil getNperfil() {
        return nperfil;
    }

    public void setNperfil(BeanPerfil nperfil) {
        this.nperfil = nperfil;
    }

    public String getSnombre() {
        return snombre;
    }

    public void setSnombre(String snombre) {
        this.snombre = snombre;
    }

    public String getSpaterno() {
        return spaterno;
    }

    public void setSpaterno(String spaterno) {
        this.spaterno = spaterno;
    }

    public String getDnacimiento() {
        return dnacimiento;
    }

    public void setDnacimiento(String dnacimiento) {
        this.dnacimiento = dnacimiento;
    }

    public String getSnum_doc() {
        return snum_doc;
    }

    public void setSnum_doc(String snum_doc) {
        this.snum_doc = snum_doc;
    }

    public String getSusuario() {
        return susuario;
    }

    public void setSusuario(String susuario) {
        this.susuario = susuario;
    }

    public String getSclave() {
        return sclave;
    }

    public void setSclave(String sclave) {
        this.sclave = sclave;
    }
    
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this,ToStringStyle.SIMPLE_STYLE);
    }

    public void setSmaterno(String smaterno) {
        this.smaterno = smaterno;
    }

    public String getSmaterno() {
        return smaterno;
    }

    public void setPerfil(Long perfil) {
        this.perfil = perfil;
    }

    public Long getPerfil() {
        return perfil;
    }

    public void setNacimiento(Calendar nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Calendar getNacimiento() {
        return nacimiento;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setFclave(Integer fclave) {
        this.fclave = fclave;
    }

    public Integer getFclave() {
        return fclave;
    }

    public void setIdSession(String idSession) {
        this.idSession = idSession;
    }

    public String getIdSession() {
        return idSession;
    }

    public void setNnotaria(BeanNotaria nnotaria) {
        this.nnotaria = nnotaria;
    }

    public BeanNotaria getNnotaria() {
        return nnotaria;
    }

    public void setNotaria(Long notaria) {
        this.notaria = notaria;
    }

    public Long getNotaria() {
        return notaria;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public String getSemail() {
        return semail;
    }
}
