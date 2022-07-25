package tests.day010_2507_TestNG_Giris;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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

public class C02_DropDown_Task {

    // https://the-internet.herokuapp.com/dropdown adresine gidin.
    // Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın  2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    // Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin  ve yazdırın
    // Tüm dropdown değerleri(value) yazdırın
    // Dropdown’un boyutunu bulun
    // Dropdown’da 4 öğe varsa konsolda True, yoksa False yazdırın.

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
    }

    @Test (priority = 1)
    public void testPrint(){
        WebElement dropDown = driver.findElement(By.xpath("//select[@id=\"dropdown\"]"));

        Select select = new Select(dropDown);
        select.selectByIndex(1);
        System.out.println("Index ile Seçenek 1 : "+select.getFirstSelectedOption().getText());

        select.selectByValue("2");
        System.out.println("Value ile Seçenek 2 : "+select.getFirstSelectedOption().getText());

        select.selectByVisibleText("Option 1");
        System.out.println("VisibleText ile Seçenek 1 : "+select.getFirstSelectedOption().getText());
    }

    @Test (priority = 2)
    public void testAllDropDowns(){
        WebElement dropDown = driver.findElement(By.xpath("//select[@id=\"dropdown\"]"));

        Select select = new Select(dropDown);
        List<WebElement> options = select.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i+1)+". Option : "+options.get(i).getText());
        }
    }

    @Test (priority = 3)
    public void testDropDownBoyut(){
        WebElement dropDown = driver.findElement(By.xpath("//select[@id=\"dropdown\"]"));

        Select select = new Select(dropDown);
        List<WebElement> options = select.getOptions();
        int actualDropDownTotal = options.size();
        int expectedDropDownTotal = 4;

        Assert.assertEquals(actualDropDownTotal,expectedDropDownTotal,"FALSE");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
