package testcases;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pagesObject.android.LoginScreen;
import pagesObject.android.NavigationTabs;
import pagesObject.android.NewsfeedScreen;
import pagesObject.android.ProfileScreen;

public class TestsNewsfeed extends AppiumSetUpDevices {
    NewsfeedScreen newsfeedScreen;
    LoginScreen loginscreen;
    NavigationTabs navigation;
    ProfileScreen profilescreen;

    @DataProvider
    public Object[][] getAccounts(){
        return new Object[][]{{"galina_01","123456"},{"teamelders","123456"}};
    }
@Test(dataProvider = "getAccounts")
public void searchField(String name, String pass){
        for (AppiumDriver appiumDriver : drivers) {
            loginscreen = new LoginScreen(appiumDriver);
            newsfeedScreen = new NewsfeedScreen(appiumDriver);
            navigation =new NavigationTabs(appiumDriver);
            profilescreen = new ProfileScreen(appiumDriver);
    }
        loginscreen.validCredentials(name,pass);
    System.out.println("bla");
        newsfeedScreen.checkSearchIsAvailable();
        newsfeedScreen.clickSearch();
        newsfeedScreen.searchBroadcasts();
        navigation.tapOnProfileTab();
        profilescreen.logOut();

    }

    @Test

    public void Stories() {

        for (AppiumDriver appiumDriver : drivers) {
            newsfeedScreen = new NewsfeedScreen(appiumDriver);

            {
                newsfeedScreen.checkSearchIsAvailable();
                newsfeedScreen.checkStoriesAreaIsAvailable();
                newsfeedScreen.openStories();
               // newsfeedScreen.swipeStories();
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
              //  newsfeedScreen.swipeBanners();
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
