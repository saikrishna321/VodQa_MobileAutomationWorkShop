package com.appium.ios.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;

import java.net.URL;

import static org.junit.Assert.*;


public class IOSWebTest {

    private WebDriver driver;

    /**
     * Instantiates the {@link #driver} instance by using DesiredCapabilities which specify the
     * 'iPhone Simulator' device and 'safari' app.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "iPhone 6s");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("browserName", "safari");
        driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),
                capabilities);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    /**
     * Navigates to http://www.thoughtworks.com and interacts with the browser.
     *
     * @throws Exception
     */
    @Test
    public void runTest() throws Exception {
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

    /**
     * Closes the {@link #driver} instance.
     *
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}