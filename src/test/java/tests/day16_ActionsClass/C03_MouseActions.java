package tests.day16_ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_MouseActions extends TestBase {

    // https://demoqa.com/droppable adresine gidelim
    // “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    // “Drop here” yazisi yerine “Dropped!” oldugunu test edin

    @Test
    public void test(){
        driver.get("https://demoqa.com/droppable");

        Actions actions = new Actions(driver);

        WebElement dragMe = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
        WebElement dropHere = driver.findElement(By.xpath("//div[@id=\"droppable\"]"));

        actions.dragAndDrop(dragMe,dropHere).perform();

        Assert.assertEquals(dropHere.getText(),"Dropped!","Text Dropped! değildir.");
    }

}
