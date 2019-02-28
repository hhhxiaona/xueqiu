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
 * @Date:2019/2/27 11:42
 * @Description:
 */
public class XueQiuALi {
    protected AndroidDriver driver;
    @Before
    public void setup()throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("appPackage", "com.xueqiu.android");
        capabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        capabilities.setCapability("autoGrantPermissions", "true");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
    }
    @Test
    public void test() {
        //app 页面信息位置可能会变，解决方法：多次定位
        driver.findElement(By.xpath("//*[@text='自选' and contains(@resource-id,tab_name)]"));
        driver.findElement(By.xpath("//*[@text='自选' and contains(@resource-id,tab_name)]"));
        driver.findElement(By.xpath("//*[@text='自选' and contains(@resource-id,tab_name)]"));
        driver.findElement(By.xpath("//*[contains(@resource-id,tab_name) and @text='自选']")).click();

        //查找图片导入
//        System.out.println(driver.findElement(By.xpath("//*[contains(@text,'图片导入')]")));;

        //打印页面布局
//        System.out.println(driver.getPageSource());

        driver.findElement(By.id("action_create_cube")).click();
        driver.findElement(By.id("search_input_text")).sendKeys("ali");
        //判断是否已点击
        if(driver.findElementById("follow_btn").isDisplayed()) {
            driver.findElement(By.id("follow_btn")).click();
            driver.findElement(By.xpath("//*[@text='下次再说']")).click();
        }
        driver.findElement(By.id("action_close")).click();

        try{

            driver.findElements(By.xpath("//*[contains(@resource-id,'portfolio_stockName') and @text='阿里巴巴']"));
            System.out.println("OK");
        }catch (Exception e) {
            System.out.println("没有找到 "+e);
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);



    }
    @After
    public void teardown(){
        driver.quit();
    }
}
