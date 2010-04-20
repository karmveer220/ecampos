package org.cnl.digemin.DAO;

import java.util.List;
import org.cnl.digemin.bean.BeanNotaria;

/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Mayo 2009
 * @version 2.0
 */
public interface NotariaDAO {

    /**
     * Retorna la Lista de Notarias pertenecientes al Colegio de Notarios de Lima, el <br />
     * primer item es el Colegio
     * @return
     * @throws Exception
     */
    public List<BeanNotaria> listadeNotarias() throws Exception;
    
    public Integer grabaNotaria(BeanNotaria notaria )throws Exception;
    
    public Integer modificaNotaria(BeanNotaria notaria )throws Exception;

    public BeanNotaria obtenerNotaria(String cod) throws Exception;

    /**
     * Ya no se debe usar porque el lisadenbotarias hace lo mismo
     * @return lista de notarias
     * @throws Exception
     */
    @Deprecated
    public List<BeanNotaria> listaComboNotarias()throws Exception;

    public List<BeanNotaria> listaComboNotarias(Long notaria) throws Exception;

    public List<BeanNotaria> buscarnotarias(String nombre) throws Exception;
}
