package pageobject.tests;

import org.springframework.util.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.pages.LoginPage;
import pageobject.pages.WelcomePage;

/**
 * Created by saikrisv on 24/08/16.
 */
public class AddPostTest {

    @BeforeClass
    public void setUp() {
    }


    @AfterClass
    public void tearDown() {

    }

    @Test
    public void addPost() {

        LoginPage loginPage = new LoginPage();
        WelcomePage welcomePage = new WelcomePage();

        loginPage.initElements();
        loginPage.enterUserCredentials();

        welcomePage.initElements();
        welcomePage.waitForWelcomePage();

        String postText = welcomePage.clickOnPostButton().addTitle()
                .addPost().publishPost().clickOnBlogPosts().getPostText();
        Assert.isTrue(postText.equals("VodQAPune"));

        loginPage.cleanUp();
    }
}
