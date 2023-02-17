package by.itacademy.andreichumakou.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TimeToWait {

    public static void waitForVisualisation(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("Exception of timeout using!");
            e.printStackTrace();
        }
    }

    public static void waitForPresenceOfElement(WebDriver driver, String xPathOfElement) {
        new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(xPathOfElement)));
    }
}
