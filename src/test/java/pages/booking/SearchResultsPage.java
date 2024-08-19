package pages.booking;

import driver.MyDriver;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage {

    WebDriver driver = MyDriver.getDriver();
    private static final Logger LOGGER = LogManager.getLogger(SearchResultsPage.class);

    public void selectPropertyTypeCheckbox(String propertyType) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement propertyTypeHotelsCheckbox = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By
                        .xpath(String.format("//div[@id='popular-filters-go-here']//preceding-sibling::div[@data-testid='filters-sidebar']//div[@data-filters-group='ht_id']//div[text()='%s']", propertyType))));
        Actions actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        actions.moveToElement(propertyTypeHotelsCheckbox).perform();
        propertyTypeHotelsCheckbox.click();

        LOGGER.trace("Select property type checkbox is performed, locator: //div[@id='popular-filters-go-here']//preceding-sibling::div[@data-testid='filters-sidebar']//div[@data-filters-group='ht_id']//div[text()='%s']");
    }

    public void selectPropertyRatingCheckbox(String propertyRateInStars) {
        driver.findElement(By.xpath(String.format("//div[@id='popular-filters-go-here']//preceding-sibling::div[@data-testid='filters-sidebar']//div[@data-filters-group='class']//div[text()='%s']", propertyRateInStars))).click();

        LOGGER.trace("Select property rate checkbox is performed, locator: //div[@id='popular-filters-go-here']//preceding-sibling::div[@data-testid='filters-sidebar']//div[@data-filters-group='class']//div[text()='%s']");
    }

    public void explicitWaitOfDisplayedLabelOfRate(int propertyRate) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//label[@data-testid='filter:class=%s']", propertyRate))));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        LOGGER.trace("Explicit wait of displayed rate label is performed, locator: //label[@data-testid='filter:class=%s']");
    }

    public void clickToDropdownSortingList() {
        driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();

        LOGGER.trace("Click to dropdown sorting list button is performed, locator: //button[@data-testid='sorters-dropdown-trigger']");
    }

    public void clickToPropertyRatingLowToHighOptionOfDropdownSortingList() {
        driver.findElement(By.xpath("//div/span[text()='Property rating (low to high)']")).click();

        LOGGER.trace("Click to property rating low tp high option of dropdown sorting list is performed, locator: //div/span[text()='Property rating (low to high)']");
    }

    public String getRateFromPropertyCard(int propertyCardOrderNumber) {
        LOGGER.trace("Get rate from property card will be performed, locator: //div[@data-testid='property-card'][%s]//div[@aria-label]");

        return driver.findElement(By.xpath(String.format("//div[@data-testid='property-card'][%s]//div[@aria-label]", propertyCardOrderNumber))).getAttribute("aria-label");
    }

    public void scrollToPropertyCard(int propertyCardOrderNumber) {
        WebElement propertyCard = driver.findElement(By.xpath(String.format("//div[@data-testid='property-card'][%s]", propertyCardOrderNumber)));
        Actions actions = new Actions(driver);
        actions.scrollToElement(propertyCard).build().perform();

        LOGGER.trace("Scroll to property card is performed, locator: //div[@data-testid='property-card'][%s]");
    }

    public void changePropertyCardBackgroundColor(int propertyCardOrderNumber) {
        WebElement propertyCard = driver.findElement(By.xpath(String.format("//div[@data-testid='property-card'][%s]", propertyCardOrderNumber)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.backgroundColor = 'green'", propertyCard);
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.color = 'red'", propertyCard);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", propertyCard);

        LOGGER.trace("Change background of property card is performed, locator: //div[@data-testid='property-card'][%s]");
    }

    public void takeScreenshot(String directoryForScreenshots, String screenshotName) throws IOException {
        File asfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(asfile, new File(directoryForScreenshots, screenshotName));

        LOGGER.trace("Take screenshot is performed");
    }

    public void selectScoreRateCheckbox(String scoreRateText) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement scoreRateCheckbox = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By
                        .xpath(String.format("//div[@id='popular-filters-go-here']//preceding-sibling::div[@data-testid='filters-sidebar']//div[@data-filters-group='review_score']//div[text()='%s']", scoreRateText))));
        Actions actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        actions.moveToElement(scoreRateCheckbox).perform();
        scoreRateCheckbox.click();

        LOGGER.trace("Select score rate checkbox is performed, locator: //div[@id='popular-filters-go-here']//preceding-sibling::div[@data-testid='filters-sidebar']//div[@data-filters-group='review_score']//div[text()='%s']");
    }

    public void explicitWaitOfDisplayedLabelOfScoreRate(String propertyScoreRate) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//label[@data-testid='filter:%s']", propertyScoreRate))));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        LOGGER.trace("Explicit wait of displayed label of score rate is performed, locator: //label[@data-testid='filter:%s']");
    }

    public void clickToPropertyCardImage(int propertyCardNumber) {
        driver.findElement(By.xpath(String.format("//div[@data-testid='property-card'][%s]//img", propertyCardNumber))).click();

        LOGGER.trace("Click to property card image is performed, locator: //div[@data-testid='property-card'][%s]//img");
    }

    public void switchToTab(int orderTabNumber) {
        List<String> tabsList = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabsList.get(orderTabNumber));

        LOGGER.trace("Switch tab is performed");
    }
}
