package org.cnl.digemin.DAO;

import java.util.List;

import org.cnl.digemin.bean.BeanPersona;
/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public interface UsuarioDAO {
    
    public BeanPersona validarPersona(String usuario ,String clave)throws Exception;

    public Integer nuevaPersona(BeanPersona persona) throws Exception;

    public List<BeanPersona> listarUsuarios(Long codigo)throws Exception;

    public List<BeanPersona> buscarUsuarios(BeanPersona b) throws Exception;

    public BeanPersona obtenerUsuarioById(Long codigo)throws Exception;

    public Integer modificarPersona(BeanPersona p)throws Exception;
}
