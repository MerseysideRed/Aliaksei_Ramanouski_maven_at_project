import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.testng.AssertJUnit.assertEquals;

public class BookingClassTest {

    @Test
    public void testFiveStarsHotels() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.booking.com/");

        WebElement buttonCLoseSignInPopUp = driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']"));
        if (buttonCLoseSignInPopUp.isDisplayed()) {
            buttonCLoseSignInPopUp.click();
        }

        WebElement searchField = driver.findElement(By.xpath("//div[@data-testid='searchbox-layout-wide']//input"));
        searchField.clear();
        searchField.sendKeys("Paris");

        driver.findElement(By.xpath("//li[@id='autocomplete-result-0']//div[text()='Paris']")).click();

        LocalDateTime ldt1 = LocalDateTime.now().plusDays(3);
        LocalDateTime ldt2 = LocalDateTime.now().plusDays(10);
        String firstDay = ldt1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String secondDay = ldt2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        driver.findElement(By.xpath("//span[@data-date='" + firstDay + "']")).click();
        driver.findElement(By.xpath("//span[@data-date='" + secondDay + "']")).click();

        driver.findElement(By.xpath("//button[@data-testid='occupancy-config']")).click();

        WebElement plusAdultsButton = driver.findElement(By.xpath("//button[ancestor::div/input[@id='group_adults']][2]"));
        while (!driver.findElement(By.xpath("//input[@id='group_adults']")).getAttribute("value").equals("4")) {
            plusAdultsButton.click();
        }

        WebElement plusRoomsButton = driver.findElement(By.xpath("//button[ancestor::div/input[@id='no_rooms']][2]"));
        while (!driver.findElement(By.xpath("//input[@id='no_rooms']")).getAttribute("value").equals("2")) {
            plusRoomsButton.click();
        }

        driver.findElement(By.xpath("//button/span[text()='Search']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement propertyTypeHotelsCheckbox = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='popular-filters-go-here']//preceding-sibling::div[@data-testid='filters-sidebar']//div[@data-filters-group='ht_id']//div[text()='Hotels']")));
        Actions actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        actions.moveToElement(propertyTypeHotelsCheckbox).perform();
        propertyTypeHotelsCheckbox.click();

        driver.findElement(By.xpath("//div[@id='popular-filters-go-here']//preceding-sibling::div[@data-testid='filters-sidebar']//div[@data-filters-group='class']//div[text()='5 stars']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@data-testid='filter:class=5']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();

        driver.findElement(By.xpath("//div/span[text()='Property rating (low to high)']")).click();

        String actualResult = driver.findElement(By.xpath("//div[@data-testid='property-card'][1]//div[@aria-label]")).getAttribute("aria-label");

        driver.quit();

        assertEquals("5 out of 5", actualResult);
    }
}
