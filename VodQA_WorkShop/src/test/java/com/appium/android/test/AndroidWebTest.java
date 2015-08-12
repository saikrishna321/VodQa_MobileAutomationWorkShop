package com.appium.android.test;

import static org.junit.Assert.assertNotNull;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AndroidWebTest {
	AppiumDriver<WebElement> driver;
	@Before
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "10.4.21.140:5555");
		capabilities.setCapability("platformVersion", "5.0.1");
		capabilities.setCapability("browserName", "Chrome");
		driver=new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}

	@Test
	public void runWebTest() throws Exception {
		driver.get("http://www.thoughtworks.com");
		WebElement idElement = driver.findElement(By.id("mobile-menu-title"));
		assertNotNull(idElement);
		idElement.click();
		WebDriverWait wait_1 = new WebDriverWait(driver, 30);
		wait_1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='mobile-menu']/li[6]/a")));
		WebElement commentElement = driver.findElement(By.xpath(".//*[@id='mobile-menu']/li[6]/a"));
		assertNotNull(commentElement);
		commentElement.click();
		Thread.sleep(5000);
		WebElement contact_us = driver.findElement(By.xpath(".//*[@id='footer-menu']/div/ul/li[9]/a"));
		contact_us.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='contact-us-vertical']")));
		Thread.sleep(2000);
	}
}
