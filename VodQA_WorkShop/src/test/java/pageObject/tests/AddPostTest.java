package pageObject.tests;

import org.springframework.util.Assert;
import org.testng.annotations.Test;
import pageObject.pages.LoginPage;
import pageObject.utils.BaseTest;

/**
 * Created by saikrisv on 24/08/16.
 */
public class AddPostTest extends BaseTest {

    LoginPage loginPage;

    @Test public void addPost() {
        loginPage = new LoginPage(driver);
        String postText = loginPage.enterUserCredentials().waitForWelcomePage().clickOnPostButton().addTitle()
            .addPost().publishPost().clickOnBlogPosts().getPostText();
        Assert.isTrue(postText.equals("VodQAPune"));
    }
}
