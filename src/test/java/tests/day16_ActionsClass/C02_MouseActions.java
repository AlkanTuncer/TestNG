package tests.day16_ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C02_MouseActions extends TestBase {

    @Test
    public void test(){
        // https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.navigate().to("https://the-internet.herokuapp.com/context_menu");

        //  Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        WebElement ciziliAlan = driver.findElement(By.xpath("//div[@id=\"hot-spot\"]"));
        actions.contextClick(ciziliAlan).perform();

        // Alert’te cikan yazinin “You selected a context menu” oldugunu  test edelim.
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText,"You selected a context menu","Alert Text hatalı.");

        // Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();

        String mainPage = driver.getWindowHandle();

        // Elemental Selenium linkine tiklayalim
        WebElement elementalSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        actions.click(elementalSelenium).perform();

        Set<String> pageHandles = driver.getWindowHandles();

        // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String tabPage = "";
        for (String each : pageHandles){
            if (!each.equals(mainPage)){
                tabPage = each;
            }
        }

        driver.switchTo().window(tabPage);
        String actText = driver.findElement(By.tagName("h1")).getText();
        String expText = "Elemental Selenium";
        Assert.assertEquals(actText,expText,"Elemental Selenium yazmıyor.");

    }

}