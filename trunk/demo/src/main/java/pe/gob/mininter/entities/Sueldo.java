package pe.gob.mininter.entities;

import java.io.Serializable;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Sueldo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private Integer mes;
	private String desc_mes;
	private Integer anio;
	private Double monto;
	private Double afp;
	private Double essalud;
	private Double renta;
	private Double neto;
	private Integer dias;
	private String estado;
	private Integer contrato;
	private String renuncia;
	private Integer mesRenuncia;
	private Integer updateRenuncia;
	
	//Contrato
	private String fecIniCont;
	private String fecFinCont;
	
	public Sueldo( ){
		  codigo=0;
		  mes=0;
		  anio=0;
		  monto=0.00;
		  afp=0.00;
		  essalud=0.00;
		  renta=0.00;
		  neto=0.00;
		  dias=0;
		  contrato=0;		
	}
	
	public Sueldo(Integer codigo, Integer mes, Integer anio, Double monto, Double afp, Double essalud, Double renta, Double neto, Integer contrato){
		this.codigo=codigo;
		this.mes=mes;
		this.anio=anio;
		this.monto=monto;
		this.afp=afp;
		this.essalud=essalud;
		this.renta=renta;
		this.neto=neto;
		this.contrato=contrato;
	}
	public Sueldo(int int1, String string, String string2, String string3,	double double1) {

	}

	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public Double getAfp() {
		return afp;
	}
	public void setAfp(Double afp) {
		this.afp = afp;
	}
	public Double getEssalud() {
		return essalud;
	}
	public void setEssalud(Double essalud) {
		this.essalud = essalud;
	}
	public Double getRenta() {
		return renta;
	}
	public void setRenta(Double renta) {
		this.renta = renta;
	}
	public Double getNeto() {
		return neto;
	}
	public void setNeto(Double neto) {
		this.neto = neto;
	}
	public Integer getDias() {
		return dias;
	}
	public void setDias(Integer dias) {
		this.dias = dias;
	}
	public Integer getContrato() {
		return contrato;
	}
	public void setContrato(Integer contrato) {
		this.contrato = contrato;
	}
	public String getDesc_mes() {
		return desc_mes;
	}
	public void setDesc_mes(String desc_mes) {
		this.desc_mes = desc_mes;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFecIniCont() {
		return fecIniCont;
	}
	public void setFecIniCont(String fecIniCont) {
		this.fecIniCont = fecIniCont;
	}
	public String getFecFinCont() {
		return fecFinCont;
	}
	public void setFecFinCont(String fecFinCont) {
		this.fecFinCont = fecFinCont;
	}
	public String getRenuncia() {
		return renuncia;
	}
	public void setRenuncia(String renuncia) {
		this.renuncia = renuncia;
	}
	public Integer getMesRenuncia() {
		return mesRenuncia;
	}

	public void setMesRenuncia(Integer mesRenuncia) {
		this.mesRenuncia = mesRenuncia;
	}

	public Integer getUpdateRenuncia() {
		return updateRenuncia;
	}

	public void setUpdateRenuncia(Integer updateRenuncia) {
		this.updateRenuncia = updateRenuncia;
	}

	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
}
