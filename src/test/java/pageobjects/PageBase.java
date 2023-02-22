package pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import java.time.Duration;


public class PageBase {

	AppiumDriver driver;


	public PageBase(AppiumDriver appiumDriver) {
		PageFactory.initElements(appiumDriver, this);
		driver = appiumDriver;
	}


	public void waitForVisibility(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void waitForAlertPresent(WebElement element) {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		if(wait1.until(ExpectedConditions.alertIsPresent())==null)
		    System.out.println("alert was not present");
		else {
		    System.out.println("alert was present");
	}
	}

	public void click(WebElement element) {
		waitForVisibility(element);
		element.click();
	}

	public void enterText(WebElement element, String text) {
		waitForVisibility(element);
		element.sendKeys(text);
	}

	// @AfterTest public void teardown() { if (null != driver) { driver.quit(); } }

}
