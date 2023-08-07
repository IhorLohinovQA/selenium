package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastebinComHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://pastebin.com/";

    @FindBy(id = "postform-text")
    private WebElement pasteInput;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpirationDropDownList;

    @FindBy (xpath = "//li[text()='10 Minutes']")
    private WebElement expirationTenMinutes;

    @FindBy(id = "postform-name")
    private WebElement pasteNameTitle;

    @FindBy(css = ".btn.-big")
    private WebElement pasteSubmitButton;

    public PastebinComHomePage(WebDriver driver) {
        super(driver);
    }

    public PastebinComHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PastebinComHomePage enterNewPasteValue(String term) {
        pasteInput.click();
        pasteInput.sendKeys(term);
        return this;
    }

    public PastebinComHomePage selectExpirationValue() {
        pasteExpirationDropDownList.click();
        expirationTenMinutes.click();
        return this;
    }

    public PastebinComHomePage enterNameValue(String title) {
        pasteNameTitle.click();
        pasteNameTitle.sendKeys(title);
        return this;
    }

    public PastePage createNewPaste() {
        pasteSubmitButton.click();
        return new PastePage(driver);
    }

}
