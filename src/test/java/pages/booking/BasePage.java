package pages.booking;

import driver.MyDriver;
import org.openqa.selenium.WebDriver;

public class BasePage {

    static WebDriver driver;

    public static void navigateToURL(String urlString) {

        driver = MyDriver.getDriver();
        driver.get(urlString);
    }
}
