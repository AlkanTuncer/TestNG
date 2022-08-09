package tests.day21_ExcelAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_ReusableRunner {

    // ulkeler excel'indeki Sayfa1'de
    // 11.index'deki satırın, 2.index'deki hücresinin Azerbaycan oldugunu test edin.

    @Test
    public void taskTest() {
        String path = "src/test/java/resources/ulkeler.xlsx";

        String expectedCell = "Azerbaycan";

        String actualCell = C03_ReusableMethodsExcel.hucreGetir(path,"Sayfa1",11,2).getStringCellValue();

        Assert.assertEquals(actualCell,expectedCell,"Test FAILED - Azerbaycan değil.");
    }
}
