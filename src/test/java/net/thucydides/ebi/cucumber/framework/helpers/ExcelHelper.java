package net.thucydides.ebi.cucumber.framework.helpers;

import com.monitorjbl.xlsx.StreamingReader;

import net.thucydides.ebi.cucumber.pages.fullTextDataPipelineImpl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;

import java.util.ArrayList;

import java.util.List;


public class ExcelHelper {

    public static ArrayList<List<String>> ReadFullTextIndexPipeLineData(String filename) throws Exception {
        String lookupValue=null;
        FileInputStream fileInputStream = null;
        ArrayList<List<String>> fileValues = new ArrayList<List<String>>();
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources"+"\\"+filename);
            Workbook workbook = StreamingReader.builder()
                    .rowCacheSize(100)
                    .bufferSize(4096)
                    .open(fileInputStream);
            Sheet worksheet = workbook.getSheet("DataLoadingStatus");

            int index = -1;
            for (Row r : worksheet) {
                List<String> rowValue = new ArrayList<String>();
                int col = -1;
                index = index +1;
                int colCount = r.getLastCellNum();
                for (Cell c : r) {
                    col = col +1;
                    lookupValue = c.getStringCellValue();
                    rowValue.add(col,lookupValue);
                    if (col+1 ==colCount-1) {
                        break;
                    }
                }
                fileValues.add(index,rowValue);
            }

        } catch (Exception e) {
            throw new Exception("Failed to retrieve value from the Excel Files/File Does NOT exist" + e.getMessage());
        } finally {
            fileInputStream.close();
        }
        return fileValues;
    }
}

