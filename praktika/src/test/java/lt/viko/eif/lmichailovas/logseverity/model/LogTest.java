package lt.viko.eif.lmichailovas.logseverity.model;

import lt.viko.eif.lmichailovas.logseverity.model.Log;
import lt.viko.eif.lmichailovas.logseverity.model.LogIp;
import lt.viko.eif.lmichailovas.logseverity.model.LogSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * This class contains unit tests for the Log class.
 * It validates the behavior of the Log class methods.
 */
class LogTest {

    private Log log;
    private LogIp logIp;
    private LogSource logSource;

    /**
     * Test case to verify the behavior of the setLogName and getLogName methods.
     * It sets a log name and verifies if it can be retrieved correctly.
     */
    @Test
    void testLogName() {
        log = new Log();
        String logName = "TestName";
        log.setLogName(logName);
        assertEquals(logName, log.getLogName());
    }

    /**
     * Test case to verify the behavior of the setLogDescription and getLogDescription methods.
     * It sets a log description and verifies if it can be retrieved correctly.
     */
    @Test
    void testLogDescription() {
        log = new Log();
        String logDescription = "TestDescription";
        log.setLogDiscription(logDescription);
        assertEquals(logDescription, log.getLogDiscription());
    }

    /**
     * Test case to verify the behavior of the setSeverityInt and getSeverityInt methods.
     * It sets a severity level as an integer and verifies if it can be retrieved correctly.
     */
    @Test
    void testSeverityInt() {
        log = new Log();
        int severity = 5;
        log.setSeverityInt(severity);
        assertEquals(severity, log.getSeverityInt());
    }

    /**
     * Test case to verify the behavior of the setLogIp and getLogIp methods.
     * It sets a LogIp object for the log and verifies if it can be retrieved correctly.
     */
    @Test
    void testLogIp() {
        log = new Log();
        log.setLogip(logIp);
        assertEquals(logIp, log.getLogip());
    }

    /**
     * Test case to verify the behavior of the setLogSource and getLogSource methods.
     * It sets a LogSource object for the log and verifies if it can be retrieved correctly.
     */
    @Test
    void testLogSource() {
        log = new Log();
        log.setLogsource(logSource);
        assertEquals(logSource, log.getLogsource());
    }
}