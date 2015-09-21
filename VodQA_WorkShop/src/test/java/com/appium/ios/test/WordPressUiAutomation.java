package com.appium.ios.test;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class WordPressUiAutomation {
	private AppiumDriver<IOSElement> driver;

	private WebElement row;

	@Before
	public void setUp() throws Exception {
		// set up appium
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/build/");
		File app = new File(appDir, "ios.app");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformVersion", "8.4");
		capabilities.setCapability("deviceName", "iPhone 6");
		capabilities.setCapability("app", app.getAbsolutePath());
		driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testApp() throws InterruptedException {
		driver.findElement(MobileBy.IosUIAutomation(".elements().firstWithPredicate(\"value beginsWith 'Username'\")"))
				.sendKeys("calabash");
		driver.findElement(MobileBy.IosUIAutomation(".elements().firstWithPredicate(\"value beginsWith 'Password'\")"))
				.sendKeys("password");
		driver.hideKeyboard();
		findElemenetByUiAutomation(".elements()[\"Add Self-Hosted Site\"]").click();
		findElemenetByUiAutomation(".textFields().firstWithPredicate(\"value beginsWith 'Site'\")")
				.sendKeys("ec2-54-82-18-238.compute-1.amazonaws.com/wordpress");
		findElemenetByUiAutomation(".buttons()[\"Add Site\"]").click();
		Thread.sleep(3000);
		findElemenetByUiAutomation(".tableViews()[0]").click();
		Thread.sleep(3000);
		List<IOSElement> el = driver.findElements(MobileBy.IosUIAutomation(".tableViews()"));
		for(int i=0;i<=el.size();i++){
			System.out.println(el.get(i).getAttribute("name"));
		}
	}

	public IOSElement findElemenetByUiAutomation(String str) {
		return driver.findElement(MobileBy.IosUIAutomation(str));
	}
}
