import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WebDriverSeleniumDevTest {

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetUp() {
        driver = new ChromeDriver();
    }

    @Test (description = "Just first test, JIRA binding can be here")
    public void commonSearchTermResultsAreNotEmpty() {

        driver.get("https://www.selenium.dev/");

        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"docsearch\"]/button"));
        searchInput.click();

        WebElement enterValue = driver.findElement(By.id("docsearch-input"));
        enterValue.sendKeys("selenium java");

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("docsearch-item-0")));

        List<WebElement> foundResult = driver.findElements(By.id("docsearch-item-0"));
        //foundResult.get(0).click();

        Assert.assertTrue(foundResult.size()>1, "Search results are empty!");

    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
