package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyDriver {
    static WebDriver driver;

    public static WebDriver getDriver() {
        if (null == driver) {
            driver = new ChromeDriver();
        }
        return driver;
    }
}
