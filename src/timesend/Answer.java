package timesend;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(namespace = "http://timesend/")
@XmlAccessorType(XmlAccessType.FIELD)
public class Answer {

    private String status;
    private String session_id;
    private String description = "Successfully";

    @XmlElementWrapper(name = "response")
    @XmlElement(name = "data")
    private List<Values> responces;

    /**
     * This default constructor is required if there are other constructors.
     */
    public Answer() {

    }

    public Answer(String status, String session_id ) {
        this.status = status;
        this.session_id = session_id;
    }

    public Answer(String status, String session_id, String description ) {
        this.status = status;
        this.session_id = session_id;
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSession() {
        return session_id;
    }

    public void setSession(String session_id) {
        this.session_id = session_id;
    }

    public List<Values> getResponse() {
        return responces;
    }

    public void setResponse(List<Values> responses) {
        this.responces = responses;
    }

}