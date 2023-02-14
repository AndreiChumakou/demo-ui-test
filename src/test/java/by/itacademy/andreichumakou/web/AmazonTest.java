package by.itacademy.andreichumakou.web;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    @Test
    public void testOpenAmazonCart() {
        driver.get(AmazonPage.URL);
        driver.findElement(By.xpath(AmazonPage.CART_FROM_MAIN_XPATH)).click();
        new WebDriverWait(driver, Duration.ofMillis(3000)).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(AmazonPage.ROW_YOUR_AMAZON_CART_IS_EMPTY_XPATH)));
        String actualTextIsCartEmpty = driver
                .findElement(By.xpath(AmazonPage.ROW_YOUR_AMAZON_CART_IS_EMPTY_XPATH)).getText();
    }

    @Test
    public void testOpenAmazonLoginForm() {
        driver.get(AmazonPage.URL);
        driver.findElement(By.xpath(AmazonPage.CART_FROM_MAIN_XPATH)).click();
        driver.findElement(By.xpath(AmazonPage.BUTTON_SIGN_TO_ACCOUNT_XPATH)).click();

        new WebDriverWait(driver, Duration.ofMillis(3000)).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(AmazonPage.SING_IN_XPATH)));

        String actualTextSingIn = driver.findElement(By.xpath(AmazonPage.SING_IN_XPATH)).getText();
        Assert.assertEquals(AmazonPage.SING_IN_TEXT, actualTextSingIn);
    }

    @After
    public void endTest() {
        driver.quit();
    }
}
