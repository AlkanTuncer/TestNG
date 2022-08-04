package tests.day17_ActionsAndFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test(){
        //  1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.navigate().to("http://webdriveruniversity.com/Actions");

        //  2- Hover over Me First" kutusunun ustune gelin
        WebElement hoverOverMeFirst = driver.findElement(By.xpath("(//button[@class=\"dropbtn\"])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOverMeFirst).perform();

        //  3- Link 1" e tiklayin
        WebElement link1 = driver.findElement(By.xpath("(//div[@class=\"dropdown-content\"])[1]"));
        actions.click(link1).perform();

        //  4- Popup mesajini yazdirin
        //  5- Popup'i tamam diyerek kapatin
        String popUpText = driver.switchTo().alert().getText();
        System.out.println("Pop-Up Mesajı : "+popUpText);
        driver.switchTo().alert().accept();

        //  6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.xpath("//div[@id=\"click-box\"]"));
        actions.clickAndHold(clickAndHold).perform();

        //  7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("Click and Hold Text : "+clickAndHold.getText());
        actions.release(clickAndHold).perform();

        //  8- “Double click me" butonunu cift tiklayin
        WebElement doubleClick = driver.findElement(By.xpath("//div[@id=\"double-click\"]"));
        actions.doubleClick(doubleClick).perform();

    }

}
