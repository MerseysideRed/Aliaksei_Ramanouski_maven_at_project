package pages.w3schools;

import driver.MyDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.booking.MainPage;

import java.util.ArrayList;
import java.util.List;

public class GooglePage {

    WebDriver driver = MyDriver.getDriver();
    Actions actions = new Actions(driver);

    public void pasteTutorialWord() {

        WebElement searchInput = driver.findElement(By.xpath("//textarea[@title='Шукаць']"));
        searchInput.click();
        actions.keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v")
                .keyUp(Keys.LEFT_CONTROL)
                .build().perform();
    }

    public void pressEnterKey() {
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    public boolean verifyPresenceTutorialWordInSearchResultSet() {
        List<WebElement> h3List = driver.findElements(By.xpath("//h3"));
        List<String> h3TextList = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            WebElement h3Element = h3List.get(i);
            h3TextList.add(h3Element.getText().toLowerCase());
        }

        return h3TextList.stream().allMatch(h3 -> h3.contains("tutorial"));
    }
}
