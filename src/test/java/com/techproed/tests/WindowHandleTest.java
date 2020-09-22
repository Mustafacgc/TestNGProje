package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;

import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleTest extends TestBase {

    @Test
    public void cokluPencereTest(){

        driver.get("https://the-internet.herokuapp.com/windows");

        String sayfaninHandle = driver.getWindowHandle();
        System.out.println(sayfaninHandle);

        driver.findElement(By.partialLinkText("Click Here")).click();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Set<String> tumPencereler = driver.getWindowHandles();
        /*
        elinizdeki tum pencerelerin windows handle'larini bu sekilde ekrana yazdirabilirsiniz.
            for(String handle : tumPencereler) {
            System.out.println(handle);

        }*/

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }


        Object[] array = (Object[]) tumPencereler.toArray();
        String ikinciSayfaHandle = array[array.length-1].toString();

        System.out.println(ikinciSayfaHandle);

        driver.switchTo().window(sayfaninHandle);


        



    }
}
