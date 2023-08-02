package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class SeleniumDevHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://www.selenium.dev/";

    @FindBy (xpath = "//*[@id=\"docsearch\"]/button")
    private WebElement searchInput;

    @FindBy (id = "docsearch-input")
    private WebElement enterValue;

    @FindBy (css = "#docsearch-list .DocSearch-Hit")
    private List<WebElement> searchResults;

    public SeleniumDevHomePage (WebDriver driver) {
        super(driver);
    }

    public SeleniumDevHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public SeleniumDevHomePage searchForTerms(String term) {
        searchInput.click();
        enterValue.sendKeys(term);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("docsearch-item-0")));
        return this;
    }

    public int countSearchResults() {
        return searchResults.size();
    }

}
