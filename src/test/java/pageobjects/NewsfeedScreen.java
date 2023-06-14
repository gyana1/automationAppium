package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsfeedScreen extends PageBase {

    public NewsfeedScreen(AppiumDriver appiumDriver) {

        super(appiumDriver);
        androidDriver = (AndroidDriver)appiumDriver;
    }
    public AndroidTouchAction actions;


   // Describe elements
     @FindBy(className="android.widget.EditText")
    WebElement search;

    @FindBy(id="com.pruvitint:id/ad_banners_view_pager")
    WebElement ad_banner;
    @FindBy(id="com.pruvitint:id/more_text_view")
    WebElement ad_banner_more;
    @FindBy(id="com.pruvitint:id/more_text_view")
    WebElement more;
    @FindBy(className = "android.widget.ImageButton")
    WebElement back_arrow;
    @FindBy(xpath="//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    WebElement back_button;
    @FindBy(id="com.pruvitint:id/stories_liner_layout")
    WebElement stories;


    //
    public void clickSearch(){
        click(search);

    }
    public void SearchBroadcasts(){
        click(search);
        search.sendKeys("testBrdc");
    }

    public void checkSearchIsAvailable(){
        waitForVisibility(stories);

        if(search.isDisplayed()){
            System.out.println("The search field is there");
        } else{
            System.out.println(" The search field is not displayed on the screen ");
        }
    }

 public void checkStoriesAreaIsAvailable(){
        if(stories.isDisplayed()){
            System.out.println("There are Stories section");

        } else{
            System.out.println(" The user does not have permission to this section. Check permission in Newgen profile");
        }

 }
    public void swipeStories() {
        waitForVisibility(stories);
        swipeGesture(stories);
    }

    public void openStories() {

        WebElement slides_story = driver.findElements(By.className("android.widget.ImageView")).get(0);
        slides_story.click();
        waitForVisibility(back_arrow);
        click(back_arrow);
    }

    public void checkAdBannersIsAvailable(){
        waitForVisibility(ad_banner);
        if(ad_banner.isDisplayed()){
            System.out.println("There is AdBanners section");

        } else{
            System.out.println("No Adbanners ");
        }

    }

    public void swipeBanners() {
        waitForVisibility(ad_banner);
        swipeGesture(ad_banner);

    }

    public void listBroadcasts(){
         WebElement brds = driver.findElements(By.className("android.widget.RelativeLayout")).get(0);
         click(brds);
         waitForVisibility(back_button);
         click(back_button);



    }
}
