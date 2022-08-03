package tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_KeyboardActions extends TestBase {

    @Test
    public void test(){
        //  https://html.com/tags/iframe/ sayfasina gidelim.
        driver.navigate().to("https://html.com/tags/iframe/");

        //   video’yu gorecek kadar asagi inin.
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //  videoyu izlemek icin Play tusuna basin.
        WebElement iFrame=driver.findElement(By.xpath("//iframe[@src=\"https://www.youtube.com/embed/owsfdh4gxyc\"]"));
        driver.switchTo().frame(iFrame);

        WebElement playButton=driver.findElement(By.xpath("//button[@class=\"ytp-large-play-button ytp-button\"]"));
        actions.click(playButton).perform();

        //   videoyu calistirdiginizi test edin
        Assert.assertFalse(playButton.isDisplayed(),"Video çalışmıyor.");

    }
}