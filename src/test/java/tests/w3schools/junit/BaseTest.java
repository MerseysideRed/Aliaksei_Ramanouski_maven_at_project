package tests.w3schools.junit;

import driver.MyDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseTest {
    static WebDriver driver = MyDriver.getDriver();

    @BeforeClass
    public static void initDriver() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/java/");
    }

    @AfterClass
    public static void closeDriver() {
        driver.quit();
    }
}
