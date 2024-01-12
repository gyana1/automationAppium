package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class AndroidGestures {

    AppiumDriver appiumDriver;
    protected AndroidDriver androidDriver;

    public AndroidGestures(AppiumDriver appiumDriver) {

        this.appiumDriver = appiumDriver;
    }

    public void click(WebElement element) {
        element.click();
    }

    public void enterText(WebElement element, String text) {
        waitForVisibility(element);
        element.sendKeys(text);
    }

    public void doubleClick(WebElement element) {
        ((JavascriptExecutor) appiumDriver).executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }

    public void longPress(WebElement element) {

        ((JavascriptExecutor) appiumDriver)
                .executeScript("mobile:longClickGesture", ImmutableMap.of
                        ("elementId", ((RemoteWebElement) element).getId(),
                                "duration", 2000));
    }

    public void longClick(WebElement element) {
        ((JavascriptExecutor) appiumDriver)
                .executeScript("mobile: longClickGesture", ImmutableMap.of(
                        "elementId", ((RemoteWebElement) element).getId()
                ));
    }

    public void scrollToEnd() {
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean)
                    ((JavascriptExecutor) appiumDriver)
                            .executeScript("mobile:scrollGesture", ImmutableMap.of
                                    (
                                            "left", 100,
                                            "top", 100,
                                            "width", 200,
                                            "height", 200,
                                            "direction", "down",
                                            "percent", 3.0
                                    )
                            );
        }
        while (canScrollMore);
    }

    public void scrollToText(String text) {
        appiumDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(text(\"" + text + "\"));"));
    }


    public void dragGesture(WebElement element) {
        ((JavascriptExecutor) appiumDriver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 100,
                "endY", 100
        ));
    }

    public void waitForAlertPresent(WebElement element) {
        WebDriverWait wait1 = new WebDriverWait(appiumDriver, ofSeconds(10));

        if (wait1.until(ExpectedConditions.alertIsPresent()) == null) {
            System.out.println("alert was not present");
        } else {
            System.out.println("alert was present");
        }
    }

    public void waitForVisibility(WebElement element) {

        WebDriverWait wait = new WebDriverWait(appiumDriver, ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void waitForInvisibility(WebElement element) {
        WebDriverWait wait2 = new WebDriverWait(appiumDriver, ofSeconds(20));
        wait2.until(ExpectedConditions.invisibilityOf(element));
    }

    public void pullToRefresh(WebElement element){
        ((JavascriptExecutor) appiumDriver).executeScript("mobile:dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "startX",0,
                "startY",0,
                "endX", 100,
                "endY", 100
        ));
    }

    public void swipe(){

    }
}
