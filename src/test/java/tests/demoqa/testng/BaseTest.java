package tests.demoqa.testng;

import driver.MyDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    WebDriver driver = MyDriver.getDriver();

    @BeforeClass
    public void initDriver() {
        driver.get("https://demoqa.com/select-menu");
    }

    @AfterClass
    public  void closeDriver() {
        driver.quit();
    }
}
