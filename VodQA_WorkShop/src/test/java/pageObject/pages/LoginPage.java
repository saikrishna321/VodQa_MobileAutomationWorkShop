package pageobject.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pageobject.objects.LoginPageObjects;

/**
 * Created by saikrisv on 24/08/16.
 */
public class LoginPage extends BasePage implements IPageFactory{

    private LoginPageObjects loginPageObjects;

    @Override
    public void initElements() {
        loginPageObjects = new LoginPageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), loginPageObjects);
    }

    public void enterUserCredentials() {
        loginPageObjects.userName.sendKeys("vodqa@gmail.com");
        loginPageObjects.password.sendKeys("Hello12345678");
        loginPageObjects.signInButton.click();
    }
}
