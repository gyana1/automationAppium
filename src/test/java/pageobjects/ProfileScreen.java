package pageobjects;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static io.netty.util.AsciiString.contains;

public class ProfileScreen extends PageBase {
    public ProfileScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Shortcuts')]")
    WebElement section_Shortcuts;
        @FindBy(id = "com.pruvitint:id/cloud_office_container")
        WebElement shortcut_CloudOffice;
        @FindBy(id = "com.pruvitint:id/resource_center_container")
        WebElement shortcut_ResourceCenter;
        @FindBy(id = "com.pruvitint:id/rewards_container")
        WebElement shortcut_Rewards;
        @FindBy(id = "com.pruvitint:id/shop_container")
        WebElement shortcut_ShopSupplements;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Account')]")
    WebElement section_Account;
        @FindBy(id = "com.pruvitint:id/order_history_container")
        WebElement account_OrderHistory;
        @FindBy(id = "com.pruvitint:id/settings_container")
        WebElement account_Settings;
        @FindBy(id = "com.pruvitint:id/help_container")
        WebElement account_Help;
        @FindBy(id = "com.pruvitint:id/logout_container")
        WebElement account_Logout;
        @FindBy(id="com.pruvitint:id/menu_action_details")
        WebElement ord_history_more_details;


        public void tapCloudOfficeLink(){
            click(shortcut_CloudOffice);

        }
        public void tapResourceCenterLink(){
            click(shortcut_ResourceCenter);
        }
    public void tapRewardsLink(){
            click(shortcut_Rewards);
    }
    public void tapShopSupplementsLink(){
            click(shortcut_ShopSupplements);
    }

    public void tapOrderHistory(){
            click(account_OrderHistory);
    }
    public void tapSettings(){
        click(account_Settings);
    }
    public void tapHelp(){
        click(account_Help);
    }

    public void checkAllShortcutsVisible(){
        Assert.assertEquals(shortcut_CloudOffice.isDisplayed(),true);
        Assert.assertEquals(shortcut_ResourceCenter.isDisplayed(),true);
        Assert.assertEquals(shortcut_Rewards.isDisplayed(),true);
        Assert.assertEquals(shortcut_ShopSupplements.isDisplayed(),true);
        System.out.println("All shortcuts are displayed");

    }
    public void checkAccountSubsectionsVisible(){
        Assert.assertEquals(account_OrderHistory.isDisplayed(),true);
        Assert.assertEquals(account_Settings.isDisplayed(),true);
        Assert.assertEquals(account_Help.isDisplayed(),true);
        Assert.assertEquals(account_Logout.isDisplayed(),true);
        System.out.println("All subsections in Account are displayed");

    }

    public void logOut() {
        boolean canScrollMore = (Boolean)
                ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.builder()
                        .put("left", 100)
                        .put("top", 100)
                        .put("width", 200)
                        .put("height", 200)
                        .put("direction", "down")
                        .put("percent", 3.0)
                        .build()
                );

        click(account_Logout);
        System.out.println("Logout");

    }
    public void openOrderHistory(){
            click(account_OrderHistory);
            waitForVisibility(ord_history_more_details);

    }
    public void orderHistoryMoreDetails(){
            click(ord_history_more_details);

            driver.navigate().back();
    }


}
