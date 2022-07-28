package tests.day13_AlertsHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C02_Alerts {  // C01_Alerts'in SoftAssert ile yazılımı

    WebDriver driver;
    SoftAssert softAssert;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        softAssert = new SoftAssert();
    }

    @Test
    public void acceptAlert(){
        driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]")).click();

        driver.switchTo().alert().accept();  // Alert'daki OK butonuna tıklama.

        WebElement result = driver.findElement(By.xpath("//p[@id=\"result\"]"));
        softAssert.assertEquals(result.getText(),"You successfully clicked an alert","Test FAILED - Clicked an alert yok.");
    }

    @Test
    public void dismissAlert(){
        driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();

        driver.switchTo().alert().dismiss();  // Alert'daki Cancel butonuna tıklama.

        WebElement result = driver.findElement(By.xpath("//p[@id=\"result\"]"));
        softAssert.assertFalse(result.getText().contains("successfuly"),"Test FAILED - successfuly içeriyor.");
    }

    @Test
    public void sendKeysAlert(){
        driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]")).click();

        driver.switchTo().alert().sendKeys("Alkan");
        driver.switchTo().alert().accept();

        WebElement result = driver.findElement(By.xpath("//p[@id=\"result\"]"));
        softAssert.assertTrue(result.getText().contains("Alkan"),"You entered: Alkan yazısı çıkmadı.");

        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
