package com.appium.ios.test;

import java.io.File;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class RecipeTouchActionTest {
	private AppiumDriver<IOSElement> driver;

	@Before
	public void setUp() throws Exception {
		// set up appium
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/build/");
		File app = new File(appDir, "Recipes.app");
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
	public void touchActionTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElementById("Chocolate Cake").click();
		driver.findElementById("Edit").click();
		MobileElement first_el = driver.findElement(MobileBy.IosUIAutomation(".elements()[1].cells()[1].buttons()[1]"));
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(first_el, 10000);
		touchAction.moveTo(driver.findElement(MobileBy.IosUIAutomation(".elements()[1].cells()[4].buttons()[1]")))
				.release().perform();
		Thread.sleep(5000);
	}
}
