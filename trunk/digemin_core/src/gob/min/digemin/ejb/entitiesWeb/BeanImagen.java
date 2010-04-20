package gob.min.digemin.ejb.entitiesWeb;
/**
 * COLEGIO DE NOTARIOS DE LIMA - CEDETEC
 * Convenio DIGEMIN - CNL
 * @author Elvis Ruben Campos Mori
 * @since Octubre 2008
 * @version 1.0
 */
public class BeanImagen {

    private String id;
    private byte[] imagen;
    
    public BeanImagen() {
    }
    
    public BeanImagen(String id,byte[] imagen) {
        this.id=id;
        this.imagen = imagen;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
}
