package by.itacademy.andreichumakou.web;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


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

        String actualTitleAuthForm = driver.findElement(By.xpath(OnlinerEnterPage.TITLE_AUTH_FORM_XPATH)).getText();
        Assert.assertEquals(OnlinerEnterPage.TITLE_AUTH_FORM_TEXT, actualTitleAuthForm);
        driver.quit();
    }
}
