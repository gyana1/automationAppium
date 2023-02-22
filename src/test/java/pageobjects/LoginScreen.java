package pageobjects;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import io.appium.java_client.AppiumDriver;


public class LoginScreen extends PageBase {

	public LoginScreen(AppiumDriver appiumDriver) {
		super(appiumDriver);
	}

	@FindBy(id = "com.pruvitint:id/pruvit_spinner_image_view")
	WebElement pruvit_icon;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Welcome Prüver')]")
	WebElement welcome_text;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Log in with your Cloud account')]")
	WebElement welcome_subtext;

	@FindBy(id = "com.pruvitint:id/username_edit_text")
	WebElement username;

	@FindBy(id = "com.pruvitint:id/password_edit_text")
	WebElement password;

	@FindBy(id = "com.pruvitint:id/text_input_end_icon")
	WebElement show_pass;

	@FindBy(id = "com.pruvitint:id/sign_in_text_view")
	WebElement login_btn;

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Switch or close tabs\"]")
	WebElement tabs_browser;

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"More options\"]")
	WebElement dots_menu;

	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"Close all tabs\"]")
	WebElement close_all_tabs;

	@FindBy(id = "android:id/content")
	WebElement update_msg;

	@FindBy(id = "android:id/button2")
	WebElement later_btn;

	@FindBy(id = "com.pruvitint:id/profile_navigation")
	WebElement profile_tab;

	@FindBy(id = "com.pruvitint:id/logout_container")
	WebElement logout_btn;

	@FindBy(id = "com.pruvitint:id/alertTitle")
	WebElement alertText;

	@FindBy(id = "com.pruvitint:id/alertTitle")
	WebElement alertInfo;

	@FindBy(id = "android:id/message")
	WebElement engine_failed;

	@FindBy(id = "android:id/button2")
	WebElement close_btn;

	@FindBy(id="com.pruvitint:id/forgot_password_linear_layout")
	WebElement linkResetPass;

	@FindBy(id= "com.android.chrome:id/url_bar")
	WebElement chrome_forgotpass;

	public void enterUsername(String userName) {
		waitForVisibility(username);
		if (username.isDisplayed()) {
			click(username);
			enterText(username, userName);
		}
	}

	public void checkElementsOnTheScreen() {

		waitForVisibility(pruvit_icon);

		Assert.assertEquals(pruvit_icon.isDisplayed(), true);
		System.out.println("\033[0m Welcome Prüver icon is displayed \033[0m\n");

		String welcome_txt = welcome_text.getText();

		Assert.assertEquals(welcome_txt, "Welcome Prüver");
		System.out.println("Welcome Prüver text is displayed");

		Assert.assertEquals(welcome_subtext.isDisplayed(), true);
		Assert.assertEquals(welcome_subtext.getText(), "Log in with your Cloud account");
		System.out.println("Log in with your Cloud account text is displayed");

	}

	public void enterPassword(String userPass) {
		waitForVisibility(password);
		if (password.isDisplayed()) {
			click(password);
			enterText(password, userPass);
		}
	}

	public void clickLogin() {
		click(login_btn);
	}

	public void clickShowPass() {
		click(show_pass);
	}

	public void closeChrome() {
		waitForVisibility(chrome_forgotpass);

		//Assert.assertEquals(chrome_forgotpass,"https://cloud.justpruvit.com/auth/forgot");

		driver.navigate().back();

	}

	public void checkLgnBtnIsActive() {

		if (login_btn.isEnabled()) {
			login_btn.click();
		} else {
			driver.close();
		}
	}

	public void updateAppLater() {

		try {
			waitForAlertPresent(update_msg);

			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (Exception e) {

		}
	}


	public void unableToLogin() {

		waitForAlertPresent(alertInfo);

		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void validLogin() {
		enterUsername("teamelders");
		enterPassword("123456");
		clickLogin();
		updateAppLater();
	}


	public void forgotPassword(){
		click(linkResetPass);
	}

/*	public void multiTouchLoginBtn(){

		TouchActions actionOne = new TouchAction();
		actionOne.press(10, 10);
		actionOne.moveTo(10, 100);
		actionOne.release();
		TouchActions actionTwo = new TouchAction();
		actionTwo.press(20, 20);
		actionTwo.moveTo(20, 200);
		actionTwo.release();
		MultiTouchAction action = new MultiTouchAction();
		action.add(actionOne);
		action.add(actionTwo);
		action.perform();
	}*/


}
