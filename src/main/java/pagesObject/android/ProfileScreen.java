package pagesObject.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.AndroidGestures;

public class ProfileScreen extends AndroidGestures {
    AppiumDriver appiumDriver;
    public ProfileScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
        this.appiumDriver=appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
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
    @FindBy(id = "com.pruvit.int:id/settings_container")
    WebElement account_Settings;
    @FindBy(id = "com.pruvit.int:id/help_container")
    WebElement account_Help;
    @FindBy(id = "com.pruvit.int:id/logout_container")
    WebElement account_Logout;
    @FindBy(id = "com.pruvit.int:id/menu_action_details")
    WebElement ord_history_more_details;

    @FindBy(id="com.pruvit.int:id/location_settings_container")
    WebElement location_settings;

    @FindBy(id="com.pruvit.int:id/container")
    WebElement country_region;
    @FindBy(id="com.pruvit.int:id/country_container")
    WebElement country;
    @FindBy(id="com.pruvit.int:id/country_chosen_label")
    WebElement selected_country;
    @FindBy(id="com.pruvit.int:id/region_container")
    WebElement region;
    @FindBy(id="com.pruvit.int:id/region_chosen_label")
    WebElement selected_region;

    @FindBy(id="com.pruvit.int:id/image_chevron_country")
    WebElement dropdown_country;

    @FindBy(id="android:id/content")
    WebElement list_countries;

    public void tapCloudOfficeLink() {
        click(shortcut_CloudOffice);

    }

    public void tapResourceCenterLink() {
        click(shortcut_ResourceCenter);
    }

    public void tapRewardsLink() {
        click(shortcut_Rewards);
    }

    public void tapShopSupplementsLink() {
        click(shortcut_ShopSupplements);
    }

    public void tapOrderHistory() {
        click(account_OrderHistory);
    }

    public void tapSettings() {
        click(account_Settings);
    }

    public void tapHelp() {
        click(account_Help);
    }

    public void checkAllShortcutsVisible() {
        Assert.assertEquals(shortcut_CloudOffice.isDisplayed(), true);
        Assert.assertEquals(shortcut_ResourceCenter.isDisplayed(), true);
        Assert.assertEquals(shortcut_Rewards.isDisplayed(), true);
        Assert.assertEquals(shortcut_ShopSupplements.isDisplayed(), true);
        System.out.println("All shortcuts are displayed");

    }

    public void checkAccountSubsectionsVisible() {
        Assert.assertEquals(account_OrderHistory.isDisplayed(), true);
        Assert.assertEquals(account_Settings.isDisplayed(), true);
        Assert.assertEquals(account_Help.isDisplayed(), true);
        Assert.assertEquals(account_Logout.isDisplayed(), true);
        System.out.println("All subsections in Account are displayed");

    }

    public void logOut() {
       // scrollToDown();
//        boolean canScrollMore = (Boolean)
//                ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.builder()
//                        .put("left", 100)
//                        .put("top", 100)
//                        .put("width", 200)
//                        .put("height", 200)
//                        .put("direction", "down")
//                        .put("percent", 3.0)
//                        .build()
//                );

        click(account_Logout);
        System.out.println("Logout");

    }

    public void openOrderHistory() {
        click(account_OrderHistory);
        waitForVisibility(ord_history_more_details);

    }
    public void orderHistoryMoreDetails(){
        click(ord_history_more_details);

//        Set<String> contextNames = driver.getcontexthandles();
//        for (String contextName : contextNames) {
//            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
//        }

    }

    public void openLocationSettings() {
        tapSettings();
        click(location_settings);
        waitForVisibility(country_region);

        if (selected_country.isDisplayed()) {
            String selected = selected_country.getText();
            System.out.println("The country is:" + selected);
        } else {
            waitForVisibility(selected_country);
            String selected = selected_country.getText();
            System.out.println(selected);
        }

        try {
            String region1 = selected_region.getText();
            System.out.println("The region is:" + " " + region1);
        } catch (Exception e) {
            System.out.println("The country does not have regions");
        }

    }

    public void backToSettings(){

    }
    public void changeCountry(){
        click(dropdown_country);
        waitForVisibility(list_countries);
    }


}
