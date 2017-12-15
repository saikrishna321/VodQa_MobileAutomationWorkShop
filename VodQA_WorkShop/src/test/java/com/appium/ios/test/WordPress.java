package com.appium.ios.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class WordPress {
	private AppiumDriver<IOSElement> driver;

	private WebElement row;

	@Before
	public void setUp() throws Exception {
		// set up appium

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.2");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
		capabilities.setCapability(MobileCapabilityType.APP,
			System.getProperty("user.dir") + "/build/WordPress.app");
		driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testApp() throws InterruptedException {
		driver.findElementById("Username / Email").sendKeys("vodqa@gmail.com");
		driver.findElementById("Password").sendKeys("Hello12345678");
		//driver.hideKeyboard();
		driver.findElementById("Sign In").click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("new-editor-modal-dismiss-button")));
		driver.findElementById("new-editor-modal-dismiss-button").click();
		
	}
}
