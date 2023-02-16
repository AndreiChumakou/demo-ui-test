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


public class OnlinerTest {
    WebDriver driver;

    @Before
    public void initObject() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerMainPage.URL);
    }

    @Test
    public void testOpenOnliner() {
        new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(OnlinerMainPage.COPYRIGHT_XPATH)));
        String actualCopyright = driver.findElement(By.xpath(OnlinerMainPage.COPYRIGHT_XPATH)).getText();
        Assert.assertEquals(OnlinerMainPage.COPYRIGHT_TEXT, actualCopyright);
    }

    @Test
    public void testOpenOnlinerLoginForm() {
        driver.findElement(By.xpath(OnlinerMainPage.ENTER_XPATH)).click();
        String actualTitleAuthForm = driver.findElement(By.xpath(OnlinerEnterPage
                .TITLE_AUTH_FORM_XPATH)).getText();
        Assert.assertEquals(OnlinerEnterPage.TITLE_AUTH_FORM_TEXT, actualTitleAuthForm);
    }

    @Test
    public void testOnlinerLoginFormWithEmptyCredentials() {
        driver.findElement(By.xpath(OnlinerMainPage.ENTER_XPATH)).click();
        driver.findElement(By.xpath(OnlinerEnterPage.BUTTON_ENTER_XPATH)).click();
        new WebDriverWait(driver, Duration.ofMillis(10000)).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(OnlinerEnterPage
                        .ERROR_MSG_AUTH_FORM_NAME_XPATH)));
        String actualMessageErrorName = driver.findElement(By.xpath(OnlinerEnterPage
                .ERROR_MSG_AUTH_FORM_NAME_XPATH)).getText();
        String actualMessageErrorPassword = driver.findElement(By.xpath(OnlinerEnterPage
                .ERROR_MSG_AUTH_FORM_PASSWORD_XPATH)).getText();
        Assert.assertEquals(OnlinerEnterPage.ERROR_MSG_AUTH_FORM_NAME_TEXT, actualMessageErrorName);
        Assert.assertEquals(OnlinerEnterPage.ERROR_MSG_AUTH_FORM_PASSWORD_TEXT, actualMessageErrorPassword);
    }

    @Test
    public void testOnlinerLoginFormWithEmptyPassword() {
        waitForPresenceOfElement(OnlinerMainPage.ENTER_XPATH);
        driver.findElement(By.xpath(OnlinerMainPage.ENTER_XPATH)).click();
        driver.findElement(By.xpath(OnlinerEnterPage.NAME_FIELD_XPATH))
                .sendKeys(OnlinerEnterPage.CREDENTIALS_EMAIL);
        driver.findElement(By.xpath(OnlinerEnterPage.BUTTON_ENTER_XPATH)).click();
        waitForPresenceOfElement(OnlinerEnterPage.ERROR_MSG_AUTH_FORM_PASSWORD_XPATH);
        String actualMessageErrorPassword = driver.findElement(By.xpath(OnlinerEnterPage
                .ERROR_MSG_AUTH_FORM_PASSWORD_XPATH)).getText();
        Assert.assertEquals(OnlinerEnterPage.ERROR_MSG_AUTH_FORM_PASSWORD_TEXT, actualMessageErrorPassword);
    }

    @Test
    public void testOnlinerLoginFormWithEmptyNameOfUser() {
        waitForPresenceOfElement(OnlinerMainPage.ENTER_XPATH);
        driver.findElement(By.xpath(OnlinerMainPage.ENTER_XPATH)).click();
        driver.findElement(By.xpath(OnlinerEnterPage.PASSWORD_FIELD_XPATH))
                .sendKeys(OnlinerEnterPage.CREDENTIALS_PASSWORD);
        driver.findElement(By.xpath(OnlinerEnterPage.BUTTON_ENTER_XPATH)).click();
        waitForPresenceOfElement(OnlinerEnterPage.ERROR_MSG_AUTH_FORM_NAME_XPATH);
        String actualMessageErrorName = driver.findElement(By.xpath(OnlinerEnterPage
                .ERROR_MSG_AUTH_FORM_NAME_XPATH)).getText();
        Assert.assertEquals(OnlinerEnterPage.ERROR_MSG_AUTH_FORM_NAME_TEXT, actualMessageErrorName);
    }


    @After()
    public void closeDriver() {
        driver.quit();
    }

    public void waitForPresenceOfElement(String xPathOfElement) {
        new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(xPathOfElement)));
    }
}
