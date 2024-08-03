package tests.demoqa.testng;

import driver.MyDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    WebDriver driver = MyDriver.getDriver();

    @BeforeClass
    public void initDriver() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
    }

    @AfterClass
    public  void closeDriver() {
        driver.quit();
    }
}
