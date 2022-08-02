package tests.day16_ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_MouseActions extends TestBase {

    /*
           - Fare ve klavye eylemlerini gerçekleştirmek için 'Actions Class' kullanılır.
           - Actions Class bir çok kullanıslı fare ve klavye işlevine sahiptir.
           - Actions Class obje üretilerek kullanılır.
           - Actions actions = new Actions(driver);
           - Kullanmak istediğimiz WebElement locate edilir.
           - actions.contextClick(element).perform();  -> perform() demeyi unutmuyoruz!
           - actions.doubleClick(element).perform();
                    doubleClick (): Öğeye çift tıklama yapar
                    clickAndHold (): Fareyi serbest bırakmadan uzun tıklama yapar
                    dragAndDrop (): Öğeyi bir noktadan diğerine sürükler ve bırakır
                    moveToElement (): Fare işaretçisini öğenin üzerine gider
                    contextClick (): Fare üzerinde sağ tıklama yapar

            https://webdriveruniversity.com/Actions/index.html# -> mouse actionları için egzersiz
     */

    @Test
    public void test(){
        //    https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com/");

        //    Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirelim
        WebElement accountLists = driver.findElement(By.xpath("//span[@class=\"nav-line-2 \"]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(accountLists).perform();

        //    “Create a list” butonuna basalim
        WebElement createList = driver.findElement(By.xpath("//*[text()=\"Create a List\"]"));
        actions.click(createList).perform();

        //    Acilan sayfada “Your List” yazisi oldugunu test edelim
        Assert.assertTrue(driver.getTitle().contains("Your List"),"Your List yazısı yoktur.");
    }

}