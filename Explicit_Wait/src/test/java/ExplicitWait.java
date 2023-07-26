import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ExplicitWait {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/");

        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"docsearch\"]/button/span[1]/span"));
        searchInput.click();

        WebElement enterValue = driver.findElement(By.id("docsearch-input"));
        enterValue.sendKeys("selenium java");

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"docsearch-item-0\"]/a/div/div[2]/span[1]")));

        List<WebElement> foundResult = driver.findElements(By.xpath("//*[@id=\"docsearch-item-0\"]/a/div/div[2]/span[1]"));
        foundResult.get(0).click();

        Thread.sleep(3000);

        driver.quit();
    }

}
