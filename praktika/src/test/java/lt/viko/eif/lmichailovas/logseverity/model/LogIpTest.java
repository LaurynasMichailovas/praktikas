package lt.viko.eif.lmichailovas.logseverity.model;

import lt.viko.eif.lmichailovas.logseverity.model.LogIp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * This class contains unit tests for the LogIp class.
 * It validates the behavior of the LogIp class methods.
 */
class LogIpTest {

    private LogIp logIp;

    /**
     * Sets up the initial state for each test by creating a new instance of LogIp.
     */
    @BeforeEach
    void setUp() {
        logIp = new LogIp();
    }

    /**
     * Test case to verify the behavior of the setLogIp and getLogIp methods.
     * It sets an IP address for the log and verifies if it can be retrieved correctly.
     */
    @Test
    void testLogIp() {
        String testIp = "11.1.1.1";
        logIp.setLogIp(testIp);
        assertEquals(testIp, logIp.getLogIp());
    }
}