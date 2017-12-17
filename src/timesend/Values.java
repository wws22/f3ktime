package timesend;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class Values {

    private String key;
    private String value;
    private String description;

    /**
     * This default constructor is required if there are other constructors.
     */
    public Values() {

    }

    public Values(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public Values(String key, String value, String description) {
        this.key = key;
        this.value = value;
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}