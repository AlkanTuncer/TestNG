package tests.day14_Review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C03_iFrame {

    WebDriver driver;
    SoftAssert softAssert;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        softAssert = new SoftAssert();

        //https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
    }

    //Bir metod olusturun: iframeTest
    @Test
    public void iFrameTest(){
        // “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda  yazdirin.
        WebElement text = driver.findElement(By.tagName("h3"));
        softAssert.assertTrue(text.isEnabled(),"“An IFrame containing….” textine erişim sağlanamadı.");

        //Text Box’a “Merhaba Dunya!” yazin.
        WebElement iFrame = driver.findElement(By.xpath("//iframe[@id=\"mce_0_ifr\"]"));
        driver.switchTo().frame(iFrame);
        WebElement iFrameTextBox = driver.findElement(By.tagName("p"));
        iFrameTextBox.clear();
        iFrameTextBox.sendKeys("Merhaba Dünya!");

        // - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur  oldugunu dogrulayin ve konsolda yazdirin.
        driver.switchTo().parentFrame();
        WebElement elementalLink = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        softAssert.assertTrue(elementalLink.isDisplayed(),"“Elemental Selenium” linkinin texti görünmüyor.");
    }

    @AfterClass
    public void tearDown(){
        softAssert.assertAll();
        driver.close();
    }

}