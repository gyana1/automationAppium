package testcases;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pagesObject.android.ActivityScreen;
import pagesObject.android.LoginScreen;
import pagesObject.android.NavigationTabs;

public class TestsActivity extends AppiumSetUpDevices {
    LoginScreen loginscreen;
    NavigationTabs navigation;
    ActivityScreen activity;
    @DataProvider
    public Object[][] getAccounts(){
        return new Object[][]{{"galina_01","123456"},{"teamelders","123456"}};
    }
    @Test(dataProvider = "getAccounts")
    public void expiredPROsub(String name,String pass) {
        for (AppiumDriver appiumDriver : drivers) {
            loginscreen = new LoginScreen(appiumDriver);
            navigation = new NavigationTabs(appiumDriver);
            activity = new ActivityScreen(appiumDriver);
        }
        {
            loginscreen.validCredentials(name,pass);
            navigation.tapOnActivityTab();
            activity.refreshScreen();
            activity.toastProIsExpired();


        }
    }
}