package www.eurobank.pl.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageObject {

    @FindBy(id = "topSearch")
    private WebElement searchEngineTextField;

    @FindBy(id = "submit-search")
    private WebElement magnifyingGlassButton;

    @FindBy(id = "nav-menu")
    private WebElement grayMenuBar;

    @FindBy(css = "#nav-menu > li:nth-child(1)")
    private WebElement personalAccountOptionFromGrayMenuBar;

    @FindBy(css = "#nav-menu > li:nth-child(1) > ul > li:nth-child(1) > div > a")
    private WebElement activeAccountOption;

    @FindBy(css = "#layout > div.footer > div > div.f-div.last > div.language-flag > a > span.bold")
    private WebElement changingLanguageButton1;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isInitializedSearchingBox() {
        return searchEngineTextField.isDisplayed();
    }

    public void searchExpression(String searchingPhrase) {
        Actions builder = new Actions(webDriver);
        Action searchingPhraseAction = builder
                .moveToElement(searchEngineTextField)
                .doubleClick(searchEngineTextField)
                .sendKeys(searchEngineTextField, searchingPhrase)
                .moveToElement(magnifyingGlassButton)
                .click(magnifyingGlassButton)
                .build();
        searchingPhraseAction.perform();
    }

    public void displayingAllTypesOfPersonalAccount(){
        Actions builder = new Actions(webDriver);
        Action selectingPersonalAccount = builder
                .moveToElement(personalAccountOptionFromGrayMenuBar)
                .doubleClick(personalAccountOptionFromGrayMenuBar)
                .build();
        selectingPersonalAccount.perform();
    }

    public void displayingInfoAboutActiveAccount(){
        Actions builder = new Actions(webDriver);
        Action selectingActivePersonalAccount = builder
                .moveToElement(personalAccountOptionFromGrayMenuBar)
                .click(personalAccountOptionFromGrayMenuBar)
                .moveToElement(activeAccountOption)
                .click(activeAccountOption)
                .build();
        selectingActivePersonalAccount.perform();
    }

    public void clickingOnChangingLanguageButton() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        changingLanguageButton1.click();
    }
}


