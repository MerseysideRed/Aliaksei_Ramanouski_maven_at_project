package pages.booking;

import driver.MyDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainPage {

    WebDriver driver = MyDriver.getDriver();
    private static final Logger LOGGER = LogManager.getLogger(MainPage.class);

    public void closeSignInWindow() {
        WebElement buttonCLoseSignInPopUp = driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']"));
        if (buttonCLoseSignInPopUp.isDisplayed()) {
            buttonCLoseSignInPopUp.click();
        }

        LOGGER.trace("Close Sign-in window is performed, locator: //button[@aria-label='Dismiss sign-in info.']");
    }

    public void setSearchCityField(String city) {
        WebElement searchField = driver.findElement(By.xpath("//div[@data-testid='searchbox-layout-wide']//input"));
        searchField.clear();
        searchField.sendKeys(city);
        driver.findElement(By.xpath(String.format("//li[@id='autocomplete-result-0']//div[text()='%s']", city))).click();

        LOGGER.trace("Set city value to city field is performed, locators: //div[@data-testid='searchbox-layout-wide']//input; //li[@id='autocomplete-result-0']//div[text()='%s']");
    }

    public void setTimeRangeField(int plusDaysFromFirstDate, int plusDaysFromSecondDate) {

        LocalDateTime ldt1 = LocalDateTime.now().plusDays(plusDaysFromFirstDate);
        LocalDateTime ldt2 = LocalDateTime.now().plusDays(plusDaysFromSecondDate);

        String firstDay = ldt1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String secondDay = ldt2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        driver.findElement(By.xpath(String.format("//span[@data-date='%s']", firstDay))).click();
        driver.findElement(By.xpath(String.format("//span[@data-date='%s']", secondDay))).click();

        LOGGER.trace("Set time range value is performed, locator: //span[@data-date='%s']");
    }

    public void setQuantityParametersOfPeopleAndRooms(String quantityOfAdults, String quantityOfRooms) {

        driver.findElement(By.xpath("//button[@data-testid='occupancy-config']")).click();

        WebElement plusAdultsButton = driver.findElement(By.xpath("//button[ancestor::div/input[@id='group_adults']][2]"));
        while (!driver.findElement(By.xpath("//input[@id='group_adults']")).getAttribute("value").equals(quantityOfAdults)) {
            plusAdultsButton.click();
        }

        WebElement plusRoomsButton = driver.findElement(By.xpath("//button[ancestor::div/input[@id='no_rooms']][2]"));
        while (!driver.findElement(By.xpath("//input[@id='no_rooms']")).getAttribute("value").equals(quantityOfRooms)) {
            plusRoomsButton.click();
        }

        LOGGER.trace("Set quantity parameters of adults and rooms are performed, locators: //button[ancestor::div/input[@id='group_adults']][2], //button[ancestor::div/input[@id='no_rooms']][2]");
    }

    public void clickSearchButton() {
        driver.findElement(By.xpath("//button/span[text()='Search']")).click();

        LOGGER.trace("Click to search button is performed, locator: //button/span[text()='Search']");
    }

    public void navigateToIndicator(String indicatorType) {

        WebElement tooltip = driver.findElement(By.xpath(String.format("//button[@data-testid= 'header-%s-picker-trigger']", indicatorType)));

        Actions actions = new Actions(driver);
        actions.moveToElement(tooltip).perform();

        LOGGER.trace("Navigate to tooltip is performed, locator: //button[@data-testid= 'header-%s-picker-trigger']");
    }

    public String getTooltipValue(String tooltipType) {
        LOGGER.trace("Get tooltip value will be performed, locator: //div[contains(text(), '%s')]");

        return driver.findElement(By.xpath(String.format("//div[contains(text(), '%s')]", tooltipType))).getText();
    }
}
