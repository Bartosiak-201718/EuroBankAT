package Excersise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PG2 {

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
    public void doSecondTest(){
        String baseURL = "http://www.facebook.com";
        String tagName = "";
        String expectedTagName = "div";
        WebElement cssSelectror;
        WebElement linkText;
        WebElement name;
        String xpath;
        String alterMessage="";

        webDriver.get(baseURL);

        tagName = webDriver.findElement(By.id("u_0_u")).getTagName();
        System.out.println(tagName);
        //Assert.assertTrue(expectedTagName.contentEquals(tagName));

        cssSelectror = webDriver.findElement(By.cssSelector("input[name='pass']"));
        System.out.println(cssSelectror);

//        linkText=webDriver.findElement(By.partialLinkText("email"));
//        System.out.println(linkText);

        name = webDriver.findElement(By.name("email"));
        System.out.println(name);

        xpath = webDriver.findElement(By.xpath("//*[@id=\"email\"]")).getTagName();
        System.out.println(xpath);

        System.out.println(webDriver.getTitle());
        System.out.println();
        System.out.println();
        System.out.println(webDriver.getPageSource());
        System.out.println();
        System.out.println();
        System.out.println("URL::::::::::::::::::::::::" + webDriver.getCurrentUrl());
        System.out.println();
        System.out.println();
        System.out.println(webDriver.findElement(By.xpath("//*[@id=\"u_0_z\"]")).getText());

        //webDriver.navigate().to("https://www.onet.pl/");
        //webDriver.navigate().refresh();
        //webDriver.navigate().forward();
        //webDriver.navigate().back();

        webDriver.navigate().to("http://demo.guru99.com/selenium/deprecated.html");
        webDriver.switchTo().frame("classFrame");
        webDriver.findElement(By.linkText("Deprecated")).click();
        //webDriver.navigate().to("http://demo.guru99.com/selenium/deprecated.html");
        webDriver.switchTo().parentFrame();
        webDriver.switchTo().frame("packageFrame");
        webDriver.findElement(By.linkText(("AbstractWebDriverEventListener"))).click();

        webDriver.navigate().to("http://output.jsbin.com/usidix/1");
        webDriver.findElement(By.xpath("/html/body/input")).click();
        alterMessage=webDriver.switchTo().alert().getText();
        System.out.println(alterMessage);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.switchTo().alert().accept();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
//        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("username")));
//        webDriver.findElement(By.id("username")).sendKeys("tutorial");



    }

    @After
    public void TearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
