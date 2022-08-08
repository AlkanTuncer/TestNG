package tests.day20_JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class C03_WebTables extends TestBase {

    /*
        <table>                                                 Soldaki HTML Tablosu
            <tr>
                <th>First Name</th>                         First Name    Last Name      Age
                <th>Last Name</th>                            Alkan         Tuncer       30
                <th>Age</th>                                 Caglasu         Buke        25
            </tr>
            <tr>
                <td>Alkan</td>
                <td>Tuncer</td>
                <td>30</td>
            </tr>
            <tr>
                <td>Caglasu</td>
                <td>Buke</td>
                <td>25</td>
            </tr>
        </table>
     */

        // https://editor.datatables.net/

    @Test
    public void table(){
        // table() metodu oluşturun
        driver.navigate().to("https://editor.datatables.net/");

        // ○ Tüm table body’sinin boyutunu(size) bulun. /tbody
        List<WebElement> tbody = driver.findElements(By.xpath("//tbody//td"));   // tbody diye ararsak 1 tane cıkar. İçeriğine erişmemiş lazım.
        System.out.println("tbody sayısı : "+tbody.size());

        // ○ Table’daki başlıkları(headers) konsolda yazdırın.
        List<WebElement> headers = driver.findElements(By.xpath("//thead//th"));
        for (int i = 0; i < headers.size(); i++) {
            System.out.println((i+1)+". Başlık : "+headers.get(i).getText());
        }

    }

    @Test
    public void printRows(){
        // ● printRows() metodu oluşturun //tr
        driver.navigate().to("https://editor.datatables.net/");

        // ○ table’da bulunan toplam satir(row) sayısını bulun.
        List<WebElement> row = driver.findElements(By.xpath("//table//tr"));
        System.out.println("Toplam Satır (Row - tr) : "+row.size());

        // ○ Table’de bulunan satirlari(rows) konsolda yazdırın.
        for (int i = 0; i < row.size(); i++) {
            System.out.println((i+1)+". Satır : "+row.get(i).getText());
        }

        // ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        WebElement row4 = driver.findElement(By.xpath("//table//tr[4]"));
        System.out.println("4.Satır : "+row4.getText());
    }

    @Test
    public void printCells(){
        // ● printCells() metodu oluşturun //td
        driver.navigate().to("https://editor.datatables.net/");

        // ○ table’de bulunan toplam hücre(cell) sayısını bulun.
        List<WebElement> tableData = driver.findElements(By.xpath("//table//td"));
        System.out.println("Toplam Hücre(cell) : "+tableData.size());

        // ○ Table’de bulunan hücreleri(cells) konsolda yazdırın.
        for (int i = 0; i < tableData.size(); i++) {
            System.out.println((i+1)+". Data : "+tableData.get(i).getText());
        }
    }

    @Test
    public void printColumns() {
        // ● printColumns() metodu oluşturun
        driver.navigate().to("https://editor.datatables.net/");

        // ○ table’de bulunan toplam sutun(column) sayısını bulun.
        List<WebElement> column = driver.findElements(By.xpath("//tr[6]//td"));
        System.out.println("Sütun sayısı : "+column.size());

        // ○ Table’de bulunan bir sütunu(column) konsolda yazdırın.
        List<WebElement> office = driver.findElements(By.xpath("//tbody//td[4]"));
        for (WebElement officeColumn : office){
            System.out.println("officeColumn.getText() = " + officeColumn.getText());
        }

        // ○ 5.column daki elementleri konsolda yazdırın.
        List<WebElement> column5 = driver.findElements(By.xpath("//tbody//td[5]"));
        for (WebElement column53 : column5){
            System.out.println("officeColumn.getText() = " + column53.getText());
        }
    }
}
