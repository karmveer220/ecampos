package pe.gob.mininter.entities;

import java.io.Serializable;

public class Marcacion implements Serializable {
	
	  String codigoMarcacion;
	  String diaAsistencia;
	  String diaOrder;
	Empleado empleado;
	  Turno turno;
	  String horaEntrada;
	  String horaSalida;
	  String horaEntradaAlmuerzo;
	  String horaFinAlmuerzo;

	  Justificacion justificacion;
	  String  descripcionMarcacion;
	  String horasExtras;
	  String horasAbandono;
	  String horasTardanzas;
	  Double lector;
	  String dependencia;
	  String multaMarcacion;
	  
	  TipoRegistro tipoRegistro;
		 Integer contador;
		 String codigoEmp;
		 String nombreCompleto;
		 String dni;
		 String tipIngreso;
		String ofi_destaque;
		String cod_ofi_destaque;
		String cargo;
		 String horario;
		 String ofi_abreviatura;
		 String distdia;
		 
		 String funcion;
		 
		 
    public String getFuncion() {
            return funcion;
        }
        public void setFuncion(String funcion) {
            this.funcion = funcion;
        }
    public String getDistdia() {
			return distdia;
		}
		public void setDistdia(String distdia) {
			this.distdia = distdia;
		}
	public String getOfi_abreviatura() {
			return ofi_abreviatura;
		}
		public void setOfi_abreviatura(String ofiAbreviatura) {
			ofi_abreviatura = ofiAbreviatura;
		}
		public String getCod_ofi_destaque() {
			return cod_ofi_destaque;
		}
		public void setCod_ofi_destaque(String codOfiDestaque) {
			cod_ofi_destaque = codOfiDestaque;
		}
	public String getTipIngreso() {
			return tipIngreso;
		}
		public void setTipIngreso(String tipIngreso) {
			this.tipIngreso = tipIngreso;
		}
	public String getDni() {
			return dni;
		}
		public void setDni(String dni) {
			this.dni = dni;
		}
		 public String getOfi_destaque() {
				return ofi_destaque;
			}
			public void setOfi_destaque(String ofiDestaque) {
				ofi_destaque = ofiDestaque;
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
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

		public String getCargo() {
			return cargo;
		}
		public void setCargo(String cargo) {
			this.cargo = cargo;
		}
		public String getHorario() {
			return horario;
		}
		public void setHorario(String horario) {
			this.horario = horario;
		}
	
	
	
	  public enum TipoRegistro{
		  AUTOMATICO("A"),
		  MANUAL("M");
		  
		  private String tipo;
		  
		  TipoRegistro(String tipo){
			  this.tipo = tipo;
		  }

		public String getTipo() {
			return tipo;
		}
	  
	  }
	  	  
	private String codigoMarcacionEmpleado;
	

	
	public TipoRegistro getTipoRegistro() {
		return tipoRegistro;
	}
	public void setTipoRegistro(TipoRegistro tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}
	public String getMultaMarcacion() {
		return multaMarcacion;
	}
	public void setMultaMarcacion(String multaMarcacion) {
		this.multaMarcacion = multaMarcacion;
	}
	public String getDependencia() {
		return dependencia;
	}
	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}
	public String getHorasExtras() {
		return horasExtras;
	}
	public void setHorasExtras(String horasExtras) {
		this.horasExtras = horasExtras;
	}
	public String getHorasAbandono() {
		return horasAbandono;
	}
	public void setHorasAbandono(String horasAbandono) {
		this.horasAbandono = horasAbandono;
	}
	public String getHorasTardanzas() {
		return horasTardanzas;
	}
	public void setHorasTardanzas(String horasTardanzas) {
		this.horasTardanzas = horasTardanzas;
	}
	
	public String getCodigoMarcacion() {
		return codigoMarcacion;
	}
	public void setCodigoMarcacion(String codigoMarcacion) {
		this.codigoMarcacion = codigoMarcacion;
	}
	public String getDiaAsistencia() {
		return diaAsistencia;
	}
	public void setDiaAsistencia(String diaAsistencia) {
		this.diaAsistencia = diaAsistencia;
	}

	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	public String getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public String getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}
	public Justificacion getJustificacion() {
		return justificacion;
	}
	public void setJustificacion(Justificacion justificacion) {
		this.justificacion = justificacion;
	}
	public String getDescripcionMarcacion() {
		return descripcionMarcacion;
	}
	public void setDescripcionMarcacion(String descripcionMarcacion) {
		this.descripcionMarcacion = descripcionMarcacion;
	}
	public Double getLector() {
		return lector;
	}
	public void setLector(Double lector) {
		this.lector = lector;
	}
	public void setCodigoMarcacionEmpleado(String string) {
		// TODO Auto-generated method stub
		codigoMarcacionEmpleado = string;
	}
	
	public String getCodigoMarcacionEmpleado() {
		// TODO Auto-generated method stub
		return  this.codigoMarcacionEmpleado ;
	}
	public String getHoraEntradaAlmuerzo() {
		return horaEntradaAlmuerzo;
	}
	public void setHoraEntradaAlmuerzo(String horaEntradaAlmuerzo) {
		this.horaEntradaAlmuerzo = horaEntradaAlmuerzo;
	}
	public String getHoraFinAlmuerzo() {
		return horaFinAlmuerzo;
	}
	public void setHoraFinAlmuerzo(String horaFinAlmuerzo) {
		this.horaFinAlmuerzo = horaFinAlmuerzo;
	}
	
	 public String getDiaOrder() {
			return diaOrder;
		}
		public void setDiaOrder(String diaOrder) {
			this.diaOrder = diaOrder;
		}
        
 
	  

}
