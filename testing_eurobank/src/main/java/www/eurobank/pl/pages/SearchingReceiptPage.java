package www.eurobank.pl.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchingReceiptPage extends PageObject {

    @FindBy(id = "s-word")
    private WebElement searchEngineTextField;

    @FindBy(id = "Searchresult")
    private WebElement searchResultDiv;


    public Boolean counterOfWrongSearching = true;

    public SearchingReceiptPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkingExpressionInSearchEngineTextFieldAfterSearching(String searchingExpression) {
        searchEngineTextField.isDisplayed();
        String currentValueOfSearchEngineTextField = searchEngineTextField.getAttribute("value");
        Assert.assertEquals(searchingExpression, currentValueOfSearchEngineTextField);
    }

    public void lookingForSearchingExpressionInLinks(String searchingExpression) {
        List<WebElement> allLinks = webDriver.findElements(By.cssSelector("#Searchresult > div > p.resultText"));
        for (WebElement link : allLinks) {
            if (!link.getText().contains(searchingExpression)) {
                counterOfWrongSearching = false;
            }
            Assert.assertTrue(counterOfWrongSearching == true);
        }
    }

    public void waitForSearchingReceiptPageLoad() {
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("Searchresult")));
    }
}
