package UI.day05;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadToFile {
    public static void main(String[] args) {
        try (FileInputStream file = new FileInputStream("dataLogin.xlsx");
             Workbook workbook = new XSSFWorkbook(file)) {
            Sheet sheetDataLogin = workbook.getSheetAt(0);
            DataFormatter dataFormatter = new DataFormatter();

            //Doc du lieu tu file Excel
            for (Row row : sheetDataLogin) {
                if (row.getRowNum() == 0) continue;  //Bo qua hang tieu de

                //Lay cac gia tri tu cot User (0) vaf Pass (1)
                String user = dataFormatter.formatCellValue(row.getCell(0)).trim();
                String pass = dataFormatter.formatCellValue(row.getCell(1)).trim();

                //In ra khi ca User va Pass khong rong
                if (!user.isEmpty() || !pass.isEmpty()) {
                    System.out.println("User: " + user);
                    System.out.println("Pass: " + pass);
                }
            }

        } catch (FileNotFoundException e) {
            //throw new RuntimeException(e);
            System.err.println("Không tìm thấy file: " + e.getMessage());
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.err.println("Đã xảy ra lỗi khi đọc file Excel: " + e.getMessage());
        }
    }

}
