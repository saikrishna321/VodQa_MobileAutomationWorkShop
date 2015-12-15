package com.appium.android.test;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

/*
 * Code Snippet to Run Appium on Mobile Browsers
 * Run the Appium server from commandline before running the test.
 */

public class AndroidWebTest {
	AppiumDriver<WebElement> driver;
	WebDriverWait wait;

	@Before
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "10.4.21.140:5555");
		capabilities.setCapability("platformVersion", "5.0.1");
		//If you want the tests on real device, make sure chrome browser is installed and change the line to 
		//capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("browserName", "browser");
		capabilities.setCapability("setJavaScriptEnabled", true);
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		wait = new WebDriverWait(driver, 30);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void runWebTest() throws Exception {
		driver.get("http://www.thoughtworks.com");
		WebElement idElement = driver.findElement(By.id("mobile-menu-title"));
		assertNotNull(idElement);
		elementHighlight(idElement);
		idElement.click();	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='mobile-menu']/li[6]/a")));
		WebElement commentElement = driver.findElement(By.xpath(".//*[@id='mobile-menu']/li[6]/a"));
		elementHighlight(commentElement);
		assertNotNull(commentElement);
		commentElement.click();
		Thread.sleep(5000);
		WebElement contact_us = driver.findElement(By.xpath(".//*[@id='footer-menu']/div/ul/li[9]/a"));
		contact_us.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='contact-us-vertical']")));
	}

	public void elementHighlight(WebElement element) throws InterruptedException, IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String oldStyle = element.getAttribute("style");
		String args = "arguments[0].setAttribute('style', arguments[1]);";
		js.executeScript(args, element, "color: yellow; border: 3px solid yellow;");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy
		// somewhere
		FileUtils.copyFile(scrFile, new File("screenshot.png"));
		Thread.sleep(1000);
		js.executeScript(args, element, oldStyle);
	}
}
