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

public class C01_Alerts_Review {

    WebDriver driver;
    SoftAssert softAssert;

    // ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        softAssert = new SoftAssert();
    }

    // ● Bir metod olusturun: acceptAlert
    //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert” oldugunu test edin.
    @Test
    public void acceptAlert(){
        WebElement buttonJSAlert = driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]"));
        buttonJSAlert.click();
        driver.switchTo().alert().accept();

        WebElement result = driver.findElement(By.xpath("//p[@id=\"result\"]"));
        softAssert.assertEquals(result.getText(),"You successfully clicked an alert","Result mesajı beklenildiği gibi değil.");
    }

    // ● Bir metod olusturun: dismissAlert
    //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin.
    @Test
    public void dismissAlert(){
        WebElement buttonJSConfirm = driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]"));
        buttonJSConfirm.click();
        driver.switchTo().alert().dismiss();

        WebElement result = driver.findElement(By.xpath("//p[@id=\"result\"]"));
        softAssert.assertFalse(result.getText().contains("successfuly"),"Result mesajı 'successfuly' içeriyor.");
    }

    // ● Bir metod olusturun: sendKeysAlert
    //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    @Test
    public void sendKeysAlert(){
        WebElement buttonJSPrompt = driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));
        buttonJSPrompt.click();
        driver.switchTo().alert().sendKeys("Alkan");
        driver.switchTo().alert().accept();

        WebElement result = driver.findElement(By.xpath("//p[@id=\"result\"]"));
        softAssert.assertTrue(result.getText().contains("Alkan"),"Result mesajında isminiz görüntülenmiyor.");

        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
