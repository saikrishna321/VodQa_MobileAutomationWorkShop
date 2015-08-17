package com.appium.ios.test;

import java.io.File;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class WordPress {
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
	    public void testApp() throws InterruptedException{
	     driver.findElement(By.className("UIATextField")).sendKeys("calabash");
	     driver.findElement(By.className("UIASecureTextField")).sendKeys("password");
	     driver.findElement(By.xpath(".//*[@name='Add Self-Hosted Site']")).click();
	     driver.findElement(By.xpath(".//*[@value='Site Address (URL)']")).sendKeys("ec2-54-82-18-238.compute-1.amazonaws.com/wordpress");
	     driver.findElement(By.xpath(".//*[@name='Add Site']")).click();
	    }
}
