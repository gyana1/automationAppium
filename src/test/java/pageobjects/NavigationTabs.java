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
	@FindBy(id="com.pruvitint:id/activity_list")
	WebElement activity_list;
	@FindBy(id="com.pruvitint:id/layoutShare")
	WebElement actions_sharelist;

	@FindBy(id="com.pruvitint:id/placeholderLayout")
	WebElement community_leads;
	public void tapOnNewsTab() {
		click(newsfeed_tab);
	}
	public void tapOnActivityTab() {
		click(activity_tab);
		waitForVisibility(activity_list);
	}
	public void tapOnActionsTab() {
		click(actions_tab);
		waitForVisibility(actions_sharelist);
	}
	public void tapOnProfileTab() {
		click(profile_tab);
		waitForVisibility(profile_username);
	}
	public void tapOnCommunityTab(){
		click(community_tab);
		waitForVisibility(community_leads);
	}


}
