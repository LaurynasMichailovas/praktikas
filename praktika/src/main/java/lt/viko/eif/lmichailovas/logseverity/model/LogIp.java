/**
 * The LogIp class represents an IP address associated with a log in the system.
 */
package lt.viko.eif.lmichailovas.logseverity.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "logip")
public class LogIp {
    /**
     * Default constructor for the LogIp class.
     */
    public LogIp() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String logIp;

    /**
     * Parameterized constructor for the LogIp class.
     * @param logIp The IP address to be associated with the log.
     */
    public LogIp(String logIp) {
        this.logIp = logIp;
    }

    @Override
    public String toString() {
        return String.format(" %s\n", this.logIp);
    }

    /**
     * Retrieves the IP address associated with the log.
     * @return The IP address associated with the log.
     */
    public String getLogIp() {
        return logIp;
    }

    /**
     * Sets the IP address associated with the log.
     * @param logIp The IP address to be associated with the log.
     */
    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    /**
     * Retrieves the ID of the LogIp instance.
     * @return The ID of the LogIp instance.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the LogIp instance.
     * @param id The ID to be set for the LogIp instance.
     */
    @XmlTransient
    public void setId(int id) {
        this.id = id;
    }
}