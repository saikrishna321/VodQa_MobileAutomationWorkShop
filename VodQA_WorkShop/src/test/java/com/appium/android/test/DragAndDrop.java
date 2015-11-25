package com.appium.android.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class DragAndDrop {

	public static AndroidDriver<WebElement> driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "emulator-5554");
		caps.setCapability("appPackage", "com.android.launcher3");
		caps.setCapability("appActivity", ".Launcher");
		caps.setCapability("commandTimeout", "50");
		caps.setCapability("platformVersion", "5.0.2");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	}

	@Test(priority = 1)
	public void drapAndDropApp() throws InterruptedException {
		Thread.sleep(5000);
		MobileElement appIcon = (MobileElement) driver.findElementByAccessibilityId("Apps");
		appIcon.click();
		Thread.sleep(1000);
		MobileElement calc = (MobileElement) driver.findElementByName("Calculator");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.press(calc).perform();
		Thread.sleep(5000);
		touchAction.moveTo(driver.findElementByName("App info")).release().perform();
		Thread.sleep(5000);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
