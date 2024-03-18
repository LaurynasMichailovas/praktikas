package lt.viko.eif.lmichailovas.logseverity.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Represents an account entity in the system.
 * An account consists of a username, password, and associated log entries.
 */
@Entity
@Table(name = "account")
public class Account {

    public Account() {
    }

    /**
     * Constructs an Account object with the specified username and password.
     *
     * @param userName The username for the account.
     * @param password The password for the account.
     */
    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * The username associated with the account.
     */
    private String userName;

    /**
     * The password associated with the account.
     */
    private String password;

    /**
     * The list of log entries associated with the account.
     */
    @OneToMany(targetEntity = Log.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Log> logList = new ArrayList<>();

    // Getters and Setters

    /**
     * Retrieves the username associated with the account.
     *
     * @return The username of the account.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Retrieves the password associated with the account.
     *
     * @return The password of the account.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the username for the account.
     *
     * @param userName The username to be set for the account.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Sets the password for the account.
     *
     * @param password The password to be set for the account.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retrieves the list of log entries associated with the account.
     *
     * @return The list of log entries associated with the account.
     */
    public List<Log> getLogList() {
        return logList;
    }

    /**
     * Sets the list of log entries associated with the account.
     *
     * @param logList The list of log entries to be set for the account.
     */
    @XmlElementWrapper(name = "logs")
    @XmlElement(name = "log")
    public void setLogList(List<Log> logList) {
        this.logList = logList;
    }

    /**
     * Retrieves the ID of the account.
     *
     * @return The ID of the account.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the account.
     *
     * @param id The ID to be set for the account.
     */
    @XmlTransient
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Generates a string representation of the Account object.
     *
     * @return A string representation of the Account object.
     */
    @Override
    public String toString() {
        return String.format("\t\tUserName: %s\n" +
                        "\t\t Password %s\n" +
                        "\t\t Log %s\n",
                this.userName, this.password, constructlogList());

    }

    /**
     * Constructs a string representation of the list of log entries associated with the account.
     *
     * @return A string representation of the list of log entries.
     */
    private String constructlogList() {
        String result = "";
        for (Log log : logList) {
            result += log;
        }
        return result;
    }
}