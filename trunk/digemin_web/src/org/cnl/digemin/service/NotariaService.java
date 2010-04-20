package org.cnl.digemin.service;

import java.util.List;
import org.cnl.digemin.DAO.NotariaDAO;
import org.cnl.digemin.DAO.impl.HibNotariasDAO;
import org.cnl.digemin.bean.BeanNotaria;
import org.springframework.stereotype.Service;

@Service
public class NotariaService {
    
    private NotariaDAO notariaDAO;
    public static int CODIGO_COLEGIO = 1 ;
    
    public NotariaService(){
       notariaDAO = new HibNotariasDAO();
    }
    

    /**
     * Si el codigo de notaria pertenece a la del Colegio de Notarios entrega <br />
     * toda al lista de notarias. Caso contrario, entrega solo la notaria <br />
     * que coincide con el codigo.
     * @param notaria
     * @return
     * @throws Exception
     */
    public List<BeanNotaria> listaComboNotarias(Long notaria) throws Exception{
        if(notaria==CODIGO_COLEGIO){
            return notariaDAO.listadeNotarias();
        }else{
            return notariaDAO.listaComboNotarias(notaria);
        }
    }
    
    public Integer grabaNotaria(BeanNotaria notaria) throws Exception{
        return notariaDAO.grabaNotaria(notaria);
    }

    public Integer modificaNotaria(BeanNotaria notaria) throws Exception{
        return notariaDAO.modificaNotaria(notaria);
    }

    public BeanNotaria obtenerNotaria(String cod) throws Exception{
        return notariaDAO.obtenerNotaria(cod);
    }

    public List<BeanNotaria> buscarnotarias(String nombre) throws Exception{
        return notariaDAO.buscarnotarias(nombre);
    }
}
