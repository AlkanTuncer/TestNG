package tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {

    // https://the-internet.herokuapp.com/upload adresine gidelim
    // chooseFile butonuna basalim
    // Yuklemek istediginiz dosyayi secelim.
    // Upload butonuna basalim.
    // “File Uploaded!” textinin goruntulendigini test edelim.

    @Test
    public void testFileUpload(){
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFileButton = driver.findElement(By.xpath("//input[@id=\"file-upload\"]"));
        String dosyaPath = System.getProperty("user.home")+"\\Desktop\\Deneme1\\selenium.xlsx";
        chooseFileButton.sendKeys(dosyaPath);

        WebElement uploadButton = driver.findElement(By.xpath("//input[@id=\"file-submit\"]"));
        uploadButton.click();

        WebElement fileUploadedText = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedText.isDisplayed(),"Upload gerçekleşmedi.");
    }

}