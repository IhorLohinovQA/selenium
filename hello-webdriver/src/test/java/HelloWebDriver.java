import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWebDriver {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://vodokanal.kharkov.ua/");
        WebElement searchInput = driver.findElement(By.id("searchform-search_string"));
        searchInput.sendKeys("ав");
        WebElement searchBtn = driver.findElement(By.xpath("//*[@id=\"search\"]/button/i"));
        searchBtn.click();
        Thread.sleep(1000);
        driver.quit();
    }
}