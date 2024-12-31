package UI.day05;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ExcelUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LoginPageTest {

    private WebDriver driver;

    public void LoginPageTest(WebDriver driver) {
        this.driver = driver;
    }

    public static void main(String[] args) {
        //Đường dan excel
        String excelFilePath = "dataLogin.xlsx";
        String sheetName = "Sheet2";

        //Doc du lieu tu file excel
        List<Map<String, String>> excelData = ExcelUtils.readExcelData(excelFilePath, sheetName);

        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try {
            //Duyet qua tung ban ghi trong du lieu
            for (Map<String, String> rowData : excelData) {
                System.out.println("Du lieu hang: " + rowData);
                String user = rowData.get("Username"); //Lay gia tri cot user
                String pass = rowData.get("Password"); //Lay gia tri cot pass
                driver.get("https://www.saucedemo.com/");
                WebElement inputUsername = driver.findElement(By.id("user-name"));
                inputUsername.sendKeys(user);
                WebElement inputPassword = driver.findElement(By.id("password"));
                inputPassword.sendKeys(pass);
                WebElement loginButton = driver.findElement(By.id("login-button"));
                loginButton.click();
            }
        }finally {
            driver.quit();
        }
    }
}