package pageObject.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by saikrisv on 25/08/16.
 */
public class WelcomePageObjects {
    @AndroidFindBy(id="org.wordpress.android:id/my_site_title_label") public MobileElement welcomeHeader;
    @AndroidFindBy(id="org.wordpress.android:id/fab_button") public MobileElement clickAddPostButton;
    @AndroidFindBy(id ="org.wordpress.android:id/my_site_blog_posts_text_view") public MobileElement clickBlogPost;
}
