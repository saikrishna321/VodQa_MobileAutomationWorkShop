package com.pageObect;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
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
 * Created by saikrisv on 25/08/16.
 */
public class AddPostIOSTest {
    AppiumDriver driver;
    DesiredCapabilities caps;
    WebDriverWait wait;
    @BeforeClass public void setUp() throws MalformedURLException {
        caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.2");
        caps.setCapability(MobileCapabilityType.APP,
            System.getProperty("user.dir") + "/build/WordPress.app");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 30);
    }

    @Test public void addPost() {
        driver.findElementById("Username / Email").sendKeys("vodqa@gmail.com");
        driver.findElementById("Password").sendKeys("Hello12345678");
        driver.findElementByAccessibilityId("Sign In").click();
        wait.until(ExpectedConditions
            .elementToBeClickable(By.id("new-editor-modal-dismiss-button")));
        driver.findElementById("new-editor-modal-dismiss-button").click();
        driver.findElementByClassName("UIATableCell").click();
        driver.findElementById("New Post").click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("Post title")));
        driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]e").sendKeys("VodQAPune");
        driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[2]").sendKeys("VodQA Rocks!!");
        driver.navigate().back();
        driver.findElementById("Post").click();
        driver.findElementById("Blog Posts").click();

    }

    @AfterClass public void tearDown() {
        driver.quit();
    }
}
