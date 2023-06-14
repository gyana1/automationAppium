package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class PN extends PageBase{
    public PN(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
//    private Dimension screenSize;
//    AppiumDriver driver;
//    WebDriver drivers = new AppiumDriver(driver);
//    public void sizeScreen(){
//        screenSize= driver.manage().window().getSize();
//        driver.close();
//
//    }
//
//    private void manageNotifications(Boolean show) {
//        int yMargin = 5;
//        int xMid = screenSize.width / 2;
//        PointOption top = PointOption.point(xMid, yMargin);
//        PointOption bottom = PointOption.point(xMid, screenSize.height - yMargin);
//
//        TouchAction action = new TouchAction(appiumDriver);
//        if (show) {
//            action.press(top);
//        } else {
//            action.press(bottom);
//        }
//        action.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)));
//        if (show) {
//            action.moveTo(bottom);
//        } else {
//            action.moveTo(top);
//        }
//        action.perform();
//    }
}
