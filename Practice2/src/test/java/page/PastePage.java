package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PastePage extends AbstractPage{
    @FindBy(xpath = "//*[text()='how to gain dominance among developers']")
    private WebElement nameTitle;

    @FindBy(xpath = "//*[text()='Bash']")
    private WebElement syntaxBash;

    @FindBy(xpath = "//div[@class='source bash']//div[@class='de1']")
    private List<WebElement> codeLines;


    protected PastePage(WebDriver driver) {
        super(driver);
    }

    public boolean isNameTitle() {
        return nameTitle.isDisplayed();
    }

    public boolean isSyntaxBash() {
        return syntaxBash.isDisplayed();
    }

    public String getFormattedCode() {
        StringBuilder actualTextBuilder = new StringBuilder();
        for (WebElement line : codeLines) {
            actualTextBuilder.append(line.getText()).append("\n");
        }
        return actualTextBuilder.toString().trim();
    }

    public PastePage openPage() {
        throw new RuntimeException("PastePage should not be opened directly");
    }

}
