package testcases;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;
import pagesObject.android.LoginScreen;
import pagesObject.android.NavigationTabs;
import pagesObject.android.ProfileScreen;

public class TestsProfile extends AppiumSetUpDevices {
    LoginScreen loginscreen;
    NavigationTabs navigation;
    ProfileScreen profilescreen;

    @Test

    public void SectionShortCuts() throws InterruptedException {
        for (AppiumDriver appiumDriver : drivers) {
            loginscreen = new LoginScreen(appiumDriver);
            navigation = new NavigationTabs(appiumDriver);
            profilescreen = new ProfileScreen(appiumDriver);

            {
               // loginscreen.validCredentials();
                navigation.tapOnProfileTab();
                profilescreen.checkAllShortcutsVisible();
            }
        }
    }

    @Test
    public void SectionAccount() throws InterruptedException {
        for (AppiumDriver appiumDriver : drivers) {
            loginscreen = new LoginScreen(appiumDriver);
            navigation = new NavigationTabs(appiumDriver);
            profilescreen = new ProfileScreen(appiumDriver);

            {
               //loginscreen.validCredentials();
                navigation.tapOnProfileTab();
                profilescreen.checkAccountSubsectionsVisible();
            }
        }
    }

    @Test
    public void OrderHistoryMoreDetails() throws InterruptedException {
        for (AppiumDriver appiumDriver : drivers) {
            loginscreen = new LoginScreen(appiumDriver);
            navigation = new NavigationTabs(appiumDriver);
            profilescreen = new ProfileScreen(appiumDriver);

            {
               // loginscreen.validCredentials();
                navigation.tapOnProfileTab();
                profilescreen.openOrderHistory();
              //  profilescreen.orderHistoryMoreDetails();

            }
        }
    }

    @Test

    public void locationSettings() throws InterruptedException {
        for (AppiumDriver appiumDriver : drivers) {
            loginscreen = new LoginScreen(appiumDriver);
            navigation = new NavigationTabs(appiumDriver);
            profilescreen = new ProfileScreen(appiumDriver);

            {
              //  loginscreen.validCredentials();
                navigation.tapOnProfileTab();
                profilescreen.openLocationSettings();
            }

        }
    }


}
