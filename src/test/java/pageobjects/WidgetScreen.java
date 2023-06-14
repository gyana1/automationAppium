package pageobjects;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.Duration;
//Only Pro users are able to add Pruvit Pulse widget
public class WidgetScreen extends PageBase {

    public WidgetScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @FindBy(id = "com.google.android.apps.nexuslauncher:id/deep_shortcuts_container")
    WebElement widget_popup;
    @FindBy(xpath = "//android.widget.LinearLayout/android.widget.FrameLayout[2]")
    WebElement widget_option;
    @FindBy(xpath="//android.widget.TextView[@content-desc=\"Pulse Demo\"]")
    WebElement pruvitdemo;

    public void longPressToOpenWidgets() throws Throwable {

        longPress(800,600);
        waitForVisibility(widget_popup);

        if(widget_popup.isDisplayed()){
            System.out.println("Widget popUp appears");
         }
        }

        public void addWidgets(){
        click(widget_option);
        }

        public void navigateToPruvitWidget(){

         scrollToElement(pruvitdemo);
        }


}
