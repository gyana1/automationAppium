package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ActivityScreen extends PageBase{

	public ActivityScreen(AppiumDriver appiumDriver) {
		super(appiumDriver);
	}
	WebDriver driver;
	AppiumDriver appiumDriver;
		  

	  @FindBy(id="com.pruvitint:id/see_all_text")
	  private WebElement see_all;
	  @FindBy(id="com.pruvitint:id/activity_title")
	  private WebElement activity_title;
	  @FindBy(id="com.pruvitint:id/time_period_text")
	  private WebElement time_period_filter;
	  @FindBy(id="com.pruvitint:id/cells_layout")
	  private WebElement highlights_cards;
	@FindBy(xpath="//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	WebElement top_back_arrow;


	  public void highlightsSeeAll(){
		  waitForVisibility(see_all);
		  click(see_all);
		  click(top_back_arrow);

	  }

	  public void highlightsListCards(){
		  WebElement cards = driver.findElements(By.className("android.view.ViewGroup")).get(1);

		  System.out.println(cards);


	  }

	  
	  
}
