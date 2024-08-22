package tests.booking.junit;

import driver.MyDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;

public class BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);

    @Before
    public void initDriver() {

        LOGGER.info("Test is started");
    }

    @After
    public void closeDriver() {
        MyDriver.killDriver();
        LOGGER.info("Test is ended");
    }
}
