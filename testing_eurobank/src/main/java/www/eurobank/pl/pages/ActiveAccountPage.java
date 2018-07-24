package www.eurobank.pl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActiveAccountPage extends PageObject {

    WebDriverWait webDriverWait;

    public ActiveAccountPage(WebDriver webDriver) {
        super(webDriver);
        webDriverWait = new WebDriverWait(this.webDriver);
    }

    public void waitForActiveAccountPageLoad() {
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("tabs1")));
    }
}
