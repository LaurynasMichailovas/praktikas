package lt.viko.eif.lmichailovas.logseverity.model;

import lt.viko.eif.lmichailovas.logseverity.model.Account;
import lt.viko.eif.lmichailovas.logseverity.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * This class contains unit tests for the User class.
 * It validates the behavior of the User class methods.
 */
class UserTest {

    private User user;

    /**
     * Test case to verify the behavior of the setFirstName and getFirstName methods.
     * It sets a first name for the user and verifies if it can be retrieved correctly.
     */
    @Test
    void testFirstName() {
        user = new User();
        String firstName = "labas";
        user.setFirstName(firstName);
        assertEquals(firstName, user.getFirstName());
    }

    /**
     * Test case to verify the behavior of the setLastName and getLastName methods.
     * It sets a last name for the user and verifies if it can be retrieved correctly.
     */
    @Test
    void testLastName() {
        user = new User();
        String lastName = "krabas";
        user.setLastName(lastName);
        assertEquals(lastName, user.getLastName());
    }

    /**
     * Test case to verify the behavior of the setCode and getCode methods.
     * It sets a code for the user and verifies if it can be retrieved correctly.
     */
    @Test
    void testCode() {
        user = new User();
        String code = "2024";
        user.setCode(code);
        assertEquals(code, user.getCode());
    }

    /**
     * Test case to verify the behavior of the setAccount and getAccount methods.
     * It sets an account for the user and verifies if it can be retrieved correctly.
     */
    @Test
    void testAccount() {
        user = new User();
        Account account = new Account("username", "password");
        user.setAccount(account);
        assertEquals(account, user.getAccount());
    }
}