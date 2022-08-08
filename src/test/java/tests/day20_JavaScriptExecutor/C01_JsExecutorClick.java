package tests.day20_JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_JsExecutorClick extends TestBase {

    /*
            JavascriptExecutor jse = (JavascriptExecutor) driver;  -> Kullanmak için driver'ımızı cast ediyoruz.

            jse.executeScript("ilgili script","web element");

            jse.executeScript("document.getElementByID('element id').click();");  -> click kullanımı.
            jse.executeScript("arguments[0].click();",button);   -> Tanımlanan button'a click etme.

            * BrowserStack'de daha fazla kullanımına bakabilirsiniz.
     */

    @Test
    public void testJsExecutor(){
        // amazon anasayfaya gidip
        driver.navigate().to("https://www.amazon.com/");

        // sell linkine JSExecuter ile tiklayin
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebElement sellElement = driver.findElement(By.xpath("//a[@data-csa-c-content-id=\"nav_cs_sell\"]"));
        jse.executeScript("arguments[0].click();",sellElement);

        // ilgil sayfaya gittigimizi test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"),"Yanlış sayfaya gittiniz.");

    }

}
