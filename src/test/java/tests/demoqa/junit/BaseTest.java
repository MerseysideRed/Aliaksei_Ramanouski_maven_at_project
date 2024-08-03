package tests.demoqa.junit;

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
        driver.get("https://demoqa.com/select-menu");
    }

    @AfterClass
    public static void closeDriver() {
        driver.quit();
    }
}
