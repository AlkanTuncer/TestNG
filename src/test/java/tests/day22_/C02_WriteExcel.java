package tests.day22_;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void testVerilerExcel(){

        String path = "src/test/java/resources/veriler.xlsx";

        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(fis);

            FileOutputStream fos = new FileOutputStream(path);

            // Satırlara sütun ekleme
            Sheet sheet = workbook.getSheetAt(0);
            sheet.getRow(0).createCell(3).setCellValue("Yorumlar");
            sheet.getRow(1).createCell(3).setCellValue("100");
            sheet.getRow(2).createCell(3).setCellValue("50");
            sheet.getRow(3).createCell(3).setCellValue("25");

            // Satır silmek
            Row silinecekSatir = sheet.getRow(3);  // 4.satır
            sheet.removeRow(silinecekSatir);

            // Hücre silmek
            Cell silinecekHücre = sheet.getRow(0).getCell(2);  // veriler.xlsx - Kategori
            sheet.getRow(0).removeCell(silinecekHücre);

            workbook.write(fos);

            workbook.close();
            fis.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
