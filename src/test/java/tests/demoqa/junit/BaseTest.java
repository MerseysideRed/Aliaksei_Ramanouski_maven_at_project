package tests.demoqa.junit;

import driver.MyDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseTest {

    static WebDriver driver = MyDriver.getDriver();

    @Before
    public void initDriver() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
    }

    @After
    public void closeDriver() {
        driver.quit();
    }
}
