package tests.day19_;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_Screenshot extends TestBase {
    /*
        TakesScreenshot ts = (TakesScreenshot) driver;
        File tumResim = new File(pathname:"target/ekranResmi/tumSayfa");
        File resimGecici = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(resimGecici,tumResim);
     */

    @Test
    public void testScreenshot(){
        // amazon anasayfaya gidin
        driver.navigate().to("https://www.amazon.com/");

        // amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        TakesScreenshot ts = (TakesScreenshot) driver;                                                           // -> Önce obje olusturulur.
        File dosyaResimler = new File("C:\\Users\\alkan\\IdeaProjects\\TestNG\\tScreen\\tumSayfa.png"); // -> Kaydedeceğimiz dosyayı olusturalım.
        File resimGecici = ts.getScreenshotAs(OutputType.FILE);                                                  // -> Gecici bir dosya olusturup screenshot ile screen alalım.
        try {
            FileUtils.copyFile(resimGecici,dosyaResimler);                                                       // -> Gecicideki resmi asıl yerine alacagız.
        } catch (IOException e) {
            System.out.println("ERROR - "+e.getMessage());;
        }

        // Real Madrid icin arama yapin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Real Madrid",Keys.ENTER);

        // sonucun Real Madrid icerdigini test edin ve ilk urunun goruntusunu alin
        File realMadrid = new File("C:\\Users\\alkan\\IdeaProjects\\TestNG\\tScreen\\realMadrid.png");
        File geciciResimMadrid = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciResimMadrid,realMadrid);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
