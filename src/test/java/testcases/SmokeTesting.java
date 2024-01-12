package testcases;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;
import pagesObject.android.LoginScreen;
import pagesObject.android.NavigationTabs;
import pagesObject.android.NewsfeedScreen;
import pagesObject.android.ProfileScreen;

public class SmokeTesting extends AppiumSetUpDevices {
    NewsfeedScreen newsfeedScreen;
    LoginScreen loginscreen;
    NavigationTabs navigation;
    ProfileScreen profilescreen;

    @Test

    public void mainScreens(String name,String pass) {

        for (AppiumDriver appiumDriver : drivers) {
            newsfeedScreen = new NewsfeedScreen(appiumDriver);
            loginscreen = new LoginScreen(appiumDriver);
            navigation = new NavigationTabs(appiumDriver);
            profilescreen = new ProfileScreen(appiumDriver);
            {

                loginscreen.validCredentials(name,pass);
              //  newsfeedScreen.swipeStories();
                newsfeedScreen.openStories();
                newsfeedScreen.listBroadcasts();
                navigation.tapOnActivityTab();
                navigation.tapOnActionsTab();

                navigation.tapOnCommunityTab();
                navigation.tapOnProfileTab();
                profilescreen.logOut();


            }
    }

}}
