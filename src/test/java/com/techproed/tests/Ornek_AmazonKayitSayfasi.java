package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ornek_AmazonKayitSayfasi extends TestBase {   //DAY 14 - 6 EYLUL 2020 PAZAR

    @Test
    public void test01(){
        driver.get("http://amazon.com");
        // 4 dk sureniz var.
        //1.adim : Mouse'u moveToElement methodunu kullanarak, Account & Lists
        //          webelementinin uzerine goturun.
        //2.adim : Start here. linkine tiklayin.

        WebElement webElement = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);

        //mouse'u webelement'in uzerine goturme islemi yapiyoruz.
        actions.moveToElement(webElement).perform();

        // xpath ->  //*[.='Start here.']
        WebElement startHereLink = driver.findElement(By.partialLinkText("Start here."));
        startHereLink.click();

        //3.adim : Sayfanin title'i Amazon Registration ise testiniz basarili olsun.

        // True kullanarak ->Assert.assertTrue(driver.getTitle().equals("Amazon Registration"));

        // False kullanarak Assert.assertFalse(!driver.getTitle().equals("Amazon Registration"));
        Assert.assertEquals(driver.getTitle(),"Amazon Registration");

    }

    @Test (dependsOnMethods = "test01")
    public void test02(){
        WebElement isim=driver.findElement(By.id("ap_customer_name"));
        isim.sendKeys("Mustafa Cicgi");

        driver.findElement(By.id("ap_email")).sendKeys("mustafacigci@gmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("Amazon06");
        driver.findElement(By.id("ap_password_check")).sendKeys("Amazon06");

        driver.findElement(By.id("continue")).click();
    }



}
