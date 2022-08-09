package tests.day21_ExcelAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class C05_ExceliMapeYukleme {

    @Test
    public void excelToMap(){
        String path = "src/test/java/resources/ulkeler.xlsx";
        String sayfaAdi = "Sayfa1";

        Map<String,String> mapUlkeler = C03_ReusableMethodsExcel.excelToMap(path,sayfaAdi);

        // Map kullanarak "Cuba" bilgilerini yazdırınız.
        System.out.println("Cuba Bilgileri : "+mapUlkeler.get("Cuba"));

        // Map'de Nepal oldugunu test edin.
        Assert.assertTrue(mapUlkeler.containsKey("Nepal"),"Map'de 'Nepal' yoktur.");

    }

}
