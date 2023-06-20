package pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ActionsScreen extends PageBase {
    public ActionsScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    WebDriver driver;
    AppiumDriver appiumDriver;


    @FindBy(id = "com.pruvitint:id/layoutShare")
    WebElement share_section;
    @FindBy(id = "com.pruvitint:id/layoutReach")
    WebElement reach_section;
    @FindBy(id = "com.pruvitint:id/layoutShortcuts")
    WebElement shorcuts_section;
    @FindBy(id = "com.pruvitint:id/layoutAdmin")
    WebElement admin_section;

    @FindBy(id = "com.pruvitint:id/layoutSamples")
    WebElement offers;
    @FindBy(id = "com.pruvitint:id/layoutStories")
    WebElement stories;
    @FindBy(id = "com.pruvitint:id/layoutSocial")
    WebElement social;
    @FindBy(id = "com.pruvitint:id/layoutWebsites")
    WebElement my_website;
    @FindBy(id = "com.pruvitint:id/layoutBroadcasts")
    WebElement broadcasts;
    @FindBy(id = "com.pruvitint:id/layoutPruvitTv ")
    WebElement pruvit_tv;
    @FindBy(id = "com.pruvitint:id/layoutDmoApp")
    WebElement track_daily_habits;
    @FindBy(id = "com.pruvitint:id/layoutChallenges")
    WebElement training_center;
    @FindBy(id = "com.pruvitint:id/layoutPruvitGear")
    WebElement pruvit_gear;
    @FindBy(id = "com.pruvitint:id/layoutLibrary")
    WebElement library;
    @FindBy(id = "com.pruvitint:id/layoutAdBanner")
    WebElement admin_adbanner;
    @FindBy(id = "com.pruvitint:id/layoutAdStories")
    WebElement admin_stories;
    @FindBy(id = "com.pruvitint:id/layoutAudiences")
    WebElement admin_audiences;

//offers
    @FindBy(id = "com.pruvitint:id/action_buy_samples")
    WebElement buy_credits;
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"In stock\"]")
    WebElement in_stock_tab;
    @FindBy(id = "com.pruvitint:id/buy_now_text")
    WebElement buy_now_btn;
    @FindBy(id = "//android.widget.LinearLayout[@content-desc=\"Pending (0)\"]")
    WebElement pending_tab;
    @FindBy(id = "com.pruvitint:id/recycler_view")
    WebElement no_pending_items;
    @FindBy(id = "//android.widget.LinearLayout[@content-desc=\"History\"]")
    WebElement history_tab;

    // Stories

    @FindBy(className = "android.widget.ImageView")
    WebElement stories1;

    //Socials
    @FindBy(id = "com.pruvitint:id/layoutFacebook")
    WebElement fb_link;
    @FindBy(id = "com.pruvitint:id/layoutInstagram")
    WebElement instagram_link;
    @FindBy(id = "com.pruvitint:id/layoutYouTube")
    WebElement youtube_link;

    //Admin AdBanners

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Scheduled\"]")
    WebElement adbanners_scheduled;
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Live\"]")
    WebElement adbanners_live;
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Past\"]")
    WebElement adbanners_past;
    @FindBy(id="com.pruvitint:id/plus_menu_item")
    WebElement adbanners_add;
    @FindBy(id="com.pruvitint:id/web_image_view")
    WebElement adbanners_webimage;
    @FindBy(id="com.pruvitint:id/mobile_image_view")
    WebElement adbanners_mobileimage;
    @FindBy(id="com.pruvitint:id/title_edit_text")
    WebElement adbanners_title;
    @FindBy(id="com.pruvitint:id/link_edit_text")
    WebElement adbanners_link;
    @FindBy(id="com.pruvitint:id/language_text_view")
    WebElement adbanners_language;
    @FindBy(id="com.pruvitint:id/menu_action_next")
    WebElement adbanners_next;

public void IsSectionsAreAvailable(){
    Assert.assertEquals(share_section.getText(),"Share");
    Assert.assertEquals(reach_section.getText(),"Reach");
    Assert.assertEquals(shorcuts_section.getText(),"Shortcuts");
    Assert.assertEquals(admin_section.getText(),"Admin");

}
}


