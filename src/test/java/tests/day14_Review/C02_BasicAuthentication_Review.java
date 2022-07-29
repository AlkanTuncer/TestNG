package tests.day14_Review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_BasicAuthentication_Review {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        driver.navigate().to("https://the-internet.herokuapp.com/basic_auth");
    }

    @Test
    public void testBasicAuthentication(){
        //  Asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //    Html komutu : https://username:password@URL/   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //    Username     : admin
        //    password      : admin
        // https://username:password@URL/ -> Bu yapıya göre verilen dataları yazıyoruz.
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth/");

        // Basarili sekilde sayfaya girildigini dogrulayin
        WebElement basicAuth = driver.findElement(By.xpath("//div[@class=\"example\"]"));
        Assert.assertTrue(basicAuth.isDisplayed());
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
