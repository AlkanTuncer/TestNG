package tests.day012_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class C02_SoftAssertion_Task {

    // Yeni bir Class Olusturun : C03_SoftAssert
    // 1. “http://zero.webappsecurity.com/” Adresine gidin
    // 2. Sign in butonuna basin
    // 3. Login kutusuna “username” yazin
    // 4. Password kutusuna “password” yazin
    // 5. Sign in tusuna basin
    // 6. Only Banking Pay Bills sayfasina gidin
    // 7. “Purchase Foreign Currency” tusuna basin
    // 8. “Currency” drop down menusunden Eurozone’u secin
    // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
    // 10. soft assert kullanarak DropDown listesinde "Switzerland (franc)" oldugunu test edin .

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test(){
        driver.navigate().to("http://zero.webappsecurity.com/");  // 1.adım
        driver.findElement(By.xpath("//button[@id=\"signin_button\"]")).click(); // 2.adım
        driver.findElement(By.xpath("//input[@id=\"user_login\"]")).sendKeys("username"); //3.adım
        driver.findElement(By.xpath("//input[@id=\"user_password\"]")).sendKeys("password"); //4.adım
        driver.findElement(By.xpath("//input[@value=\"Sign in\"]")).click(); //5.adım
        driver.navigate().back();
        driver.findElement(By.xpath("//a[@id=\"online-banking\"]")).click(); //6.adım
        driver.findElement(By.xpath("//span[@id=\"pay_bills_link\"]")).click();
        driver.findElement(By.linkText("Purchase Foreign Currency")).click(); //7.adım

        WebElement dropDown = driver.findElement(By.xpath("//select[@id=\"pc_currency\"]"));
        Select select = new Select(dropDown);
        select.selectByIndex(6);  //8.adım
        String expected = "Eurozone (euro)";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(select.getFirstSelectedOption().getText(),expected);  //9.adım
        softAssert.assertTrue(select.getFirstSelectedOption().isSelected());

        List<WebElement> options = select.getOptions();  //10.adım


        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}