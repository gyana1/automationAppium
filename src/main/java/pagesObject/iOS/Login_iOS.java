package pagesObject.iOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.IOSGestures;

public class Login_iOS extends IOSGestures {
    IOSDriver driver;

    public Login_iOS(IOSDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
     @iOSXCUITFindBy(accessibility = "username")
    private WebElement username;

}
