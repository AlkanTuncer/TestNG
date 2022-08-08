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
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

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
        String tarih=new SimpleDateFormat("yyMMddhhmmss").format(new Date());  // Üst üste screenshot almasın diye dosya adını her seferinde tarihle yeniliyoruz.
        File allPage = new File("TScreenshot\\screenshot"+tarih+".png");
        File temporaryPage = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(temporaryPage,allPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

