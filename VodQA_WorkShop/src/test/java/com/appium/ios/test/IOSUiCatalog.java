package com.appium.ios.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

/**
 * Code Snippet to control Alert, Sliders and scroll
 * 
 * @author saikrisv
 *
 */
@SuppressWarnings("deprecation")
public class IOSUiCatalog {

	private IOSDriver<IOSElement> driver;

	private WebElement row;

	@Before
	public void setUp() throws Exception {
		// set up appium
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/build/");
		File app = new File(appDir, "UICatalog.app");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformVersion", "9.0");
		capabilities.setCapability("deviceName", "iPhone 6s");
		capabilities.setCapability("app", app.getAbsolutePath());
		driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(1800);
		driver.quit();
	}

	private void openMenuPosition(int index) {
		// populate text fields with two random number
		MobileElement table = (MobileElement) driver.findElementByClassName("UIATableView");
		row = table.findElementsByClassName("UIATableCell").get(index);
		row.click();
	}

	private Point getCenter(WebElement element) {

		Point upperLeft = element.getLocation();
		Dimension dimensions = element.getSize();
		return new Point(upperLeft.getX() + dimensions.getWidth() / 2, upperLeft.getY() + dimensions.getHeight() / 2);
	}

	public IOSElement findElementByIOS(String str) {
		return driver.findElement(MobileBy.IosUIAutomation(str));

	}

	@Test
	public void actionSheets() throws InterruptedException {
		findElementByIOS(".elements()[1].cells()[0]").click();
		Thread.sleep(1800);
		findElementByIOS(".elements()[1].cells()[0]").click();
		findElementByIOS(".elements()[0].elements()[2]").click();

	}

	@Test
	public void scrollDown() {
		driver.scrollTo("Steppers");
	}

	/**
	 * Method holds the slider and drags to particular point
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testSlider() throws InterruptedException {
		// go to controls
		openMenuPosition(10);
		Thread.sleep(2000);
		// get the slider
		WebElement slider = driver.findElementByClassName("UIASlider");
		assertEquals("42%", slider.getAttribute("value"));
		Point sliderLocation = getCenter(slider);
		driver.swipe(sliderLocation.getX(), sliderLocation.getY(), sliderLocation.getX() - 100, sliderLocation.getY(),
				2000);
		assertEquals("12%", slider.getAttribute("value"));
	}

	/**
	 * Method to control the Alert Modules
	 */
	@Test
	public void testAlertModal() {
		openMenuPosition(2);
		WebElement el = driver.findElementById("Simple");
		el.click();
		assertEquals("A Short Title Is Best", driver.findElementById("A Short Title Is Best").getAttribute("name"));
	}
}
