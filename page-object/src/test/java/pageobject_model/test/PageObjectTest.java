package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.SeleniumDevHomePage;


public class PageObjectTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Just first test, JIRA binding can be here")
    public void commonSearchTermResultsAreNotEmpty() {

        int expectedSearchResultsNumber = new SeleniumDevHomePage(driver)
                .openPage()
                .searchForTerms("selenium java")
                .countSearchResults();

        Assert.assertEquals(expectedSearchResultsNumber, 5);

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
