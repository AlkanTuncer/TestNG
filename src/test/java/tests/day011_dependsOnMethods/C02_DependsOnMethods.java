package tests.day011_dependsOnMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_DependsOnMethods {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //    2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin arama yapin ve aramanizin gerceklestigini Test edin
    //    3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $14.99 oldugunu test edin

    @Test
    public void logoTest(){
        driver.navigate().to("https://www.amazon.com/");
        WebElement logo = driver.findElement(By.xpath("//div[@id=\"nav-logo\"]"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test (dependsOnMethods = "logoTest")   // logoTest'i çalışmadan bu test çalışmaz.
    public void amazonNutellaTest(){
        WebElement searchBox = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        searchBox.sendKeys("Nutella", Keys.ENTER);

        Assert.assertTrue(driver.getTitle().contains("Nutella"),"Nutella bulunamadı.");
    }

    @Test (dependsOnMethods = "amazonNutellaTest")
    public void amazonNutellaUrunTest(){
        driver.findElement(By.xpath("//img[@data-image-index=\"1\"]")).click();
        WebElement fiyat = driver.findElement(By.xpath("//*[@id=\"size_name_1_price\"]"));

        Assert.assertTrue(fiyat.getText().contains("$14.99"));
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
