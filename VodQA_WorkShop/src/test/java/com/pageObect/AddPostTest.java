package com.pageObect;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by saikrisv on 24/08/16.
 */
public class AddPostTest {

    AppiumDriver driver;
    DesiredCapabilities caps;
    WebDriverWait wait;

    @BeforeClass public void setUp() throws MalformedURLException {
        caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
        //caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.wordpress.android");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
            "org.wordpress.android.ui.WPLaunchActivity");
        caps.setCapability(MobileCapabilityType.APP,
            System.getProperty("user.dir") + "/build/wordpress.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 30);
    }

    @Test public void addPost() {
        driver.findElementById("org.wordpress.android:id/nux_username").sendKeys("vodqa@gmail.com");
        driver.findElementById("org.wordpress.android:id/nux_password").sendKeys("Hello12345678");
        driver.findElementById("org.wordpress.android:id/nux_sign_in_button").click();
        wait.until(ExpectedConditions
            .elementToBeClickable(By.id("org.wordpress.android:id/my_site_title_label")));
        driver.findElementById("org.wordpress.android:id/fab_button").click();
        driver.findElementById("org.wordpress.android:id/post_title").sendKeys("VodQAPune");
        driver.findElementById("org.wordpress.android:id/post_content").sendKeys("VodQA Rocks!!");
        driver.navigate().back();
        driver.findElementById("org.wordpress.android:id/menu_save_post").click();

    }

    @AfterClass public void tearDown() {
        driver.quit();
    }
}
