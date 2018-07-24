package Excersise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class AutomationPractice3 {
    private WebDriver driver;
    private Actions action;
    private final String url = "http://automationpractice.com/index.php";

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        action = new Actions(driver);
    }

    @After
    public void teardown() {
/*        if (driver != null) {
            driver.quit();
        }*/
    }

    @Test
    public void testTryBuyBlouse() throws InterruptedException {
        driver.get(url);
        driver.findElement(By.linkText("Women")).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[3]/div/div[1]/div/a[1]/img")).click();

        for (int i = 0; i < 5; i++)
            driver.findElement(By.className("icon-plus")).click();
        WebElement sizeProduct = driver.findElement(By.xpath("//*[@id=\"group_1\"]"));
        sizeProduct.sendKeys(Keys.PAGE_DOWN);
        driver.findElement(By.name("Submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //TimeUnit.SECONDS.sleep(3);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn:nth-child(2) > span:nth-child(1)")));
        driver.findElement(By.cssSelector("a.btn:nth-child(2) > span:nth-child(1)")).click();
        Assert.assertTrue(driver.getPageSource().contains("Shopping-cart summary"));
    }

}
