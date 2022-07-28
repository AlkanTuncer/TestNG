package tests.day13_Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C04_iFrame {

       /*
            https://the-internet.herokuapp.com/iframe adresine gidin.
            Bir metod olusturun: iframeTest
            - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda  yazdirin.
            - Text Box’a “Merhaba Dunya!” yazin.
            - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur  oldugunu dogrulayin ve
            konsolda yazdirin
       */

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
    }

    @Test
    public void iFrameTest(){
        WebElement iFrameText = driver.findElement(By.tagName("h3"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(iFrameText.isEnabled(),"iFrame yazısı görünmüyor.");
        System.out.println("iFrame Text : "+iFrameText.getText());

        // Text Box'a "Merhaba Dünya!" yazın.
        WebElement iFrame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrame);
        WebElement iFrameTextBox = driver.findElement(By.tagName("p"));
        iFrameTextBox.clear();
        iFrameTextBox.sendKeys("Hala Madrid!");

        driver.switchTo().parentFrame();  //iFrame'den çıkıp asıl siteye dönmemiz lazım ki sitenin elementini bulabilelim.
        WebElement elementalLink = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        softAssert.assertTrue(elementalLink.isDisplayed());
        System.out.println("Link Text : "+elementalLink.getText());

        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

}