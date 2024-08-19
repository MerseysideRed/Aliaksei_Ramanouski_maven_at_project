package tests.w3schools.junit;

import driver.MyDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseTest {
    static WebDriver driver = MyDriver.getDriver();

    @BeforeClass
    public static void initDriver() {
        driver.get("https://www.w3schools.com/java/");
    }

    @AfterClass
    public static void closeDriver() {
        driver.quit();
    }
}
