package gob.min.digemin.ejb.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Simusuarioexterno.findAll", 
    query = "select o from Simusuarioexterno o")
@Table(name = "\"SimUsuarioExterno\"")
public class Simusuarioexterno implements Serializable {
    @Id
    private Integer nIdOperador;
    private String sInstitucion;
    private String sLogin;
    private String sNombre;

    public Simusuarioexterno() {
    }

    public Integer getNIdOperador() {
        return nIdOperador;
    }

    public void setNIdOperador(Integer nIdOperador) {
        this.nIdOperador = nIdOperador;
    }

    public String getSInstitucion() {
        return sInstitucion;
    }

    public void setSInstitucion(String sInstitucion) {
        this.sInstitucion = sInstitucion;
    }

    public String getSLogin() {
        return sLogin;
    }

    public void setSLogin(String sLogin) {
        this.sLogin = sLogin;
    }

    public String getSNombre() {
        return sNombre;
    }

    public void setSNombre(String sNombre) {
        this.sNombre = sNombre;
    }
}
