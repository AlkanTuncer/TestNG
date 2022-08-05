package tests.day19_Screenshots;


import org.openqa.selenium.*;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_ScreenshotTestBase extends TestBase {

    //  amazona gidin
    //  3 farkli test methodu ile java, honey ve elma aratip
    //  sonuc sayfasini screenshot'i kaydedin

    @Test
    public void testJava(){
        driver.navigate().to("https://www.amazon.com/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java", Keys.ENTER);

        getScreenshot();
    }

    @Test
    public void testHoney(){
        driver.navigate().to("https://www.amazon.com/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Honey", Keys.ENTER);

        getScreenshot();
    }

    @Test
    public void testElma(){
        driver.navigate().to("https://www.amazon.com/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Elma", Keys.ENTER);

        getScreenshot();
    }
}
