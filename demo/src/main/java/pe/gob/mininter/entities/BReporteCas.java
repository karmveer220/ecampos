package pe.gob.mininter.entities; 

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class BReporteCas implements Serializable, Comparable<BReporteCas> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Datos del Empleado
	/**
	 * codigoEmp es c_perl_codigo q solo y es a la la llave primaria
	 * C_PERL_CODIGO
	 * @return
	 */
	private String codigoEmp;	
	/**
	 * codAutogeneradoEmp es el codigo que viene del la pantalla C_MST_CODIGO es el codigo de carnet del mininter
	 * C_MST_CODIGO
	 * @return
	 */
	private String codAutogeneradoEmp;
	
	/**Reporte Datos Generales*/
	private Integer contador;
	private String nombresEmp;
	private String nombresEmp2;
	
	private String dniEmp;
	private String rucEmp;
	private String domicilioEmp;
	private String sexoEmp;
	private String estadoCivilEmp;
	private String mailEmp;	
	private String fecNacimEmp;	
	private String nroAfpEmp;
	private String nroTarjBanEmp;
	private String carnetSeguroEmp;
	private String nroTelefEmp;
	private String nroCelulEmp;
	private String domiDepartamento;
	private String domiProvincia;
	private String domiDistrito;
	private String nroAdenda;
	private String codInterno;
	private String fecResContrato;

	/**Reporte Datos Laborales*/
	private String nroContEmp;
	private String fecIngMininter;
	private String fecContIniEmp;
	private String fecContFinEmp;
	private String fecContrato;
	private String fecAdenIniEmp;	
	private Date fecAdenIni;	
	private String fecAdenFinEmp;
	private Date fecAdenFin;
	
	private String diaCont;
	private String mesCont;
	private String añoCont;
	
	private String mesesAdenda;
	private String dependenciaEmp;
	private String dependenciaDest;
	private String turnoEmp;
	private String ingresoEmp;
	private String funcionEmp;
	private String descFuncionEmp;
	private String situacionEmp;
	private String cargoEmp;	
	private String profesionEmp;
	private Double honorariosEmp;
	private String honorariosEmpF;
	private Double honorarioNetoEmp;
	private String honorarioNetoEmpF;
	private String dsctoPensionEmp;
	private String dsctoAfpEmp;
	private String dsctoEssaludEmp;
	private String culminacionEmp;
	
	private String nroContrato;
	
	private String dsctoRenta;
	private Double dsctoRentaEmp;
		
	/**Reporte Sistema de pensiones*/
	private Double pensionONP ;
	private Double pensionPROFUTURO ;
	private Double pensionHORIZONTE ;
	private Double pensionINTEGRA ;
	private Double pensionPRIMA ;
	private String pensionNINGUNA;
	private String sistemaPension;
	private String nroCUSP;
	
	private List<BMonto> listaDscto;
	private Double totalDscto;
	private Double totalHaberes;
	/****/
	private String fuentefto;
	private Double montodsctoEssaludEmp;
	private Double montototaldsctoEssaludEmp;
	private Double montodsctoCASEmp;
	
	//Double montoDsctoAfiCafae;
	//Double montoDsctoVida;
	private Double montoFijo;
	 	
	private String dsctoCASEmp;
	private String sueldoContrato;
	
	private String mes;
	private String anio;
	private String meta;
	
	private Double montocomi;
	private Double montoseguro;
	private Double montocomisionvariable;
	private Double totalretencion;
	private Double totalretaporte;
	private String nomBeneficiario;
	private String dniBeneficiario;
	private String tipoPago;
	private Integer codAdenda;
	private String funcion;
	private String nroresol;
	private String fecResolucion;
	private String tipoRecurso;
	
	private String tipoIngregoFormateado;
	
	private Double montoMulta;
	private String montoMultaS;
	private String multa;
	private String montoseguroS;
	private String dsctoRentaEmpS;
	private String fecAfiliacionPension;
	
	private String oficioPersonal;
	private String oficioPresupuesto;
	
	private String diaHabil;
	private String descRenuncia;
	private String tipoRenuncia;
	private String fecBaja;
	private String estadoCont;
	
	private String tipoResol;
	private String numFaltas;
	
	private List<BDsctoHaber> listadodsctos;
	private List<BDsctoHaber> listadodsctos1;
	
	//Impresion de Adendas Personalizadas
	private String codDirector;
	private String director;
	private String titDirector;
	private String dniDirector;
	private String resoDirector;
	private String direccionDirector;
	private Integer oficinaDir;
	
	//private String fecAdenIniEmp;
	private String fecIniAdendaFor;
	private String fecFinAdendaFor;
	
	//Reporte de Tablas Cruzadas
	private Double mesEnero;
	private Double mesFebrero;
	private Double mesMarzo;
	private Double mesAbril;
	private Double mesMayo;
	private Double mesJunio;
	private Double mesJulio;
	private Double mesAgosto;
	private Double mesSeptiembre;
	private Double mesOctubre;
	private Double mesNoviembre;
	private Double mesDiciembre;
	
	private Double dsctTotalSP;
	
	private String nroPlaza;
	
	public BReporteCas(){
		listaDscto = new ArrayList<BMonto>();
		listadodsctos = new ArrayList<BDsctoHaber>();
		listadodsctos1 = new ArrayList<BDsctoHaber>();
	}
	
	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public String getFecContFinEmp() {
		return fecContFinEmp;
	}

	public void setFecContFinEmp(String fecContFinEmp) {
		this.fecContFinEmp = fecContFinEmp;
	}

	public Integer getContador() {
		return contador;
	}

	public void setContador(Integer contador) {
		this.contador = contador;
	}

	public String getCodigoEmp() {
		return codigoEmp;
	}

	public void setCodigoEmp(String codigoEmp) {
		this.codigoEmp = codigoEmp;
	}

	public String getCodAutogeneradoEmp() {
		return codAutogeneradoEmp;
	}

	public void setCodAutogeneradoEmp(String codAutogeneradoEmp) {
		this.codAutogeneradoEmp = codAutogeneradoEmp;
	}	

	public String getNombresEmp() {
		return nombresEmp;
	}

	public void setNombresEmp(String nombresEmp) {
		this.nombresEmp = nombresEmp;
	}

	public String getDniEmp() {
		return dniEmp;
	}

	public void setDniEmp(String dniEmp) {
		this.dniEmp = dniEmp;
	}

	public String getRucEmp() {
		return rucEmp;
	}

	public void setRucEmp(String rucEmp) {
		this.rucEmp = rucEmp;
	}

	public String getDomicilioEmp() {
		return domicilioEmp;
	}

	public void setDomicilioEmp(String domicilioEmp) {
		this.domicilioEmp = domicilioEmp;
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

	public String getMailEmp() {
		return mailEmp;
	}

	public void setMailEmp(String mailEmp) {
		this.mailEmp = mailEmp;
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

	public String getNroContEmp() {
		return nroContEmp;
	}

	public void setNroContEmp(String nroContEmp) {
		this.nroContEmp = nroContEmp;
	}

	public String getFecContIniEmp() {
		return fecContIniEmp;
	}

	public void setFecContIniEmp(String fecContIniEmp) {
		this.fecContIniEmp = fecContIniEmp;
	}

	public String getFecAdenIniEmp() {
		return fecAdenIniEmp;
	}

	public void setFecAdenIniEmp(String fecAdenIniEmp) {
		this.fecAdenIniEmp = fecAdenIniEmp;
	}

	public String getFecAdenFinEmp() {
		return fecAdenFinEmp;
	}

	public void setFecAdenFinEmp(String fecAdenFinEmp) {
		this.fecAdenFinEmp = fecAdenFinEmp;
	}

	public String getDependenciaEmp() {
		return dependenciaEmp;
	}

	public void setDependenciaEmp(String dependenciaEmp) {
		this.dependenciaEmp = dependenciaEmp;
	}

	public String getTurnoEmp() {
		return turnoEmp;
	}

	public void setTurnoEmp(String turnoEmp) {
		this.turnoEmp = turnoEmp;
	}

	public String getIngresoEmp() {
		return ingresoEmp;
	}

	public void setIngresoEmp(String ingresoEmp) {
		this.ingresoEmp = ingresoEmp;
	}

	public String getFuncionEmp() {
		return funcionEmp;
	}

	public void setFuncionEmp(String funcionEmp) {
		this.funcionEmp = funcionEmp;
	}

	public String getSituacionEmp() {
		return situacionEmp;
	}

	public void setSituacionEmp(String situacionEmp) {
		this.situacionEmp = situacionEmp;
	}

	public String getCargoEmp() {
		return cargoEmp;
	}

	public void setCargoEmp(String cargoEmp) {
		this.cargoEmp = cargoEmp;
	}

	public String getProfesionEmp() {
		return profesionEmp;
	}

	public void setProfesionEmp(String profesionEmp) {
		this.profesionEmp = profesionEmp;
	}
		
	public String getDsctoPensionEmp() {
		return dsctoPensionEmp;
	}

	public void setDsctoPensionEmp(String dsctoPensionEmp) {
		this.dsctoPensionEmp = dsctoPensionEmp;
	}

	public String getDsctoAfpEmp() {
		return dsctoAfpEmp;
	}

	public void setDsctoAfpEmp(String dsctoAfpEmp) {
		this.dsctoAfpEmp = dsctoAfpEmp;
	}

	public Double getDsctoRentaEmp() {
		return dsctoRentaEmp;
	}

	public void setDsctoRentaEmp(Double dsctoRentaEmp) {
		this.dsctoRentaEmp = dsctoRentaEmp;
	}

	public String getDsctoEssaludEmp() {
		return dsctoEssaludEmp;
	}

	public void setDsctoEssaludEmp(String dsctoEssaludEmp) {
		this.dsctoEssaludEmp = dsctoEssaludEmp;
	}
	
	public Double getPensionONP() {
		return pensionONP;
	}

	public void setPensionONP(Double pensionONP) {
		this.pensionONP = pensionONP;
	}

	public Double getPensionPROFUTURO() {
		return pensionPROFUTURO;
	}

	public void setPensionPROFUTURO(Double pensionPROFUTURO) {
		this.pensionPROFUTURO = pensionPROFUTURO;
	}

	public Double getPensionHORIZONTE() {
		return pensionHORIZONTE;
	}

	public void setPensionHORIZONTE(Double pensionHORIZONTE) {
		this.pensionHORIZONTE = pensionHORIZONTE;
	}

	public Double getPensionINTEGRA() {
		return pensionINTEGRA;
	}

	public void setPensionINTEGRA(Double pensionINTEGRA) {
		this.pensionINTEGRA = pensionINTEGRA;
	}

	public Double getPensionPRIMA() {
		return pensionPRIMA;
	}

	public void setPensionPRIMA(Double pensionPRIMA) {
		this.pensionPRIMA = pensionPRIMA;
	}

	public String getPensionNINGUNA() {
		return pensionNINGUNA;
	}

	public void setPensionNINGUNA(String pensionNINGUNA) {
		this.pensionNINGUNA = pensionNINGUNA;
	}

	public Double getHonorariosEmp() {
		return honorariosEmp;
	}

	public void setHonorariosEmp(Double honorariosEmp) {
		this.honorariosEmp = honorariosEmp;
	}

	public Double getHonorarioNetoEmp() {
		return honorarioNetoEmp;
	}

	public void setHonorarioNetoEmp(Double honorarioNetoEmp) {
		this.honorarioNetoEmp = honorarioNetoEmp;
	}
	
	public String getCulminacionEmp() {
		return culminacionEmp;
	}

	public void setCulminacionEmp(String culminacionEmp) {
		this.culminacionEmp = culminacionEmp;
	}

	public String getDomiDepartamento() {
		return domiDepartamento;
	}

	public void setDomiDepartamento(String domiDepartamento) {
		this.domiDepartamento = domiDepartamento;
	}

	public String getDomiProvincia() {
		return domiProvincia;
	}

	public void setDomiProvincia(String domiProvincia) {
		this.domiProvincia = domiProvincia;
	}

	public String getDomiDistrito() {
		return domiDistrito;
	}

	public void setDomiDistrito(String domiDistrito) {
		this.domiDistrito = domiDistrito;
	}

	public String getDsctoRenta() {
		return dsctoRenta;
	}

	public void setDsctoRenta(String dsctoRenta) {
		this.dsctoRenta = dsctoRenta;
	}

	public Double getTotalDscto() {
		return totalDscto;
	}

	public void setTotalDscto(Double totalDscto) {
		this.totalDscto = totalDscto;
	}

	public List<BMonto> getListaDscto() {
		return listaDscto;
	}

	public void setListaDscto(List<BMonto> listaDscto) {
		this.listaDscto = listaDscto;
	}

	public String getFecIngMininter() {
		return fecIngMininter;
	}

	public void setFecIngMininter(String fecIngMininter) {
		this.fecIngMininter = fecIngMininter;
	}

	public String getNroContrato() {
		return nroContrato;
	}

	public void setNroContrato(String nroContrato) {
		this.nroContrato = nroContrato;
	}

	public String getSistemaPension() {
		return sistemaPension;
	}

	public void setSistemaPension(String sistemaPension) {
		this.sistemaPension = sistemaPension;
	}

	public String getNroCUSP() {
		return nroCUSP;
	}

	public void setNroCUSP(String nroCUSP) {
		this.nroCUSP = nroCUSP;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getFuentefto() {
		return fuentefto;
	}

	public void setFuentefto(String fuentefto) {
		this.fuentefto = fuentefto;
	}

	public Double getMontodsctoEssaludEmp() {
		return montodsctoEssaludEmp;
	}

	public void setMontodsctoEssaludEmp(Double montodsctoEssaludEmp) {
		this.montodsctoEssaludEmp = montodsctoEssaludEmp;
	}

	public Double getMontototaldsctoEssaludEmp() {
		return montototaldsctoEssaludEmp;
	}

	public void setMontototaldsctoEssaludEmp(Double montototaldsctoEssaludEmp) {
		this.montototaldsctoEssaludEmp = montototaldsctoEssaludEmp;
	}

	public Double getMontodsctoCASEmp() {
		return montodsctoCASEmp;
	}

	public void setMontodsctoCASEmp(Double montodsctoCASEmp) {
		this.montodsctoCASEmp = montodsctoCASEmp;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getDsctoCASEmp() {
		return dsctoCASEmp;
	}

	public void setDsctoCASEmp(String dsctoCASEmp) {
		this.dsctoCASEmp = dsctoCASEmp;
	}

	public String getMeta() {
		return meta;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	public Double getMontocomi() {
		return montocomi;
	}

	public void setMontocomi(Double montocomi) {
		this.montocomi = montocomi;
	}

	public Double getMontoseguro() {
		return montoseguro;
	}

	public void setMontoseguro(Double montoseguro) {
		this.montoseguro = montoseguro;
	}

	public Double getMontocomisionvariable() {
		return montocomisionvariable;
	}

	public void setMontocomisionvariable(Double montocomisionvariable) {
		this.montocomisionvariable = montocomisionvariable;
	}

	public Double getTotalretencion() {
		return totalretencion;
	}

	public void setTotalretencion(Double totalretencion) {
		this.totalretencion = totalretencion;
	}

	public Double getTotalretaporte() {
		return totalretaporte;
	}

	public String getNomBeneficiario() {
		return nomBeneficiario;
	}

	public void setNomBeneficiario(String nomBeneficiario) {
		this.nomBeneficiario = nomBeneficiario;
	}

	public void setTotalretaporte(Double totalretaporte) {
		this.totalretaporte = totalretaporte;
	}

	public String getDniBeneficiario() {
		return dniBeneficiario;
	}

	public Integer getCodAdenda() {
		return codAdenda;
	}

	public void setDniBeneficiario(String dniBeneficiario) {
		this.dniBeneficiario = dniBeneficiario;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public void setCodAdenda(Integer codAdenda) {
		this.codAdenda = codAdenda;
	}

	public String getNroAdenda() {
		return nroAdenda;
	}

	public void setNroAdenda(String nroAdenda) {
		this.nroAdenda = nroAdenda;
	}

	public Date getFecAdenIni() {
		return fecAdenIni;
	}

	public void setFecAdenIni(Date fecAdenIni) {
		this.fecAdenIni = fecAdenIni;
	}

	public Date getFecAdenFin() {
		return fecAdenFin;
	}

	public void setFecAdenFin(Date fecAdenFin) {
		this.fecAdenFin = fecAdenFin;
	}

	public String getNroresol() {
		return nroresol;
	}

	public void setNroresol(String nroresol) {
		this.nroresol = nroresol;
	}

	public String getTipoIngregoFormateado() {
		return tipoIngregoFormateado;
	}

	public String getFecResolucion() {
		return fecResolucion;
	}

	public void setFecResolucion(String fecResolucion) {
		this.fecResolucion = fecResolucion;
	}

	public void setTipoIngregoFormateado(String tipoIngregoFormateado) {
		this.tipoIngregoFormateado = tipoIngregoFormateado;
	}

	public Double getMontoMulta() {
		return montoMulta;
	}

	public void setMontoMulta(Double montoMulta) {
		this.montoMulta = montoMulta;
	}

	public String getMontoMultaS() {
		return montoMultaS;
	}

	public void setMontoMultaS(String montoMultaS) {
		this.montoMultaS = montoMultaS;
	}

	public String getMulta() {
		return multa;
	}

	public void setMulta(String multa) {
		this.multa = multa;
	}

	public List<BDsctoHaber> getListadodsctos() {
		return listadodsctos;
	}

	public void setListadodsctos(List<BDsctoHaber> listadodsctos) {
		this.listadodsctos = listadodsctos;
	}

	public String getMontoseguroS() {
		return montoseguroS;
	}

	public void setMontoseguroS(String montoseguroS) {
		this.montoseguroS = montoseguroS;
	}

	public String getDsctoRentaEmpS() {
		return dsctoRentaEmpS;
	}

	public void setDsctoRentaEmpS(String dsctoRentaEmpS) {
		this.dsctoRentaEmpS = dsctoRentaEmpS;
	}

	public String getFecAfiliacionPension() {
		return fecAfiliacionPension;
	}

	public void setFecAfiliacionPension(String fecAfiliacionPension) {
		this.fecAfiliacionPension = fecAfiliacionPension;
	}

	public String getCodInterno() {
		return codInterno;
	}

	public void setCodInterno(String codInterno) {
		this.codInterno = codInterno;
	}

	public String getDiaHabil() {
		return diaHabil;
	}

	public void setDiaHabil(String diaHabil) {
		this.diaHabil = diaHabil;
	}

	public String getOficioPersonal() {
		return oficioPersonal;
	}

	public void setOficioPersonal(String oficioPersonal) {
		this.oficioPersonal = oficioPersonal;
	}

	public String getOficioPresupuesto() {
		return oficioPresupuesto;
	}

	public void setOficioPresupuesto(String oficioPresupuesto) {
		this.oficioPresupuesto = oficioPresupuesto;
	}

	public String getSueldoContrato() {
		return sueldoContrato;
	}

	public void setSueldoContrato(String sueldoContrato) {
		this.sueldoContrato = sueldoContrato;
	}

	public String getDescRenuncia() {
		return descRenuncia;
	}

	public void setDescRenuncia(String descRenuncia) {
		this.descRenuncia = descRenuncia;
	}

	public String getTipoRenuncia() {
		return tipoRenuncia;
	}

	public void setTipoRenuncia(String tipoRenuncia) {
		this.tipoRenuncia = tipoRenuncia;
	}

	public String getFecBaja() {
		return fecBaja;
	}

	public void setFecBaja(String fecBaja) {
		this.fecBaja = fecBaja;
	}

    public String getHonorariosEmpF() {
        return honorariosEmpF;
    }

    public void setHonorariosEmpF(String honorariosEmpF) {
        this.honorariosEmpF = honorariosEmpF;
    }

    public String getHonorarioNetoEmpF() {
        return honorarioNetoEmpF;
    }

    public void setHonorarioNetoEmpF(String honorarioNetoEmpF) {
        this.honorarioNetoEmpF = honorarioNetoEmpF;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitDirector() {
        return titDirector;
    }

    public void setTitDirector(String titDirector) {
        this.titDirector = titDirector;
    }

    public String getDniDirector() {
        return dniDirector;
    }

    public void setDniDirector(String dniDirector) {
        this.dniDirector = dniDirector;
    }

    public String getResoDirector() {
        return resoDirector;
    }

    public void setResoDirector(String resoDirector) {
        this.resoDirector = resoDirector;
    }

    public String getNombresEmp2() {
        return nombresEmp2;
    }

    public void setNombresEmp2(String nombresEmp2) {
        this.nombresEmp2 = nombresEmp2;
    }

    public String getDireccionDirector() {
        return direccionDirector;
    }

    public void setDireccionDirector(String direccionDirector) {
        this.direccionDirector = direccionDirector;
    }

    public Double getMontoFijo() {
        return montoFijo;
    }

    public void setMontoFijo(Double montoFijo) {
        this.montoFijo = montoFijo;
    }

    public String getEstadoCont() {
        return estadoCont;
    }

    public void setEstadoCont(String estadoCont) {
        this.estadoCont = estadoCont;
    }
    
    public String getDependenciaDest() {
        return dependenciaDest;
    }

    public void setDependenciaDest(String dependenciaDest) {
        this.dependenciaDest = dependenciaDest;
    }

    public String getTipoResol() {
        return tipoResol;
    }

    public void setTipoResol(String tipoResol) {
        this.tipoResol = tipoResol;
    }

    public String getNumFaltas() {
        return numFaltas;
    }

    public void setNumFaltas(String numFaltas) {
        this.numFaltas = numFaltas;
    }

    public Integer getOficinaDir() {
        return oficinaDir;
    }

    public void setOficinaDir(Integer oficinaDir) {
        this.oficinaDir = oficinaDir;
    }

    public String getCodDirector() {
        return codDirector;
    }

    public void setCodDirector(String codDirector) {
        this.codDirector = codDirector;
    }

    public String getFecContrato() {
        return fecContrato;
    }

    public void setFecContrato(String fecContrato) {
        this.fecContrato = fecContrato;
    }

    public String getMesesAdenda() {
        return mesesAdenda;
    }

    public void setMesesAdenda(String mesesAdenda) {
        this.mesesAdenda = mesesAdenda;
    }

    public String getDiaCont() {
        return diaCont;
    }

    public void setDiaCont(String diaCont) {
        this.diaCont = diaCont;
    }

    public String getMesCont() {
        return mesCont;
    }

    public void setMesCont(String mesCont) {
        this.mesCont = mesCont;
    }

    public String getAñoCont() {
        return añoCont;
    }

    public void setAñoCont(String añoCont) {
        this.añoCont = añoCont;
    }

    public String getFecIniAdendaFor() {
        return fecIniAdendaFor;
    }

    public void setFecIniAdendaFor(String fecIniAdendaFor) {
        this.fecIniAdendaFor = fecIniAdendaFor;
    }

    public String getFecFinAdendaFor() {
        return fecFinAdendaFor;
    }

    public void setFecFinAdendaFor(String fecFinAdendaFor) {
        this.fecFinAdendaFor = fecFinAdendaFor;
    }

    public String getDescFuncionEmp() {
        return descFuncionEmp;
    }

    public void setDescFuncionEmp(String descFuncionEmp) {
        this.descFuncionEmp = descFuncionEmp;
    }

    public String getFecResContrato() {
        return fecResContrato;
    }

    public void setFecResContrato(String fecResContrato) {
        this.fecResContrato = fecResContrato;
    }

    public Double getMesEnero() {
        return mesEnero;
    }

    public void setMesEnero(Double mesEnero) {
        this.mesEnero = mesEnero;
    }

    public Double getMesFebrero() {
        return mesFebrero;
    }

    public void setMesFebrero(Double mesFebrero) {
        this.mesFebrero = mesFebrero;
    }

    public Double getMesMarzo() {
        return mesMarzo;
    }

    public void setMesMarzo(Double mesMarzo) {
        this.mesMarzo = mesMarzo;
    }

    public Double getMesAbril() {
        return mesAbril;
    }

    public void setMesAbril(Double mesAbril) {
        this.mesAbril = mesAbril;
    }

    public Double getMesMayo() {
        return mesMayo;
    }

    public void setMesMayo(Double mesMayo) {
        this.mesMayo = mesMayo;
    }

    public Double getMesJunio() {
        return mesJunio;
    }

    public void setMesJunio(Double mesJunio) {
        this.mesJunio = mesJunio;
    }

    public Double getMesJulio() {
        return mesJulio;
    }

    public void setMesJulio(Double mesJulio) {
        this.mesJulio = mesJulio;
    }

    public Double getMesAgosto() {
        return mesAgosto;
    }

    public void setMesAgosto(Double mesAgosto) {
        this.mesAgosto = mesAgosto;
    }

    public Double getMesSeptiembre() {
        return mesSeptiembre;
    }

    public void setMesSeptiembre(Double mesSeptiembre) {
        this.mesSeptiembre = mesSeptiembre;
    }

    public Double getMesOctubre() {
        return mesOctubre;
    }

    public void setMesOctubre(Double mesOctubre) {
        this.mesOctubre = mesOctubre;
    }

    public Double getMesNoviembre() {
        return mesNoviembre;
    }

    public void setMesNoviembre(Double mesNoviembre) {
        this.mesNoviembre = mesNoviembre;
    }

    public Double getMesDiciembre() {
        return mesDiciembre;
    }

    public void setMesDiciembre(Double mesDiciembre) {
        this.mesDiciembre = mesDiciembre;
    }

    public Double getDsctTotalSP() {
        return dsctTotalSP;
    }

    public void setDsctTotalSP(Double dsctTotalSP) {
        this.dsctTotalSP = dsctTotalSP;
    }    

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public List<BDsctoHaber> getListadodsctos1() {
        return listadodsctos1;
    }

    public void setListadodsctos1(List<BDsctoHaber> listadodsctos1) {
        this.listadodsctos1 = listadodsctos1;
    }

    public Double getTotalHaberes() {
        return totalHaberes;
    }

    public void setTotalHaberes(Double totalHaberes) {
        this.totalHaberes = totalHaberes;
    }

    public String getNroPlaza() {
        return nroPlaza;
    }

    public void setNroPlaza(String nroPlaza) {
        this.nroPlaza = nroPlaza;
    }

    @Override
    public int compareTo(BReporteCas reporteCas) {
        int result = nombresEmp.compareTo(reporteCas.nombresEmp);
        return result == 0 ? nombresEmp.compareTo(((BReporteCas) reporteCas).nombresEmp) : result;
    }
}