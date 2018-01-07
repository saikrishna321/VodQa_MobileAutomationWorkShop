package pageobject.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pageobject.objects.WelcomePageObjects;

/**
 * Created by saikrisv on 25/08/16.
 */
public class WelcomePage extends BasePage{

    private WelcomePageObjects welcomePageObjects;

    public WelcomePage() {
        welcomePageObjects = new WelcomePageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), welcomePageObjects);
    }

    public WelcomePage waitForWelcomePage(){
        waitForElement(welcomePageObjects.welcomeHeader);
        return this;
    }


    public PostPage clickOnPostButton() {
        welcomePageObjects.clickAddPostButton.click();
        return new PostPage();
    }

    public BlogPostPage clickOnBlogPosts() {
        welcomePageObjects.clickBlogPost.click();
        return new BlogPostPage();
    }

}
