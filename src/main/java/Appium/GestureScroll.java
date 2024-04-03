package Appium;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class GestureScroll extends BaseScript {
    @Test
    public void Scroll() throws MalformedURLException, URISyntaxException, InterruptedException
    {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //Scroll Gesture With UiAutomator when we know where to scroll and know about the element we need.
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
        Thread.sleep(2000);

        //Scroll Gesture With JS when we need to find if the element we search is available.
        scrollToEndAction();

    }
}