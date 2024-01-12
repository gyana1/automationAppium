package testcases;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;
import pagesObject.android.Widget;

public class WidgetTests extends AppiumSetUpDevices {
    Widget widgetscreen;
    @Test
    public void openWidgetsFromPopUp() throws Throwable {
        for (AppiumDriver appiumDriver : drivers) {
            widgetscreen = new Widget(appiumDriver);
            {
                widgetscreen.longPressToOpenWidgets();
                widgetscreen.addWidgets();
                widgetscreen.navigateToPruvitWidget();


            }
        }
    }

}
