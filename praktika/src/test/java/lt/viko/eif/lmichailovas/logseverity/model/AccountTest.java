package lt.viko.eif.lmichailovas.logseverity.model;

import lt.viko.eif.lmichailovas.logseverity.model.Account;
import lt.viko.eif.lmichailovas.logseverity.model.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This class contains unit tests for the Account class.
 * It validates the behavior of various methods in the Account class.
 */
class AccountTest {

    private Account account;

    /**
     * Test case to verify the behavior of the setUserName and getUserName methods.
     * It sets a username for the account and verifies if it can be retrieved correctly.
     */
    @Test
    void testUserName() {
        account = new Account();
        String userName = "testUser";
        account.setUserName(userName);
        assertEquals(userName, account.getUserName());
    }

    /**
     * Test case to verify the behavior of the setPassword and getPassword methods.
     * It sets a password for the account and verifies if it can be retrieved correctly.
     */
    @Test
    void testPassword() {
        account = new Account();
        String password = "testPassword";
        account.setPassword(password);
        assertEquals(password, account.getPassword());
    }

    /**
     * Test case to verify the behavior of the setLogList and getLogList methods.
     * It sets a list of logs for the account and verifies if it can be retrieved correctly.
     */
    @Test
    void testLogList() {
        account = new Account();
        Log log1 = new Log();
        Log log2 = new Log();
        List<Log> newLogs = new ArrayList<>();
        newLogs.add(log1);
        newLogs.add(log2);

        account.setLogList(newLogs);
        assertEquals(newLogs, account.getLogList());
    }
}