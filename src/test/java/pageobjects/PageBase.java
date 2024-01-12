//package pageobjects;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.pagefactory.AppiumFieldDecorator;
//import org.openqa.selenium.support.PageFactory;
//
//
//public class PageBase {
//
//
//	AppiumDriver driver;
//	protected AndroidDriver androidDriver;
//
//	public PageBase(AppiumDriver appiumDriver) {
//		driver = appiumDriver;
//		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
//	}
//
////	public void waitForVisibility(WebElement element) {
////
////		WebDriverWait wait = new WebDriverWait(driver, ofSeconds(20));
////		wait.until(ExpectedConditions.visibilityOf(element));
////
////	}
//
////	public void waitForAlertPresent(WebElement element) {
////		WebDriverWait wait1 = new WebDriverWait(driver, ofSeconds(10));
////
////		if (wait1.until(ExpectedConditions.alertIsPresent()) == null)
////			System.out.println("alert was not present");
////		else {
////			System.out.println("alert was present");
////		}
////	}
//
////	public void click(WebElement element) {
////		waitForVisibility(element);
////		element.click();
////	}
//
////	public void enterText(WebElement element, String text) {
////		waitForVisibility(element);
////		element.sendKeys(text);
////	}
////
////
////
////	public void swipeGesture(WebElement elements){
////		TouchAction actions = new TouchAction((PerformsTouchActions) driver);
////		int startX=elements.getLocation().getX();
////		int endX = elements.getLocation().getX()-(elements.getSize().getWidth())/2;
////		// minus Width for right to left
////		// plus Width for left to right
////
////		int startY=elements.getLocation().getY();
////		int endY = elements.getLocation().getY();
////
////		actions  = new AndroidTouchAction(androidDriver);
////		actions.press(point(startX,startY))
////				.waitAction(waitOptions(ofMillis(1000)))
////				.moveTo(point(endX, endY))
////				.release()
////				.perform();
////
////
////	}
////public void multiTouchByElement ( WebElement element) {
////	TouchAction press = new TouchAction(androidDriver)
////			.press(element(element))
////			.waitAction(waitOptions(ofSeconds(1)))
////			.release();
////	new MultiTouchAction(androidDriver)
////			.add(press)
////			.perform();
////}
////
////	public void scrollToDown(){
////		boolean canScrollMore = (Boolean)
////				((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.builder()
////						.put("left", 100)
////						.put("top", 100)
////						.put("width", 200)
////						.put("height", 200)
////						.put("direction", "down")
////						.put("percent", 3.0)
////						.build()
////				);
////	}
////
////	private void scrollDownBySG(int top){
////		boolean canScrollMore = (Boolean)
////				((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.builder()
////						.put("left",1060)
////						.put("top", top)
////						.put("width", 10)
////						.put("height", 300)
////						.put("direction", "down")
////						.put("percent", 1.0)
////						.build()
////				);
////
////		System.out.println(canScrollMore);
////	}
////
////
////	public  void scrollToElement(WebElement element) {
////		WebElement view = driver.findElement(By.id("com.google.android.apps.nexuslauncher:id/widgets_list_view"));
////		view.click();
////		boolean scrollDown = true;
////
////		int top = 120;
////		WebElement pulseDemoSection;
////
////		while (scrollDown) {
////
////			scrollDownBySG(top);
////
////			top += 300;
////			try {
////				pulseDemoSection = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Pulse Demo\"]"));
////
////				scrollDown = pulseDemoSection.getRect().y + pulseDemoSection.getSize().height < top;
////			} catch (Exception ex) {
////
////			}
////
////		}
////
////		scrollDownBySG(top);
////
////	}
////public void pullToRefresh(){
////		int deviceH= driver.manage().window().getSize().getHeight();
////		int deviceW=driver.manage().window().getSize().getWidth();
////		int midH=(deviceH/2);
////		int midW=(deviceW/2);
////		int bottomEdge=(int)( deviceH*0.85f);
////
////
////}
//}