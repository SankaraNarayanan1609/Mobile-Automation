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
import java.time.Duration;

public class BaseScript {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException, URISyntaxException {

            service = AppiumDriverLocalService.buildDefaultService(); // Use the correct method to build AppiumDriverLocalService
            service.start();

            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("Pixel 8 Pro Android 15");
            options.setApp("C://Users//SankaraNarayanan//Appium Resources//resources//ApiDemos-debug.apk");

            //AndroidDriver, IOSDriver

            URI appiumServerUri = new URI("http://127.0.0.1:4723");
            driver = new AndroidDriver(appiumServerUri.toURL(), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }
    public void LongPres(WebElement ele)
    {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),
                        "duration", 2000));
    }

    @AfterClass
    public void teerDown ()
    {
        driver.quit();
        service.stop();
    }
}
