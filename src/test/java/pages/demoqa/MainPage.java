package pages.demoqa;

import driver.MyDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

public class MainPage {

    WebDriver driver = MyDriver.getDriver();

    public void chooseSelectValue(String selectId, String selectOptionId) {

        WebElement element = driver.findElement(By.id(selectId));

        Actions actions = new Actions(driver);
        actions.scrollToElement(element).build().perform();

        Select select = new Select(element);
        select.selectByValue(selectOptionId);
    }

    public void takeScreenshot() throws IOException {
        File asfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(asfile, new File("picDemoQA.png"));
    }
}
