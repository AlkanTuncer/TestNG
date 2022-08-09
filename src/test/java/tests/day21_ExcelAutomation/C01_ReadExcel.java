package tests.day21_ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {

    // dosya/sayfa/satır/sütun   -> hücredeki data'ya ulaşmak için izlenicek yol.

    // Workbook - Excel dosyamız
    // Sheet    - Her açık excel sekmesi, sayfası
    // Row      - İçinde veri olan satırlar. Veri yoksa satır sayısı 0'dır.

    @Test
    public void test01() throws IOException {

        String path = "src/test/java/resources/ulkeler.xlsx";   // ulkeler.xlsx sağ tıkla copy path ile content root'a tıklayacaksın.
        FileInputStream fis = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fis);   // Excel dosyasını seçtik.
        Sheet sheet = workbook.getSheet("Sayfa1");      // Dosyadaki sayfayı seçtik.
        Row row = sheet.getRow(5);                     //  Satırı seçtik.                          -> Row ve Cell seçerken indekse göre seçmemiz lazım.
        Cell cell = row.getCell(2);                     // Seçilen satırdaki 3.datayı seçtik.        0'dan baslayarak saymamız gerekli. 3 için 2.indeks

        System.out.println("Cell : "+cell);

        String expectedCell = "Angola";
        Assert.assertEquals(cell.getStringCellValue(),expectedCell,"Test FAILED - Angola değil.");

        // Kostarika yazdırın.
        row = sheet.getRow(40);
        cell = row.getCell(2);
        System.out.println("Cell : "+cell);

    }

}