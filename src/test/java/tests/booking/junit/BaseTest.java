package tests.booking.junit;

import driver.MyDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import pages.booking.MainPage;

import java.time.Duration;

public class BaseTest {

    static WebDriver driver = MyDriver.getDriver();
    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);

    @Before
    public void initDriver() {
        LOGGER.info("Test is started");
        driver.get("https://www.booking.com/");
    }

    @After
    public void closeDriver() {
        MyDriver.killDriver();
        LOGGER.info("Test is ended");
    }
}
