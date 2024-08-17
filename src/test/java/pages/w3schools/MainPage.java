package pages.w3schools;

import driver.MyDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage {

    WebDriver driver = MyDriver.getDriver();

    public void copyTutorialWord() {

        WebElement tutorialWord = driver.findElement(By.xpath("//h1[text()='Java ']/span[@class='color_h1']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(tutorialWord)
               .keyDown(Keys.LEFT_CONTROL)
               .sendKeys("c")
               .keyUp(Keys.LEFT_CONTROL)
               .build().perform();
    }

    public void goToGooglePage() {

        driver.get("https://google.com");
    }
}
