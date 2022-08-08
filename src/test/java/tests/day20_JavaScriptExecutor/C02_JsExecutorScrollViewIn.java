package tests.day20_JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_JsExecutorScrollViewIn extends TestBase {

    // 1- Yeni bir class olusturun : ScroolInto
    // 2- /movita.com gidin
    // 3- 2 farkli test method’u olusturarak actions clasi ve Js Executor kullanarak
    // 4- çözümler sayfasinın acildigini test edin


    @Test
    public void testActions(){
        driver.navigate().to("https://www.movita.com.tr/");

        WebElement cozum = driver.findElement(By.xpath("//strong[text()=\"tıklayınız\"]"));

        Actions actions = new Actions(driver);
        actions.scrollToElement(cozum).click(cozum).perform();

        WebElement pageTitle = driver.findElement(By.xpath("//section[@id=\"page-title\"]"));
        Assert.assertTrue(pageTitle.getText().contains("Çözümler"),"Çözümler sayfasına giremediniz.");
    }

    @Test
    public void testJxExecutor(){
        driver.navigate().to("https://www.movita.com.tr/");

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebElement cozum = driver.findElement(By.xpath("//strong[text()=\"tıklayınız\"]"));

        jse.executeScript("arguments[0].scrollIntoView(true);",cozum);
        jse.executeScript("arguments[0].click();",cozum);

        WebElement pageTitle = driver.findElement(By.xpath("//section[@id=\"page-title\"]"));
        Assert.assertTrue(pageTitle.getText().contains("Çözümler"),"Çözümler sayfasına giremediniz.");
    }

}
