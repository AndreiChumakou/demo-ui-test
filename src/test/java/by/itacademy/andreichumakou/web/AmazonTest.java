package by.itacademy.andreichumakou.web;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {

    WebDriver driver;

    @Before
    public void initObject() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testOpenAmazon() {
        driver.get(AmazonPage.URL);
        String actualCopyrightText = driver.findElement(By.xpath(AmazonPage.COPYRIGHT_XPATH)).getText();
        System.out.println(AmazonPage.COPYRIGHT_TEXT);
        System.out.println(actualCopyrightText);
        Assert.assertEquals(AmazonPage.COPYRIGHT_TEXT, actualCopyrightText);
    }

    @After
    public void endTest() {
        driver.quit();
    }
}
