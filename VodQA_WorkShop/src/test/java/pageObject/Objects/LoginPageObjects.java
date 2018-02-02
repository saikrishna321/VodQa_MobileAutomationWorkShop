package pageObject.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by saikrisv on 24/08/16.
 */
public class LoginPageObjects {
    @AndroidFindBy(id = "org.wordpress.android:id/nux_username") public MobileElement userName;
    @AndroidFindBy(id = "org.wordpress.android:id/nux_password") public MobileElement passWord;
    @AndroidFindBy(id = "org.wordpress.android:id/nux_sign_in_button") public MobileElement signIn;
}
