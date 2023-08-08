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
    public void pastNameTitleIsSuitable() {

         PastePage newPaste = new PastebinComHomePage(driver)
                 .openPage()
                 .enterNewPasteValue("git config --global user.name  \"New Sheriff in Town\"\n" +
                         "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                         "git push origin master --force")
                 .selectExpirationValue()
                 .selectSyntaxHighlighting()
                 .enterNameValue("how to gain dominance among developers")
                 .createNewPaste();
        Assert.assertTrue(newPaste.isNameTitle());
    }

    @Test(description = "My second test")
    public void pastSyntaxIsSuitable() {

        PastePage newPaste = new PastebinComHomePage(driver)
                .openPage()
                .enterNewPasteValue("git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force")
                .selectExpirationValue()
                .selectSyntaxHighlighting()
                .enterNameValue("how to gain dominance among developers")
                .createNewPaste();
        Assert.assertTrue(newPaste.isSyntaxBash());
    }

    @Test(description = "My third test")
    public void pastBodyIsSuitable() {

        PastePage newPaste = new PastebinComHomePage(driver)
                .openPage()
                .enterNewPasteValue("git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force")
                .selectExpirationValue()
                .selectSyntaxHighlighting()
                .enterNameValue("how to gain dominance among developers")
                .createNewPaste();

        String actualText = newPaste.getFormattedCode();

        String expectedText = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";

        Assert.assertEquals(expectedText, actualText);
    }


    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
