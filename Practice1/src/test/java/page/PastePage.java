package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastePage extends AbstractPage{
    @FindBy(xpath = "//*[text()='NOTE:']")
    private WebElement notification;

    protected PastePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPastePage() {
        return notification.isDisplayed();
    }

    public PastePage openPage() {
        throw new RuntimeException("PastePage should not be opened directly");
    }

}
