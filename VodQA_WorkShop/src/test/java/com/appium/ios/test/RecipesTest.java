package com.appium.ios.test;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class RecipesTest {
	private AppiumDriver<IOSElement> driver;
	WebDriverWait wait;

	/**
	 * Instantiates the {@link #driver} instance by using DesiredCapabilities
	 * which specify the 'iPhone Simulator' device and 'safari' app.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {

		// set up appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
		capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/build/Recipes.app");
		driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		wait = new WebDriverWait(driver, 30);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void addRecipe() throws InterruptedException {

		// click on add recipe (using accessibility id)
		driver.findElementByAccessibilityId("Add").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("Recipe Name")));

		// add recipe (using id)
		driver.findElementById("Recipe Name").sendKeys("TestRecipe");

		// save recipe (using xpath)
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[2]/UIANavigationBar[1]/UIAButton[3]").click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Recipes")));

		// navigate to home page
		driver.findElementByAccessibilityId("Recipes").click();
		Thread.sleep(5000);
	}

	@Test
	public void editReceipe() throws InterruptedException {
		// edit a receipe
		wait.until(ExpectedConditions.elementToBeClickable(By.id("Chocolate Cake")));
		driver.findElementById("Chocolate Cake").click();
		driver.findElementById("Edit").click();
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[2]/UIAButton[2]")
				.click();
		driver.findElement(MobileBy.IosUIAutomation(".elements()[1].cells()[0].textFields()")).click();
		driver.findElement(MobileBy.IosUIAutomation(".elements()[1].cells()[0].textFields()")).sendKeys("cheese");
		Thread.sleep(5000);

	}
}
