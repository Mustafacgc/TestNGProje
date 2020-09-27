package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDownLoadTest extends TestBase {

    @Test
    public void dosyVarMi(){
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));

        String kullaniciDosyaYolu = System.getProperty("user.dir");

        // C:/Users/PC/IdeaProjects/TestNGProje/pom.xml
        String pomXmlDosyYolu = kullaniciDosyaYolu + "pom.xml";

        boolean varMi = Files.exists(Paths.get(pomXmlDosyYolu));
        System.out.println(varMi);
        Assert.assertTrue(varMi);
    }

    @Test
    public void dosyUpLoad(){ // bilgisayardan websayfasina dosya yukleme
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement dosyaSecmeButonu = driver.findElement(By.id("file-upload"));

        //yuklemek istedigimiz dosyanin, path(dosya yolunu) ekleyelim.
        dosyaSecmeButonu.sendKeys("C:/Users/PC/Desktop/upload/Logo.png");

        WebElement uploadButonu = driver.findElement(By.id("file-submit"));
        uploadButonu.click();

        WebElement fileUploadYazisi = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(fileUploadYazisi.isDisplayed());
  }

  @Test
    public void dosyaDownload(){
        // C:\Users\PC\Downloads\Amsterdam.jpg
       driver.get("http://the-internet.herokuapp.com/download");
       WebElement amsterdamLinki = driver.findElement(By.partialLinkText("Amsterdam.jpg"));
       amsterdamLinki.click();

      try {
          Thread.sleep(3000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }

      boolean varMi = Files.exists(Paths.get("C:\\Users\\PC\\Downloads\\Amsterdam.jpg"));
      Assert.assertTrue(varMi);

  }


}
