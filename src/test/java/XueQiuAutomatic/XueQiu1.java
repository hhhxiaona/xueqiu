package XueQiuAutomatic;

import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @Author:xiaohl
 * @Date:2019/2/26 15:42
 * @Description:
 */
public class XueQiu1 {
    protected AndroidDriver driver;
    @Before
    public void setup()throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
//        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("appPackage", "com.xueqiu.android");
        capabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
    }
    @Test
    public void test() {
        driver.findElement(By.id("home_search")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("search_input_text")).sendKeys("pdd");
        driver.findElement(By.id("stockName")).click();


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


//        String result = driver.findElement(By.id("com.xueqiu.android:id/edittext")).getText();
//        System.out.println(result);
    }
    @After
    public void teardown(){
        driver.quit();
    }
}
