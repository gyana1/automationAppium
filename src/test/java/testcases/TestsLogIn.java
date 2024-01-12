package testcases;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pagesObject.android.LoginScreen;
import pagesObject.android.NavigationTabs;
import pagesObject.android.ProfileScreen;

public class TestsLogIn extends AppiumSetUpDevices{

	@DataProvider
	public Object[][] getAccounts(){
		return new Object[][]{{"galina_01","123456"},{"teamelders","123456"}};
	}
	@Test(priority = 5, dataProvider = "getAccounts")
	public void ValidLogin(String name,String pass) {

		for (AppiumDriver appiumDriver : drivers) {
			LoginScreen loginscreen = new LoginScreen(appiumDriver);
			ProfileScreen profilescreen = new ProfileScreen(appiumDriver);

			{

				loginscreen.validCredentials(name,pass);
				NavigationTabs navigation = new NavigationTabs(appiumDriver);
				navigation.tapOnProfileTab();
				profilescreen.logOut();

			}
		}
	}

	@Test(priority = 2)
	public void emptyLogin() {
		for (AppiumDriver appiumDriver : drivers) {
			LoginScreen loginscreen = new LoginScreen(appiumDriver);

			loginscreen.enterUsername("");
			loginscreen.enterPassword("");
			loginscreen.checkLgnBtnIsActive();
			System.out.println("Empty Login Passed");
		}
	}

	@Test(priority = 4)
	public void wrongPassLogin() {
		for (AppiumDriver appiumDriver : drivers) {
			LoginScreen loginscreen = new LoginScreen(appiumDriver);

			loginscreen.enterUsername("teamelders");
			loginscreen.enterPassword("111111");
			loginscreen.clickLogin();
			loginscreen.unableToLogin();
		}

	}

	@Test(priority = 6)
	public void showPassword()  {
		for (AppiumDriver appiumDriver : drivers) {
			LoginScreen loginscreen = new LoginScreen(appiumDriver);

			loginscreen.enterPassword("123456");
			loginscreen.clickShowPass();

		}
	}

	@Test(priority = 3)
	public void wrongUsernameLogin()  {
		for (AppiumDriver appiumDriver : drivers) {
			LoginScreen loginscreen = new LoginScreen(appiumDriver);

			loginscreen.enterUsername("teameldersSS");
			loginscreen.enterPassword("123456");
			loginscreen.clickLogin();
			loginscreen.unableToLogin();

		}
	}
	
	@Test(priority = 1)
	public void allElementsExistOnTheScreen() {
		for (AppiumDriver appiumDriver : drivers) {
			LoginScreen loginscreen = new LoginScreen(appiumDriver);

			loginscreen.checkElementsOnTheScreen();
			System.out.println("All elements are on the screen ");
		}
		
	}

	  @Test(priority =7)
	  public void forgotPassword()  {

	  for (AppiumDriver appiumDriver : drivers) {
		  LoginScreen loginscreen = new	LoginScreen(appiumDriver);

	  loginscreen.forgotPassword();
	  loginscreen.closeChrome();

	  }
	}
}
