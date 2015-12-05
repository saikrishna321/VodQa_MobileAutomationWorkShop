package com.appium.ios.test;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import static org.junit.Assert.assertTrue;

public class RecipeTest {
	private AppiumDriver<IOSElement> driver;

	@Before
	public void setUp() throws Exception {
		
		// set up appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
		capabilities.setCapability(MobileCapabilityType.APP,"/Users/smrititu/Desktop/smriti/vodqa/SimulatorApp/Recipes.app");
		driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void addRecipe() throws InterruptedException {
		
		//click on add recipe (using accessibility id)
		driver.findElementByAccessibilityId("Add").click();
		Thread.sleep(3000);
		
		//add recipe  (using  id)
		driver.findElementById("Recipe Name").sendKeys("TestRecipe");
		
		//save recipe (using xpath)
		driver.findElementByXPath("//UIAApplication[1]/UIAWindow[2]/UIANavigationBar[1]/UIAButton[3]").click();
		Thread.sleep(5000);
		
		//navigate to home page
		driver.findElementByAccessibilityId("Recipes").click();
		Thread.sleep(5000);
	}
	
	
	@Test
	public void touchActionTest() throws InterruptedException {
		//edit a receipe
		driver.findElementById("Chocolate Cake").click();
		driver.findElementById("Edit").click();
		
		//drag and drop 
		MobileElement first_el = driver.findElement(MobileBy.IosUIAutomation(".elements()[1].cells()[1].buttons()[1]"));
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(first_el, 10000);
		touchAction.moveTo(driver.findElement(MobileBy.IosUIAutomation(".elements()[1].cells()[4].buttons()[1]")))
				.release().perform();
		Thread.sleep(5000);
	}
}

