package Appium;
import java.net.URI;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

import java.net.URISyntaxException;
import java.security.PublicKey;
import java.time.Duration;

public class BaseScript {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException, URISyntaxException {

            service = AppiumDriverLocalService.buildDefaultService(); // Use the correct method to build AppiumDriverLocalService
            service.start();

            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("Pixel 4A Android 14");
            options.setApp("C://Users//SankaraNarayanan//Appium Resources//resources//ApiDemos-debug.apk");

            //AndroidDriver, IOSDriver

            URI appiumServerUri = new URI("http://127.0.0.1:4723");
            driver = new AndroidDriver(appiumServerUri.toURL(), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }
    public void LongPres(WebElement ele)
    {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
                        "duration", 2000));
    }

    //
    public void scrollToEndAction() {
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        } while (canScrollMore);
    }

    public void swipeAction(WebElement ele,String direction)
    {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)ele).getId(),
                "direction", direction,
                "percent", 0.1
        ));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}
