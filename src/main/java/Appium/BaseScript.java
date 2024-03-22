package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BaseScript {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    @BeforeClass
    public void ConfigureAppium() {
        try {
            service = AppiumDriverLocalService.buildDefaultService(); // Use the correct method to build AppiumDriverLocalService
            service.start();

            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("Pixel 8 Pro Android 15");
            options.setApp("C://Users//SankaraNarayanan//IdeaProjects//MobileApp//src//main//java//Resources//ApiDemos-debug.apk");

            //AndroidDriver, IOSDriver

            driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        catch (MalformedURLException | URISyntaxException e) {
            e.printStackTrace();
        }



    }

    @AfterClass
    public void teerDown()
    {
        driver.quit();
        service.stop();
    }
}
