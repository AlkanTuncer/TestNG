package tests.day21_ExcelAutomation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReusableMethodsExcel {

    public static Cell hucreGetir(String path, String sayfaAdi, int satirIndex, int hücreIndex){
        Cell cell = null;
        try {
            FileInputStream fis =  new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(fis);
            cell = workbook.getSheet(sayfaAdi).getRow(satirIndex).getCell(hücreIndex);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cell;
    }

}
