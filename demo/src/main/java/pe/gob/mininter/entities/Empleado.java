package pe.gob.mininter.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Empleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Datos del Empleado
	/**
	 * codigoEmp es c_perl_codigo q solo y es a la la llave primaria
	 * C_PERL_CODIGO
	 */
	String codigoEmp;
	
	
	/**
	 * codAutogeneradoEmp es el codigo que viene del la pantalla C_MST_CODIGO es el codigo de carnet
	 */
	String codAutogeneradoEmp;
	
	/**Nombre y apellido completo*/
	
	
	String remuneracion;
	
	public String getRemuneracion() {
		return remuneracion;
	}

	public void setRemuneracion(String remuneracion) {
		this.remuneracion = remuneracion;
	}

	
	
	public String getNombreCompleto() {
	return getNombresEmp() + " "+ getApeMaternoEmp() + " "+ getApePaternoEmp() ;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}


	
	
	String nombreCompleto;
	String apeNombre;
	String apePaternoEmp;
	String apeMaternoEmp;
	String nombresEmp;
	String nroDniEmp;
	String nroRucEmp;
	String mailEmp;
	String domicilioEmp;
	String ubig_domicilioEmp;
	String ubig_domicilio_depEmp;
	String ubig_domicilio_provEmp;
	String ubig_domicilio_disEmp;
	String sexoEmp;
	String estadoCivilEmp;
	String grado_instEmp;
	String numHijosEmp;
	String lug_nacEmp;
	String lug_nac_depEmp;
	String lug_nac_provEmp;
	String lug_nac_disEmp;
	String fecNacimEmp;
	String nroAfpEmp;
	String nroTarjBanEmp;
	String carnetSeguroEmp;
	String nroTelefEmp;
	String nroCelulEmp;

	// Datos Laborales del Empleado
	String nroContCasEmp;
	String fecContIniEmp;
	String fecContFinEmp;
	String fecIngMinEmp;
	String situacionEmp;
	String descOficina;
	String descOficinaInterna;
	
	String codOficinaEmp;
	String codOficinaEmpInterno;
	
	
	String codOficinaDesEmp;
	String turnoEmp;
	String profesion;
	String cargoEmp;
	String descCargoEmp;
	String honorariosEmp;
	String funcionEmp;
	String desfuncionEmp;
	String sistPensionEmp;
	String sueldoNeto;
	String sueldo;
	String dsctoPensionEmp;
	String dsctoImpRentaEmp;
	String tipoIngresoEmp;
	String situacEspEmp;
	String actividadesEmp;
	String abrevDomicEmp;
	String observacionEmp;
	Integer tipoPlanEmp;
	// Usuario que ingreso al sistema
	String usu_crea;
	String usu_modi;
	String codContrato;
	List<Contrato> bContrato;
	Contrato contratoActual;

    private String resolucion;
    private String extinsion;
	
	
	//Contador de Variables 
	Integer contador;
	String motivoEmp;
	
	
	
	

	public String getCodOficinaEmpInterno() {
		return codOficinaEmpInterno;
	}

	public void setCodOficinaEmpInterno(String codOficinaEmpInterno) {
		this.codOficinaEmpInterno = codOficinaEmpInterno;
	}

	public String getDescOficinaInterna() {
		return descOficinaInterna;
	}

	public void setDescOficinaInterna(String descOficinaInterna) {
		this.descOficinaInterna = descOficinaInterna;
	}

	private String fecResolucion;
	
	
	public Empleado() {
		contratoActual = new Contrato();
		bContrato = new ArrayList<Contrato>();
	}

	public Empleado(String codigoEmp,String nombresEmp,String apePaternoEmp,String apeMaternoEmp,String apeNombre) {
		this.codigoEmp=codigoEmp;
		this.nombresEmp=nombresEmp;
		this.apePaternoEmp=apePaternoEmp;
		this.apeMaternoEmp=apeMaternoEmp;
		this.apeNombre=apeNombre;
		contratoActual = new Contrato();
		bContrato = new ArrayList<Contrato>();
	}
	
	/**
	 * codigoEmp es c_perl_codigo q solo y es a la la llave primaria
	 * C_PERL_CODIGO
	 * 
	 * @return
	 */
	public String getCodigoEmp() {
		return codigoEmp;
	}

	/**
	 * codigoEmp es c_perl_codigo q solo y es a la la llave primaria
	 * C_PERL_CODIGO
	 * 
	 * @param codigoEmp
	 */
	public void setCodigoEmp(String codigoEmp) {
		this.codigoEmp = codigoEmp;
	}

	public String getCodAutogeneradoEmp() {
		return codAutogeneradoEmp;
	}

	public void setCodAutogeneradoEmp(String codAutogeneradoEmp) {
		this.codAutogeneradoEmp = codAutogeneradoEmp;
	}

	public String getApeNombre() {
		return apeNombre;
	}

	public void setApeNombre(String apeNombre) {
		this.apeNombre = apeNombre;
	}

	public String getApePaternoEmp() {
		return apePaternoEmp;
	}

	public void setApePaternoEmp(String apePaternoEmp) {
		this.apePaternoEmp = apePaternoEmp;
	}

	public String getApeMaternoEmp() {
		return apeMaternoEmp;
	}

	public void setApeMaternoEmp(String apeMaternoEmp) {
		this.apeMaternoEmp = apeMaternoEmp;
	}

	public String getNombresEmp() {
		return nombresEmp;
	}

	public void setNombresEmp(String nombresEmp) {
		this.nombresEmp = nombresEmp;
	}

	public String getNroDniEmp() {
		return nroDniEmp;
	}

	public void setNroDniEmp(String nroDniEmp) {
		this.nroDniEmp = nroDniEmp;
	}

	public String getNroRucEmp() {
		return nroRucEmp;
	}

	public void setNroRucEmp(String nroRucEmp) {
		this.nroRucEmp = nroRucEmp;
	}

	public String getMailEmp() {
		return mailEmp;
	}

	public void setMailEmp(String mailEmp) {
		this.mailEmp = mailEmp;
	}

	public String getDomicilioEmp() {
		return domicilioEmp;
	}

	public void setDomicilioEmp(String domicilioEmp) {
		this.domicilioEmp = domicilioEmp;
	}

	public String getUbig_domicilioEmp() {
		return ubig_domicilioEmp;
	}

	public void setUbig_domicilioEmp(String ubig_domicilioEmp) {
		this.ubig_domicilioEmp = ubig_domicilioEmp;
	}

	public String getUbig_domicilio_depEmp() {
		return ubig_domicilio_depEmp;
	}

	public void setUbig_domicilio_depEmp(String ubig_domicilio_depEmp) {
		this.ubig_domicilio_depEmp = ubig_domicilio_depEmp;
	}

	public String getUbig_domicilio_provEmp() {
		return ubig_domicilio_provEmp;
	}

	public void setUbig_domicilio_provEmp(String ubig_domicilio_provEmp) {
		this.ubig_domicilio_provEmp = ubig_domicilio_provEmp;
	}

	public String getUbig_domicilio_disEmp() {
		return ubig_domicilio_disEmp;
	}

	public void setUbig_domicilio_disEmp(String ubig_domicilio_disEmp) {
		this.ubig_domicilio_disEmp = ubig_domicilio_disEmp;
	}

	public String getSexoEmp() {
		return sexoEmp;
	}

	public void setSexoEmp(String sexoEmp) {
		this.sexoEmp = sexoEmp;
	}

	public String getEstadoCivilEmp() {
		return estadoCivilEmp;
	}

	public void setEstadoCivilEmp(String estadoCivilEmp) {
		this.estadoCivilEmp = estadoCivilEmp;
	}

	public String getGrado_instEmp() {
		return grado_instEmp;
	}

	public void setGrado_instEmp(String grado_instEmp) {
		this.grado_instEmp = grado_instEmp;
	}

	public String getNumHijosEmp() {
		return numHijosEmp;
	}

	public void setNumHijosEmp(String numHijosEmp) {
		this.numHijosEmp = numHijosEmp;
	}

	public String getLug_nacEmp() {
		return lug_nacEmp;
	}

	public void setLug_nacEmp(String lug_nacEmp) {
		this.lug_nacEmp = lug_nacEmp;
	}

	public String getLug_nac_depEmp() {
		return lug_nac_depEmp;
	}

	public void setLug_nac_depEmp(String lug_nac_depEmp) {
		this.lug_nac_depEmp = lug_nac_depEmp;
	}

	public String getLug_nac_provEmp() {
		return lug_nac_provEmp;
	}

	public void setLug_nac_provEmp(String lug_nac_provEmp) {
		this.lug_nac_provEmp = lug_nac_provEmp;
	}

	public String getLug_nac_disEmp() {
		return lug_nac_disEmp;
	}

	public void setLug_nac_disEmp(String lug_nac_disEmp) {
		this.lug_nac_disEmp = lug_nac_disEmp;
	}

	

	
	public String getFecNacimEmp() {
		return fecNacimEmp;
	}

	public void setFecNacimEmp(String fecNacimEmp) {
		this.fecNacimEmp = fecNacimEmp;
	}

	public String getNroAfpEmp() {
		return nroAfpEmp;
	}

	public void setNroAfpEmp(String nroAfpEmp) {
		this.nroAfpEmp = nroAfpEmp;
	}

	public String getNroTarjBanEmp() {
		return nroTarjBanEmp;
	}

	public void setNroTarjBanEmp(String nroTarjBanEmp) {
		this.nroTarjBanEmp = nroTarjBanEmp;
	}

	public String getCarnetSeguroEmp() {
		return carnetSeguroEmp;
	}

	public void setCarnetSeguroEmp(String carnetSeguroEmp) {
		this.carnetSeguroEmp = carnetSeguroEmp;
	}

	public String getNroTelefEmp() {
		return nroTelefEmp;
	}

	public void setNroTelefEmp(String nroTelefEmp) {
		this.nroTelefEmp = nroTelefEmp;
	}

	public String getNroCelulEmp() {
		return nroCelulEmp;
	}

	public void setNroCelulEmp(String nroCelulEmp) {
		this.nroCelulEmp = nroCelulEmp;
	}

	public String getNroContCasEmp() {
		return nroContCasEmp;
	}

	public void setNroContCasEmp(String nroContCasEmp) {
		this.nroContCasEmp = nroContCasEmp;
	}

	public String getFecContIniEmp() {
		return fecContIniEmp;
	}

	public void setFecContIniEmp(String fecContIniEmp) {
		this.fecContIniEmp = fecContIniEmp;
	}

	public String getFecContFinEmp() {
		return fecContFinEmp;
	}

	public void setFecContFinEmp(String fecContFinEmp) {
		this.fecContFinEmp = fecContFinEmp;	
	}
	

	public String getFecIngMinEmp() {
		return fecIngMinEmp;
	}

	public void setFecIngMinEmp(String fecIngMinEmp) {
		this.fecIngMinEmp = fecIngMinEmp;
	}

	public String getSituacionEmp() {
		return situacionEmp;
	}

	public void setSituacionEmp(String situacionEmp) {
		this.situacionEmp = situacionEmp;
	}

	public String getCodOficinaEmp() {
		return codOficinaEmp;
	}

	public void setCodOficinaEmp(String codOficinaEmp) {
		this.codOficinaEmp = codOficinaEmp;
	}

	public String getCodOficinaDesEmp() {
		return codOficinaDesEmp;
	}

	public void setCodOficinaDesEmp(String codOficinaDesEmp) {
		this.codOficinaDesEmp = codOficinaDesEmp;
	}

	public String getTurnoEmp() {
		return turnoEmp;
	}

	public void setTurnoEmp(String turnoEmp) {
		this.turnoEmp = turnoEmp;
	}

	public String getCargoEmp() {
		return cargoEmp;
	}

	public void setCargoEmp(String cargoEmp) {
		this.cargoEmp = cargoEmp;
	}

	public String getDescCargoEmp() {
		return descCargoEmp;
	}

	public void setDescCargoEmp(String descCargoEmp) {
		this.descCargoEmp = descCargoEmp;
	}

	public String getSueldoNeto() {
		return sueldoNeto;
	}

	public void setSueldoNeto(String sueldoNeto) {
		this.sueldoNeto = sueldoNeto;
	}

	public String getHonorariosEmp() {
		return honorariosEmp;
	}

	public void setHonorariosEmp(String honorariosEmp) {
		this.honorariosEmp = honorariosEmp;
	}

	public String getFuncionEmp() {
		return funcionEmp;
	}

	public void setFuncionEmp(String funcionEmp) {
		this.funcionEmp = funcionEmp;
	}

	public String getSistPensionEmp() {
		return sistPensionEmp;
	}

	public void setSistPensionEmp(String sistPensionEmp) {
		this.sistPensionEmp = sistPensionEmp;
	}

	public String getDsctoPensionEmp() {
		return dsctoPensionEmp;
	}

	public void setDsctoPensionEmp(String dsctoPensionEmp) {
		this.dsctoPensionEmp = dsctoPensionEmp;
	}

	public String getDsctoImpRentaEmp() {
		return dsctoImpRentaEmp;
	}

	public void setDsctoImpRentaEmp(String dsctoImpRentaEmp) {
		this.dsctoImpRentaEmp = dsctoImpRentaEmp;
	}

	public String getTipoIngresoEmp() {
		return tipoIngresoEmp;
	}

	public void setTipoIngresoEmp(String tipoIngresoEmp) {
		this.tipoIngresoEmp = tipoIngresoEmp;
	}

	public String getSituacEspEmp() {
		return situacEspEmp;
	}

	public void setSituacEspEmp(String situacEspEmp) {
		this.situacEspEmp = situacEspEmp;
	}

	public String getUsu_crea() {
		return usu_crea;
	}

	public void setUsu_crea(String usu_crea) {
		this.usu_crea = usu_crea;
	}

	public String getUsu_modi() {
		return usu_modi;
	}

	public void setUsu_modi(String usu_modi) {
		this.usu_modi = usu_modi;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getDescOficina() {
		return descOficina;
	}

	public void setDescOficina(String descOficina) {
		this.descOficina = descOficina;
	}

	public String getCodContrato() {
		return codContrato;
	}

	public void setCodContrato(String codContrato) {
		this.codContrato = codContrato;
	}

	public String getActividadesEmp() {
		return actividadesEmp;
	}

	public void setActividadesEmp(String actividadesEmp) {
		this.actividadesEmp = actividadesEmp;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public List<Contrato> getBContrato() {
		return bContrato;
	}

	public void setBContrato(List<Contrato> contrato) {
		bContrato = contrato;
	}

	public String getDesfuncionEmp() {
		return desfuncionEmp;
	}

	public void setDesfuncionEmp(String desfuncionEmp) {
		this.desfuncionEmp = desfuncionEmp;
	}

	public Contrato getContratoActual() {
		return contratoActual;
	}

	public void setContratoActual(Contrato contratoActual) {
		this.contratoActual = contratoActual;
	}

	public Integer getContador() {
		return contador;
	}

	public void setContador(Integer contador) {
		this.contador = contador;
	}

	public String getSueldo() {
		return sueldo;
	}

	public void setSueldo(String sueldo) {
		this.sueldo = sueldo;
	}

	public String getMotivoEmp() {
		return motivoEmp;
	}

	public void setMotivoEmp(String motivoEmp) {
		this.motivoEmp = motivoEmp;
	}

	public String getAbrevDomicEmp() {
		return abrevDomicEmp;
	}

	public void setAbrevDomicEmp(String abrevDomicEmp) {
		this.abrevDomicEmp = abrevDomicEmp;
	}

	public String getObservacionEmp() {
		return observacionEmp;
	}

	public void setObservacionEmp(String observacionEmp) {
		this.observacionEmp = observacionEmp;
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public String getExtinsion() {
		return extinsion;
	}

	public void setExtinsion(String extinsion) {
		this.extinsion = extinsion;
	}

	public void setFecResolucion(String parameter) {
		this.fecResolucion=parameter;
		
	}	
	
	public String getFecResolucion() {
		return fecResolucion;
		
	}	

	public Integer getTipoPlanEmp() {
		return tipoPlanEmp;
	}

	public void setTipoPlanEmp(Integer tipoPlanEmp) {
		this.tipoPlanEmp = tipoPlanEmp;
	}

Turno turno;


public Turno getTurno() {
	return turno;
}

public void setTurno(Turno turno) {
	this.turno = turno;
}

public static long getSerialVersionUID() {
	return serialVersionUID;
}


	
}