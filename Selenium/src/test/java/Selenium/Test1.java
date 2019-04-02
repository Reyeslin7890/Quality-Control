package Selenium;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class Test1 {

    public void ScreenShot(WebDriver driver) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String dest = "d:\\QA\\screenshot\\Selenium_Test1_" + new Date().getTime() + ".png";
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    @Test
    public void Test1Positive() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\QA\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        //Amazon Regester
        driver.get("https://www.amazon.com/ap/register?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_custrec_newcust");
        Thread.sleep(100);
        ScreenShot(driver);
        Thread.sleep(100);
        
        //Fill in blanks
        driver.findElement(By.id("ap_customer_name")).sendKeys("Jin Lin");
        driver.findElement(By.id("ap_email")).sendKeys("reyeslin7890@gmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("selenium");
        driver.findElement(By.id("ap_password_check")).sendKeys("selenium");
        Thread.sleep(200);
        ScreenShot(driver);
        
        //Click on register
        driver.findElement(By.id("continue")).click();
        Thread.sleep(200);
        ScreenShot(driver);
        Thread.sleep(200);
        driver.quit();
    }
    
    
    @Test
    public void Test1Negative() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\QA\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/ap/register?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_custrec_newcust");
        Thread.sleep(200);
        ScreenShot(driver);
        Thread.sleep(200);
        driver.findElement(By.id("ap_customer_name")).sendKeys("Jin Lin");
            driver.findElement(By.id("ap_email")).sendKeys("reyeslin7890@gmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("selenium");
        driver.findElement(By.id("ap_password_check")).sendKeys("seleniummm");
        Thread.sleep(200);
        ScreenShot(driver);
        driver.findElement(By.id("continue")).click();
        Thread.sleep(200);
        ScreenShot(driver);
        Thread.sleep(200);
        driver.quit();
    }
}
