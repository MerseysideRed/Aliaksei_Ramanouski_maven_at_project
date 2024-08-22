package pages.booking;

import driver.MyDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PropertyPage extends BasePage{

    WebDriver driver = MyDriver.getDriver();

    private static final Logger LOGGER = LogManager.getLogger(PropertyPage.class);

    private static final String WEB_ITEM_WITH_SCORE_RATE = ("//div[contains(text(), 'Scored') and ancestor::div[@class='hp-sidebar--right']]");

    public int getPropertyRate() {
        LOGGER.trace("Get score rate value will be performed, locator: //div[contains(text(), 'Scored') and ancestor::div[@class='hp-sidebar--right']]");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        String rawActualResultString = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath(WEB_ITEM_WITH_SCORE_RATE))).getText();
        String actualResultString = rawActualResultString.replace("Scored ", "");
        return Integer.parseInt(actualResultString);
    }
}
