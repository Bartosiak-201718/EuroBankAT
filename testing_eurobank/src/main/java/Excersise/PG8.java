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
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PG8 {
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
    public void testingScottseveranceLinksTest(){
        String baseURL = "https://www.scottseverance.us/mailto.html";
        webDriver.get(baseURL);
        webDriver.findElement(By.linkText("E-mail 1")).click();
        System.out.println("Title of this page is: "+webDriver.getTitle());
    }

    @Test
    public void testingLinks() {
        String baseURL = "https://www.scottseverance.us/mailto.html";
        webDriver.get(baseURL);

        List<WebElement> allLinksList = webDriver.findElements(By.tagName("a"));
        for(WebElement link : allLinksList){
            if(link.getText() != null){
                System.out.println("link: "+ link.getLocation() +link.getText());
            }
        }
    }

    @Test
    public void imagineLinkTest(){
        String baseURL = "https://www.facebook.com/";
        webDriver.get(baseURL);
        webDriver.findElement(By.cssSelector(".loggedout_menubar > div:nth-child(1)")).click();
    }



    @After
    public void TearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
