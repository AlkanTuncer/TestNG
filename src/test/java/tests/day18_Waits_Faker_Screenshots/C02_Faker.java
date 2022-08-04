package tests.day18_Waits_Faker_Screenshots;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Faker extends TestBase {   // Faker adı üstünde sahte isimler,numaralar,adresler gibi bir çok şeyler üretir.

    //   "https://facebook.com/"  Adresine gidin
    //    “create new account”  butonuna basin
    //    “firstName” giris kutusuna bir isim yazin
    //    “surname” giris kutusuna bir soyisim yazin
    //    “email” giris kutusuna bir email yazin
    //    “email” onay kutusuna emaili tekrar yazin
    //    Bir sifre girin
    //    Tarih icin gun secin
    //    Tarih icin ay secin
    //    Tarih icin yil secin
    //    Cinsiyeti secin
    //    Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
    //    Sayfayi kapatin

    @Test
    public void test(){
        driver.get("https://facebook.com/");

        driver.findElement(By.xpath("//a[@data-testid=\"open-registration-form-button\"]")).click();

        WebElement firstName = driver.findElement(By.xpath("//input[@name=\"firstname\"]"));

        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        String email = faker.internet().emailAddress();  // Email'i tekrar sordugu için aynısını girmemiz lazım.

        actions.sendKeys(firstName,faker.name().firstName()).
                sendKeys(Keys.TAB,faker.name().lastName()).
                sendKeys(Keys.TAB,email).sendKeys(Keys.TAB,email).
                sendKeys(Keys.TAB,faker.internet().password()).perform();

        WebElement dropDownDay = driver.findElement(By.xpath("//select[@aria-label=\"Day\"]"));
        WebElement dropDownMonth = driver.findElement(By.xpath("//select[@aria-label=\"Month\"]"));
        WebElement dropDownYear = driver.findElement(By.xpath("//select[@aria-label=\"Year\"]"));
        Select select = new Select(dropDownDay);
        select.selectByIndex(2);
        select = new Select(dropDownMonth);
        select.selectByIndex(3);
        select = new Select(dropDownYear);
        select.selectByValue("1992");

        WebElement male = driver.findElement(By.xpath("//input[@value=\"2\"]"));
        WebElement female = driver.findElement(By.xpath("//input[@value=\"1\"]"));
        WebElement custom = driver.findElement(By.xpath("//input[@value=\"-1\"]"));

        male.click();

        Assert.assertTrue(male.isSelected());
        Assert.assertFalse(female.isSelected());
        Assert.assertFalse(custom.isSelected());
    }

}