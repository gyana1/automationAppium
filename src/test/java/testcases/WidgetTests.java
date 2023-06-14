package testcases;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;
import pageobjects.LoginScreen;
import pageobjects.WidgetScreen;

public class WidgetTests extends TestBase {
    WidgetScreen widgetscreen;
    @Test
    public void openWidgetsFromPopUp() throws Throwable {
        for (AppiumDriver appiumDriver : drivers) {
            widgetscreen = new WidgetScreen(appiumDriver);
            {
                widgetscreen.longPressToOpenWidgets();
                widgetscreen.addWidgets();
                widgetscreen.navigateToPruvitWidget();


            }
        }
    }

}
