package pagesObject.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidGestures;

public class NavigationTabs extends AndroidGestures {

	AppiumDriver appiumDriver;
	public NavigationTabs(AppiumDriver appiumDriver) {
		super(appiumDriver);
		this.appiumDriver=appiumDriver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	//Navigation tabs
	@AndroidFindBy(id="com.pruvit.int:id/news_navigation")
	WebElement newsfeed_tab;
	@AndroidFindBy(id="com.pruvit.int:id/activity_navigation")
	WebElement activity_tab;
	@AndroidFindBy(id="com.pruvit.int:id/actions_navigation")
	WebElement actions_tab;
	@AndroidFindBy(id="com.pruvit.int:id/community_navigation")
	WebElement community_tab;

	@AndroidFindBy(id="com.pruvit.int:id/profile_navigation")
	private WebElement profile_tab;

	@AndroidFindBy(id="com.pruvit.int:id/user_name_text_view")
	WebElement profile_username;
	@AndroidFindBy(id="com.pruvit.int:id/activity_list")
	WebElement activity_list;
	@AndroidFindBy(id="com.pruvit.int:id/layoutShare")
	WebElement actions_sharelist;

	@AndroidFindBy(id="com.pruvit.int:id/placeholderLayout")
	WebElement community_leads;
	public void tapOnNewsTab() {
		click(newsfeed_tab);
		waitForVisibility(newsfeed_tab);
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
		waitForVisibility(profile_tab);
		System.out.println("profile is visible");
		click(profile_tab);
	}
	public void tapOnCommunityTab(){
		click(community_tab);
		waitForVisibility(community_leads);
	}

}
