package pageObject.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pageObject.Objects.LoginPageObjects;

/**
 * Created by saikrisv on 24/08/16.
 */
public class LoginPage {

    AppiumDriver driver;
    LoginPageObjects  loginPageObjects;
    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        loginPageObjects = new LoginPageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(driver),loginPageObjects);
    }

    public WelcomePage enterUserCredentials(){
        loginPageObjects.userName.sendKeys("vodqa@gmail.com");
        loginPageObjects.passWord.sendKeys("Hello12345678");
        loginPageObjects.signIn.click();
        return new WelcomePage(driver);
    }
}
