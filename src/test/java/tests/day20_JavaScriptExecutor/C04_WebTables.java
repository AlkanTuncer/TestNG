package tests.day20_JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_WebTables extends TestBase {

    //  1. Bir metod oluşturun: printData(int row, int column);
    //  a. Satır(row) ve sütun(column) numarasını girdiğinizde,
    //  printData metodu bu hücredeki(cell) veriyi yazdırmalıdır.
    //  2. Baska bir metod daha oluşturun: printDataTest();
    //  a. Ve bu metodu printData() methodunu cagirmak icin kullanin.
    //  b. Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır.

    // //table//tbody//tr[5]//td[4] -> şeklinde xpath.

    @Test
    public void printDataTest(){
        driver.navigate().to("https://editor.datatables.net/");
        printDate(2,3);
        printDate(9,4);
        printDate(6,2);
    }

    public void printDate(int row,int column){
        String path = "//body//tr["+row+"]//td["+column+"]";
        WebElement data = driver.findElement(By.xpath(path));
        System.out.println("data.getText() = " + data.getText());
    }

}
