package www.eurobank.pl.tests;

import org.junit.Test;
import www.eurobank.pl.pages.ActiveAccountPage;
import www.eurobank.pl.pages.MainPage;
import www.eurobank.pl.pages.PersonalAccountPage;
import www.eurobank.pl.pages.SearchingReceiptPage;

public class MainPageTest extends FunctionalTest {

    String mainPageURL = "https://www.eurobank.pl/";
    String searchedPhrase = "bank";
    MainPage mainPage = new MainPage(webDriver);
    PersonalAccountPage personalAccountPage = new PersonalAccountPage(webDriver);
    ActiveAccountPage activeAccountPage = new ActiveAccountPage(webDriver);
    SearchingReceiptPage searchingReceiptPage = new SearchingReceiptPage(webDriver);

    @Test
    public void searchingFourLetterExpressionTest() {
        webDriver.get(mainPageURL);
        mainPage.isInitializedSearchingBox();
        mainPage.searchExpression(searchedPhrase);
        searchingReceiptPage.waitForSearchingReceiptPageLoad();
        searchingReceiptPage.checkingExpressionInSearchEngineTextFieldAfterSearching(searchedPhrase);
        searchingReceiptPage.lookingForSearchingExpressionInLinks(searchedPhrase);
    }

    @Test
    public void displayingPageWithAllTypeOfPersonalAccount() {
        webDriver.get(mainPageURL);
        mainPage.displayingAllTypesOfPersonalAccount();
        personalAccountPage.waitForPersonalAccountPageLoad();
    }

    @Test
    public void displayingInformationAboutActiveAccount() {
        webDriver.get(mainPageURL);
        mainPage.displayingInfoAboutActiveAccount();
        activeAccountPage.waitForActiveAccountPageLoad();
    }

    @Test
    public void changingLanguageOfMainPage() {
        webDriver.get(mainPageURL);
        mainPage.clickingOnChangingLanguageButton();
    }
}

