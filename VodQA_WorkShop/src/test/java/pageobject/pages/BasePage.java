package pageobject.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by saikrisv on 24/08/16.
 */
public abstract class BasePage {
    protected AppiumDriver appiumDriver;
    protected DesiredCapabilities desiredCapabilities;
    protected WebDriverWait webDriverWait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.wordpress.android");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
                "org.wordpress.android.ui.WPLaunchActivity");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,
                System.getProperty("user.dir") + "/build/wordpress.apk");
        appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
    }

    @AfterClass
    public void tearDown() {
        appiumDriver.quit();
    }

    public void waitForElement(MobileElement id) {
        webDriverWait = new WebDriverWait(appiumDriver, 30);
        webDriverWait.until(ExpectedConditions
                .elementToBeClickable(id));
    }
}
