/**
 * The User class represents a user entity in the system.
 * It contains information such as first name, last name, code, and associated account.
 */
package lt.viko.eif.lmichailovas.logseverity.model;

import javax.lang.model.element.Name;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlType(propOrder = {"firstName", "lastName", "code", "account"})
@Entity
@Table(name = "worker")
public class User {
    /**
     * Default constructor for the User class.
     */
    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String firstName;
    private String lastName;
    private String code;
    @OneToOne(targetEntity = Account.class, cascade = CascadeType.ALL)
    private Account account;

    /**
     * Parameterized constructor for the User class.
     * @param firstName The first name of the user.
     * @param lastName The last name of the user.
     * @param code The code associated with the user.
     */
    public User(String firstName, String lastName, String code) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.code = code;
    }

    @Override
    public String toString() {
        return String.format("\tfirstname: %s\n" +
                        "\tlastname: %s\n" +
                        "\tcode: %s\n" +
                        "\tAccount: %s\n",
                this.firstName, this.lastName, this.code, account);
    }

    /**
     * Retrieves the associated account of the user.
     * @return The associated account of the user.
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Sets the associated account for the user.
     * @param account The account to be associated with the user.
     */
    @XmlElement(name = "account")
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * Retrieves the first name of the user.
     * @return The first name of the user.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Retrieves the last name of the user.
     * @return The last name of the user.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Retrieves the code associated with the user.
     * @return The code associated with the user.
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the first name of the user.
     * @param firstName The first name to be set for the user.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name of the user.
     * @param lastName The last name to be set for the user.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the code associated with the user.
     * @param code The code to be associated with the user.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Retrieves the ID of the User instance.
     * @return The ID of the User instance.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the User instance.
     * @param id The ID to be set for the User instance.
     */
    @XmlTransient
    public void setId(int id) {
        this.id = id;
    }
}