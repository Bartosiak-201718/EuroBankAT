package Excersise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class PG9 {
    WebDriver webDriver;

    @BeforeClass
    public static void doBeforeStartTest() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void SetupTest() {
        webDriver = new FirefoxDriver();
    }

    @Test
    public void doActionTest(){
//      Actions builder = new Actions(webDriver);
//        WebElement linkHome = webDriver.findElement(By.linkText("Home"));
//      Action moudeOverHome = builder.moveToElement(linkHome).build();
    }

    @After
    public void TearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
