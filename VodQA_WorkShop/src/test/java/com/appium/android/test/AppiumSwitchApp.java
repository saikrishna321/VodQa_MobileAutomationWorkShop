package com.appium.android.test;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/*
 * Code Snippet to Switch between two applications, the below code would run on genymotion
 * not on real device as the appPackage and appActivity would differ.
 */
public class AppiumSwitchApp {

	public static AndroidDriver<WebElement> driver;
	public static String ContactName = "Sms User";

	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "emulator-5554");
		caps.setCapability("appPackage", "com.android.contacts");
		caps.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
		caps.setCapability("commandTimeout", "50");
		caps.setCapability("platformVersion", "5.0.2");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	}

	/*
	 * This Method would open the Contact app and add a new contact
	 */
	@Test(priority = 1)
	public void addNewContacts() throws InterruptedException {
		Thread.sleep(3000);
		//System.out.println(driver.getNetworkConnection());
		System.out.println("Application opened");
		driver.findElement(By.id("com.android.contacts:id/floating_action_button")).click();
		driver.findElement(By.xpath(".//*[@text='Name']")).sendKeys("VodQa");
		List<WebElement> el = driver.findElements(By.xpath("//*[@class='android.widget.EditText']"));
		el.get(1).sendKeys("9986923423");
		driver.findElement(By.id("com.android.contacts:id/save_menu_item")).click();
	}

	/*
	 * This method would open SMS app and send text message for the contact
	 * added above
	 */
	@Test(priority = 2)
	public void sendMessage() throws InterruptedException {
		Activity activity = new Activity("com.android.mms",".ui.ComposeMessageActivity");
		driver.startActivity(activity);
		driver.findElement(By.id("com.android.mms:id/recipients_editor")).sendKeys("VodQa");
		Thread.sleep(1500);
		driver.findElement(By.id("com.android.mms:id/history")).click();
		driver.findElement(By.id("com.android.mms:id/embedded_text_editor")).sendKeys("Testing Appium VodQa");
		Thread.sleep(3000);
	}

	/*
	 * This Method would switch back to contacts and delete the added contact
	 */

	@Test(priority = 3)
	public void deleteContact() {
		Activity activity = new Activity("com.android.contacts","com.android.contacts.activities.PeopleActivity");
		driver.startActivity(activity);
		driver.findElement(By.name("VodQa")).click();
		driver.findElement(By.id("com.android.contacts:id/menu_edit")).click();
		driver.findElement(By.xpath(".//*[@content-desc='More options']")).click();
		driver.findElement(By.name("Delete")).click();
		driver.findElement(By.id("android:id/button1")).click();
		List<WebElement> list = driver.findElements(By.name("VodQa"));
		Assert.assertTrue(list.size() == 0, "Contact Could not be deleted");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
