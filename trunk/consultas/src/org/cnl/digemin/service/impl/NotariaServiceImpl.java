package org.cnl.digemin.service.impl;

import java.util.List;

import org.cnl.digemin.DAO.NotariaDAO;
import org.cnl.digemin.bean.BeanNotaria;
import org.cnl.digemin.service.NotariaService;

public class NotariaServiceImpl implements NotariaService {
    
	private NotariaDAO notariaDAO;
    public static int CODIGO_COLEGIO = 0 ;
    
    public void setNotariaDAO(NotariaDAO notariaDAO) {
		this.notariaDAO = notariaDAO;
	}


	public NotariaServiceImpl(){
    
    }
    

    /* (non-Javadoc)
	 * @see org.cnl.digemin.service.impl.NotariaService#listaComboNotarias(java.lang.Long)
	 */
    public List<BeanNotaria> listaComboNotarias(Long colegio) throws Exception{
        return notariaDAO.listaComboNotarias(colegio);
    }
    
    /* (non-Javadoc)
	 * @see org.cnl.digemin.service.impl.NotariaService#grabaNotaria(org.cnl.digemin.bean.BeanNotaria)
	 */
    public Integer grabaNotaria(BeanNotaria notaria) throws Exception{
        return notariaDAO.grabaNotaria(notaria);
    }

    /* (non-Javadoc)
	 * @see org.cnl.digemin.service.impl.NotariaService#modificaNotaria(org.cnl.digemin.bean.BeanNotaria)
	 */
    public Integer modificaNotaria(BeanNotaria notaria) throws Exception{
        return notariaDAO.modificaNotaria(notaria);
    }

    /* (non-Javadoc)
	 * @see org.cnl.digemin.service.impl.NotariaService#obtenerNotaria(java.lang.String)
	 */
    public BeanNotaria obtenerNotaria(String cod) throws Exception{
        return notariaDAO.obtenerNotaria(cod);
    }

    /* (non-Javadoc)
	 * @see org.cnl.digemin.service.impl.NotariaService#buscarnotarias(java.lang.String)
	 */
    public List<BeanNotaria> buscarnotarias(String nombre) throws Exception{
        return notariaDAO.buscarnotarias(nombre);
    }
}
