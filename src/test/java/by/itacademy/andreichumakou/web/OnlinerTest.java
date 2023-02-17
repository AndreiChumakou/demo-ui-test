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
import java.awt.*;
import static java.awt.event.InputEvent.*;
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
        TimeUnit.waitForPresenceOfElement(driver,OnlinerMainPage.COPYRIGHT_XPATH);
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
        TimeUnit.waitForPresenceOfElement(driver, OnlinerEnterPage
                .ERROR_MSG_AUTH_FORM_NAME_XPATH);
        String actualMessageErrorName = driver.findElement(By.xpath(OnlinerEnterPage
                .ERROR_MSG_AUTH_FORM_NAME_XPATH)).getText();
        String actualMessageErrorPassword = driver.findElement(By.xpath(OnlinerEnterPage
                .ERROR_MSG_AUTH_FORM_PASSWORD_XPATH)).getText();
        Assert.assertEquals(OnlinerEnterPage.ERROR_MSG_AUTH_FORM_NAME_TEXT, actualMessageErrorName);
        Assert.assertEquals(OnlinerEnterPage.ERROR_MSG_AUTH_FORM_PASSWORD_TEXT, actualMessageErrorPassword);
    }

    @Test
    public void testOnlinerLoginFormWithEmptyPassword() {
        TimeUnit.waitForPresenceOfElement(driver, OnlinerMainPage.ENTER_XPATH);
        driver.findElement(By.xpath(OnlinerMainPage.ENTER_XPATH)).click();
        driver.findElement(By.xpath(OnlinerEnterPage.NAME_FIELD_XPATH))
                .sendKeys(OnlinerEnterPage.CREDENTIALS_EMAIL);
        driver.findElement(By.xpath(OnlinerEnterPage.BUTTON_ENTER_XPATH)).click();
        TimeUnit.waitForPresenceOfElement(driver, OnlinerEnterPage.ERROR_MSG_AUTH_FORM_PASSWORD_XPATH);
        String actualMessageErrorPassword = driver.findElement(By.xpath(OnlinerEnterPage
                .ERROR_MSG_AUTH_FORM_PASSWORD_XPATH)).getText();
        Assert.assertEquals(OnlinerEnterPage.ERROR_MSG_AUTH_FORM_PASSWORD_TEXT, actualMessageErrorPassword);
    }

    @Test
    public void testOnlinerLoginFormWithEmptyNameOfUser() {
        TimeUnit.waitForPresenceOfElement(driver, OnlinerMainPage.ENTER_XPATH);
        driver.findElement(By.xpath(OnlinerMainPage.ENTER_XPATH)).click();
        driver.findElement(By.xpath(OnlinerEnterPage.PASSWORD_FIELD_XPATH))
                .sendKeys(OnlinerEnterPage.CREDENTIALS_PASSWORD);
        driver.findElement(By.xpath(OnlinerEnterPage.BUTTON_ENTER_XPATH)).click();
        TimeUnit.waitForPresenceOfElement(driver, OnlinerEnterPage.ERROR_MSG_AUTH_FORM_NAME_XPATH);
        String actualMessageErrorName = driver.findElement(By.xpath(OnlinerEnterPage
                .ERROR_MSG_AUTH_FORM_NAME_XPATH)).getText();
        Assert.assertEquals(OnlinerEnterPage.ERROR_MSG_AUTH_FORM_NAME_TEXT, actualMessageErrorName);
    }

    @Test
    public void testOnlinerLoginFormWithRealCredentials() throws AWTException {
        TimeUnit.waitForPresenceOfElement(driver, OnlinerMainPage.ENTER_XPATH);
        driver.findElement(By.xpath(OnlinerMainPage.ENTER_XPATH)).click();
        driver.findElement(By.xpath(OnlinerEnterPage.NAME_FIELD_XPATH))
                .sendKeys(OnlinerMainPage.CREDENTIALS_EMAIL_REAL);
        driver.findElement(By.xpath(OnlinerEnterPage.PASSWORD_FIELD_XPATH))
                .sendKeys(OnlinerMainPage.CREDENTIALS_PASSWORD_REAL);
        TimeUnit.waitForVisualisation(3000);
        driver.findElement(By.xpath(OnlinerEnterPage.BUTTON_ENTER_XPATH)).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-')]")));
        Robot robot = new Robot();
        robot.mouseMove(638, 490);
        TimeUnit.waitForVisualisation(3000);
        robot.mousePress(BUTTON1_DOWN_MASK);
        robot.mouseRelease(BUTTON1_DOWN_MASK);
        TimeUnit.waitForVisualisation(60000);

        driver.findElement(By.xpath(OnlinerMainPage.BUTTON_PROFILE_XPATH)).click();
        TimeUnit.waitForPresenceOfElement(driver, OnlinerMainPage.PROFILE_NAME_XPATH);
        TimeUnit.waitForVisualisation(3000);
        String actualNameAfterLogin = driver.findElement(By.xpath(OnlinerMainPage.PROFILE_NAME_XPATH)).getText();
        Assert.assertEquals(OnlinerMainPage.CREDENTIALS_NIKNAME_REAL, actualNameAfterLogin);
        TimeUnit.waitForVisualisation(3000);
    }

    @After()
    public void closeDriver() {
        driver.quit();
    }
}
