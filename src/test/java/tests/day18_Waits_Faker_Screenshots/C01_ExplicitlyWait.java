package tests.day18_Waits_Faker_Screenshots;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {

    // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

        //  Iki tane metod olusturun : implicitWait() , explicitWait()
        //  Iki metod icin de asagidaki adimlari test edin.
        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        // 2. Remove butonuna basin.
        // 3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        // 4. Add buttonuna basin
        // 5. It’s back mesajinin gorundugunu test edin

        //! TestBase imlicitliwait comment yapalımm


    @Test
    public void implicitlyWait(){  // TestBase de implicitlyWait var zaten o yüzden bu test geçiyor.

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");                      // 1
        driver.findElement(By.xpath("//button[@onclick=\"swapCheckbox()\"]")).click();          // 2

        WebElement gone = driver.findElement(By.xpath("//p[@id=\"message\"]"));                 // 3
        Assert.assertTrue(gone.isDisplayed(),"It's gone! mesajı görüntülenemedi.");

        driver.findElement(By.xpath("//button[@onclick=\"swapCheckbox()\"]")).click();          // 4

        WebElement back = driver.findElement(By.xpath("//p[@id=\"message\"]"));                 // 5
        Assert.assertTrue(back.isDisplayed(),"It's back! mesajı görüntülenemedi.");
    }

    @Test
    public void explicitlyWait(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");                       // 1

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));

        WebElement removeButton = driver.findElement(By.xpath("//button[@onclick=\"swapCheckbox()\"]")); // 2
        removeButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id=\"message\"]")));

        WebElement gone = driver.findElement(By.xpath("//p[@id=\"message\"]"));                  // 3
        Assert.assertTrue(gone.isDisplayed(),"It's gone! mesajı görüntülenemedi.");

        WebElement addButton = driver.findElement(By.xpath("//button[@onclick=\"swapCheckbox()\"]"));   // 4
        addButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id=\"message\"]")));

        WebElement back = driver.findElement(By.xpath("//p[@id=\"message\"]"));                  // 5
        Assert.assertTrue(back.isDisplayed(),"It's back! mesajı görüntülenemedi.");
    }
}
