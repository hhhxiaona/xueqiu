package XueQiuAutomatic;


import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", ".Calculator");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.findElement(By.id("digit1")).click();
        driver.findElement(By.id("digit5")).click();
        driver.findElement(By.id("digit9")).click();
        driver.findElement(By.id("minus")).click();
        driver.findElement(By.id("digit9")).click();
        driver.findElement(By.id("plus")).click();
        driver.findElement(By.id("digit6")).click();
        driver.findElement(By.id("equal")).click();
        Thread.sleep(2000);

        String result = driver.findElement(By.id("com.android.calculator2:id/edittext")).getText();
        System.out.println(result);

        driver.quit();
    }
}
