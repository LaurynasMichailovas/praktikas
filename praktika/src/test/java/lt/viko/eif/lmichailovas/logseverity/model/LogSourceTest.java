package lt.viko.eif.lmichailovas.logseverity.model;

import lt.viko.eif.lmichailovas.logseverity.model.LogSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * This class contains unit tests for the LogSource class.
 * It validates the behavior of the LogSource class methods.
 */
class LogSourceTest {

    private LogSource logSource;

    /**
     * Test case to verify the behavior of the setSourceName and getSourceName methods.
     * It sets a source name for the log source and verifies if it can be retrieved correctly.
     */
    @Test
    void testSourceName() {
        logSource = new LogSource();
        String sourceName = "SourceNameTest";
        logSource.setSourceName(sourceName);
        assertEquals(sourceName, logSource.getSourceName());
    }

    /**
     * Test case to verify the behavior of the setSourceIp and getSourceIp methods.
     * It sets a source IP address for the log source and verifies if it can be retrieved correctly.
     */
    @Test
    void testSourceIp() {
        logSource = new LogSource();
        String sourceIp = "10.0.0.0";
        logSource.setSourceIp(sourceIp);
        assertEquals(sourceIp, logSource.getSourceIp());
    }
}