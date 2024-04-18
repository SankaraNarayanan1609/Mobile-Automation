package Appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class eCommereceTC1 extends BaseScript{

    @Test
    public void FillFormPositiveTC()throws InterruptedException
    {

        //Positive Scenario
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));")).click();
        driver.hideKeyboard();
        Thread.sleep(2000);



        //Negative Scenario


    }
}
