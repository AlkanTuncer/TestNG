package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

public abstract class TestBase {

    protected WebDriver driver;
    protected TakesScreenshot ts;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public void tearDown(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    public void getScreenshot(){
        ts = (TakesScreenshot) driver;
        double number = Math.random();  // Üst üste screenshot almasın diye dosya adını her seferinde random bir sayı üreterek yeniliyoruz.
        File allPage = new File("TScreenshot\\screenshot"+number+".png");
        File temporaryPage = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(temporaryPage,allPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

