package tests.day19_;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_Notifications extends TestBase {

    @Test
    public void testNotifications(){

        ChromeOptions chromeOptions = new ChromeOptions();
        //Add chrome switch to disable notification - "--disable-notifications"
        chromeOptions.addArguments("--disable-notifications");

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.amazon.com/");

        /* Notifications'lar konum bulmayı ignore etmek istediğimizde  'chromeOptions.addArguments("--disable-notifications");' şeklinde ignore edip
         driver içinden cağırıyoruz. */
    }

}