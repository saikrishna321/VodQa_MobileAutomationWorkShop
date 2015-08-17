package com.appiu.wearable;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AppiumWearableTest {

	public AppiumDriver<WebElement> wearableDriver;
	
	@Before
	public void setUp() throws MalformedURLException{
		
		//General Appium Config
		DesiredCapabilities caps= new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("commandTimeout", "50");
		caps.setCapability("deviceReadyTimeout", "20");
		
		//Wearbale Config
		caps.setCapability("deviceName", "emulator-5554");
		caps.setCapability("appPackage", "com.google.android.wearable.app");
		caps.setCapability("appActivity", "com.google.android.clockwork.home.HomeActivity");
		

		wearableDriver=new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4724/wd/hub"),caps);
	}
	
	@Test
	public void testWearable() throws InterruptedException{
		wearableDriver.findElement(By.xpath("//android.widget.FrameLayout[1]")).click();
		Thread.sleep(5000);
		//wearableDriver.findElement(By.name("Google")).click();
		Thread.sleep(5000);
		wearableDriver.findElement(By.name("Take a note drink more water")).click();
		//Thread.sleep(5000);
		wearableDriver.findElement(By.id("com.google.android.wearable.app:id/mic_icon")).click();
		WebElement send_text=wearableDriver.findElement(By.name("Speak now"));
		send_text.sendKeys("Appium Rocks!!!");
		Thread.sleep(5000);
		wearableDriver.findElement(By.name("Draw emoji")).click();
		wearableDriver.findElement(By.id("com.google.android.wearable.app:id/picker_button")).click();
		wearableDriver.findElement(By.id("com.google.android.wearable.app:id/candidate_0")).click();
		wearableDriver.findElement(By.id("com.google.android.wearable.app:id/picker_button")).click();
		wearableDriver.findElement(By.id("com.google.android.wearable.app:id/candidate_1")).click();	
		wearableDriver.findElement(By.id("com.google.android.wearable.app:id/done_button")).click();
		Thread.sleep(10000);
		
	}
	
	@After
	public void tearDown(){
		wearableDriver.quit();
	}

}
