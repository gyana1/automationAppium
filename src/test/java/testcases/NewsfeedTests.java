package testcases;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;
import pageobjects.*;
import pages.NewsScreen;

public class NewsfeedTests extends TestBase {
    NewsfeedScreen newsfeedScreen;
    LoginScreen loginscreen;
    NavigationTabs navigation;
    ProfileScreen profilescreen;


    @Test

    public void searchField() {

        for (AppiumDriver appiumDriver : drivers) {
             newsfeedScreen = new NewsfeedScreen(appiumDriver);
            loginscreen = new LoginScreen(appiumDriver);
            navigation = new NavigationTabs(appiumDriver);
            {

                loginscreen.validLogin();
                newsfeedScreen.clickSearch();
                newsfeedScreen.swipeAdBanners();
                navigation.tapOnProfileTab();
                profilescreen.logOut();
            }
        }

    }
}
