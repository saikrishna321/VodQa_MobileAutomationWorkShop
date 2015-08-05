package com.appium.android.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AndriodTest {

	AppiumDriver<WebElement> driver;

	@Before
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "9111833b");
		caps.setCapability("platformVersion", "5.0.2");
		caps.setCapability("app", "/Users/saikrisv/Downloads/org.wordpress.android-4.3.2-APK4Fun.com.apk");
		caps.setCapability("package", "org.wordpress.android");
		caps.setCapability("appActivity", "org.wordpress.android.ui.WPLaunchActivity");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testApp() throws InterruptedException{
		waitForElementClickable(By.id("org.wordpress.android:id/nux_username"),10);
	    driver(By.id("org.wordpress.android:id/nux_username")).sendKeys("vodqa@gmail.com");
		driver(By.id("org.wordpress.android:id/nux_password")).sendKeys("Hello12345678");
		driver(By.name("Sign in")).click();
		Thread.sleep(5000);
		Dimension size = driver.manage().window().getSize(); 
		int  startx= (int) (size.width * 0.9); 
		int endx= (int) (size.width * 0.20); 
		int starty = size.height / 2; 
		driver.swipe(startx, starty, endx, starty, 1000);
	}

	public WebElement driver(By by) {
		return driver.findElement(by);

	}
    
	public void waitForElementClickable(By by,int waitTime){
	WebDriverWait wait = new WebDriverWait(driver, waitTime);
    wait.until(ExpectedConditions.elementToBeClickable(by));
	
}
}
