import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.DayOfWeek;
import java.time.LocalDate;

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
        DayOfWeek today = LocalDate.now().plusDays(1).getDayOfWeek();
        switch (today) {
            case MONDAY -> {
                return "панядзелак";
            }
            case TUESDAY -> {
                return "аўторак";
            }
            case WEDNESDAY -> {
                return "серада";
            }
            case THURSDAY -> {
                return "чацвер";
            }
            case FRIDAY -> {
                return "пятніца";
            }
            case SATURDAY -> {
                return "субота";
            }
            case SUNDAY -> {
                return "нядзеля";
            }
            default -> {
                return "";
            }
        }
    }
}
