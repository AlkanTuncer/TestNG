package tests.day22_;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void testVeriler(){

        String path = "src/test/java/resources/veriler.xlsx";

        try {
            // Exceli okumak
            FileInputStream fis = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(fis);

            // Sheet(Sayfa) seçimi
            Sheet sheet = workbook.getSheet("Sayfa1");  // Sayfa1 seçildi.

            // Row(Satır) seçimi
            Row row = sheet.getRow(0);   // 0.index'deki satır(1.satır) seçildi.

            // Cell(hücre-data) seçimi
            Cell cell = row.getCell(0);  // 0.index'deki hücre(1.hücre) seçildi.
            System.out.println("row.getCell(0) = " + row.getCell(0));  // Excel dosyasında 1.satır 1.hücreyi yazdırır. -> isim

            for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
                System.out.println((i+1)+". Cell : "+row.getCell(i));
            }

            // İçerisinde data olan satır sayısı
            int doluSatir = sheet.getPhysicalNumberOfRows();
            System.out.println("Dolu satır sayısı : "+doluSatir);

            // Dolu ya da boş kullanılan bütün satırlar
            int satirSayisi = sheet.getLastRowNum();
            System.out.println("Satır sayısı : "+satirSayisi);  // -> İndex'i verir. (3 index/4 satır)


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
