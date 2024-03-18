/**
 * The LogSource class represents a source of a log in the system.
 */
package lt.viko.eif.lmichailovas.logseverity.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "logsource")
public class LogSource {
    /**
     * Default constructor for the LogSource class.
     */
    public LogSource() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String sourceName;
    private String sourceIp;

    /**
     * Parameterized constructor for the LogSource class.
     * @param sourceName The name of the source.
     * @param sourceIp The IP address of the source.
     */
    public LogSource(String sourceName, String sourceIp) {
        this.sourceName = sourceName;
        this.sourceIp = sourceIp;
    }

    @Override
    public String toString() {
        return String.format(" %s" +
                        "\tSourceIp: %s\n",
                this.sourceName, this.sourceIp);
    }

    /**
     * Retrieves the name of the source.
     * @return The name of the source.
     */
    public String getSourceName() {
        return sourceName;
    }

    /**
     * Sets the name of the source.
     * @param sourceName The name to be set for the source.
     */
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    /**
     * Retrieves the IP address of the source.
     * @return The IP address of the source.
     */
    public String getSourceIp() {
        return sourceIp;
    }

    /**
     * Sets the IP address of the source.
     * @param sourceIp The IP address to be set for the source.
     */
    public void setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
    }

    /**
     * Retrieves the ID of the LogSource instance.
     * @return The ID of the LogSource instance.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the LogSource instance.
     * @param id The ID to be set for the LogSource instance.
     */
    @XmlTransient
    public void setId(int id) {
        this.id = id;
    }
}