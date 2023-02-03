package testcases;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;
import pageobjects.LoginScreen;
import pageobjects.NavigationTabs;
import pageobjects.ProfileScreen;

public class ProfileTests extends TestBase {
    LoginScreen loginscreen;
    NavigationTabs navigation;
    ProfileScreen profilescreen;

    @Test

    public void SectionShortCuts() {
        for (AppiumDriver appiumDriver : drivers) {
            loginscreen = new LoginScreen(appiumDriver);
            navigation = new NavigationTabs(appiumDriver);
            profilescreen = new ProfileScreen(appiumDriver);

            {
                loginscreen.validLogin();
                navigation.tapOnProfileTab();
                profilescreen.checkAllShortcutsVisible();
            }
        }
    }

    @Test
    public void SectionAccount() {
        for (AppiumDriver appiumDriver : drivers) {
            loginscreen = new LoginScreen(appiumDriver);
            navigation = new NavigationTabs(appiumDriver);
            profilescreen = new ProfileScreen(appiumDriver);

            {
                loginscreen.validLogin();
                navigation.tapOnProfileTab();
                profilescreen.checkAccountSubsectionsVisible();
            }
        }
    }
    @Test
    public void OrderHistoryMoreDetails() {
            for (AppiumDriver appiumDriver : drivers) {
                loginscreen = new LoginScreen(appiumDriver);
                navigation = new NavigationTabs(appiumDriver);
                profilescreen = new ProfileScreen(appiumDriver);

                {
                    loginscreen.validLogin();
                    navigation.tapOnProfileTab();
                    profilescreen.tapOrderHistory();
                    profilescreen.orderHistoryMoreDetails();

                }
            }

        }



}
