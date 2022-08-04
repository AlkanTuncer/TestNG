package tests.day17_ActionsAndFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_Synchronization extends TestBase {

    // https://the-internet.herokuapp.com/dynamic_controls sayfasina gidin
    // disable butonuna basin
    // disabled yazisinin ciktigini test edin

    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[@onclick=\"swapInput()\"]")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement enabledText = driver.findElement(By.xpath("//p[@id=\"message\"]"));
        Assert.assertTrue(enabledText.isDisplayed(),"It's enabled! mesajı çıkmadı.");

        driver.findElement(By.xpath("//button[@onclick=\"swapInput()\"]")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement disabledText = driver.findElement(By.xpath("//p[@id=\"message\"]"));
        Assert.assertTrue(disabledText.isDisplayed(),"It's disabled! mesajı çıkmadı.");
    }

}
