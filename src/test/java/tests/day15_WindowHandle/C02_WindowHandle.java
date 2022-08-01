package tests.day15_WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

public class C02_WindowHandle {

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
        //    amazon.com a git ve sayfanın handell değerini al
        driver.navigate().to("https://www.amazon.com/");
        String amazonWindowHandle = driver.getWindowHandle();
        System.out.println("Amazon Handle : "+amazonWindowHandle);

        //    Yeni bir pencere aç bestbuy.com git ve yeni açılan pencerenin handel değerini al
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyWindowHandle = driver.getWindowHandle();
        System.out.println("BestBuy Handle : "+bestBuyWindowHandle);

        //    sonra bütün handelların değerini al
        Set<String> handles = driver.getWindowHandles();
        System.out.println("Handles'lar : "+handles);

        //    şimdi yeni bir tab aç ve facebook.com a git
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com/");

        //    amazon.com a geri dön ve arama kısmınıa 'Nutella' yaz ve ara
        driver.switchTo().window(amazonWindowHandle);
        driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("Nutella", Keys.ENTER);

        //    sonra bestbuy.com geç, title  doğrula
        driver.switchTo().window(bestBuyWindowHandle);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.getTitle().contains("Best Buy"),"Title Best Buy içermiyor.");

        //    Şimdi de facebook.com penceresine git ve title  facebook.com olduğunu  doğrula
        Set<String> allHandles = driver.getWindowHandles();  // Yukarıdaki Set'de facebook handle değeri yok.
        System.out.println("All Handles : "+allHandles);

        String facebookWindowHandle = "";
        for (String each : allHandles){
            if (!(each.equals(amazonWindowHandle) || each.equals(bestBuyWindowHandle))){
                facebookWindowHandle += each;
            }
        }
        System.out.println("Facebook Handle : "+facebookWindowHandle);

        driver.switchTo().window(facebookWindowHandle);
        softAssert.assertTrue(driver.getTitle().contains("Facebook"));

        softAssert.assertAll();
    }

    @Test
    public void testSet(){
        Set<String> list = new HashSet<>();
        list.add("Alkan");
        list.add("Dante");
        list.add("Jugking");
        list.add("53");

        System.out.println("List : "+list);  // Set -> Rastgele yazdırır.
    }

    @AfterClass
    public void tearDown(){
        driver.quit();  // Açılan ne varsa sayfa tab hepsini kapatır.
    }
}