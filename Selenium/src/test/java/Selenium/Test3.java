/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Selenium;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Reyes
 */
public class Test3 {

    public void ScreenShot(WebDriver driver) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String dest = "d:\\QA\\screenshot\\Selenium_Test3_" + new Date().getTime() + ".png";
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    @Test
    public void Test3() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\QA\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        //Buy products
        
        //Log in
        driver.get("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_custrec_newcust&prevRID=5S5NVX98VKY7XPSNEX1P&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=usflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        Thread.sleep(200);
        ScreenShot(driver);
        Thread.sleep(200);
        driver.findElement(By.id("ap_email")).sendKeys("reyeslin7890@gmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("selenium");
        Thread.sleep(200);
        ScreenShot(driver);
        driver.findElement(By.id("signInSubmit")).click();
        Thread.sleep(2000);
        ScreenShot(driver);
        Thread.sleep(200);

        //Search Items
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("guarana soda");
        ScreenShot(driver);
        Thread.sleep(200);
        driver.findElement(By.id("twotabsearchtextbox")).submit();
        Thread.sleep(200);
        ScreenShot(driver);
        Thread.sleep(200);
        
        //Click on the item
        driver.findElement(By.linkText("Antarctica - Soda Guarana - 11.83 Fl. Oz. (PACK OF 12) | Guaraná - 350ml")).click();
        Thread.sleep(200);
        ScreenShot(driver);
        Thread.sleep(200);
        
        //Add to cart
        driver.findElement(By.id("add-to-cart-button")).click();
        Thread.sleep(200);
        ScreenShot(driver);
        Thread.sleep(200);
        
        //Checkout
        driver.findElement(By.id("hlb-ptc-btn-native")).click();
        Thread.sleep(200);
        ScreenShot(driver);
        Thread.sleep(2000);
        driver.quit();
    }

}
