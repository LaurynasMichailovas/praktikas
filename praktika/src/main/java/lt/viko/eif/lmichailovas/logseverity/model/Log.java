/**
 * The Log class represents a log entity in the system.
 * It contains information such as log name, description, severity level, associated IP, and source.
 */
package lt.viko.eif.lmichailovas.logseverity.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "log")
public class Log {
    /**
     * Default constructor for the Log class.
     */
    public Log() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String logName;
    private String logDescription;
    private int severityInt;
    @OneToOne(targetEntity = LogIp.class, cascade = CascadeType.ALL)
    private LogIp logIp;
    @OneToOne(targetEntity = LogSource.class, cascade = CascadeType.ALL)
    private LogSource logSource;

    /**
     * Parameterized constructor for the Log class.
     * @param logName The name of the log.
     * @param logDescription The description of the log.
     * @param severityInt The severity level of the log.
     */
    public Log(String logName, String logDescription, int severityInt) {
        this.logName = logName;
        this.logDescription = logDescription;
        this.severityInt = severityInt;
    }

    /**
     * Retrieves the name of the log.
     * @return The name of the log.
     */
    public String getLogName() {
        return logName;
    }

    /**
     * Sets the name of the log.
     * @param logName The name to be set for the log.
     */
    public void setLogName(String logName) {
        this.logName = logName;
    }

    /**
     * Retrieves the description of the log.
     * @return The description of the log.
     */
    public String getLogdescription() {
        return logDescription;
    }

    /**
     * Sets the description of the log.
     * @param logDescription The description to be set for the log.
     */
    public void setLogdescription(String logDescription) {
        this.logDescription = logDescription;
    }

    /**
     * Retrieves the severity level of the log.
     * @return The severity level of the log.
     */
    public int getSeverityInt() {
        return severityInt;
    }

    /**
     * Sets the severity level of the log.
     * @param severityInt The severity level to be set for the log.
     */
    public void setSeverityInt(int severityInt) {
        this.severityInt = severityInt;
    }

    /**
     * Retrieves the source of the log.
     * @return The source of the log.
     */
    public LogSource getLogsource() {
        return logSource;
    }

    /**
     * Retrieves the ID of the log.
     * @return The ID of the log.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the log.
     * @param id The ID to be set for the log.
     */
    @XmlTransient
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the source of the log.
     * @param logSource The source to be set for the log.
     */
    public void setLogsource(LogSource logSource) {
        this.logSource = logSource;
    }

    @Override
    public String toString() {
        return String.format("\t\tlogName: %s" +
                        "\t\t logDescription: %s"+
                        "\t\t severity: %s" +
                        "\t\t logSource: %s" +
                        "\t\t logIP: %s\n",
                this.logName, this.logDescription, this.severityInt, logSource, logIp);

    }

    /**
     * Retrieves the IP associated with the log.
     * @return The IP associated with the log.
     */
    public LogIp getLogip() {
        return logIp;
    }

    /**
     * Sets the IP associated with the log.
     * @param logIp The IP to be associated with the log.
     */
    public void setLogip(LogIp logIp) {
        this.logIp = logIp;
    }
}