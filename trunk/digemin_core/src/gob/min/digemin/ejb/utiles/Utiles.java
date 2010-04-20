package gob.min.digemin.ejb.utiles;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * Libreria con metodos utiles
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public class Utiles {

    public static String FORMATO_FECHA_LARGE="dd/MM/yyyy hh:mm:ss";
    public static String FORMATO_FECHA_CORTA="dd/MM/yyyy";
    public static String FORMATO_FECHA_CORTA_MYSQL="dd-MM-yyyy";
    public static final String version = "1.0";
    
    /**
     * retorna una cadena vacia en caso de ser null
     */
    public static String nullToBlank(Object texto){
        try{
            if(texto==null){return "";}
            return texto.toString().trim();
        }catch(Exception e){}
        return "";
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
    
    public static String CalendarToStringTry(Calendar fecha,String formato){
        try{
            SimpleDateFormat df = new SimpleDateFormat(formato);
            return df.format(fecha.getTime());
        }catch(Exception e){return "";}
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
}
