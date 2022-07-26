package tests.day010_2507_TestNG_Giris;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C02_DropDown_Task3 {

    // Test 1
    //    https://www.amazon.com/ adresine gidin.
    //    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    // Test 2
    //    1. Kategori menusunden Books secenegini  secin
    //    2. Arama kutusuna Java yazin ve aratin
    //    3. Bulunan sonuc sayisini yazdirin
    //    4. Sonucun Java kelimesini icerdigini test edin

    WebDriver driver;
    Select select;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void amazonTest1(){
        driver.navigate().to("https://www.amazon.com/");
        WebElement dropDown = driver.findElement(By.xpath("//select[@class=\"nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown\"]"));

        select = new Select(dropDown);
        List<WebElement> options = select.getOptions();
        System.out.println("Actual Kategori Sayısı : "+options.size());
        //Assert.assertEquals(options.size(),45,"Kategori sayısı eşit değil.");
    }

    @Test
    public void amazonTest2(){
        driver.navigate().to("https://www.amazon.com/");
        WebElement dropDown = driver.findElement(By.xpath("//select[@class=\"nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown\"]"));
        select = new Select(dropDown);
        select.selectByIndex(5);

        WebElement searchBox = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        searchBox.sendKeys("Java", Keys.ENTER);

        WebElement sonuc = driver.findElement(By.xpath("(//div[@class=\"a-section a-spacing-small a-spacing-top-small\"])[1]"));
        String sonucText = sonuc.getText();  // 1-16 of over 30,000 results for "Java"
        System.out.println("Sonuc Text : "+sonucText);
        String[]sonucDizi = sonucText.split(" "); // Boşluğa göre bölerek diziye atadım ve sonuc sayısı 3.indekse geldi (:
        System.out.println("Sonuç sayısı : "+sonucDizi[3]);

        Assert.assertTrue(sonucText.contains("Java"));

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
