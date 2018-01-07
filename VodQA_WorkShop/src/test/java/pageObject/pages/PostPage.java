package pageobject.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pageobject.objects.PostPageObjects;

/**
 * Created by saikrisv on 25/08/16.
 */
public class PostPage  extends BasePage{

    private PostPageObjects postPageObjects;

    public PostPage() {
        postPageObjects = new PostPageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver),postPageObjects);
    }


    public PostPage addTitle(){
        postPageObjects.postTitle.sendKeys("VodQAPune");
        return this;
    }

    public PostPage addPost(){
        postPageObjects.postContent.sendKeys("VodQA Rocks!!");
        appiumDriver.navigate().back();
        return this;
    }

    public WelcomePage publishPost(){
        postPageObjects.publish.click();
        return new WelcomePage();
    }
}
