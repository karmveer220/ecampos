package pe.gob.mininter.entities;

import java.io.Serializable;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class BDsctoHaber implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer codigoPersona;
	private Integer contador;
	
	private String codigoDsctoHaber;
	private String codigoDscto;
	private String codigoHaber;
	private String nombreDscto;
	private String nombreEmp;
	private String codigoEmp;
	private Double montoDsctoHaber;
	private Integer mesDscto;
	private Integer periodoDscto;
	private Integer estadoDH;
	private Integer tipoPago;
	
	private String nombresPersona;
	public BDsctoHaber () {
	}
	public BDsctoHaber (String codigoDscto, String nombreDscto) {
		this.codigoDscto=codigoDscto;
		this.nombreDscto=nombreDscto;
	}
	public String getCodigoDscto() {
		return codigoDscto;
	}
	public void setCodigoDscto(String codigoDscto) {
		this.codigoDscto = codigoDscto;
	}
	public String getNombreEmp() {
		return nombreEmp;
	}
	public void setNombreEmp(String nombreEmp) {
		this.nombreEmp = nombreEmp;
	}
	public String getNombreDscto() {
		return nombreDscto;
	}
	public void setNombreDscto(String nombreDscto) {
		this.nombreDscto = nombreDscto;
	}
	public String getCodigoEmp() {
		return codigoEmp;
	}
	public void setCodigoEmp(String codigoEmp) {
		this.codigoEmp = codigoEmp;
	}	
	public Integer getMesDscto() {
		return mesDscto;
	}
	public void setMesDscto(Integer mesDscto) {
		this.mesDscto = mesDscto;
	}
	public Integer getPeriodoDscto() {
		return periodoDscto;
	}
	public void setPeriodoDscto(Integer periodoDscto) {
		this.periodoDscto = periodoDscto;
	}	
	public Integer getEstadoDH() {
		return estadoDH;
	}
	public void setEstadoDH(Integer estadoDH) {
		this.estadoDH = estadoDH;
	}
	public String getCodigoDsctoHaber() {
		return codigoDsctoHaber;
	}
	public void setCodigoDsctoHaber(String codigoDsctoHaber) {
		this.codigoDsctoHaber = codigoDsctoHaber;
	}
	public String getCodigoHaber() {
		return codigoHaber;
	}
	public void setCodigoHaber(String codigoHaber) {
		this.codigoHaber = codigoHaber;
	}
	public Double getMontoDsctoHaber() {
		return montoDsctoHaber;
	}
	public void setMontoDsctoHaber(Double montoDsctoHaber) {
		this.montoDsctoHaber = montoDsctoHaber;
	}
	public Integer getCodigoPersona() {
		return codigoPersona;
	}
	public void setCodigoPersona(Integer codigoPersona) {
		this.codigoPersona = codigoPersona;
	}
	public String getNombresPersona() {
		return nombresPersona;
	}
	public void setNombresPersona(String nombresPersona) {
		this.nombresPersona = nombresPersona;
	}
	public Integer getContador() {
		return contador;
	}
	public void setContador(Integer contador) {
		this.contador = contador;
	}
	public Integer getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(Integer tipoPago) {
		this.tipoPago = tipoPago;
	}
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
