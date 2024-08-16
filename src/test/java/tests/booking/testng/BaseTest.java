package tests.booking.testng;

import driver.MyDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(tests.booking.junit.BaseTest.class);

    @BeforeMethod
    public void initDriver() {
        driver = MyDriver.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.booking.com/");
    }

    @AfterMethod
    public void closeDriver() {
        MyDriver.killDriver();
    }
}
