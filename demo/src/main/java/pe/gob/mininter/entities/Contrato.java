package pe.gob.mininter.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.log4j.Logger;

public class Contrato implements Serializable {
	
	private static final Logger logger = Logger.getLogger(Contrato.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cod_empleado;
	private Empleado empleado;
	private String cod_contrato; 	
	private String fec_ini_cont;
	private String fec_fin_cont;
	private String fec_fin_cont_modi;
	private String fec_renuncia;
	private String sueld_cont;
	private String sueldNeto_cont;
	private String dscto_cont;
	private String nro_cont;
	private String ofi_asignada;
	private String turno_asignado;
	private String carg_asignado;
	private String sist_pension;
	private String funcion_cont;
	private String estado_cont;
	private String nro_dni;
	private String actividades;
	private SistPension sistemaPension;
	private List<Adenda> adendas;
	/**Para ayuda en el jsp*/
	private boolean llenarDetalle=false;
	private Integer cantMeses;
	private Integer cantDias;
	private Integer diasMesUno;
	private boolean isMesUnoCompleto=false;
	private List<Sueldo> sueldos;
	private boolean radioImp1 = false;
	private boolean radioImp2 = false;
	private String sueldo = "";	
	
	public Contrato(){
		sueldos = new ArrayList<Sueldo>();
	}
	
	public Contrato(String cod_contrato,String fec_ini_cont,String fec_fin_cont_modi) {
		this.cod_contrato = cod_contrato;
		this.fec_ini_cont = fec_ini_cont;
		this.fec_fin_cont_modi = fec_fin_cont_modi;	
	}

	public List<Sueldo> getSueldos() {
		return sueldos;
	}
	public void setSueldos(List<Sueldo> sueldos) {
		this.sueldos = sueldos;
	}
	public Integer getCantMeses() {
		return cantMeses;
	}
	public void setCantMeses(Integer cantMeses) {
		this.cantMeses = cantMeses;
	}
	public String getCod_empleado() {
		return cod_empleado;
	}
	public void setCod_empleado(String cod_empleado) {
		this.cod_empleado = cod_empleado;
	}
	public String getCod_contrato() {
		return cod_contrato;
	}
	public void setCod_contrato(String cod_contrato) {
		this.cod_contrato = cod_contrato;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public String getFec_ini_cont() {
		return fec_ini_cont;
	}
	public void setFec_ini_cont(String fec_ini_cont) {
		this.fec_ini_cont = fec_ini_cont;
	}
	public String getFec_fin_cont() {
		return fec_fin_cont;
	}
	public void setFec_fin_cont(String fec_fin_cont) {
		this.fec_fin_cont = fec_fin_cont;
	}
	public String getSueld_cont() {
		return sueld_cont;
	}
	public void setSueld_cont(String sueld_cont) {
		this.sueld_cont = sueld_cont;
	}

	public String getSueldNeto_cont() {
		return sueldNeto_cont;
	}

	public void setSueldNeto_cont(String sueldNeto_cont) {
		this.sueldNeto_cont = sueldNeto_cont;
	}

	public String getDscto_cont() {
		return dscto_cont;
	}

	public void setDscto_cont(String dscto_cont) {
		this.dscto_cont = dscto_cont;
	}

	public String getNro_cont() {
		return nro_cont;
	}

	public void setNro_cont(String nro_cont) {
		this.nro_cont = nro_cont;
	}

	public String getOfi_asignada() {
		return ofi_asignada;
	}

	public void setOfi_asignada(String ofi_asignada) {
		this.ofi_asignada = ofi_asignada;
	}

	public String getTurno_asignado() {
		return turno_asignado;
	}

	public void setTurno_asignado(String turno_asignado) {
		this.turno_asignado = turno_asignado;
	}

	public String getCarg_asignado() {
		return carg_asignado;
	}

	public void setCarg_asignado(String carg_asignado) {
		this.carg_asignado = carg_asignado;
	}

	public String getSist_pension() {
		return sist_pension;
	}

	public void setSist_pension(String sist_pension) {
		this.sist_pension = sist_pension;
	}

	public String getFuncion_cont() {
		return funcion_cont;
	}

	public void setFuncion_cont(String funcion_cont) {
		this.funcion_cont = funcion_cont;
	}

	public String getEstado_cont() {
		return estado_cont;
	}

	public void setEstado_cont(String estado_cont) {
		this.estado_cont = estado_cont;
	}

	public List<Adenda> getAdendas() {
		return adendas;
	}

	public void setAdendas(List<Adenda> adendas) {
		this.adendas = adendas;
	}

	public String getNro_dni() {
		return nro_dni;
	}

	public void setNro_dni(String nro_dni) {
		this.nro_dni = nro_dni;
	}
	public SistPension getSistemaPension() {
		return sistemaPension;
	}

	public void setSistemaPension(SistPension sistemaPension) {
		this.sistemaPension = sistemaPension;
	}
	public boolean isLlenarDetalle() {
		return llenarDetalle;
	}

	public void setLlenarDetalle(boolean llenarDetalle) {
		this.llenarDetalle = llenarDetalle;
	}
	public Integer getDiasMesUno() {
		return diasMesUno;
	}
	public void setDiasMesUno(Integer diasMesUno) {
		this.diasMesUno = diasMesUno;
	}
	public boolean isMesUnoCompleto() {
		return isMesUnoCompleto;
	}
	public void setMesUnoCompleto(boolean isMesUnoCompleto) {
		this.isMesUnoCompleto = isMesUnoCompleto;
	}
	public Integer getCantDias() {
		return cantDias;
	}
	public void setCantDias(Integer cantDias) {
		this.cantDias = cantDias;
	}
	public boolean isRadioImp1() {
		return radioImp1;
	}
	public void setRadioImp1(boolean radioImp1) {
		this.radioImp1 = radioImp1;
	}
	public boolean isRadioImp2() {
		return radioImp2;
	}
	public void setRadioImp2(boolean radioImp2) {
		this.radioImp2 = radioImp2;
	}
	public String getFec_fin_cont_modi() {
		return fec_fin_cont_modi;
	}
	public void setFec_fin_cont_modi(String fec_fin_cont_modi) {
		this.fec_fin_cont_modi = fec_fin_cont_modi;
	}
	public String getSueldo() {
		return sueldo;
	}
	public void setSueldo(String sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this,ToStringStyle.MULTI_LINE_STYLE);
	}

	

	public String getFec_renuncia() {
		return fec_renuncia;
	}

	public void setFec_renuncia(String fec_renuncia) {
		this.fec_renuncia = fec_renuncia;
	}

	public String getActividades() {
		return actividades;
	}

	public void setActividades(String actividades) {
		this.actividades = actividades;
	}
}
