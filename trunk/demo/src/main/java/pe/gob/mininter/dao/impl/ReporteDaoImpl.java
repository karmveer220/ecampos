package pe.gob.mininter.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import pe.gob.mininter.dao.ReporteDao;
import pe.gob.mininter.entities.BDsctoHaber;
import pe.gob.mininter.entities.BReporteCas;
import pe.gob.mininter.entities.Marcacion;
import pe.gob.mininter.utiles.Utiles;

@Repository
public class ReporteDaoImpl extends HibernateDaoSupport implements ReporteDao {

	@Autowired
	public ReporteDaoImpl(SessionFactory sessionFactory){
		setHibernateTemplate( new HibernateTemplate(sessionFactory));
	}
	
	@Override
	public List<BReporteCas> listarCasBoletas(String periodo, String mes, String dependencia, String username) {
		

	  //  UtilesService utilesService = new UtilesService();
		StringBuffer s_sql = new StringBuffer();
		ResultSet rs = null;
	    Statement stm = null;
	    List<BReporteCas> lista = new ArrayList<BReporteCas>();
	    BReporteCas planilla = null;
	    
	    NumberFormat formatter = new DecimalFormat("000000");
        formatter = new DecimalFormat("#,###,###.00");
        
        //Variables para la Validacion
        String mesPlanilla = "";
        String financiamiento = "";
        String sistemPension = "";
        
	    try{  
    	  s_sql.append("select count(m.n_mst_dni) as contador, m.c_mst_codigo, m.n_mst_teleban,to_char(to_date(m.d_mst_fech_min,'dd/mm/yy'),'dd/MM/yyyy') as d_mst_fech_min, ");
    	  s_sql.append("p.c_perl_codigo, m.n_mst_apepaterno || ' ' || m.n_mst_apematerno || ' ' || m.n_mst_nombre as nomCompleto, m.n_mst_dni, ");
    	  s_sql.append("p.n_plan_monto, co.n_cont_sueld,  u.n_uno_general, to_char(m.d_mst_fec_afiliacion,'dd/mm/yyyy') as fecAfiliacion, n_plan_essalud, ");
    	  s_sql.append("p.c_spen_codigo, m.m_mst_ruc, p.n_plan_pension, m.n_mst_nafp, p.n_plan_retencion, sp.n_spen_nombre, ma.n_mont_monto , ");
    	  s_sql.append("c_tplan_codigo, dp.n_dspe_descripcion, n_plan_tipo,afp.n_comi_prima,afp.n_comi_comision,afp.n_comi_tasa, dp.n_dspe_abreviatura,");    	  
    	  s_sql.append("(p.n_plan_monto*afp.n_comi_tasa/100) as montocomi, (p.n_plan_monto*afp.n_comi_comision/100) as montocomisionvariable, ");
          s_sql.append("round(case when p.n_plan_monto>n_comi_tope then (n_comi_tope*afp.n_comi_prima/100) else (p.n_plan_monto*afp.n_comi_prima/100) end,2) as montoseguro, ");                    
          s_sql.append("to_char(to_date(co.d_cont_fecini,'dd/mm/yy'),'dd/mm/yyyy') as fecinicont, n_plan_pago, p.n_plan_mes, ");
          s_sql.append("to_char(co.d_cont_fecfin_modi,'dd/MM/yyyy') as fecfincont, to_char(co.d_cont_fechabaja,'dd/MM/yyyy')as fecbaja, ");          
          s_sql.append("n_plan_dsct_esvida, n_plan_dsct_seguro, n_plan_dsct_alimen, n_plan_dsct_aficafae ");
          
    	  s_sql.append("from srhl_planilla p ");
    	  s_sql.append("inner join simin_maestro m on p.c_perl_codigo = m.c_perl_codigo ");
    	  s_sql.append("inner join srhl_contrato co on m.c_perl_codigo = co.c_perl_codigo and co.f_cont_estado = 1 ");
    	  s_sql.append("inner join srhl_sueldo s on co.c_cont_codigo = s.c_cont_codigo and s.n_suel_anio = " +periodo+" and s.n_suel_mes = "+mes+" ");
    	  s_sql.append("inner join simin_unidadorganica u on m.c_uno_codigo_oficina = u.c_uno_codigo ");
    	  s_sql.append("inner join srhl_sist_pension sp on sp.c_spen_codigo=p.c_spen_codigo ");
    	  s_sql.append("inner join srhmint.srhl_monto_asignados ma on ma.c_perl_codigo=m.c_perl_codigo and ma.d_mont_anio=" +periodo+" and ma.d_mont_mes="+mes+" ");    	  
    	  s_sql.append("left join srhmint.srhl_comisionafp afp on  afp.c_spen_codigo=p.c_spen_codigo and afp.n_comi_anio =" +periodo+" and afp.n_comi_mes="+mes+" ");
    	  s_sql.append("inner join srhl_dsct_perc dp on ma.c_dspe_codigo = dp.c_dspe_codigo ");
    	  s_sql.append("where p.n_plan_pago = '1' ")
    	  		.append(" and p.n_plan_tipo = 1 ")
    	  		.append(" and p.n_plan_anio=" +periodo+" ")
    	  		.append(" and p.n_plan_mes ="+mes+" ");
    	  s_sql.append("and m.n_mst_login = '"+username + "'");
    	  //s_sql.append("and m.n_mst_dni = '40000415' ");
    	  
    	  if(!Utiles.nullToBlank(dependencia).equals("-1")){
    	      s_sql.append("and u.n_uno_general_abrev = '"+ Utiles.nullToBlank(dependencia) +"'  ");	            	 
          }
    	  
    	  s_sql.append("group by m.n_mst_dni, m.c_mst_codigo, m.n_mst_teleban,m.d_mst_fech_min, p.c_perl_codigo, m.n_mst_apepaterno,m.n_mst_apematerno, ");
	      s_sql.append("m.n_mst_nombre, m.n_mst_dni, n_plan_tipo, p.n_plan_monto, co.n_cont_sueld, ");
          s_sql.append("u.n_uno_general, m.d_mst_fec_afiliacion, p.c_spen_codigo, m.m_mst_ruc, p.n_plan_pension, m.n_mst_nafp, p.n_plan_retencion, ");
          s_sql.append("sp.n_spen_nombre, ma.n_mont_monto , c_tplan_codigo, dp.n_dspe_descripcion, n_plan_dsct_alimen, ");
          s_sql.append("afp.n_comi_prima,afp.n_comi_comision,afp.n_comi_tasa, n_comi_tope, dp.n_dspe_abreviatura, ");
          s_sql.append("d_cont_fecini, d_cont_fecfin_modi, d_cont_fechabaja, n_plan_essalud, n_plan_pago, p.n_plan_mes, ");
          s_sql.append("n_plan_dsct_esvida, n_plan_dsct_seguro, n_plan_dsct_aficafae ");
    	  
    	  s_sql.append("order by  nomCompleto ");
    	  logger.debug(s_sql.toString());
    	  
	      stm = this.getSession().connection().createStatement();
	      
          rs=stm.executeQuery(s_sql.toString());
         
          int contLista = 0;
          String codEmpleado = "";
          
          Double sumDsctos = 0.0;
          
          while (rs.next()){
              
              if(!rs.getString("c_perl_codigo").equals(codEmpleado)){
                  
                  codEmpleado = rs.getString("c_perl_codigo");
                  
                  if(planilla!=null){          
                      
                      lista.add(planilla);
                      sumDsctos = 0.0;
                  }
                  
                  //Setea los paramentros no repetitivos
                  planilla = new BReporteCas();                  
                  planilla.setNombresEmp(rs.getString("nomCompleto"));
                  planilla.setContador(rs.getInt("contador"));
                  planilla.setDependenciaEmp(rs.getString("n_uno_general"));
                  planilla.setDniEmp(rs.getString("n_mst_dni"));
                  planilla.setRucEmp(rs.getString("m_mst_ruc"));
                  planilla.setCodAutogeneradoEmp(rs.getString("c_mst_codigo"));
                  planilla.setFecIngMininter(rs.getString("d_mst_fech_min"));
                  planilla.setNroCUSP(rs.getString("n_mst_nafp"));
                  planilla.setFecAfiliacionPension(rs.getString("fecAfiliacion"));
                  planilla.setFecContIniEmp(rs.getString("fecinicont"));
                  planilla.setFecBaja(rs.getString("fecbaja"));
                  planilla.setSueldoContrato(formatter.format(rs.getDouble("n_cont_sueld")));
                  planilla.setHonorariosEmp(rs.getDouble("n_plan_monto"));
                  planilla.setDsctoRentaEmp(rs.getDouble("n_plan_retencion"));
                  planilla.setMontoseguro(rs.getDouble("n_plan_pension"));
                  planilla.setDsctoEssaludEmp(""+rs.getDouble("n_plan_essalud"));
                  planilla.setAnio(periodo);
                  planilla.setMes(Utiles.devolverMes(rs.getInt("n_plan_mes")));
                  
                  if (rs.getString("c_spen_codigo").equals("11")) planilla.setDsctoPensionEmp("SIN REGIMEN DE PENSION");
                  else if (rs.getString("c_spen_codigo").equals("10")) planilla.setDsctoPensionEmp("SISTEMA NACIONAL DE PENSIONES");
                  else planilla.setDsctoPensionEmp(rs.getString("n_spen_nombre"));
                  
                  if (rs.getString("n_plan_pago").equals("1")) planilla.setTipoRecurso("REC. ORDINARIOS");
                  else planilla.setTipoRecurso("REC. DIRECTAMENTE RECAUDADOS");
                  
                  
                  if (rs.getString("c_spen_codigo").equals("10")) {
                      planilla.getListadodsctos().add(new BDsctoHaber("S.N.P. 13%", formatter.format(Double.parseDouble(rs.getString("n_plan_pension")))));
                  }else {
                      if (rs.getDouble("n_plan_pension")!=0.00){
                          planilla.getListadodsctos().add(new BDsctoHaber("PRIMA "+rs.getString("n_comi_tasa")+"%", formatter.format(Double.parseDouble(rs.getString("montocomi")))));
                          planilla.getListadodsctos().add(new BDsctoHaber("SIS "+rs.getString("n_comi_prima")+"%", formatter.format(Double.parseDouble(rs.getString("montoseguro")))));
                          planilla.getListadodsctos().add(new BDsctoHaber("CVA "+rs.getString("n_comi_prima")+"%", formatter.format(Double.parseDouble(rs.getString("montocomisionvariable")))));
                      }
                  }                  
                  
                  if (rs.getInt("n_plan_retencion")!=0){
                      planilla.getListadodsctos().add(new BDsctoHaber("4.CAT(10%)", formatter.format(Double.parseDouble(rs.getString("n_plan_retencion")))));  
                  }
                  
                  if (rs.getDouble("n_plan_dsct_alimen")!=0.00){
                      planilla.getListadodsctos().add(new BDsctoHaber("RET. ALIMENTOS", formatter.format(Double.parseDouble(rs.getString("n_plan_dsct_alimen")))));
                      sumDsctos += rs.getDouble("n_plan_dsct_alimen");
                  }
                  
                  if (rs.getDouble("n_plan_dsct_esvida")!=0.00){
                      planilla.getListadodsctos().add(new BDsctoHaber("ESSALUD VIDA", formatter.format(Double.parseDouble(rs.getString("n_plan_dsct_esvida")))));
                      sumDsctos += rs.getDouble("n_plan_dsct_esvida");
                  }
                  
                  if (rs.getDouble("n_plan_dsct_seguro")!=0.00){
                      planilla.getListadodsctos().add(new BDsctoHaber("SEGURO CAFAE", formatter.format(Double.parseDouble(rs.getString("n_plan_dsct_seguro")))));
                      sumDsctos += rs.getDouble("n_plan_dsct_seguro");
                  }
                  
                  if (rs.getDouble("n_plan_dsct_aficafae")!=0.00){
                      planilla.getListadodsctos().add(new BDsctoHaber("AFILIAC. CAFAE", formatter.format(Double.parseDouble(rs.getString("n_plan_dsct_aficafae")))));
                      sumDsctos += rs.getDouble("n_plan_dsct_aficafae");
                  }
                  
                  
                  sumDsctos += rs.getDouble("n_plan_pension");
                  sumDsctos += rs.getDouble("n_plan_retencion");
                  
                  
              }
        	  
        	  
        	  
        	  
        	  /*if (contLista==0) {
        	      
        	      //logger.debug("jo "+planilla.getNombresEmp());
        	      contLista++;
        	  }else {
        	      planilla.setNombresEmp2(rs.getString("nomCompleto"));
        	      contLista--;
        	  }*/
        	  
        	          
        	  
        	  if (rs.getDouble("n_mont_monto")!=0.00){
        	      planilla.getListadodsctos().add(new BDsctoHaber(rs.getString("n_dspe_abreviatura"), formatter.format(Double.parseDouble(rs.getString("n_mont_monto")))));
        	      sumDsctos += rs.getDouble("n_mont_monto");
        	  }
        	  
        	  
        	  
        	  planilla.setTotalDscto(sumDsctos);
              planilla.setHonorarioNetoEmp((rs.getDouble("n_plan_monto")-planilla.getTotalDscto()));
              
        	  
        	  
        	  
        	  lista.add(planilla);
          }
          logger.debug(lista.size());
	      if(rs !=null){rs.close(); rs = null;}        
	      if(stm!=null){stm.close(); }
      }catch(Exception e ){
          e.printStackTrace();
          logger.debug(e.getMessage());
       
      }finally{
    	  try {
    		  if(rs !=null){rs.close(); rs = null;}
              if (stm != null) stm.close();
    	  } catch (Exception e2) {}
      }
      return lista;
      
	}

	@Override
	public List<Marcacion> obtenerAsistenciaxEmpleado(String fecIni, String fecFin, String username) {
		List<Marcacion> lista = new ArrayList<Marcacion>();
		StringBuilder s_sql = new StringBuilder();
		ResultSet rs = null;
		PreparedStatement stm = null;
		Marcacion beanmarcacion = null;
		boolean where = false;
		try {
				        s_sql.append(
				            " select ds,obtenerpermisos(c_perl_codigo,to_char(ds,'dd/mm/yyyy')) as Permi, substr(resu.tarda,7,2)  + substr(resu.tarda,4,2)*60  + substr(resu.tarda,1,2)*60*60 seg, " +
				                " resu.n_uno_descripcion, " +
				                " resu.n_tiptur_comentariouno, " +
				                " resu.funcion,resu.codigopersonal, " +
				                " resu.tiporegistro, resu.nombrecompleto,resu.n_car_descripcion, resu.horario,resu.codigodiaorder, " +
				                " resu.codigodia, resu.horainicio, resu.horasalida," +
				                " resu.tur,resu.sal," +
				                " case when ltrim(rtrim(HORARIO))='-' " +
				                " then " +
				                " '00:00:00' else " +
				                " case when (select count(*) from  srha_calendario where resu.ds=d_cal_fecha)>0 " +
				                " then '00:00:00' else " +
				                 " case when (select count(*) from srha_detalle_vacaciones  where c_perl_codigo=resu.c_perl_codigo and  " +
				                " resu.ds >=d_detvac_fecini " +
				                 " and resu.ds <=d_detvac_fecfin and f_detvac_tomadas=1)>0 " +
				                 " then '00:00:00' else " +
				                  " case when (select count(*) from srha_detalle_permiso p inner join srha_tipo_permiso tp " +
				                 "  on p.c_tipper_codigo= tp.c_tipper_codigo where c_perl_codigo=resu.c_perl_codigo and  " +
				                " resu.ds >=d_detper_fecini " +
				                "  and resu.ds <=d_detper_fecfin and tp.f_tipper_diashoras=1)>0 " +
				                 " then " +
				                " '00:00:00' " +
				                 " else " +
				                "  case when (select count(*) from srha_detalle_permiso p inner join srha_tipo_permiso tp " +
				                 "  on p.c_tipper_codigo= tp.c_tipper_codigo where c_perl_codigo=resu.c_perl_codigo and  " +
				                " resu.ds >=d_detper_fecini " +
				                 " and resu.ds <=d_detper_fecfin and tp.f_tipper_diashoras=0 and p.f_detper_entsal=0)>0 " +
				                "  then " +
				                " (select " +
				                " case when " +
				                " TO_DATE(TO_CHAR(trunc(sysdate)+(TO_DATE(p.d_detper_horfin, 'HH24:MI:SS')-TO_DATE(p.d_detper_horini, 'HH24:MI:SS')),'HH24:MI:SS'), 'HH24:MI:SS') " +
				                " >= " + 
				                " TO_DATE(TO_CHAR(trunc(sysdate)+(TO_DATE(to_char(to_date(to_char(resu.ds, 'dd/mm/YYYY')||' '||resu.tarda, 'dd/mm/yyyy hh24:mi:ss'),'hh24:mi:ss'), 'HH24:MI:SS')-TO_DATE('00:00:00', 'HH24:MI:SS')),'HH24:MI:SS'), 'HH24:MI:SS') " +
				                " then '00:00:00' " +
				                " else " +
				                " TO_CHAR(trunc(sysdate)+(TO_DATE(to_char(to_date(to_char(resu.ds, 'dd/mm/YYYY')||' '||resu.tarda, 'dd/mm/yyyy hh24:mi:ss'),'hh24:mi:ss'), 'HH24:MI:SS')-TO_DATE(TO_CHAR(trunc(sysdate)+(TO_DATE(p.d_detper_horfin, 'HH24:MI:SS')-TO_DATE(p.d_detper_horini, 'HH24:MI:SS')),'HH24:MI:SS'), 'HH24:MI:SS')),'HH24:MI:SS') " +
				                " end   " +
				                 " as tard " +
				                " from srha_detalle_permiso p inner join srha_tipo_permiso tp " +
				                 "  on p.c_tipper_codigo= tp.c_tipper_codigo where c_perl_codigo=resu.c_perl_codigo and  " +
				                " resu.ds >=d_detper_fecini " +
				                 " and resu.ds <=d_detper_fecfin and tp.f_tipper_diashoras=0 and p.f_detper_entsal=0) " +
				                " else " +
				                 " resu.tarda " +
				                "  end end end end  end as horastardanza, " +
				                 " case when ltrim(rtrim(HORARIO))='-' " +
				                " then " +
				                " '00:00:00' else " +
				                 " case when (select count(*) from  srha_calendario where resu.ds=d_cal_fecha)>0 " +
				                " then '00:00:00' else " +
				                 " case when (select count(*) from srha_detalle_vacaciones  where c_perl_codigo=resu.c_perl_codigo and  " +
				                " resu.ds >=d_detvac_fecini " +
				                 " and resu.ds <=d_detvac_fecfin and f_detvac_tomadas=1)>0 " +
				                 " then '00:00:00' else " +
				                 " resu.horasxcompensar " +
				                 " end  end end horasxcompensar1,  " +
				                 " case when ltrim(rtrim(HORARIO))='-' " +
				                " then " +
				                " '00:00:00' else " +
				                 " case when (select count(*) from  srha_calendario where resu.ds=d_cal_fecha)>0 " +
				                " then '00:00:00' else " +
				                 " case when (select count(*) from srha_detalle_vacaciones  where c_perl_codigo=resu.c_perl_codigo and  " +
				                " resu.ds >=d_detvac_fecini " +
				                 " and resu.ds <=d_detvac_fecfin and f_detvac_tomadas=1)>0 " +
				                 " then '00:00:00' else " +
				                 "  case when (select count(*) from srha_detalle_permiso p " +
				                "  where c_perl_codigo=resu.c_perl_codigo and  " +
				                " (resu.ds >=d_detper_fecini " +
				                " and resu.ds <=d_detper_fecfin) and p.c_tipper_codigo in (3,4))>0 " +
				                 " then " +
				                 " resu.horasxcompensar " +
				                " else " +
				                " '00:00:00' " +
				                 " end end  end end horasxcompensar,  " +
				                 " case when ltrim(rtrim(HORARIO))='-' " +
				                " then " +
				                " '00:00:00' else " +
				                " case when (select count(*) from  srha_calendario where resu.ds=d_cal_fecha)>0 " +
				                " then '00:00:00' else " +
				                "  case when (select count(*) from srha_detalle_vacaciones  where c_perl_codigo=resu.c_perl_codigo and  " +
				                " resu.ds >=d_detvac_fecini " +
				                "  and resu.ds <=d_detvac_fecfin and f_detvac_tomadas=1)>0 " +
				                 " then '00:00:00' else " +
				                 "  case when (select count(*) from srha_detalle_permiso p inner join srha_tipo_permiso tp " +
				                "  on p.c_tipper_codigo= tp.c_tipper_codigo where c_perl_codigo=resu.c_perl_codigo and  " +
				                " resu.ds >=d_detper_fecini " +
				                "  and resu.ds <=d_detper_fecfin and tp.f_tipper_diashoras=1)>0 " +
				                "  then " +
				                " '00:00:00' " +
				                 " else " +
				                 " case when (select count(*) from srha_detalle_permiso p inner join srha_tipo_permiso tp " +
				                 "  on p.c_tipper_codigo= tp.c_tipper_codigo where c_perl_codigo=resu.c_perl_codigo and  " +
				                " resu.ds >=d_detper_fecini " +
				                 " and resu.ds <=d_detper_fecfin and tp.f_tipper_diashoras=0 AND p.f_detper_entsal=1)>0 " +
				                 " then " +
				                " (select " +
				                " case when  " +
				                " TO_DATE(TO_CHAR(trunc(resu.ds)+(TO_DATE(p.d_detper_horfin, 'HH24:MI:SS')-TO_DATE(p.d_detper_horini, 'HH24:MI:SS')),'HH24:MI:SS'), 'HH24:MI:SS') " +
				                " >= " +
				                " TO_DATE(TO_CHAR(trunc(resu.ds)+(TO_DATE(to_char(to_date(to_char(resu.ds, 'dd/mm/YYYY')||' '||resu.aban, 'dd/mm/yyyy hh24:mi:ss'),'hh24:mi:ss') , 'HH24:MI:SS')-TO_DATE('00:00:00', 'HH24:MI:SS')),'HH24:MI:SS'), 'HH24:MI:SS') " +
				                " then '00:00:00' " +
				                " else " +
				                " TO_CHAR(trunc(resu.ds)+(TO_DATE(to_char(to_date(to_char(resu.ds, 'dd/mm/YYYY')||' '||resu.aban, 'dd/mm/yyyy hh24:mi:ss'),'hh24:mi:ss') , 'HH24:MI:SS')-TO_DATE(TO_CHAR(trunc(resu.ds)+(TO_DATE(p.d_detper_horfin, 'HH24:MI:SS')-TO_DATE(p.d_detper_horini, 'HH24:MI:SS')),'HH24:MI:SS'), 'HH24:MI:SS')),'HH24:MI:SS') " +
				                " end  as tard " +
				                " from srha_detalle_permiso p inner join srha_tipo_permiso tp " +
				                 " on p.c_tipper_codigo= tp.c_tipper_codigo where c_perl_codigo=resu.c_perl_codigo and  " +
				                " resu.ds >=d_detper_fecini " +
				                 " and resu.ds <=d_detper_fecfin and tp.f_tipper_diashoras=0 and p.f_detper_entsal=1) " +
				                 " else " +
				                 " resu.aban " +
				                 " end end end end end horasabandono , " +
				                " case when case when ltrim(rtrim(HORARIO))='-' " +
				                " then '00:00:00' else" +
				                " case when (select count(*) from  srha_calendario where resu.ds=d_cal_fecha)>0" +
				                " then '00:00:00' else" +
				                " case when (select count(*) from srha_detalle_vacaciones  where c_perl_codigo=resu.c_perl_codigo and" +
				                " resu.ds >=d_detvac_fecini" +
				                " and resu.ds <=d_detvac_fecfin and f_detvac_tomadas=1)>0" +
				                " then '00:00:00' else" +
				                " case when (select count(*) from srha_detalle_permiso p inner join srha_tipo_permiso tp" +
				                " on p.c_tipper_codigo= tp.c_tipper_codigo where c_perl_codigo=resu.c_perl_codigo and" +
				                " resu.ds >=d_detper_fecini" +
				                " and resu.ds <=d_detper_fecfin and tp.f_tipper_diashoras=1)>0" +
				                " then '00:00:00' else" +
				                " case when (select count(*) from srha_detalle_permiso p inner join srha_tipo_permiso tp" +
				                " on p.c_tipper_codigo= tp.c_tipper_codigo where c_perl_codigo=resu.c_perl_codigo and" +
				                " resu.ds >=d_detper_fecini" +
				                " and resu.ds <=d_detper_fecfin and tp.f_tipper_diashoras=0 AND p.f_detper_entsal=1)>0" +
				                " then" +
				                " (select" +
				                " case when" +
				                " TO_DATE(TO_CHAR(trunc(resu.ds)+(TO_DATE(p.d_detper_horfin, 'HH24:MI:SS')-TO_DATE(p.d_detper_horini, 'HH24:MI:SS')),'HH24:MI:SS'), 'HH24:MI:SS')" +
				                " >= TO_DATE(TO_CHAR(trunc(resu.ds)+(TO_DATE(to_char(to_date(to_char(resu.ds, 'dd/mm/YYYY')||' '||resu.aban, 'dd/mm/yyyy hh24:mi:ss'),'hh24:mi:ss') , 'HH24:MI:SS')-TO_DATE('00:00:00', 'HH24:MI:SS')),'HH24:MI:SS'), 'HH24:MI:SS')" +
				                " then '00:00:00'" +
				                " else TO_CHAR(trunc(resu.ds)+(TO_DATE(to_char(to_date(to_char(resu.ds, 'dd/mm/YYYY')||' '||resu.aban, 'dd/mm/yyyy hh24:mi:ss'),'hh24:mi:ss') , 'HH24:MI:SS')-TO_DATE(TO_CHAR(trunc(resu.ds)+(TO_DATE(p.d_detper_horfin, 'HH24:MI:SS')-TO_DATE(p.d_detper_horini, 'HH24:MI:SS')),'HH24:MI:SS'), 'HH24:MI:SS')),'HH24:MI:SS')" +
				                " end  as tard" +
				                " from srha_detalle_permiso p inner join srha_tipo_permiso tp" +
				                " on p.c_tipper_codigo= tp.c_tipper_codigo where c_perl_codigo=resu.c_perl_codigo and" +
				                " resu.ds >=d_detper_fecini" +
				                " and resu.ds <=d_detper_fecfin and tp.f_tipper_diashoras=0 and p.f_detper_entsal=1)" +
				                " else resu.aban end end end end end ='00:00:00' then 0 else" +
				                " case when ((TO_DATE(to_char(to_date(to_char(resu.ds, 'dd/mm/YYYY')||' '||substr(resu.aban,0,8) , 'dd/mm/yyyy hh24:mi:ss'),'hh24:mi:ss'), 'HH24:MI:ss') - TO_DATE((to_char(to_date(to_char(resu.ds, 'dd/mm/YYYY')||' '|| '00:00:00'  , 'dd/mm/yyyy hh24:mi:ss'),'hh24:mi:ss')), 'HH24:MI:ss'))*24  >=" +
				                " (TO_DATE(to_char(to_date(to_char(resu.ds, 'dd/mm/YYYY')||' '||substr(resu.horario,12,8) , 'dd/mm/yyyy hh24:mi:ss'),'hh24:mi:ss'), 'HH24:MI:ss') - TO_DATE((to_char(to_date(to_char(resu.ds, 'dd/mm/YYYY')||' '||substr(resu.horario,0,8) , 'dd/mm/yyyy hh24:mi:ss'),'hh24:mi:ss')), 'HH24:MI:ss'))*24 )" +
				                " and (TO_DATE(to_char(to_date(to_char(resu.ds, 'dd/mm/YYYY')||' '||substr(resu.aban,0,8) , 'dd/mm/yyyy hh24:mi:ss'),'hh24:mi:ss'), 'HH24:MI:ss') - TO_DATE((to_char(to_date(to_char(resu.ds, 'dd/mm/YYYY')||' '|| '00:00:00'  , 'dd/mm/yyyy hh24:mi:ss'),'hh24:mi:ss')), 'HH24:MI:ss'))*24  > 0 then 1 else 0 end end faltas," +

				                " resu.horaalmuerzoini, resu.horafin_almuerzo" + 
				                " from ( " +
				                "  select uo.n_uno_descripcion as n_uno_descripcion,  m.c_perl_codigo," +
				                 " ttur.n_tiptur_comentariouno,fu.n_fun_descrip as funcion , " +
				                 " ma.c_mst_codigo as codigopersonal,ti.c_ting_nombre  as tiporegistro, " +
				                 " m.n_mst_nombre || ' '|| m.n_mst_apepaterno || ' '|| m.n_mst_apematerno as nombrecompleto, " +
				                 " m.n_mst_dni,c.n_car_descripcion as  n_car_descripcion, " +
				                 " ttur.n_tiptur_entrada || ' - ' ||  ttur.n_tiptur_salida horario, " +
				                 " to_char(to_date(REPLACE(ma.n_dia,'------','000000'),'dd/mm/yy'),'(mm/dd)') as codigodiaorder, " +
				                 " to_char(to_date(REPLACE(ma.n_dia,'------','000000'),'dd/mm/yy'), 'DD MONTH YYYY DAY (dd/mm/yyyy)','NLS_DATE_LANGUAGE=spanish') as codigodia," + 
				                 " to_char(to_date(REPLACE(ma.n_horainicio,'------','000000'),'hh24:mi:ss'),'hh24:mi:ss') as horainicio, " +
				                 " to_char(to_date(REPLACE(ma.n_horafin,'------','000000'),'hh24:mi:ss'),'hh24:mi:ss') as horasalida, " +
				                 " to_date(to_char(to_date(REPLACE(ma.n_dia,'------','000000'),'dd/mm/yy'),'dd/mm/yyyy')||' '|| " +
				                 " ttur.n_tiptur_salida, 'dd/mm/yyyy hh24:mi:ss') as tur, " +
				                 " to_date(to_char(to_date(REPLACE(ma.n_dia,'------','000000'),'dd/mm/yy'), " +
				                 " 'dd/mm/yyyy')||' '||to_char(to_date(REPLACE(ma.n_horafin,'------','000000'),'hh24:mi:ss'),'hh24:mi:ss'), ' " +
				                 " dd/mm/yyyy hh24:mi:ss') as sal, " +
				                 " case when (  to_date(to_char(to_date(REPLACE(ma.n_dia,'------','000000'),'dd/mm/yy'),'dd/mm/yyyy')||' '||to_char(to_date(REPLACE(ma.n_horainicio,'------','000000'),'hh24:mi:ss'),'hh24:mi:ss'), 'dd/mm/yyyy hh24:mi:ss') - " + 
				                " to_date(to_char(to_date(REPLACE(ma.n_dia,'------','000000'),'dd/mm/yy'),'dd/mm/yyyy')||' '|| ttur.n_tiptur_entrada, 'dd/mm/yyyy hh24:mi:ss'))>0 " +
				                " then  ( " +
				                " to_char ( to_date(to_char(to_date(REPLACE(ma.n_dia,'------','000000'),'dd/mm/yy'),'dd/mm/yyyy')||' '||to_char(to_date(REPLACE(ma.n_horainicio,'------','000000'),'hh24:mi:ss'),'hh24:mi:ss'), 'dd/mm/yyyy hh24:mi:ss') - " +
				                " to_date(to_char(to_date(REPLACE(ma.n_dia,'------','000000'),'dd/mm/yy'),'dd/mm/yyyy')||' '|| ttur.n_tiptur_entrada , 'dd/mm/yyyy hh24:mi:ss')  + " +
				                " to_date(to_char(to_date(REPLACE(ma.n_dia,'------','000000'),'dd/mm/yy'),'dd/mm/yyyy')||'00:00:00', 'dd/mm/yyyy hh24:mi:ss') ,'hh24:mi:ss')  ) " +
				                 " else   '00:00:00'  end tarda, " +
				                 " case when ((NVL(ma.N_HORAINICIO ,'-') <>'-') AND  (NVL(ma.n_horafin,'-') <>'-') ) " +
				                 " then " +
				                 " case when (  to_date(to_char(to_date(REPLACE(ma.n_dia,'------','000000'),'dd/mm/yy'),'dd/mm/yyyy')||' '||to_char(to_date(REPLACE(ma.n_horafin,'------','000000'),'hh24:mi:ss'),'hh24:mi:ss'), 'dd/mm/yyyy hh24:mi:ss') - " +
				                "  to_date(to_char(to_date(REPLACE(ma.n_dia,'------','000000'),'dd/mm/yy'),'dd/mm/yyyy')||' '|| ttur.n_tiptur_salida, 'dd/mm/yyyy hh24:mi:ss'))>0  " +
				                "  then  (  to_char ( to_date(to_char(to_date(REPLACE(ma.n_dia,'------','000000'),'dd/mm/yy'),'dd/mm/yyyy')||' '||to_char(to_date(REPLACE(ma.n_horafin,'------','000000'),'hh24:mi:ss'),'hh24:mi:ss'), 'dd/mm/yyyy hh24:mi:ss') - " +
				                 " to_date(to_char(to_date(REPLACE(ma.n_dia,'------','000000'),'dd/mm/yy'),'dd/mm/yyyy')||' '|| ttur.n_tiptur_salida , 'dd/mm/yyyy hh24:mi:ss')  + " +
				                 " to_date(to_char(to_date(REPLACE(ma.n_dia,'------','000000'),'dd/mm/yy'),'dd/mm/yyyy')||'00:00:00', 'dd/mm/yyyy hh24:mi:ss') ,'hh24:mi:ss')  ) " +
				                 " else '00:00:00' end else '00:00:00' end as horasxcompensar, " +
				                 " to_date(to_char(to_date(REPLACE(ma.n_dia,'------','000000'),'dd/mm/yy'),'dd/mm/yyyy'),'dd/mm/yyyy') ds," +
				                 " case when ((NVL(ma.N_HORAINICIO ,'-') <>'-') AND  (NVL(ma.n_horafin,'-') <>'-') ) " +
				                 " then  case when ( to_date(to_char(to_date(REPLACE(ma.n_dia,'------','000000'),'dd/mm/yy'),'dd/mm/yyyy')||' '||to_char(to_date(REPLACE(ma.n_horafin,'------','000000'),'hh24:mi:ss'),'hh24:mi:ss'), 'dd/mm/yyyy hh24:mi:ss') - " + 
				                 " to_date(to_char(to_date(REPLACE(ma.n_dia,'------','000000'),'dd/mm/yy'),'dd/mm/yyyy')||' '||ttur.n_tiptur_salida , 'dd/mm/yyyy hh24:mi:ss'))<0 " +
				                 " then " +
				                 " (to_char ( to_date(to_char(to_date(REPLACE(ma.n_dia,'------','000000'),'dd/mm/yy'),'dd/mm/yyyy')||' '|| ttur.n_tiptur_salida, 'dd/mm/yyyy hh24:mi:ss') - " +
				                "   to_date(to_char(to_date(REPLACE(ma.n_dia,'------','000000'),'dd/mm/yy'),'dd/mm/yyyy')||' '||to_char(to_date(REPLACE(ma.n_horafin,'------','000000'),'hh24:mi:ss'),'hh24:mi:ss'), 'dd/mm/yyyy hh24:mi:ss') + " + 
				                 " to_date(to_char(to_date(REPLACE(ma.n_dia,'------','000000'),'dd/mm/yy'),'dd/mm/yyyy')||'00:00:00', 'dd/mm/yyyy hh24:mi:ss')  ,'hh24:mi:ss') ) " +
				                 " else  '00:00:00' end  else  " +
				                 " (to_char ( to_date(to_char(to_date(REPLACE(ma.n_dia,'------','000000'),'dd/mm/yy'),'dd/mm/yyyy')||' '|| ttur.n_tiptur_salida, 'dd/mm/yyyy hh24:mi:ss') - " +
				                 " to_date(to_char(to_date(REPLACE(ma.n_dia,'------','000000'),'dd/mm/yy'),'dd/mm/yyyy')||' '||ttur.n_tiptur_entrada, 'dd/mm/yyyy hh24:mi:ss') + " +
				                  " to_date(to_char(to_date(REPLACE(ma.n_dia,'------','000000'),'dd/mm/yy'),'dd/mm/yyyy')||'00:00:00', 'dd/mm/yyyy hh24:mi:ss')  ,'hh24:mi:ss') ) " +
				                  " end     as aban,  " +
				                 " '00:00:00' as horaalmuerzoini, '00:00:00' as horafin_almuerzo " +
				                " from srha_marcacion ma  " +
				                 " inner join simin_maestro m on m.c_mst_codigo=ma.c_mst_codigo  " +
				                 " inner join simin_unidadorganica uo on m.c_uno_codigo_of_destaque=uo.c_uno_codigo  " +
				                 " inner join srhl_tip_ing ti on m.c_ting_codigo=ti.c_ting_codigo  " +
				                 " left join simin_cargo c on m.c_car_codigo=c.c_car_codigo  " +
				                 " left join simin_funciones fu on m.c_fun_codigo=fu.c_fun_codigo  " +
				                 " inner join SRHA_detalle_turno dett on dett.c_perl_codigo= m.c_perl_codigo  " +
				                 " inner join SRHA_dias_turnos diast on dett.c_dettur_codigo= diast.c_dettur_codigo  " +
				                " and case when to_number(to_char(to_date(ma.n_dia,'dd/mm/yy'), 'd'))-1=0 then 7 else to_number(to_char(to_date(ma.n_dia,'dd/mm/yy'), 'd'))-1 end =diast.c_dias_codigo " +  
				                 " and (to_char(to_date(ma.n_dia,'dd/mm/yy'),'yyyymmdd') >=to_char(dett.d_dettur_fecini,'yyyymmdd')  " +
				                " and to_char(to_date(ma.n_dia,'dd/mm/yy'),'yyyymmdd') <= to_char(nvl(dett.d_dettur_fecfin,sysdate),'yyyymmdd') )  " +
				                "  left join SRHA_tipo_turno ttur on diast.c_tiptur_codigo = ttur.c_tiptur_codigo   " +
				                 " where " + 
				            "   m.n_mst_login ='" + username + "'"+
				            " and to_char(to_date(ma.n_dia,'dd/mm/yy'),'yyyymmdd') >= to_char(to_date('"+fecIni+"','dd/mm/yyyy'),'yyyymmdd')" + 
				            " and to_char(to_date(ma.n_dia,'dd/mm/yy'),'yyyymmdd') <= to_char(to_date('"+fecFin+"','dd/mm/yyyy') ,'yyyymmdd')" + 
				            ") resu order by codigodiaorder asc") ; 
				        
			stm = this.getSession().connection().prepareStatement(s_sql.toString());
			
			logger.debug("Busqueda de Asistencia por Persona -> "
					+ s_sql.toString());
			rs = stm.executeQuery();
			
			while (rs.next()) {
				beanmarcacion = new Marcacion();
				beanmarcacion.setContador(rs.getRow());
				// beanmarcacion.setDistdia(rs.getString("distdia"));
				beanmarcacion.setNombreCompleto(rs.getString("nombrecompleto"));
				beanmarcacion.setCodigoEmp(rs.getString("codigopersonal"));
				// beanmarcacion.setDni(rs.getString("n_mst_dni"));
				beanmarcacion.setDiaAsistencia(rs.getString("codigodia"));
				System.out.println(beanmarcacion.getDiaAsistencia());
				// beanmarcacion.setDiaOrder(rs.getString("codigodiaorder"));
				beanmarcacion.setHoraEntrada(rs.getString("horainicio"));
				beanmarcacion.setHoraSalida(rs.getString("horasalida"));
				beanmarcacion.setHorasTardanzas(rs.getString("horastardanza"));
				beanmarcacion.setHorasExtras(rs.getString("horasxcompensar1"));
				beanmarcacion.setHorasAbandono(rs.getString("horasabandono"));
				beanmarcacion.setHoraEntradaAlmuerzo(rs.getString("horaalmuerzoini"));
				beanmarcacion.setHoraFinAlmuerzo(rs.getString("horafin_almuerzo"));
				beanmarcacion.setTipIngreso(rs.getString("tiporegistro"));
				beanmarcacion.setOfi_destaque(rs.getString("n_uno_descripcion"));
				beanmarcacion.setCargo(rs.getString("n_car_descripcion"));
				beanmarcacion.setFuncion(rs.getString("funcion"));
				beanmarcacion.setHorario(rs.getString("horario"));
				beanmarcacion.setDescripcionMarcacion(rs.getString("Permi"));
				lista.add(beanmarcacion);
			}
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stm != null) {
				stm.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stm != null)
					stm.close();
			} catch (Exception exception1) {
			}
		}
		logger.debug(lista.size());
		return lista;
	}

}
