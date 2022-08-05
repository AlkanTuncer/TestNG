package tests.day19_;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_Screenshot extends TestBase {

    @Test
    public void testScreenshot(){
        // amazon anasayfaya gidin
        driver.navigate().to("https://www.amazon.com/");

        // amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        TakesScreenshot ts = (TakesScreenshot) driver;                                                                 // -> Önce obje olusturulur.
        File dosyaResimler = new File("C:\\Users\\alkan\\IdeaProjects\\TestNG\\tScreen\\amazonanasayfa.png"); // -> Kaydedeceğimiz dosyayı olusturalım.
        File resimGecici = ts.getScreenshotAs(OutputType.FILE);                                                        // -> Gecici bir dosya olusturup screenshot ile screen alalım.
        try {
            FileUtils.copyFile(resimGecici,dosyaResimler);                                                             // -> Gecicideki resmi asıl yerine alacagız.
        } catch (IOException e) {
            System.out.println("ERROR - "+e.getMessage());;
        }

        // Nutella icin arama yapin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella", Keys.ENTER);

        // sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu alin
        Assert.assertTrue(driver.getTitle().contains("Nutella"),"Sonuç 'Nutella' içermiyor.");
        WebElement nutellaIlkUrun = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/div/div"));

        File ilkUrunResim = new File("C:\\Users\\alkan\\IdeaProjects\\TestNG\\tScreen\\nutellailkürün.png");
        File geciciIlkUrun = nutellaIlkUrun.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciIlkUrun,ilkUrunResim);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
