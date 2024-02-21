package testcases;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pagesObject.android.LoginScreen;
import pagesObject.android.NavigationTabs;
import pagesObject.android.NewsfeedScreen;
import pagesObject.android.ProfileScreen;

public class SmokeTesting extends AppiumSetUpDevices {
    @DataProvider
    public Object[][] getAccounts(){
        return new Object[][]{{"galina_01","123456"},{"teamelders","123456"}};
    }

@Test(dataProvider = "getAccounts")
    public void allScreens(String name, String pass) {

        for (AppiumDriver appiumDriver : drivers) {
           NewsfeedScreen newsfeedScreen = new NewsfeedScreen(appiumDriver);
           LoginScreen loginscreen = new LoginScreen(appiumDriver);
           NavigationTabs navigation = new NavigationTabs(appiumDriver);
           ProfileScreen profilescreen = new ProfileScreen(appiumDriver);
            {

                loginscreen.validCredentials(name,pass);
              //  newsfeedScreen.swipeStories();
              //  newsfeedScreen.openStories();
              //  newsfeedScreen.listBroadcasts();
                navigation.tapOnActivityTab();
                navigation.tapOnActionsTab();
                navigation.tapOnCommunityTab();
                navigation.tapOnProfileTab();
                profilescreen.logOut();


            }
    }

}}
