package tests.day21_ExcelAutomation;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C06_WriteExcel {

    // ulkeler exceline 5.sutun olarak NUFUS sutunu ekleyelim
    // 4.satirdaki ulkenin nufusunu 5000 yapalim

    @Test
    public void writeExcel(){
        String path = "src/test/java/resources/ulkeler.xlsx";

        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(fis);
            workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("NUFUS");
            workbook.getSheet("Sayfa1").getRow(4).createCell(4).setCellValue("5000");

            FileOutputStream fos = new FileOutputStream(path);
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
