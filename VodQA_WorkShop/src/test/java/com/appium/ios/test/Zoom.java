package com.appium.ios.test;

import java.io.File;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class Zoom {
	 public static AppiumDriver<IOSElement> driver;

	  @Before
	  public void setup() throws Exception {
	    
	    File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/build/");
	    File app = new File(appDir, "TestApp.app.zip");
	    DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformVersion", "8.4");
        capabilities.setCapability("deviceName", "iPhone 5s");
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }

	  @Test
	  public void TouchActionTest() throws InterruptedException {
	    WebElement button = driver.findElementsByClassName("UIAButton").get(3);
	    TouchAction action = new TouchAction(driver);
	    action.press(button).perform();
	    Thread.sleep(2000);
	  }

	  @Test
	  public void TouchActionChainTest() throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, 20);

	    WebElement button = driver.findElementsByClassName("UIAButton").get(5);
	    TouchAction action = new TouchAction(driver);
	    action.press(button).perform();

	    wait.until(ExpectedConditions.alertIsPresent());
	    Alert alert = driver.switchTo().alert();
	    alert.accept();

	    WebElement mapview = driver.findElementByXPath("//UIAWindow[1]/UIAMapView[1]");
	    action = new TouchAction(driver);
	    action.press(mapview).moveTo(mapview, 0, 100).release().perform();
	    Thread.sleep(2000);
	  }

	  @Test
	  public void MultiGestureTest() throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, 20);

	    WebElement button = driver.findElementsByClassName("UIAButton").get(5);
	    TouchAction action = new TouchAction(driver);
	    action.press(button).perform();

	    wait.until(ExpectedConditions.alertIsPresent());
	    Alert alert = driver.switchTo().alert();
	    alert.accept();

	    WebElement mapview = driver.findElementByXPath("//UIAWindow[1]/UIAMapView[1]");

	    MultiTouchAction multiTouch = new MultiTouchAction(driver);
	    TouchAction action0 = new TouchAction(driver).press(mapview, 100, 0).moveTo(mapview, 0,-80).release();
	    TouchAction action1 = new TouchAction(driver).press(mapview, 100, 50).moveTo(mapview, 0,80).release();
	    multiTouch.add(action0).add(action1).perform();
	    Thread.sleep(2000);
	  }

	  @Test
	  public void ZoomTest() throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, 20);

	    WebElement button = driver.findElementsByClassName("UIAButton").get(5);
	    TouchAction action = new TouchAction(driver);
	    action.press(button).perform();

	    wait.until(ExpectedConditions.alertIsPresent());
	    Alert alert = driver.switchTo().alert();
	    alert.accept();

	    WebElement mapview = driver.findElementByXPath("//UIAWindow[1]/UIAMapView[1]");

	    //driver.zoom(mapview);
	    Thread.sleep(2000);
	  }

	  @Test
	  public void TapSingleFingerTest() {
	    //driver.tap(1,100,200,1000);
	  }

	  
}
