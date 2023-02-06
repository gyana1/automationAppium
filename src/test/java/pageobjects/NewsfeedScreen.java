package pageobjects;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class NewsfeedScreen extends PageBase {
    public NewsfeedScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

   // Describe elements
     @FindBy(className="android.widget.EditText")
    WebElement search;

    @FindBy(id="com.pruvitint:id/stories_liner_layout")
    WebElement stories_area;

    @FindBy(id="com.pruvitint:id/ad_banners_view_pager")
    WebElement ad_banner_area;
    @FindBy(id="com.pruvitint:id/more_text_view")
    WebElement ad_banner_more;
    @FindBy(id="com.pruvitint:id/more_text_view")
    WebElement more;



    //
    public void clickSearch(){
        click(search);

    }
    public void swipeAdBanners(){

        boolean swipeAdBanner = (Boolean)
               ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.builder()
                .put("left", 100)
                .put("top", 100)
                .put("width", 200)
                .put("height", 200)
                .put( "direction","left")
                .put("percent", 0.75)
               );
    }
}
