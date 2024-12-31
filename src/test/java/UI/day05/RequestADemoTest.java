package UI.day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ExcelUtils;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class RequestADemoTest {
    private static WebDriver driver;

    public RequestADemoTest(WebDriver driver) {
        this.driver = driver;
    }

    public static void main(String[] args) throws NullPointerException {
        //Đường dan excel
        String excelFilePath = "infoUser.xlsx";
        String sheetName = "Sheet1";

        //Doc du lieu tu file excel
        List<Map<String, String>> excelData = ExcelUtils.readExcelData(excelFilePath, sheetName);

        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/request-demo");

        try {
            //Duyet qua tung ban ghi trong du lieu
            for (Map<String, String> rowData : excelData) {
                System.out.println("Du lieu hang: \n " + rowData);
                String email = rowData.get("Email"); //Lay gia tri cot product
                String firstName = rowData.get("First Name");
                String lastName = rowData.get("Last Name");
                String company = rowData.get("Company");
                String phoneNumber = rowData.get("Phone Number");
                String country = rowData.get("Country");
                String interest = rowData.get("Interest");
                String comment = rowData.get("Comment");
                //Tim element va dien thong tin
                WebElement inputEmail = driver.findElement(By.xpath("//input[@id='Email']"));
                WebElement inputEmail1 = inputEmail;
                inputEmail1.sendKeys(email);

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                WebElement inputFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='FirstName']")));
                WebElement inputFirstName1 = inputFirstName;
                inputFirstName1.sendKeys(firstName);

                WebElement inputLastName = driver.findElement(By.xpath("//input[@id='LastName']"));
                WebElement inputLastName1 = inputLastName;
                inputLastName1.sendKeys(lastName);

                WebElement inputCompany = driver.findElement(By.xpath("//input[@id='Company']"));
                WebElement inputCompany1 = inputCompany;
                inputCompany1.sendKeys(company);

                WebElement inputPhoneNumber = driver.findElement(By.xpath("//input[@id='Phone']"));
                WebElement inputPhoneNumber1 = inputPhoneNumber;
                inputPhoneNumber1.sendKeys(phoneNumber);

                WebElement selectCountry = driver.findElement(By.xpath("//option[@value='"+country+"']"));
                WebElement selectCountry1 = selectCountry;
                selectCountry1.click();

                WebElement selectInterest = driver.findElement(By.xpath("//option[@value='"+interest+"']"));
                WebElement selectInterest1 = selectInterest;
                selectInterest1.click();

                WebElement inputComment = driver.findElement(By.xpath("//textarea[@id='Sales_Contact_Comments__c']"));
                WebElement inputComment1 = inputComment;
                inputComment1.sendKeys(comment);

                WebElement checkBoxPolicy = driver.findElement(By.xpath("//label[@id='LblmktoCheckbox_44280_0']"));
                WebElement checkBoxPolicy1 = checkBoxPolicy;
                checkBoxPolicy1.click();

                WebElement selectLetsTalk = driver.findElement(By.xpath("//button[contains(text(),'Talk')]"));
                WebElement selectLetsTalk1 = selectLetsTalk;
                selectLetsTalk1.click();

            }
        } finally {
            driver.quit();
        }
    }}

//public static void main(String[] args) {
//    // Đường dẫn Excel
//    String excelFilePath = "infoUser.xlsx";
//    String sheetName = "Sheet1";
//
//    // Đọc dữ liệu từ file Excel
//    List<Map<String, String>> excelData = ExcelUtils.readExcelData(excelFilePath, sheetName);
//
//    // Khởi tạo WebDriver
//    WebDriver driver = new ChromeDriver();
//    driver.manage().window().maximize();
//    // Khởi tạo WebDriverWait
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//    driver.get("https://saucelabs.com/request-demo");
//    // Duyệt qua từng bản ghi trong dữ liệu
//    for (Map<String, String> rowData : excelData) {
//        System.out.println("Dữ liệu hàng: \n " + rowData);
//
//        // Lấy dữ liệu từ Excel
//        String email = rowData.get("Email");
//        String firstName = rowData.get("First Name");
//        String lastName = rowData.get("Last Name");
//        String company = rowData.get("Company");
//        String phoneNumber = rowData.get("Phone Number");
//        String country = rowData.get("Country");
//        String interest = rowData.get("Interest");
//        String comment = rowData.get("Comment");
//
//        // Nhập dữ liệu vào các trường
//        driver.findElement(By.id("Email")).sendKeys(email);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName"))).sendKeys(firstName);
//        driver.findElement(By.id("LastName")).sendKeys(lastName);
//        driver.findElement(By.id("Company")).sendKeys(company);
//        driver.findElement(By.id("Phone")).sendKeys(phoneNumber);
//
//        driver.findElement(By.xpath("//option[@value='" + country + "']")).click();
//        driver.findElement(By.xpath("//option[@value='" + interest + "']")).click();
//
//        driver.findElement(By.id("Sales_Contact_Comments__c")).sendKeys(comment);
//        driver.findElement(By.id("LblmktoCheckbox_44280_0")).click();
//
//        // Gửi yêu cầu
//        driver.findElement(By.xpath("//button[contains(text(),'Talk')]")).click();
//    }
//    // Đảm bảo đóng trình duyệt sau khi thực hiện xong
//    driver.quit();
//}
