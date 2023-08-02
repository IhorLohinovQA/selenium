package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class SeleniumDevHomePage {
    private static final String HOMEPAGE_URL = "https://www.selenium.dev/";
    private final WebDriver driver;
    @FindBy (xpath = "//*[@id=\"docsearch\"]/button")
    private WebElement searchInput;

    @FindBy (id = "docsearch-input")
    private WebElement enterValue;

    @FindBy (css = "#docsearch-list .DocSearch-Hit")
    private List<WebElement> searchResults;

    public SeleniumDevHomePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SeleniumDevHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public SeleniumDevHomePage searchForTerms(String term) {
        searchInput.click();
        enterValue.sendKeys(term);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("docsearch-item-0")));
        return this;
    }

    public int countSearchResults() {
        return searchResults.size();
    }

}
