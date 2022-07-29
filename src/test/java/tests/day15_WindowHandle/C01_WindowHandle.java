package tests.day15_WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class C01_WindowHandle {

    WebDriver driver;

    // Before ve After'ı Class metodu ile yazdıgımız için hepsinin WindowHandle değeri aynı olucak.
    // BeforeMethod ve AfterMethod ile yazsaydık her test için farklı WindowHandle değerlerini konsola yazardı.

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void testWindowHandle(){
        driver.get("https://www.amazon.com");
        System.out.println("driver.getWindowHandle() for Amazon = " + driver.getWindowHandle());
    }

    @Test
    public void testWindowHandle2(){
        driver.get("https://the-internet.herokuapp.com");
        System.out.println("driver.getWindowHandle() for Herokuapp = " + driver.getWindowHandle());
    }

    @Test
    public void testWindowHandle3(){
        driver.get("https://www.bestbuy.com");
        System.out.println("driver.getWindowHandle() for BestBuy = " + driver.getWindowHandle());
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
