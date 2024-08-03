package tests.booking.testng;

import driver.MyDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {

    WebDriver driver = MyDriver.getDriver();

    @BeforeTest
    public void initDriver() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.booking.com/");
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}
