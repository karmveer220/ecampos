package org.cnl.digemin.DAO.impl;

import java.util.List;

import org.cnl.digemin.DAO.UsuarioDAO;
import org.cnl.digemin.bean.BeanPersona;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public class HibUsuarioDAO implements UsuarioDAO{
   
    public HibUsuarioDAO(){
       
    }

    public BeanPersona validarPersona(String usuario, String clave) throws Exception{return null;}

    public Integer nuevaPersona(BeanPersona persona) throws Exception{return null;}

    public List<BeanPersona> listarUsuarios(Long codigo)throws Exception{return null;}

    public List<BeanPersona> buscarUsuarios(BeanPersona b) throws Exception{return null;}
    
    public BeanPersona obtenerUsuarioById(Long codigo)throws Exception{return null;}

    public Integer modificarPersona(BeanPersona p) throws Exception{return null;}
}
