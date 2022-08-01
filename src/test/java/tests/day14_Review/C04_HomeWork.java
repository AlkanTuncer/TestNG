package tests.day14_Review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class C04_HomeWork {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void iFrameTest(){
        // - https://the-internet.herokuapp.com/iframe siteye gidilsin.
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        WebElement iFrame = driver.findElement(By.xpath("//iframe[@id=\"mce_0_ifr\"]"));
        driver.switchTo().frame(iFrame);

        //- Text Box'a 'Dünya'nın Bütün Denizleri' yazılsın.
        //- Yazılan yazı silinsin.
        WebElement iFrameTextBox = driver.findElement(By.tagName("p"));
        iFrameTextBox.sendKeys("Dünya'nın Bütün Denizleri");
        iFrameTextBox.clear();

        //- Yazı kalınlığı 'Bold' olarak seçilsin.
        driver.switchTo().defaultContent().findElement(By.xpath("//button[@title=\"Bold\"]")).click();

        //- 'Hollanda'nın Nüfusu 8.000.000' text'i 7 kere yazılsın.
        driver.switchTo().frame(iFrame);
        for (int i = 0; i < 7; i++) {
            iFrameTextBox.sendKeys("Hollanda'nın Nüfusu 8.000.000");
        }

        //- Yazılan yazı ortalansın.
        driver.switchTo().defaultContent().findElement(By.xpath("//button[@title=\"Align center\"]")).click();

        //- Elemental Selenium tıklansın.
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        //- 'Sauce Labs' yazısının sonuna 'box' eklenerek konsola yazılsın.
        WebElement sauceLabs = driver.findElement(By.linkText("Sauce Labs"));
        System.out.println(sauceLabs.getText()+" box");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}