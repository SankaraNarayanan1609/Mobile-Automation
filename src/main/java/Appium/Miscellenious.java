package Appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class Miscellenious extends BaseScript {
    @Test
    public void AppiumTest() throws MalformedURLException, URISyntaxException {


        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']"
        )).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();

        //LandscapeMode
        DeviceRotation landScape =  new DeviceRotation(0,0,90);
        driver.rotate(landScape);

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]")).click();
        String alertTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle,"WiFi settings");

        //Copy to Clipboard
        driver.setClipboardText("vcidex209");
        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys(driver.getClipboardText());

        //driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
//        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
//
//        try {
//            Thread.sleep(3000); // Sleep for 1 second
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //Not Working
        driver.navigate().back();

    }
}
