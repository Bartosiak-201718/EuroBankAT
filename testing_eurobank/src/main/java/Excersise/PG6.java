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

public class PG6 {
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
    public void fillingRegisterFormTest(){
        String baseURL = "http://demo.guru99.com/test/newtours/register.php";
        webDriver.get(baseURL);
        WebElement firstName = webDriver.findElement(By.name("firstName"));
        firstName.sendKeys("Sylwia");
        Select dropdownCountry = new Select(webDriver.findElement(By.name("country")));
        dropdownCountry.selectByVisibleText("POLAND");
    }

    @After
    public void TearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

}
