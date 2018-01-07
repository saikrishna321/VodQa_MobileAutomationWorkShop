package pageobject.tests;

import org.springframework.util.Assert;
import org.testng.annotations.Test;
import pageobject.pages.LoginPage;
import pageobject.pages.WelcomePage;

/**
 * Created by saikrisv on 24/08/16.
 */
public class AddPostTest{

    private LoginPage loginPage;
    private WelcomePage welcomePage;

    @Test
    public void addPost() {
        loginPage = new LoginPage();
        welcomePage = loginPage.enterUserCredentials();
        welcomePage.waitForWelcomePage();
        String postText = welcomePage.clickOnPostButton().addTitle()
                .addPost().publishPost().clickOnBlogPosts().getPostText();
        Assert.isTrue(postText.equals("VodQAPune"));
    }
}
