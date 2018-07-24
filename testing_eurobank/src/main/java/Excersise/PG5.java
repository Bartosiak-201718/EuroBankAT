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
import org.openqa.selenium.interactions.Actions;

public class PG5 {
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
    public void keepUserAfterLoginTest (){

        String baseURL = "https://urlopek.pl/Account/LogOn?ReturnUrl=%2fstart";
        webDriver.get(baseURL);
        WebElement chkPersist = webDriver.findElement(By.id("RememberMe"));
        for(int i=0; i<2; i++){
            chkPersist.click();
            System.out.println(chkPersist.isSelected());
        }


    }

    @After
    public void TearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
