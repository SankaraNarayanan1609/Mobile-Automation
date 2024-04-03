                package Appium;
                import com.google.common.collect.ImmutableMap;
                import io.appium.java_client.AppiumBy;
                import org.openqa.selenium.By;
                import org.openqa.selenium.JavascriptExecutor;
                import org.openqa.selenium.WebElement;
                import org.openqa.selenium.remote.RemoteWebElement;
                import org.testng.Assert;
                import org.testng.annotations.Test;
                import java.net.MalformedURLException;
                import java.net.URISyntaxException;

                public class GestureSwipe extends BaseScript {
                    @Test
                    public void Swipe() throws MalformedURLException, URISyntaxException, InterruptedException {
                        driver.findElement(AppiumBy.accessibilityId("Views")).click();
                        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
                        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();
                        WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView[@class='android.widget.ImageView'])[1]"));

                        Assert.assertEquals(firstImage.getAttribute("focusable"), "true");

                        //Swipe Action
                        swipeAction(firstImage, "left");

                        Assert.assertEquals(firstImage.getAttribute("focusable"), "false");
                    }

                }

