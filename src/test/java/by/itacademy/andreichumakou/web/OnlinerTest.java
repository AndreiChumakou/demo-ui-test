package by.itacademy.andreichumakou.web;

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
    }

    @Test
    public void testOpenOnliner() {
        driver.get(OnlinerMainPage.URL);
        String actualCopyright = driver.findElement(By.xpath(OnlinerMainPage.COPYRIGHT_XPATH)).getText();

        Assert.assertEquals(OnlinerMainPage.COPYRIGHT_TEXT, actualCopyright);
        driver.quit();
    }

    @Test
    public void testOpenOnlinerLoginForm() {
        driver.get(OnlinerMainPage.URL);
        driver.findElement(By.xpath(OnlinerMainPage.ENTER_XPATH)).click();

        String actualTitleAuthForm = driver.findElement(By.xpath(OnlinerEnterPage
                .TITLE_AUTH_FORM_XPATH)).getText();
        Assert.assertEquals(OnlinerEnterPage.TITLE_AUTH_FORM_TEXT, actualTitleAuthForm);
        driver.quit();
    }

    @Test
    public void testOnlinerLoginFormWithEmptyCredentials() {
        driver.get(OnlinerMainPage.URL);
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
        driver.quit();
    }

    @Test
    public void testOnlinerLoginFormWithEmptyPassword() {
        driver.get(OnlinerMainPage.URL);
        driver.findElement(By.xpath(OnlinerMainPage.ENTER_XPATH)).click();

        driver.findElement(By.xpath(OnlinerEnterPage.NAME_FIELD_XPATH))
                .sendKeys(OnlinerEnterPage.CREDENTIALS_EMAIL);

        driver.findElement(By.xpath(OnlinerEnterPage.BUTTON_ENTER_XPATH)).click();

        new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(OnlinerEnterPage
                        .ERROR_MSG_AUTH_FORM_PASSWORD_XPATH)));
        String actualMessageErrorPassword = driver.findElement(By.xpath(OnlinerEnterPage
                .ERROR_MSG_AUTH_FORM_PASSWORD_XPATH)).getText();
        Assert.assertEquals(OnlinerEnterPage.ERROR_MSG_AUTH_FORM_PASSWORD_TEXT, actualMessageErrorPassword);
        driver.quit();
    }
}
