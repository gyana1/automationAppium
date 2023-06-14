package testcases;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;
import pageobjects.LoginScreen;
import pageobjects.NavigationTabs;
import pageobjects.NewsfeedScreen;
import pageobjects.ProfileScreen;

public class SmokeTesting extends TestBase{
    NewsfeedScreen newsfeedScreen;
    LoginScreen loginscreen;
    NavigationTabs navigation;
    ProfileScreen profilescreen;

    @Test

    public void mainScreens() {

        for (AppiumDriver appiumDriver : drivers) {
            newsfeedScreen = new NewsfeedScreen(appiumDriver);
            loginscreen = new LoginScreen(appiumDriver);
            navigation = new NavigationTabs(appiumDriver);
            profilescreen = new ProfileScreen(appiumDriver);
            {

                loginscreen.validLogin();
                newsfeedScreen.swipeStories();
                newsfeedScreen.openStories();
                newsfeedScreen.swipeBanners();
                newsfeedScreen.listBroadcasts();
                navigation.tapOnActivityTab();
                navigation.tapOnActionsTab();

                navigation.tapOnCommunityTab();
                navigation.tapOnProfileTab();
                profilescreen.logOut();


            }
    }

}}
