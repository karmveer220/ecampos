package org.cnl.digemin.DAO.impl;

import java.util.List;

import org.cnl.digemin.DAO.NotariaDAO;
import org.cnl.digemin.bean.BeanNotaria;

public class HibNotariasDAO implements NotariaDAO{
       
    public HibNotariasDAO(){
     
    }
    
    public List<BeanNotaria> listadeNotarias() throws Exception{return null;}

    public List<BeanNotaria> buscarnotarias(String nombre) throws Exception{return null;}
    
    public Integer grabaNotaria(BeanNotaria notaria) throws Exception{return null;}

    public Integer modificaNotaria(BeanNotaria notaria) throws Exception{return null;}

    public BeanNotaria obtenerNotaria(String cod) throws Exception{return null;}

    public List<BeanNotaria> listaComboNotarias() throws Exception{return null;}

    public List<BeanNotaria> listaComboNotarias(Long notaria) throws Exception{return null;}

}