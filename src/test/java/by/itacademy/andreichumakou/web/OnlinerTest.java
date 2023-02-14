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

        driver.get(OnlinerPage.URL);
        String actualCopyright = driver.findElement(By.xpath(OnlinerPage.COPYRIGHT_XPATH)).getText();

        Assert.assertEquals(actualCopyright, OnlinerPage.COPYRIGHT_TEXT);
        driver.quit();
    }
}
