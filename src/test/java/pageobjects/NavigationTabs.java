package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;

public class NavigationTabs extends PageBase {

	public NavigationTabs(AppiumDriver appiumDriver) {
		super(appiumDriver);
	}
	
	//Navigation tabs
	@FindBy(id="com.pruvitint:id/news_navigation")
	WebElement newsfeed_tab;
	@FindBy(id="com.pruvitint:id/activity_navigation")
	WebElement activity_tab;
	@FindBy(id="com.pruvitint:id/actions_navigation")
	WebElement actions_tab;
	@FindBy(id="com.pruvitint:id/community_navigation")
	WebElement community_tab;
	@FindBy(id="com.pruvitint:id/profile_navigation")
	WebElement profile_tab;

	@FindBy(id="com.pruvitint:id/user_name_text_view")
	WebElement profile_username;

	
	public void tapOnNewsTab() {
		click(newsfeed_tab);
	}
	public void tapOnActivityTab() {
		click(activity_tab);
	}
	public void tapOnActionsTab() {
		click(actions_tab);
	}
	public void tapOnProfileTab() {
		click(profile_tab);
		waitForVisibility(profile_username);
	}
}
