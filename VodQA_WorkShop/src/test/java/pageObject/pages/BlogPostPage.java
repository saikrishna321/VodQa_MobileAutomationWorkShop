package pageobject.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by saikrisv on 25/08/16.
 */
public class BlogPostPage extends BasePage implements IPageFactory{

    @AndroidFindBy(xpath = ".//*[@text='VodQAPune']")
    public MobileElement verifyPost;

    @Override
    public void initElements() {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public String getPostText() {
        waitForElement(verifyPost);
        return verifyPost.getText();
    }

}
