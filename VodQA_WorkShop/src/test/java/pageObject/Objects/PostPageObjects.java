package pageObject.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by saikrisv on 25/08/16.
 */
public class PostPageObjects {
    @AndroidFindBy(xpath = ".//*[@text='Title1']") //incorrect locator which will be ignored
        @AndroidFindBy(id = "org.wordpress.android:id/post_title")
    public MobileElement postTitle;

    @AndroidFindBy(id="org.wordpress.android:id/post_content") public MobileElement postContent;
    @AndroidFindBy(id="org.wordpress.android:id/menu_save_post") public MobileElement publish;
}
