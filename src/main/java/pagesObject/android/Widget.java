package pagesObject.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidGestures;

//Only Pro users are able to add Pruvit Pulse widget
public class Widget extends AndroidGestures {
    AppiumDriver appiumDriver;
    public Widget (AppiumDriver appiumDriver) {
        super(appiumDriver);
        this.appiumDriver=appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    @FindBy(id = "com.google.android.apps.nexuslauncher:id/deep_shortcuts_container")
    WebElement widget_popup;
    @FindBy(xpath = "//android.widget.LinearLayout/android.widget.FrameLayout[2]")
    WebElement widget_option;
    @FindBy(xpath="//android.widget.TextView[@content-desc=\"Pulse Demo\"]")
    WebElement pruvitdemo;

    public void longPressToOpenWidgets() throws Throwable {

       // longPress(800,600);
        waitForVisibility(widget_popup);

        if(widget_popup.isDisplayed()){
            System.out.println("Widget popUp appears");
         }
        }

        public void addWidgets(){
        click(widget_option);
        }

        public void navigateToPruvitWidget(){

            scrollToText("Pulse Demo");
        }


}
