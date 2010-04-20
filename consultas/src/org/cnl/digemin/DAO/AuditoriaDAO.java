package org.cnl.digemin.DAO;

import org.cnl.digemin.bean.BeanAuditoria;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Mayo 2009
 * @version 1.0
 */
public interface AuditoriaDAO {
    /**
     * Regsitra la auditoria en la base de dtos
     * @param auditoria objeto con los campos llenos para la auditoria, usuario, lave, metodo
     * @throws Exception
     */
    public void grabaAuditoria(BeanAuditoria auditoria) throws Exception;
 
}
