package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;

public class ActivityScreen extends PageBase{
		
		
	

	public ActivityScreen(AppiumDriver appiumDriver) {
		super(appiumDriver);
		// TODO Auto-generated constructor stub
	}
	WebDriver driver;
	  AppiumDriver appiumDriver;
		  
	  @FindBy(id="com.pruvitint:id/actions_navigation")
	  private WebElement actions_tab;
	  @FindBy(id="com.pruvitint:id/layoutBroadcasts")
	  private WebElement brdcst_option;
	  
	  
}
