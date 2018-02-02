package pageObject.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pageObject.Objects.WelcomePageObjects;
import pageObject.utils.BaseTest;

/**
 * Created by saikrisv on 25/08/16.
 */
public class WelcomePage {

    AppiumDriver driver;
    BaseTest baseTest;
    WelcomePageObjects welcomePageObjects;

    public WelcomePage(AppiumDriver driver) {
        this.driver = driver;
        baseTest = new BaseTest();
        welcomePageObjects = new WelcomePageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(driver),welcomePageObjects);
    }

    public WelcomePage waitForWelcomePage(){
      baseTest.waitForElement(driver,welcomePageObjects.welcomeHeader);
        return this;
    }

    public PostPage clickOnPostButton(){
        welcomePageObjects.clickAddPostButton.click();
        return new PostPage(driver);
    }

    public BlogPostPage clickOnBlogPosts(){
        welcomePageObjects.clickBlogPost.click();
        return new BlogPostPage(driver);
    }

}
