package pagesObject.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.AndroidGestures;

import java.time.Duration;

import static java.lang.System.out;
import static org.testng.Assert.assertEquals;

@SuppressWarnings("ALL")
public class LoginScreen extends AndroidGestures {
	AppiumDriver appiumDriver;
	public LoginScreen(AppiumDriver appiumDriver) {
		super(appiumDriver);
		this.appiumDriver=appiumDriver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}

	@AndroidFindBy(id = "com.pruvit.int:id/pruvit_spinner_image_view")
	private WebElement pruvit_icon;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Welcome Prüver')]")
	private WebElement welcome_text;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Log in with your Cloud account')]")
	private WebElement welcome_subtext;

	@AndroidFindBy(id = "com.pruvit.int:id/username_edit_text")
	private WebElement username;

	@AndroidFindBy(id = "com.pruvit.int:id/password_edit_text")
	private WebElement password;

	@AndroidFindBy(id = "com.pruvit.int:id/text_input_end_icon")
	private WebElement show_pass;

	@AndroidFindBy(id = "com.pruvit.int:id/sign_in_text_view")
	private WebElement login_btn;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Switch or close tabs\"]")
	private WebElement tabs_browser;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"More options\"]")
	private WebElement dots_menu;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Close all tabs\"]")
	private WebElement close_all_tabs;

	@AndroidFindBy(id = "android:id/content")
	private WebElement update_msg;

	@AndroidFindBy(id = "android:id/button2")
	private WebElement later_btn;

	@AndroidFindBy(id = "com.pruvit.int:id/profile_navigation")
	private WebElement profile_tab;

	@AndroidFindBy(id = "com.pruvit.int:id/logout_container")
	private WebElement logout_btn;

	@AndroidFindBy(id = "com.pruvit.int:id/alertTitle")
	private WebElement alertInfo;

	@AndroidFindBy(id = "android:id/message")
	private WebElement alertText;

	@AndroidFindBy(id = "android:id/button2")
	private WebElement close_btn;

	@AndroidFindBy(id="com.pruvit.int:id/forgot_password_linear_layout")
	private WebElement linkResetPass;

	@AndroidFindBy(id= "com.android.chrome:id/url_bar")
	private WebElement chromeForgotpass;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView[2]")
	private WebElement skip;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView[1]")
	private WebElement wheel;

	@AndroidFindBy(xpath="(//android.widget.Toast)[1]")
	private WebElement toastMessage;

	@AndroidFindBy(id="com.pruvit.int:id/bottom_navigation")
	private WebElement bottom_nav;

	public void enterUsername(String userName) {
		waitForVisibility(username);
		if (username.isDisplayed()) {
			click(username);
			enterText(username, userName);
		}
	}
	public void checkElementsOnTheScreen() {

		waitForVisibility(pruvit_icon);

		Assert.assertTrue(pruvit_icon.isDisplayed(), String.valueOf(true));
		System.out.println("\033[0m Welcome Prüver icon is displayed \033[0m\n");

		String welcome_txt = welcome_text.getText();

		assertEquals(welcome_txt, "Welcome Prüver");
		out.println("Welcome Prüver text is displayed");

		assertEquals(welcome_subtext.isDisplayed(), true);
		assertEquals(welcome_subtext.getText(), "Log in with your Cloud account");
		out.println("Log in with your Cloud account text is displayed");

	}

	public void skipPruvitWheel() {

			if(wheel.isDisplayed()){
			out.println("skip is displayed");
			click(skip);
			out.println("skip clicked");

		}
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

		assertEquals(chromeForgotpass,"https://cloud.justpruvit.com/auth/forgot");
		appiumDriver.navigate().back();

	}

	public void checkLgnBtnIsActive() {

		if (login_btn.isEnabled()) {
			login_btn.click();
		} else {
			appiumDriver.close();
		}
	}

	public void updateAppLater() {
			if(update_msg.isDisplayed()){
			Alert alert = appiumDriver.switchTo().alert();
			alert.dismiss();}

	}


	public void unableToLogin() {

		waitForAlertPresent(alertInfo);

		Alert alert = appiumDriver.switchTo().alert();
		out.println(alertInfo.getText()+":"+" "+alertText.getText());
		alert.accept();
	}


	public void validCredentials(String name, String pass) {
		enterUsername(name);
		enterPassword(pass);
		clickLogin();
		waitForInvisibility(login_btn);
		out.println("Logged as" +" " +name);
		appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	public void forgotPassword()   {
//		waitForVisibility(linkResetPass);
//		linkResetPass.click();
//		appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//
//		out.println("web or native view");
//
//			Set<String> contexts = androidDriver.getContextHandles();
//			for (String contextView : contexts)
//			{
//				out.println(contextView);
		}



}
