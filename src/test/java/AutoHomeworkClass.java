import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class AutoHomeworkClass {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("погода минск");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@role='listbox']/li[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='wob_dp']/div[2]")).click();
        Thread.sleep(1000);
        String day = AutoHomeworkClass.getTomorrowDay();
        String result = driver.findElement(By.xpath("//*[contains(@aria-label, '°Celsius " + day + " 12:00')][1]")).getAttribute("aria-label");
        System.out.println(result);
        driver.quit();
    }

    static public String getTomorrowDay() {
        LocalDate today = LocalDate.now().plusDays(1);
        Locale belLocale = new Locale("be", "BY");
        return today.format(DateTimeFormatter.ofPattern("EEEE", belLocale));
    }
}
