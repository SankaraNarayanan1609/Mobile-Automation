package Appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class eCommereceTC3 extends BaseScript {

    @Test
    public void AdToCartTC() throws InterruptedException {

        //Country Dropdown
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Albania\"));")).click();
        driver.hideKeyboard();

        //Name Field
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sankar");
        driver.hideKeyboard();

        //Gender
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();

        //Submit
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(1000);

        //Product Scroll
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"));"));
//        int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
//        for (int i =0; i< productCount; i++)
//        {
//            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
//            if (productName.equalsIgnoreCase("Air Jordan 9 Retro"))
//                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
//            Thread.sleep(3000);
        driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart'])[3]")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(3000);
    String NEWS =  driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(NEWS,"Air Jordan 9 Retro");
        
            //Page Crosscheck
//            WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
//            wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text", "cart"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//         String NEW                =  driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
//                       Assert.assertEquals(NEW, "Air Jordan 9 Retro");




        }

//        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
//        Thread.sleep(3000);
    }



