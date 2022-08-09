package tests.day21_ExcelAutomation;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_SatirSayisi {

    @Test
    public void testSatirSayisi(){

        // ulkeler excel'inde Sayfa1 ve Sayfa2'deki total satır sayıları bulun.

        String path = "src/test/java/resources/ulkeler.xlsx";

        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(fis);

            int satirSayisiS1 = workbook.getSheet("Sayfa1").getLastRowNum();  // index ile çalışır.
            int fizikselSatirNoS1 = workbook.getSheet("Sayfa1").getPhysicalNumberOfRows(); // index ile değil sayma sayısı ile çalışır.

            System.out.println("Satır Sayısı S1 - index : "+satirSayisiS1);
            System.out.println("Fiziksel Satır No S1 : "+fizikselSatirNoS1);

            int satirSayisiS2 = workbook.getSheet("Sayfa2").getLastRowNum();  // boş olan satırlarıda aldı.
            int fizikselSatirNoS2 = workbook.getSheet("Sayfa2").getPhysicalNumberOfRows(); // dolu olan satırları alıyor sadece.

            System.out.println("Satır Sayısı S2 - index : "+satirSayisiS2);
            System.out.println("Fiziksel Satır No S2 : "+fizikselSatirNoS2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
