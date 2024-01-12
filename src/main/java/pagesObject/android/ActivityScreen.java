package pagesObject.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidGestures;

public class ActivityScreen extends AndroidGestures {


	AppiumDriver appiumDriver;
	public ActivityScreen(AppiumDriver appiumDriver) {
		super(appiumDriver);
		this.appiumDriver=appiumDriver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}

		  

	  @AndroidFindBy(id="com.pruvitint:id/see_all_text")
	  private WebElement see_all;
	  @FindBy(id="com.pruvitint:id/activity_title")
	  private WebElement activity_title;
	  @FindBy(id="com.pruvitint:id/time_period_text")
	  private WebElement time_period_filter;
	  @FindBy(id="com.pruvitint:id/cells_layout")
	  private WebElement highlights_cards;
	  @FindBy(xpath="//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	  private WebElement top_back_arrow;
	  @FindBy(xpath="(//android.widget.Toast)")
	  private WebElement toastPRO;
	  @AndroidFindBy(id="com.pruvit.int:id/activity_list")
	  private WebElement activity_list;


	  public void highlightsSeeAll(){
		  waitForVisibility(see_all);
		  click(see_all);
		  click(top_back_arrow);

	  }

	  public void highlightsListCards(){
		  WebElement cards = appiumDriver.findElements(By.className("android.view.ViewGroup")).get(1);

		  System.out.println(cards);


	  }

	  public void toastProIsExpired(){
		  if (toastPRO.isEnabled()){
			  toastPRO.getAttribute("name");
			  System.out.println(toastPRO.getText());
		  }
	  }

	  public void refreshScreen(){


		  pullToRefresh(activity_list);
	  }
	  
	  
}
