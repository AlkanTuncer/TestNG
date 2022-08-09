package tests.day21_ExcelAutomation;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel {

    // ulkeler'den 4.satırı yazdırın.

    @Test
    public void testUlkelerRow3() throws IOException {
        String path = "src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(3);

        System.out.print("3.Satır : ");
        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
            System.out.print(row.getCell(i)+" ");
        }
    }

}
