package pe.gob.pcm.constitucion.web.util;

/**
 *
 * @author ecampos
 */
public class AutoCompleteBean implements  net.sourceforge.ajaxtags.xml.AjaxXmlBuilder.PropertyReader{
    
    private String name;
    private String value;
    private boolean isCData;

    public AutoCompleteBean(){}

    public AutoCompleteBean(String name,String value,boolean isCData){
        this.name=name;
        this.value=value;
        this.isCData=isCData;
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the isCData
     */
    public boolean isCData() {
        return isCData;
    }

    /**
     * @param isCData the isCData to set
     */
    public void setIsCData(boolean isCData) {
        this.isCData = isCData;
    }
    


}

