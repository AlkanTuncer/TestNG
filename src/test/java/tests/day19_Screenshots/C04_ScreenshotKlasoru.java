package tests.day19_Screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_ScreenshotKlasoru extends TestBase {

    //  amazona gidin
    //  3 farkli test methodu ile java, honey ve elma aratip
    //  sonuc sayfasini screenshot'i kaydedin

    @Test
    public void testJava(){
        driver.navigate().to("https://www.amazon.com/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java", Keys.ENTER);

        TakesScreenshot ts = (TakesScreenshot) driver;
        File java = new File("C:\\Users\\alkan\\IdeaProjects\\TestNG\\tScreen\\java.png");
        File geciciJava = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciJava,java);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testHoney(){
        driver.navigate().to("https://www.amazon.com/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Honey", Keys.ENTER);

        TakesScreenshot ts = (TakesScreenshot) driver;
        File honey = new File("C:\\Users\\alkan\\IdeaProjects\\TestNG\\tScreen\\honey.png");
        File geciciHoney = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciHoney,honey);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testElma(){
        driver.navigate().to("https://www.amazon.com/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Elma", Keys.ENTER);

        TakesScreenshot ts = (TakesScreenshot) driver;
        File elma = new File("C:\\Users\\alkan\\IdeaProjects\\TestNG\\tScreen\\elma.png");
        File geciciElma = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciElma,elma);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
