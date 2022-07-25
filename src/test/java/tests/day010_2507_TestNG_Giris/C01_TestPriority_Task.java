package tests.day010_2507_TestNG_Giris;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_TestPriority_Task {

    // 3 test methodu olusturun
    // 1. amazon ana sayfasina
    // 2. https://github.com/ ana sayfaya
    // 3. facebook ana sayfaya gitsin
    // ve sayfa title'larini yazdirsin

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test (priority = 10)
    public void testAmazon(){
        driver.navigate().to("https://www.amazon.com/");
        System.out.println("driver.getTitle() - testAmazon = " + driver.getTitle());
    }

    @Test (priority = -2)
    public void testGithub(){
        driver.navigate().to("https://www.github.com/");
        System.out.println("driver.getTitle() - testGithub = " + driver.getTitle());
    }

    @Test  // yazmasa da priority = 0'dır.
    public void testFacebook(){
        driver.navigate().to("https:/www.facebook.com/");
        System.out.println("driver.getTitle() = - testFacebook " + driver.getTitle());
    }

    @Test
    public void testYahoo(){
        driver.navigate().to("https://www.yahoo.com/");
        System.out.println("driver.getTitle() - testYahoo = " + driver.getTitle());
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
