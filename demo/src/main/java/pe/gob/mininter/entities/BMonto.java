package pe.gob.mininter.entities;

import java.io.Serializable;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class BMonto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer contador;
	private String codigoMonto;
	private String codigoEmpleado;
	private String tipoDstoPerc;
	private Double monto;
	private String montoFormateado;
	private String estado;
	private String fecIni;
	private String fecFin;
	private String tipoDsctoP;
	private Integer tipoDsctoJ;
	private Double sueldoBruto;
	
	//Solo para Retenciones Judiciales
	private Integer codigoPer;
	private Integer tipoPago;
	
	private Integer mes;
	private String mesS;
	private Integer anio;
	
	public Integer getContador() {
		return contador;
	}
	public void setContador(Integer contador) {
		this.contador = contador;
	}
	public String getCodigoMonto() {
		return codigoMonto;
	}
	public void setCodigoMonto(String codigoMonto) {
		this.codigoMonto = codigoMonto;
	}
	public String getCodigoEmpleado() {
		return codigoEmpleado;
	}
	public void setCodigoEmpleado(String codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}
	public String getTipoDstoPerc() {
		return tipoDstoPerc;
	}
	public void setTipoDstoPerc(String tipoDstoPerc) {
		this.tipoDstoPerc = tipoDstoPerc;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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
	public Integer getCodigoPer() {
		return codigoPer;
	}
	public void setCodigoPer(Integer codigoPer) {
		this.codigoPer = codigoPer;
	}
	public Integer getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(Integer tipoPago) {
		this.tipoPago = tipoPago;
	}
	public String getFecIni() {
        return fecIni;
    }
    public void setFecIni(String fecIni) {
        this.fecIni = fecIni;
    }
    public String getFecFin() {
        return fecFin;
    }
    public void setFecFin(String fecFin) {
        this.fecFin = fecFin;
    }
    public String getTipoDsctoP() {
        return tipoDsctoP;
    }
    public void setTipoDsctoP(String tipoDsctoP) {
        this.tipoDsctoP = tipoDsctoP;
    } 
    public Integer getTipoDsctoJ() {
        return tipoDsctoJ;
    }
    public void setTipoDsctoJ(Integer tipoDsctoJ) {
        this.tipoDsctoJ = tipoDsctoJ;
    }
    public String getMesS() {
        return mesS;
    }
    public void setMesS(String mesS) {
        this.mesS = mesS;
    }
    public Double getSueldoBruto() {
        return sueldoBruto;
    }
    public void setSueldoBruto(Double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }
    public String getMontoFormateado() {
        return montoFormateado;
    }
    public void setMontoFormateado(String montoFormateado) {
        this.montoFormateado = montoFormateado;
    }
    @Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
