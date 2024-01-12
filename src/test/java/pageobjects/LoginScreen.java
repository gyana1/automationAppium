//package pageobjects;
//
//import com.google.common.collect.ImmutableMap;
//import io.appium.java_client.AppiumBy;
//import io.appium.java_client.android.nativekey.AndroidKey;
//import io.appium.java_client.pagefactory.AndroidBy;
//import io.appium.java_client.pagefactory.AndroidFindBy;
//import org.apache.commons.collections.bag.SynchronizedSortedBag;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.testng.Assert;
//import io.appium.java_client.AppiumDriver;
//
//
//public class LoginScreen  {
//
//	public LoginScreen(AppiumDriver appiumDriver) {
//		super(appiumDriver);
//	}
//
//	@AndroidFindBy(id = "com.pruvit.int:id/pruvit_spinner_image_view")
//	private WebElement pruvit_icon;
//
//	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Welcome Prüver')]")
//	private WebElement welcome_text;
//
//	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Log in with your Cloud account')]")
//	private WebElement welcome_subtext;
//
//	@AndroidFindBy(id = "com.pruvit.int:id/username_edit_text")
//	private WebElement username;
//
//	@AndroidFindBy(id = "com.pruvit.int:id/password_edit_text")
//	private WebElement password;
//
//	@AndroidFindBy(id = "com.pruvit.int:id/text_input_end_icon")
//	private WebElement show_pass;
//
//	@AndroidFindBy(id = "com.pruvit.int:id/sign_in_text_view")
//	private WebElement login_btn;
//
//	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Switch or close tabs\"]")
//	private WebElement tabs_browser;
//
//	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"More options\"]")
//	private WebElement dots_menu;
//
//	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Close all tabs\"]")
//	private WebElement close_all_tabs;
//
//	@AndroidFindBy(id = "android:id/content")
//	private WebElement update_msg;
//
//	@AndroidFindBy(id = "android:id/button2")
//	private WebElement later_btn;
//
//	@AndroidFindBy(id = "com.pruvit.int:id/profile_navigation")
//	private WebElement profile_tab;
//
//	@AndroidFindBy(id = "com.pruvit.int:id/logout_container")
//	private WebElement logout_btn;
//
//	@AndroidFindBy(id = "com.pruvit.int:id/alertTitle")
//	private WebElement alertText;
//
//	@AndroidFindBy(id = "com.pruvit.int:id/alertTitle")
//	private WebElement alertInfo;
//
//	@AndroidFindBy(id = "android:id/message")
//	private WebElement engine_failed;
//
//	@AndroidFindBy(id = "android:id/button2")
//	private WebElement close_btn;
//
//	@AndroidFindBy(id="com.pruvit.int:id/forgot_password_linear_layout")
//	private WebElement linkResetPass;
//
//	@AndroidFindBy(id= "com.android.chrome:id/url_bar")
//	private WebElement chrome_forgotpass;
//
//	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView[2]")
//	private WebElement skip;
//
//	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView[1]")
//	private WebElement wheel;
//
//	@AndroidFindBy(xpath="(//android.widget.Toast)[1]")
//	private WebElement toastMessage;
//
//	public void enterUsername(String userName) {
//		waitForVisibility(username);
//		if (username.isDisplayed()) {
//			click(username);
//			enterText(username, userName);
//			driver.hideKeyboard();
//		}
//	}
//
//	public void checkElementsOnTheScreen() {
//
//		waitForVisibility(pruvit_icon);
//
//		Assert.assertEquals(pruvit_icon.isDisplayed(), true);
//		System.out.println("\033[0m Welcome Prüver icon is displayed \033[0m\n");
//
//		String welcome_txt = welcome_text.getText();
//
//		Assert.assertEquals(welcome_txt, "Welcome Prüver");
//		System.out.println("Welcome Prüver text is displayed");
//
//		Assert.assertEquals(welcome_subtext.isDisplayed(), true);
//		Assert.assertEquals(welcome_subtext.getText(), "Log in with your Cloud account");
//		System.out.println("Log in with your Cloud account text is displayed");
//
//	}
//
//	public void skipPruvitWheel() {
//
//			if(wheel.isDisplayed()){
//			System.out.println("skip is dispayed");
//			click(skip);
//			System.out.println("skip clicked");
//
//		}
//	}
//
//	public void enterPassword(String userPass) {
//		waitForVisibility(password);
//		if (password.isDisplayed()) {
//			click(password);
//			enterText(password, userPass);
//
//		}
//	}
//
//	public void clickLogin() {
//		click(login_btn);
//	}
//
//	public void clickShowPass() {
//		click(show_pass);
//	}
//
//	public void closeChrome() {
//		waitForVisibility(chrome_forgotpass);
//
//		//Assert.assertEquals(chrome_forgotpass,"https://cloud.justpruvit.com/auth/forgot");
//
//		driver.navigate().back();
//
//	}
//
//	public void checkLgnBtnIsActive() {
//
//		if (login_btn.isEnabled()) {
//			login_btn.click();
//		} else {
//			driver.close();
//		}
//	}
//
//	public void updateAppLater() {
//			if(update_msg.isDisplayed()){
//			Alert alert = driver.switchTo().alert();
//			alert.dismiss();}
//
//	}
//
//
//	public void unableToLogin() {
//
//		waitForAlertPresent(alertInfo);
//
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
//	}
//
//	public void validLogin(){
//		enterUsername("teamelders");
//		enterPassword("123456");
//		clickLogin();
//		Thread.sleep(5000);
//	}
//
//	public void forgotPassword(){
//		click(linkResetPass);
//	}
//}
