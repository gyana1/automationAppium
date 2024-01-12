package testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AppiumSetUpDevices extends AppiumServerBasic {

	public List<AppiumDriver> drivers = new ArrayList<AppiumDriver>();
@BeforeClass
	public void setUp() throws MalformedURLException {
		ConfigureAppium();
		Android_5556_emulator_setUp();
	}

@AfterClass
	public void close(){
	tearDown();
}
	public void Android_5556_emulator_setUp() throws MalformedURLException {

		System.out.println("Prepare Appium session and load Pruvit Pulse Demo app ...");

		DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("deviceName", "sdk_gphone_x86_64");
			cap.setCapability("udid", "emulator-5554");
			cap.setCapability("appium:platformName", "Android");
			cap.setCapability("appium:platformVersion", "13");
			cap.setCapability("appium:automationName", "UIAutomator2");
			cap.setCapability("appium:appPackage","com.pruvit.int");
			cap.setCapability("appium:appActivity","com.pruvit.ui.AppLoadingActivity");

		try {
			this.drivers.add(new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), cap));
			System.out.println("Connected to Emulator-5554");
		} catch (Exception e) {
			System.out.println(">>>>>>>Unable to connect to http://127.0.0.1:4723");
			return;
		}
		System.out.println("App is loaded ..........Pixel 4 API 29-5554 -emulator");

	}

	public void AndroidRealDevice_Samsung_Galaxy_A71_setUp() throws MalformedURLException {
		// Real Device Samsung Galaxy A71
		System.out.println(">>>>>>>>>>Prepare Appium session...Real Device Samsung Galaxy A71");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Galaxy A71");
		cap.setCapability("udid", "R58N80VQANP");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "12");
		cap.setCapability("appPackage", "com.pruvitint");
		cap.setCapability("appActivity", "com.pruvit.ui.AppLoadingActivity");

		try {
			this.drivers.add(new AndroidDriver(new URL("http://0.0.0.0:5000/wd/hub"), cap));
			System.out.println("Connected to Galaxy A71");
		} catch (Exception e) {
			System.out.println(">>>>>>>>>>Unable to connect to http://0.0.0.0:5000/wd/hub");
			return;
		}

		System.out.println("App is loaded ..........");
	}

	public void AndroidGalaxyS22_R5CW13ZWGGN_setUp() throws MalformedURLException {
		// Real Device Samsung GalaxyS22
		System.out.println(">>>>>>>>>>Prepare Appium session...Real Device Samsung GalaxyS22_R5CW13ZWGGN");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "GalaxyS22");
		cap.setCapability("udid", "R5CW13ZWGGN");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "13");
		cap.setCapability("appPackage", "com.pruvitint");
		cap.setCapability("appActivity", "com.pruvit.ui.AppLoadingActivity");

		try {
			this.drivers.add(new AndroidDriver(new URL("http://0.0.0.0:5001/wd/hub"), cap));
			System.out.println("Connected to Galaxy S22");
		} catch (Exception e) {
			System.out.println(">>>>>>>>>>Unable to connect to Galaxy S22  http://0.0.0.0:5001/wd/hub");
			return;
		}

		System.out.println("App is loaded ..........");
	}



}
