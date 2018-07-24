package Excersise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PG7 {
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
    public void selectFromMultipleList(){
        String baseURL = "http://output.jsbin.com/osebed/2";
        webDriver.get(baseURL);

        Select multiListFruit = new Select(webDriver.findElement(By.id("fruits")));
        multiListFruit.selectByIndex(0);
        multiListFruit.deselectByVisibleText("Banana");

        if(multiListFruit.isMultiple()){
            multiListFruit.selectByIndex(2);
            multiListFruit.deselectAll();
        }
    }

    @After
    public void TearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
