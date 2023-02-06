package pageobjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;

public class BroadcastScreen extends PageBase {
	public BroadcastScreen(AppiumDriver appiumDriver) {
		super(appiumDriver);
	}

	
	@FindBy(xpath = "/android.widget.RelativeLayout[2]/android.widget.TextView[@resource-id=\"com.pruvitint:id/txt_message\"]")
	WebElement new_brdcst;

	@FindBy(id = "com.pruvitint:id/actions_navigation")
	WebElement action_tab;

	@FindBy(id = "com.pruvitint:id/layoutBroadcasts")
	WebElement broadcasts;

	@FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Scheduled\"]")
	WebElement scheduled_tab;

	@FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Sent\"]")
	WebElement sent_tab;

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	WebElement back_btn_nav;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.ImageButton")
	WebElement create_btn;

	@FindBy(id = "com.pruvitint:id/edit_text")
	WebElement title_field;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView")
	WebElement next_btn;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Personal\"]")
	WebElement personal_recipient_group;

	@FindBy(xpath = "//android.widget.TextView[@text=\"All\"]")
	WebElement membership_all;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Customer\"]")
	WebElement membership_customer;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Promoters\"]")
	WebElement membership_promoters;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Circle of Champions\"]")
	WebElement membership_coc;

	@FindBy(xpath = "//android.widget.TextView[@text=\"MVP\"]")
	WebElement membership_mvp;

	@FindBy(xpath = "//android.widget.TextView[@text=\"100k Champions+\"]")
	WebElement membership_100k;

	@FindBy(xpath = "//android.widget.TextView[@text=\"250k Champions+\"]")
	WebElement membership_250k;

	@FindBy(id = "com.pruvitint:id/select_all_text")
	WebElement local_all;

	 @FindBy(id = "com.pruvitint:id/immediately_text")
	 WebElement immediately_check;

	@FindBy(id = "com.pruvitint:id/action_publish")
	WebElement publish_btn;

	@FindBy(id = "com.pruvitint:id/schedule_text")
	WebElement schedule_check;

	
	
	//@FindBy(xpath="//android.view.View[@content-desc=\"" + dateStr + "\"]")
	//WebElement next_day;

	public void openBroadcasts() {

		click(broadcasts);

		Assert.assertEquals(scheduled_tab.isDisplayed(), true);
		System.out.println("There is Scheduled tab");
		Assert.assertEquals(sent_tab.isDisplayed(), true);
		System.out.println("There is Sent tab");

	}

	public void createBroadcast() {

		waitForVisibility(create_btn);
		click(create_btn);

		PageBase pagebase = new PageBase(driver);
		pagebase.waitForVisibility(title_field);
	}

	public void enterBrdcsName() {

		click(title_field);
		title_field.sendKeys("automation_testBrdc00" + Integer.toString(((new Random().nextInt(100)) + 1)));

		String brc_name = title_field.getText();
		System.out.println("Broadcast name is:" + "" + brc_name);

	}

	public void nextStepBrdcs() {
		if (next_btn.isEnabled()) {
			click(next_btn);
		}
	}

	public void selectRecipientPersonal() {
		click(personal_recipient_group);
	}

	public void selectMembershipAll() {
		click(membership_all);
		nextStepBrdcs();
	}

	public void selectMembershipCustomer() {
		click(membership_customer);
		nextStepBrdcs();

	}

	public void selectMembershipPromoter() {
		click(membership_promoters);
		nextStepBrdcs();

	}

	public void selectMembershipCircleOfChampions() {
		click(membership_coc);
		nextStepBrdcs();
	}

	public void selectMembershipMVP() {
		click(membership_mvp);
		nextStepBrdcs();
	}

	public void selectMembership100k() {
		click(membership_100k);
		nextStepBrdcs();
	}

	public void selectMembership250k() {
		click(membership_250k);
		nextStepBrdcs();
	}

	public void selectLocationAll() {
		click(local_all);
		nextStepBrdcs();
	}

	public void immediatelyPublish() {

		click(publish_btn);
		Assert.assertEquals(title_field.getText(), new_brdcst.getText());
	}

	public void schedulePublish() {
		if(schedule_check.isSelected()){
			click(publish_btn);
		}else { 
		  LocalDateTime tomorrow =  LocalDateTime.now().plusDays(1);
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		  String dateStr1  = tomorrow.format(formatter);
		//  click(next_day);
	  
	  LocalDateTime nextT= LocalDateTime.now().plusHours(1);
	  DateTimeFormatter  formatter1 = DateTimeFormatter.ofPattern("k"); 
	  String  nextHour=nextT.format(formatter1);
	  } 
		}

}
