package com.appium.android.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/*
 * Code Snippet to scroll to element with UIAutomator commands
 */
public class ScrollElement {

	public static AppiumDriver<MobileElement> driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "emulator-5554");
		caps.setCapability("appPackage", "com.android.settings");
		caps.setCapability("appActivity", ".Settings");
		caps.setCapability("commandTimeout", "50");
		caps.setCapability("platformVersion", "5.0.2");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	}

	@Test(priority = 1)
	public void scrollElement() throws InterruptedException {
		scrollToElement("Accounts");
	}

	@Test(priority = 2)
	public void scrollToExact() {
		scrollToExactElement("About phone");
	}
	
	public void scrollToElement(String str) {
		((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ str + "\").instance(0))");
	}

	public void scrollToExactElement(String str) {
		((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
						+ str + "\").instance(0))");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
