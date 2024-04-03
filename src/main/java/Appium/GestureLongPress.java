package Appium;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class GestureLongPress extends BaseScript {
    @Test
    public void LongPress() throws MalformedURLException, URISyntaxException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

        WebElement ele = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
        LongPres(ele);
//            ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
//                    ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
//                            "duration", 2000));

        String menuText = driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals(menuText, "Sample menu");
        Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());


        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}