package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import io.appium.java_client.TouchAction;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {

	public List<AppiumDriver> drivers = new ArrayList<AppiumDriver>();

	@BeforeTest

	public void setUp() throws MalformedURLException {

		Android_setUp();
		AndroidRealDevice_setUp();

	}

	public void Android_setUp() throws MalformedURLException {

		// Pixel 4 API 29-5554 -emulator

		System.out.println("Prepare Appium session...");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Android SDK built for x86");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10");
		cap.setCapability("appPackage", "com.pruvitint");
		cap.setCapability("appActivity", "com.pruvit.ui.AppLoadingActivity");


		try {
			this.drivers.add(new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap));
		} catch (Exception e) {
			System.out.println(">>>>>>>Unable to connect to http://0.0.0.0:4723/wd/hub");
			return;
		}
		System.out.println("App is loaded ..........Pixel 4 API 29-5554 -emulator");

	}

	public void AndroidRealDevice_setUp() throws MalformedURLException {
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
		} catch (Exception e) {
			System.out.println(">>>>>>>>>>Unable to connect to http://0.0.0.0:5000/wd/hub");
			return;
		}

		System.out.println("App is loaded ..........");
	}


	@AfterTest
	public void teardown() {

		for (AppiumDriver appiumDriver : drivers) {

			if (null != appiumDriver) {
				appiumDriver.quit();
			}
		}
	}
}
