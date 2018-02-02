package pageObject.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pageObject.utils.BaseTest;

/**
 * Created by saikrisv on 25/08/16.
 */
public class BlogPostPage extends BaseTest{

    AppiumDriver driver;

    @AndroidFindBy(xpath=".//*[@text='VodQAPune']") public MobileElement verifyPost;
    public BlogPostPage(AppiumDriver driver) {
        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public String getPostText(){
        waitForElement(driver,verifyPost);
        return verifyPost.getText();
    }

}
