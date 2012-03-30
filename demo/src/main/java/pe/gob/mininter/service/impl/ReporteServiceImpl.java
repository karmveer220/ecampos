package pe.gob.mininter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.mininter.dao.ReporteDao;
import pe.gob.mininter.entities.BReporteCas;
import pe.gob.mininter.entities.Marcacion;
import pe.gob.mininter.service.ReporteService;

@Service
public class ReporteServiceImpl implements ReporteService {

	@Autowired
	private ReporteDao reporteDao;
	
	@Override
	public List<BReporteCas> listarCasBoletas(String periodo, String mes,String dependencia, String nombres) {
		return reporteDao.listarCasBoletas(periodo, mes, dependencia, nombres);
	}

	@Override
	public List<Marcacion> obtenerAsistenciaxEmpleado(String fecIni,String fecFin, String codEmp) {
		return reporteDao.obtenerAsistenciaxEmpleado(fecIni,fecFin,codEmp);
	}

}
