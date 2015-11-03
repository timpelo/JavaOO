package W9E10to12;

/**
 * Created by Jani on 1.11.2015.
 */
public class LibidoEvent {

    private Person host;
    private int precentage;
    private String status;

    public LibidoEvent(int precentage, Person host) {
        this.precentage = precentage;
        this.host = host;

        if(precentage > 20 && precentage <= 39) {
            status = "mild libido";
        }
        else if(precentage > 39 && precentage <= 59) {
            status = "medium libido";
        }
        else if(precentage > 59 && precentage <= 80) {
            status = "hot libido";
        }
        else if(precentage > 80) {
            status = "suicide";
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrecentage() {
        return precentage;
    }

    public void setPrecentage(int precentage) {
        this.precentage = precentage;
    }

    public Person getHost() {
        return host;
    }

    public void setHost(Person host) {
        this.host = host;
    }
}
