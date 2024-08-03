package pages.booking;

import driver.MyDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SearchResultsPage {

    WebDriver driver = MyDriver.getDriver();

    public void selectPropertyTypeCheckbox(String propertyType) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement propertyTypeHotelsCheckbox = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By
                        .xpath(String.format("//div[@id='popular-filters-go-here']//preceding-sibling::div[@data-testid='filters-sidebar']//div[@data-filters-group='ht_id']//div[text()='%s']", propertyType))));
        Actions actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        actions.moveToElement(propertyTypeHotelsCheckbox).perform();
        propertyTypeHotelsCheckbox.click();
    }

    public void selectPropertyRatingCheckbox(String propertyRateInStars) {
        driver.findElement(By.xpath(String.format("//div[@id='popular-filters-go-here']//preceding-sibling::div[@data-testid='filters-sidebar']//div[@data-filters-group='class']//div[text()='%s']", propertyRateInStars))).click();
    }

    public void explicitWaitOfDisplayedLabelOfRate(int propertyRate) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//label[@data-testid='filter:class=%s']", propertyRate))));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void clickToDropdownSortingList() {
        driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();
    }

    public void clickToPropertyRatingLowToHighOptionOfDropdownSortingList() {
        driver.findElement(By.xpath("//div/span[text()='Property rating (low to high)']")).click();
    }

    public String getRateFromPropertyCard(int propertyCardOrderNumber) {
        return driver.findElement(By.xpath(String.format("//div[@data-testid='property-card'][%s]//div[@aria-label]", propertyCardOrderNumber))).getAttribute("aria-label");
    }

    public void scrollToPropertyCard(int propertyCardOrderNumber) {
        WebElement propertyCard = driver.findElement(By.xpath(String.format("//div[@data-testid='property-card'][%s]", propertyCardOrderNumber)));
        Actions actions = new Actions(driver);
        actions.scrollToElement(propertyCard).build().perform();
    }

    public void changePropertyCardBackgroundColor(int propertyCardOrderNumber) {
        WebElement propertyCard = driver.findElement(By.xpath(String.format("//div[@data-testid='property-card'][%s]", propertyCardOrderNumber)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.backgroundColor = 'green'", propertyCard);
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.color = 'red'", propertyCard);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", propertyCard);
    }

    public void takeScreenshot() throws IOException {
        File asfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(asfile, new File("pic.png"));
    }
}
