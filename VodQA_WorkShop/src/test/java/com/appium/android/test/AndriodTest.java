package com.appium.android.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.time.Duration;

/*
 * Code Snippet to run Appium Server programatically
 * Scroll/Swipe has been implemented
 * If running the test from windows please change the appium.js path @ line 39
 */

public class AndriodTest {

	private static final String Image_Scrollable = "org.wordpress.android:id/image_featured";
	public static final String PASSWORD = "org.wordpress.android:id/nux_password";
	public static final String USERNAME = "org.wordpress.android:id/nux_username";
	AppiumDriver driver;
	AppiumDriverLocalService appiumDriverLocalService;

	@Before
	public void setUp() throws MalformedURLException {
		 AppiumServiceBuilder builder = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				               .withArgument(GeneralServerFlag.LOG_LEVEL, "info").usingAnyFreePort(); /*and so on*/;
				         appiumDriverLocalService = builder.build();
				         appiumDriverLocalService.start();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.wordpress.android");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.wordpress.android.ui.WPLaunchActivity");
		caps.setCapability(MobileCapabilityType.APP,
				System.getProperty("user.dir") + "/build/wordpress.apk");
		driver = new AndroidDriver<MobileElement>(appiumDriverLocalService.getUrl(), caps);
	}

	@After
	public void tearDown() {
		driver.quit();
		appiumDriverLocalService.stop();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testLogin_Swipe_Scroll() throws InterruptedException {

		waitForElementClickable(By.id(USERNAME), 10);
		driver(By.id(USERNAME)).sendKeys("vodqa@gmail.com");
		driver(By.id(PASSWORD)).sendKeys("Hello12345678");
		driver(By.id("org.wordpress.android:id/nux_sign_in_button")).click();
		waitForElementClickable(By.id("org.wordpress.android:id/switch_site"), 30);

		// Swipe Method_1
		Dimension size = driver.manage().window().getSize();
		int startx = (int) (size.width * 0.9);
		int endx = (int) (size.width * 0.20);
		int starty = size.height / 2;
		new TouchAction(driver).press(PointOption.point(startx,starty))
				.waitAction(Duration.ofSeconds(3))
				.moveTo(PointOption.point(endx,starty)).release().perform();
		waitForElementClickable(By.id(Image_Scrollable), 10);

		driver(By.id("org.wordpress.android:id/image_featured")).click();
		waitForElementClickable(By.id("org.wordpress.android:id/menu_browse"), 10);

		driver(By.id("org.wordpress.android:id/menu_browse")).click();
	}

	public WebElement driver(By by) {
		return driver.findElement(by);

	}

	public void waitForElementClickable(By by, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.elementToBeClickable(by));

	}

}
