package pageObject.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pageObject.Objects.PostPageObjects;

/**
 * Created by saikrisv on 25/08/16.
 */
public class PostPage {
    AppiumDriver driver;
    PostPageObjects postPageObjects;
    public PostPage(AppiumDriver driver) {
        this.driver = driver;
        postPageObjects = new PostPageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(driver),postPageObjects);
    }


    public PostPage addTitle(){
        postPageObjects.postTitle.sendKeys("VodQAPune");
        return this;
    }

    public PostPage addPost(){
        postPageObjects.postContent.sendKeys("VodQA Rocks!!");
        driver.navigate().back();
        return this;
    }

    public WelcomePage publishPost(){
        postPageObjects.publish.click();
        return new WelcomePage(driver);
    }
}
