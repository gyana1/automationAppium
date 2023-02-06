package testcases;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;
import pageobjects.BroadcastScreen;
import pageobjects.LoginScreen;
import pageobjects.NavigationTabs;

public class BroadcastsTests extends TestBase {

	BroadcastScreen broadcastscreen;
	LoginScreen loginscreen;
	NavigationTabs navigation;

	@Test
	public void Broadcasts() {

		for (AppiumDriver appiumDriver : drivers) {
			loginscreen = new LoginScreen(appiumDriver);
			broadcastscreen = new BroadcastScreen(appiumDriver);
			navigation = new NavigationTabs(appiumDriver);
			
			{

				loginscreen.validLogin();
				navigation.tapOnActionsTab();
				broadcastscreen.openBroadcasts();
				

			}
		}
	}

	@Test
	public void createBroadcast() {
		for (AppiumDriver appiumDriver : drivers) {
			loginscreen = new LoginScreen(appiumDriver);
			broadcastscreen = new BroadcastScreen(appiumDriver);
			{

				Broadcasts();
				
				broadcastscreen.createBroadcast();
				broadcastscreen.enterBrdcsName();
				broadcastscreen.nextStepBrdcs();
				broadcastscreen.selectRecipientPersonal();
				broadcastscreen.selectMembershipAll();
				broadcastscreen.selectLocationAll();
				broadcastscreen.nextStepBrdcs();
				broadcastscreen.immediatelyPublish();
				
			}
		}
	}
	
	public void checkBranchFilter() {
		for (AppiumDriver appiumDriver : drivers) {
			loginscreen = new LoginScreen(appiumDriver);
			broadcastscreen = new BroadcastScreen(appiumDriver);
			{
				
				
			}
			}
	}

	/*
	 * @Test public void openBroadcasts()throws InterruptedException,
	 * MalformedURLException { validLogin("teamelders","123456");
	 * 
	 * driver.findElement(By.id("com.pruvitint:id/actions_navigation")).click();
	 * driver.findElement(By.id("com.pruvitint:id/layoutBroadcasts")).click(); }
	 * 
	 * 
	 * @Test
	 * 
	 * public void createBroadcast() throws InterruptedException,
	 * MalformedURLException {
	 * 
	 * openBroadcasts();
	 * 
	 * driver.findElement(By.xpath(
	 * "/hierarchy/android.widget.FrameLayout/android.widget.ImageView")).click();
	 * 
	 * //Enter Text for BCs Thread.sleep(2000);
	 * driver.findElement(By.id("com.pruvitint:id/edit_text")).click();
	 * driver.findElement(By.id("com.pruvitint:id/edit_text")).sendKeys(
	 * "new_Broadcast00"+ Integer.toString(((new Random().nextInt(10))+1)));
	 * 
	 * //Next Thread.sleep(2000);
	 * driver.findElement(By.id("com.pruvitint:id/menu_action_next")).click();
	 * --------------------------------------- //Select recipients
	 * Thread.sleep(2000); driver.findElement(By.xpath(
	 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.ImageView[2]"
	 * )).click();
	 * 
	 * //Membership Thread.sleep(2000); driver.findElement(By.xpath(
	 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[1]"
	 * )).click(); //Locations ALL
	 * driver.findElement(By.id("com.pruvitint:id/select_all_text")).click();
	 * 
	 * //Next Thread.sleep(2000);
	 * driver.findElement(By.id("com.pruvitint:id/action_next")).click();
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @Test public void newBroadcastPublished()throws InterruptedException,
	 * MalformedURLException {
	 * 
	 * createBroadcast(); //Publish Immediately Thread.sleep(2000);
	 * driver.findElement(By.id("com.pruvitint:id/action_publish")).click(); }
	 * 
	 * @Test public void newBroadcastScheduled()throws InterruptedException,
	 * MalformedURLException {
	 * 
	 * createBroadcast();
	 * 
	 * driver.findElement(By.id("com.pruvitint:id/schedule_text")).click();
	 * Thread.sleep(2000);
	 * 
	 * LocalDateTime tomorrow = LocalDateTime.now().plusDays(1); DateTimeFormatter
	 * formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy"); String dateStr =
	 * tommorow.format(formatter);
	 * driver.findElement(By.xpath("//android.view.View[@content-desc=\"" + dateStr
	 * + "\"]")).click(); driver.findElement(By.id("android:id/button1")).click();
	 * Thread.sleep(2000);
	 * 
	 * LocalDateTime nextT= LocalDateTime.now().plusHours(1); DateTimeFormatter
	 * formatter1 = DateTimeFormatter.ofPattern("k"); String
	 * nextHour=nextT.format(formatter1);
	 * 
	 * driver.findElement(By.xpath(
	 * "//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\""
	 * + nextHour + "\"]")).click();
	 * driver.findElement(By.id("android:id/button1")).click();
	 * driver.findElement(By.id("com.pruvitint:id/action_publish")).click(); }
	 * 
	 * //EDIT Scheduled BROADCAST
	 * 
	 * //Open 3dots menu
	 * 
	 * @Test public void openToEditBroadcast() throws InterruptedException,
	 * MalformedURLException{ openBroadcasts(); WebDriverWait wait = new
	 * WebDriverWait(driver,Duration.ofSeconds(5));
	 * wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
	 * "//android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.ImageView"
	 * )));
	 * 
	 * driver.findElement(By.xpath(
	 * "//android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.ImageView"
	 * )).click(); Thread.sleep(1000); if
	 * (driver.findElement(By.id("com.pruvitint:id/more")).isEnabled()) {
	 * driver.findElement(By.id("com.pruvitint:id/more")).click();
	 * Thread.sleep(1000); } }
	 * 
	 * 
	 * //Sharing
	 * 
	 * @Test public void allowOrDisallowSharingBroadcast () throws Exception {
	 * 
	 * openToEditBroadcast();
	 * 
	 * if(driver.findElement(By.
	 * xpath("//android.widget.TextView[@text='Allow sharing']")).isDisplayed()) {
	 * driver.findElement(By.
	 * xpath("//android.widget.TextView[@text='Allow sharing']")).click(); }else {
	 * driver.findElement(By.
	 * xpath("//android.widget.TextView[@text='Disallow Sharing']")).click(); }
	 * 
	 * }
	 * 
	 * //Message Recipients
	 * 
	 * @Test public void messageRecipients() throws Exception, InterruptedException
	 * { openToEditBroadcast(); driver.findElement(By.
	 * xpath("//android.widget.TextView[@text='Message recipients']")).click();
	 * Assert.assertEquals(driver.findElement(By.id("com.pruvitint:id/alertTitle")).
	 * isDisplayed(), true); System.out.print("Message recipients dialog");
	 * driver.findElement(By.id("android:id/button1")).click();
	 * 
	 * } //Edit Broadcast
	 * 
	 * @Test public void editNameBroadcast() throws InterruptedException,
	 * MalformedURLException{
	 * 
	 * openToEditBroadcast(); Thread.sleep(1000); driver.findElement(By.
	 * xpath("//android.widget.TextView[@text='Edit broadcast']")).click();
	 * 
	 * driver.findElement(By.id("com.pruvitint:id/edit_text")).clear();
	 * driver.findElement(By.id("com.pruvitint:id/edit_text")).
	 * sendKeys("The broadcast was edited");
	 * driver.findElement(By.id("com.pruvitint:id/action_save")).click(); }
	 * 
	 * //Reschedule
	 * 
	 * @Test public void rescheduleBroadcast() throws InterruptedException,
	 * MalformedURLException{
	 * 
	 * openToEditBroadcast(); } //Duplicate
	 * 
	 * @Test public void duplicateBroadcast() throws InterruptedException,
	 * MalformedURLException{
	 * 
	 * openToEditBroadcast(); }
	 * 
	 * //Delete Message
	 * 
	 * @Test public void deleteMessage()throws InterruptedException,
	 * MalformedURLException{
	 * 
	 * openToEditBroadcast(); }
	 */

}
