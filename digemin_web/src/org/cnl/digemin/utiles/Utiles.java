package org.cnl.digemin.utiles;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.XMLGregorianCalendar;
/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public class Utiles {

    public static String FORMATO_FECHA_LARGE="dd/MM/yyyy hh:mm:ss";
    public static String FORMATO_FECHA_CORTA="dd/MM/yyyy";
    public static String FORMATO_FECHA_CORTA_MYSQL="yyyy-MM-dd";
    public static final String version = "1.0";
    
    /**
     * retorna una cadena vacia en caso de ser null
     */
    public static String nullToBlank(Object texto){
            if(texto==null){
                    return "";
            }
            return texto.toString().trim();
    }
    /**
     * entrega un objetod el tipo GregorianCalendar con la fecha indicada
     * @param fecha texto a convertir en fecha
     * @param formato usar Utils.FORMATO_FECHA_CORTA o Utils.FORMATO_FECHA_LARGE
     * @return objeto gregoriancalendar con la fecha en el formato indicado
     * @throws Exception
     */
    public static GregorianCalendar stringToCalendar(String fecha,String formato) throws Exception{
            fecha=nullToBlank(fecha);
            GregorianCalendar gc = new GregorianCalendar();
            SimpleDateFormat df = new SimpleDateFormat(formato);
            gc.setTime(df.parse(fecha));
            return gc;
    }
    
    public static String CalendarToString(Calendar fecha,String formato) throws Exception{
            SimpleDateFormat df = new SimpleDateFormat(formato);
            return df.format(fecha.getTime());
    }
    public static String CalendarToString(Date fecha,String formato) throws Exception{
        SimpleDateFormat df = new SimpleDateFormat(formato);
        return df.format(fecha);
}
    public static String CalendarToString(XMLGregorianCalendar fecha,String formato) throws Exception{
        SimpleDateFormat df = new SimpleDateFormat(formato);
        return df.format(fecha.toGregorianCalendar().getTime());
    }
    
    public static String ValidaDate(String fecha,String formato) throws Exception{
            fecha=nullToBlank(fecha);
            GregorianCalendar gc = new GregorianCalendar();
            SimpleDateFormat df = new SimpleDateFormat(formato);
            gc.setTime(df.parse(fecha));
            return df.format(gc.getTime());
    }
    
    public static Date stringToDate(String fecha,String formato) throws Exception{
            fecha=nullToBlank(fecha);
            GregorianCalendar gc = new GregorianCalendar();
            SimpleDateFormat df = new SimpleDateFormat(formato);
            gc.setTime(df.parse(fecha));
            return gc.getTime();
    }
    
    /**
     * Crea un archivo con extension jpg en la carpeta temporal del proyecto web para poder mostrarla en 
     * la pagina web
     * @param imagenBuffer InputStream que contiene la imagen
     * @param extra texto para incluir en el nombre (D: dedo; H:huella)
     * @param path ruta en donde se grabará la imagen (ruta de la carpeta que contiene los html - webcontent / publichtml)
     * @return nombre de la imagen con ruta relativa para pintarla en el html
     * @throws Exception
     */
    public static String guardaImagenEnDisco(InputStream imagenBuffer,String extra,String path)throws Exception{
        File fichero =null;
        String nombre = "";
        try{
            Calendar fe = new GregorianCalendar();
            nombre =extra +fe.getTimeInMillis()+".jpg";            
            fichero = new File(path+"/temp/"+nombre);//linux
                        
            BufferedInputStream in = new BufferedInputStream(imagenBuffer);
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fichero));
            
            byte[] bytes = new byte[8096];
            int len = 0;
            while ( (len = in.read( bytes )) > 0 ){
                out.write( bytes, 0, len );
            }            
            out.flush();
            out.close();
            in.close();            
            System.out.println("archivo grabado en : "+fichero.getAbsolutePath());
            
        }catch(Exception e){
            System.out.println("ERROR al escribir en disco " + e.getMessage());
        }
    return "temp/"+nombre;
    }
       
    public static String descripcionEstadoPasaporte(String estado)throws Exception{
        estado = nullToBlank(estado);
        if(estado.toUpperCase().equals("A")){ return "Anulado"; }
        if(estado.toUpperCase().equals("E")){ return "Expedido"; }
        if(estado.toUpperCase().equals("R")){ return "Revalidado"; }
        return "";
    }
    
    public static String descripcionSexo(String sexo)throws Exception{
        if(nullToBlank(sexo).equals("F")){return "Femenino";}
        if(nullToBlank(sexo).equals("M")){return "Masculino";}
        return "";
    }
}
