package Excersise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Driver;

public class NewClass {

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
    public void test() {
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // launch Firefox and direct it to the Base URL
        webDriver.get(baseUrl);

        // get the actual value of the title
        actualTitle = webDriver.getTitle();

        //compare the actual title of the page with the expected one and print
        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        Assert.assertTrue(actualTitle.contentEquals(expectedTitle));
    }

    @After
    public void TearDown() {
        if (webDriver != null) {
            webDriver.close();
        }
    }
}
