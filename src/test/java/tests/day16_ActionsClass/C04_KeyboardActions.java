package tests.day16_ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_KeyboardActions extends TestBase {

    /*
           sendKeys (): Öğeye bir dizi anahtar gönderir.
           keyDown (): Klavyede tuşa basma işlemi gerçekleştirir.
           keyUp (): Klavyede tuşu serbest bırakma işlemi gerçekleştirir.
     */


    @Test
    public void test(){
        // https://www.amazon.com/ sayfasina gidelim
        driver.navigate().to("https://www.amazon.com/");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        // Arama kutusuna actions method’larine kullanarak samsung 'Apple IPHONE 12' yazdirin ve Enter’a basarak arama yaptirin
        Actions actions = new Actions(driver);
        actions.click(aramaKutusu).
                keyDown(Keys.SHIFT).
                sendKeys("a").
                keyUp(Keys.SHIFT).
                sendKeys("pple ").
                keyDown(Keys.SHIFT).
                sendKeys("iphone ").
                keyUp(Keys.SHIFT).sendKeys("12", Keys.ENTER).
                perform();

        // aramanin gerceklestigini test edin
        Assert.assertTrue(driver.getTitle().contains("Apple IPHONE 12"),"Title Apple IPHONE 12 içermiyor.");
    }

}
