package pe.gob.mininter.service;

import java.util.List;

import pe.gob.mininter.entities.BReporteCas;
import pe.gob.mininter.entities.Marcacion;

public interface ReporteService {

	public List<BReporteCas> listarCasBoletas(String periodo, String mes, String dependencia, String nombres) ;
	
	public List<Marcacion> obtenerAsistenciaxEmpleado(String fecIni, String fecFin, String codEmp) ;
	
}
