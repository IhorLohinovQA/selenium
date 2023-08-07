package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.PastePage;
import page.PastebinComHomePage;

public class PastebinComTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "My first test")
    public void newPasteIsCreated() {

         PastePage newPaste = new PastebinComHomePage(driver)
                 .openPage()
                 .enterNewPasteValue("Hello from WebDriver")
                 .selectExpirationValue()
                 .enterNameValue("helloweb")
                 .createNewPaste();
        Assert.assertTrue(newPaste.isPastePage());
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
