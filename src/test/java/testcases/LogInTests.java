package testcases;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;
import pageobjects.LoginScreen;
import pageobjects.NavigationTabs;
import pageobjects.ProfileScreen;

public class LogInTests extends TestBase {

	LoginScreen loginscreen;
	NavigationTabs navigation;
	ProfileScreen profilescreen;

	@Test
	public void ValidLogin() {

		for (AppiumDriver appiumDriver : drivers) {
			loginscreen = new LoginScreen(appiumDriver);
			navigation = new NavigationTabs(appiumDriver);
			profilescreen = new ProfileScreen(appiumDriver);

			{
				loginscreen.validLogin();
				navigation.tapOnProfileTab();
				profilescreen.logOut();

			}
		}
	}

	@Test
	public void multiTouchLogin() {
		for (AppiumDriver appiumDriver : drivers) {
			loginscreen = new LoginScreen(appiumDriver);
			navigation = new NavigationTabs(appiumDriver);

			{
				loginscreen.validLogin();
				//loginscreen.multiTouchLoginBtn();
			}
		}
	}


	@Test
	public void emptyLogin() {
		for (AppiumDriver appiumDriver : drivers) {
			loginscreen = new LoginScreen(appiumDriver);

			loginscreen.enterUsername("");
			loginscreen.enterPassword("");
			loginscreen.checkLgnBtnIsActive();
		}
	}

	@Test
	public void wrongPassLogin() {
		for (AppiumDriver appiumDriver : drivers) {
			loginscreen = new LoginScreen(appiumDriver);

			loginscreen.enterUsername("teamelders");
			loginscreen.enterPassword("111111");
			loginscreen.clickLogin();
			loginscreen.unableToLogin();
		}

	}

	@Test
	public void showPassword()  {
		for (AppiumDriver appiumDriver : drivers) {
			loginscreen = new LoginScreen(appiumDriver);

			loginscreen.enterPassword("123456");
			loginscreen.clickShowPass();

		}
	}

	@Test
	public void wrongUsernameLogin()  {
		for (AppiumDriver appiumDriver : drivers) {
			loginscreen = new LoginScreen(appiumDriver);

			loginscreen.enterUsername("teameldersSS");
			loginscreen.enterPassword("123456");
			loginscreen.clickLogin();
			loginscreen.unableToLogin();

		}
	}
	
	@Test
	public void allElementsExistOnTheScreen() {
		for (AppiumDriver appiumDriver : drivers) {
			loginscreen = new LoginScreen(appiumDriver);
			
			loginscreen.checkElementsOnTheScreen();
		}
		
	}

	  @Test
	  public void forgotPassword()  {

	  for (AppiumDriver appiumDriver : drivers) {
		  loginscreen = new	LoginScreen(appiumDriver);

	  loginscreen.forgotPassword();
	  loginscreen.closeChrome();

	  }
	}
}
