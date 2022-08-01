package tests.day15_WindowHandle;

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

public class C02_WindowHandle_Task {

    // ● https://the-internet.herokuapp.com/windows adresine gidin.
    // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    // ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    // ● Click Here butonuna basın.
    // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    // ● Sayfadaki textin “New Window” olduğunu doğrulayın.
    // ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test(){
        driver.navigate().to("https://the-internet.herokuapp.com/windows");

        WebElement text = driver.findElement(By.tagName("h3"));
        String anaSayfa = driver.getWindowHandle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(text.getText().equals("Opening a new window"),"'Opening a new window' - Text dogrulanamadı.");
        softAssert.assertEquals(driver.getTitle(),"The Internet","The Internet - Title dogrulanamadı.");

        driver.findElement(By.linkText("Click Here")).click();
        String tab = driver.getWindowHandle();

        softAssert.assertEquals(driver.getTitle(),"New Window","New Window - Title dogrulanamadı.");
        WebElement text2 = driver.findElement(By.tagName("h3"));
        softAssert.assertEquals(text2.getText(),"New Window","'New Window' - Text dogrulanamadı.");

        driver.switchTo().window(anaSayfa);
        softAssert.assertEquals(driver.getTitle(),"The Internet","The Internet - Title dogrulanamadı.");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
