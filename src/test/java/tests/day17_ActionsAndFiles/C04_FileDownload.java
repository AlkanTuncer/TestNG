package tests.day17_ActionsAndFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {

    // 1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    // 2. Iki tane metod oluşturun : isExist( ) ve downloadTest( )
    // 3. downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
    // - https://the-internet.herokuapp.com/download adresine gidelim.
    // - test.txt dosyasını indirelim
    // 4. Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim

    @Test
    public void downloadTest(){
        driver.navigate().to("https://the-internet.herokuapp.com/download");
        WebElement testTxt = driver.findElement(By.xpath("//a[text()=\"test.txt\"]"));

        Actions actions = new Actions(driver);
        actions.click(testTxt).perform();
    }

    @Test
    public void isExist(){
        String pathTestTxt = System.getProperty("user.home")+"\\Downloads\\test.txt";
        System.out.println("test.txt Path : "+pathTestTxt);

        Assert.assertTrue(Files.exists(Paths.get(pathTestTxt)),"text.txt dosyası mevcut değildir.");
    }
}
