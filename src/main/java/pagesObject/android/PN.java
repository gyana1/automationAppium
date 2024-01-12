package pagesObject.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidGestures;

public class PN extends AndroidGestures {

    AppiumDriver appiumDriver;
    public PN(AppiumDriver appiumDriver) {
        super(appiumDriver);
        this.appiumDriver=appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
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
