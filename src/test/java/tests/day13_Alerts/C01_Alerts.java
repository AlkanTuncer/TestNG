package tests.day13_Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class C01_Alerts {  // driver.switchTo()

    // ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    // ● Bir metod olusturun: acceptAlert
    //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının       “You successfully clicked an alert” oldugunu test edin.
    // ● Bir metod olusturun: dismissAlert
    //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının       “successfuly” icermedigini test edin.
    // ● Bir metod olusturun: sendKeysAlert
    //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna     tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void acceptAlert(){
        driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]")).click();

        driver.switchTo().alert().accept();  // Alert'daki OK butonuna tıklama.

        WebElement result = driver.findElement(By.xpath("//p[@id=\"result\"]"));
        Assert.assertEquals(result.getText(),"You successfully clicked an alert");
    }

    @Test
    public void dismissAlert(){
        driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();

        driver.switchTo().alert().dismiss();  // Alert'daki Cancel butonuna tıklama.

        WebElement result = driver.findElement(By.xpath("//p[@id=\"result\"]"));
        Assert.assertFalse(result.getText().contains("successfuly"));
    }

    @Test
    public void sendKeysAlert(){
        driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]")).click();

        driver.switchTo().alert().sendKeys("Alkan");
        driver.switchTo().alert().accept();

        WebElement result = driver.findElement(By.xpath("//p[@id=\"result\"]"));
        Assert.assertTrue(result.getText().contains("Alkan"));
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}