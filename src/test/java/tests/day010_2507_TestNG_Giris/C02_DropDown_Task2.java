package tests.day010_2507_TestNG_Giris;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_DropDown_Task2 {

    // Amazon'a gidilsin, dropdown'daki 3.element secilip yazdırılsın.

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void testAmazonDropDown(){
        driver.navigate().to("https://www.amazon.com/");
        WebElement dropDown = driver.findElement(By.xpath("//select[@class=\"nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown\"]"));
        Select select = new Select(dropDown);
        select.selectByIndex(2);
        //select.selectByVisibleText("Automotive");
        //select.selectByValue("search-alias=automotive-intl-ship");

        System.out.println("3.Element : "+select.getFirstSelectedOption().getText());

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
