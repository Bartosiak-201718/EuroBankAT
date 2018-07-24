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

public class PG4 {
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
    public void selectingButtonTest(){
        webDriver.get("http://demo.guru99.com/test/radio.html");

        WebElement radioButton1 = webDriver.findElement(By.id("vfb-7-1"));
        WebElement radioButton2 = webDriver.findElement(By.id("vfb-7-2"));

        radioButton1.click();
        radioButton2.click();

        WebElement checkBox1 = webDriver.findElement(By.id("vfb-6-0"));
        WebElement checkBox2 = webDriver.findElement(By.id("vfb-6-1"));

        checkBox1.click();
        checkBox2.click();


    }

    @Test
    public void selectingButtonMessageTest(){
        webDriver.get("http://demo.guru99.com/test/radio.html");
        WebElement checkBox1 = webDriver.findElement(By.id("vfb-6-0"));
        checkBox1.click();
        if(checkBox1.isSelected()){
            System.out.println("Checkbox 1 is selected");
        }else {
            System.out.println("Checkbox 1 is not selected");
        }

        checkBox1.click();
        if(!checkBox1.isSelected()){
            System.out.println("Checkbox 1 is not selected now!");
        }else{
            System.out.println("Checkbox 1 is selected now!");
        }
    }

    @After
    public void TearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
