package by.itacademy.andreichumakou.web;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class OnlinerTest {

    @Test
    public void testOpenOnliner() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(OnlinerMainPage.URL);
        String actualCopyright = driver.findElement(By.xpath(OnlinerMainPage.COPYRIGHT_XPATH)).getText();

        Assert.assertEquals(OnlinerMainPage.COPYRIGHT_TEXT, actualCopyright);
        driver.quit();
    }

    @Test
    public void testOpenOnlinerLoginForm() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(OnlinerMainPage.URL);
        driver.findElement(By.xpath(OnlinerMainPage.ENTER_XPATH)).click();

        String actualTitleAuthForm = driver.findElement(By.xpath(OnlinerEnterPage
                .TITLE_AUTH_FORM_XPATH)).getText();
        Assert.assertEquals(OnlinerEnterPage.TITLE_AUTH_FORM_TEXT, actualTitleAuthForm);
        driver.quit();
    }

    @Test
    public void testOnlinerLoginFormWithEmptyPassword() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

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


}
