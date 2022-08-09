package tests.day21_ExcelAutomation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

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

    public static Map<String,String> excelToMap(String path,String sayfaAdi){
        Map<String,String> map = new TreeMap<>();

        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(fis);

            int satirSayisi = workbook.getSheet(sayfaAdi).getLastRowNum();
            String key = "",value ="";

            for (int i = 0; i < satirSayisi; i++) {
                key = workbook.getSheet(sayfaAdi).getRow(i).getCell(0).getStringCellValue();
                value = workbook.getSheet(sayfaAdi).getRow(i).getCell(1).getStringCellValue()+" "+
                        workbook.getSheet(sayfaAdi).getRow(i).getCell(2).getStringCellValue()+" "+
                        workbook.getSheet(sayfaAdi).getRow(i).getCell(3).getStringCellValue();

                map.put(key,value);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

}
