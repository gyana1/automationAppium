package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TestBase {

	public List<AppiumDriver> drivers = new ArrayList<AppiumDriver>();

	@BeforeTest

	public void setUp() throws MalformedURLException {
       //
		Android_Pixel4_5554_emulator_setUp();
		AndroidRealDevice_Samsung_Galaxy_A71_setUp();
		Android_emulator_5554_Android10_setUp();
		AndroidGalaxyS22_R5CW13ZWGGN_setUp();

	}

	public void Android_Pixel4_5554_emulator_setUp() throws MalformedURLException {
		// Pixel 4 API 29-5554 -emulator

		System.out.println("Prepare Appium session and load Pruvit Pulse Demo app ...");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Android SDK built for x86");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10");
		cap.setCapability("appPackage", "com.pruvitint");
		cap.setCapability("appActivity", "com.pruvit.ui.AppLoadingActivity");

		try {
			this.drivers.add(new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap));
			System.out.println("Connected to Emulator-5554");
		} catch (Exception e) {
			System.out.println(">>>>>>>Unable to connect to http://0.0.0.0:4723/wd/hub");
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

	public void Android_emulator_5554_Android10_setUp() throws MalformedURLException {
		// Launch Android
		System.out.println("Launch Android");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Android SDK built for x86");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10");

		try {
			this.drivers.add(new AndroidDriver(new URL("http://0.0.0.0:5050/wd/hub"), cap));
			System.out.println("Connected to Android");

		} catch (Exception e) {
			System.out.println(">>>>>>>>>>Unable to connect to http://0.0.0.0:5050/wd/hub");
			return;

		}
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


	@AfterSuite
	public void teardown() {

		for (AppiumDriver appiumDriver : drivers) {

			if (null != appiumDriver) {
				appiumDriver.quit();
			}
		}
	}
}
