package testcases;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.*;
import pageobjects.*;
import pages.NewsScreen;

public class NewsfeedTests extends TestBase {
    NewsfeedScreen newsfeedScreen;
    LoginScreen loginscreen;
    NavigationTabs navigation;
    ProfileScreen profilescreen;
@BeforeTest
    public void isLogin(){
        for (AppiumDriver appiumDriver : drivers) {
            loginscreen = new LoginScreen(appiumDriver);
        }
        loginscreen.validLogin();
    }
@AfterTest
    public void isLogout(){
        for (AppiumDriver appiumDriver : drivers) {
            profilescreen = new ProfileScreen(appiumDriver);
            navigation = new NavigationTabs(appiumDriver);
        }
        navigation.tapOnProfileTab();
        profilescreen.logOut();
    }

    @Test
    public void searchField(){
        for (AppiumDriver appiumDriver : drivers) {
            newsfeedScreen = new NewsfeedScreen(appiumDriver);
    }
        newsfeedScreen.checkSearchIsAvailable();
    }

    @Test

    public void Stories() {

        for (AppiumDriver appiumDriver : drivers) {
            newsfeedScreen = new NewsfeedScreen(appiumDriver);

            {
                newsfeedScreen.checkSearchIsAvailable();
                newsfeedScreen.checkStoriesAreaIsAvailable();
                newsfeedScreen.openStories();
                newsfeedScreen.swipeStories();
            }
        }

    }

    @Test
    public void AdBanners() {
        for (AppiumDriver appiumDriver : drivers) {
            newsfeedScreen = new NewsfeedScreen(appiumDriver);
            loginscreen = new LoginScreen(appiumDriver);

            {
                newsfeedScreen.checkAdBannersIsAvailable();
                newsfeedScreen.swipeBanners();
            }
        }
    }

    @Test
    public void Broadcasts() {
        for (AppiumDriver appiumDriver : drivers) {
            newsfeedScreen = new NewsfeedScreen(appiumDriver);

            {
                newsfeedScreen.listBroadcasts();
            }
        }
    }
}
