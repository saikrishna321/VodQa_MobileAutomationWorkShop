package com.appium.android.test;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;


/*
 * Code Snippet to Drag and Drop an element
 */
public class DragAndDrop {

	public static AndroidDriver<WebElement> driver;
	WebDriverWait wait;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "android");
		caps.setCapability("appPackage", "com.android.launcher3");
		caps.setCapability("appActivity", ".Launcher");
		caps.setCapability("commandTimeout", "50");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 30);
	}

	@Test(priority = 1)
	public void drapAndDropApp() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Apps")));
		MobileElement appIcon = (MobileElement) driver.findElementByAccessibilityId("Apps");
		appIcon.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name("Calculator")));
		MobileElement calc = (MobileElement) driver.findElementByName("Calculator");
		TouchAction touchAction = new TouchAction(driver);
		touchAction.press(PointOption.point(calc.getCenter().x,calc.getCenter().y)).perform().release();
		Thread.sleep(5000);
		touchAction.moveTo(driver.findElementByName("App info")).release().perform();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
