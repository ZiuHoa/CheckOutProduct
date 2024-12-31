package UI.saucedemo;

import UI.submitDemo.PageUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.ExcelUtils;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CheckoutTest {
    public WebDriver driver;
    WebDriverWait wait;
    public PageUITest pageUITest;

    @BeforeMethod
    public void login() {
        driver = new ChromeDriver(); // Khởi tạo lại trình duyệt
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://saucedemo.com");
        pageUITest = new PageUITest(driver);
        pageUITest.inputUser().sendKeys("standard_user");
        pageUITest.inputPass().sendKeys("secret_sauce");
        pageUITest.loginButton().click();
        pageUITest.productBackpack().click();
        pageUITest.productBike().click();
        pageUITest.productTshirt().click();
        pageUITest.getCheckCartIcon().click();
        pageUITest.checkOutButton().click();
    }
    @DataProvider(name = "infoCustomerData")
    public Object[][] provideTestData() {
        String excelFilePath = "infoCustomer.xlsx";
        String sheetName = "Sheet3";
        try {
            // Đọc dữ liệu từ file Excel
            List<Map<String, String>> excelData = ExcelUtils.readExcelData(excelFilePath, sheetName);

            // Chuyển đổi danh sách Map thành mảng 2 chiều
            Object[][] data = new Object[excelData.size()][1];
            for (int i = 0; i < excelData.size(); i++) {
                data[i][0] = excelData.get(i);
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi đọc tệp Excel: " + e.getMessage());
        }
    }

    public void fillForm(Map<String, String> rowData) {
        try {
            driver.findElement(By.id("first-name")).sendKeys(rowData.get("First Name"));
            driver.findElement(By.id("last-name")).sendKeys(rowData.get("Last Name"));
            driver.findElement(By.id("postal-code")).sendKeys(rowData.get("Zip Code"));
            pageUITest.checkOutContinueButton().click();
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi điền form: " + e.getMessage());
        }
    }

    @Test(dataProvider = "infoCustomerData")

    public void checkoutSuccess(Map<String, String> rowData) {
        fillForm(rowData);
        List<WebElement> productElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='inventory_item_name']")));
        List<String> expectedProductNames = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt");
        try {
        for (int i = 0; i < productElements.size(); i++) {
            String actualProductName = productElements.get(i).getText();
            String expectedProductName = expectedProductNames.get(i);
            Assert.assertEquals(actualProductName, expectedProductName,
                    "Tên sản phẩm tại vị trí " + (i + 1) + " không khớp!");

        }
        System.out.println("Đã đúng danh sách sản phẩm");
    } catch(Exception e) {
        System.out.println(" Có lỗi với danh sách sản phẩm: " + e.getMessage());
    }
        pageUITest.checkOutFinishButton().click();
        pageUITest.backToProductsButton().click();
}

    @Test(dataProvider = "infoCustomerData")
    public void testFirstNameNull(Map<String, String> rowData) {
        rowData.put("First Name", ""); // Đặt First Name trống
        fillForm(rowData);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error-message-container error']/h3[@data-test='error' and text()='Error: First Name is required']")));
        String actualMessage = errorMessage.getText();
        Assert.assertEquals(actualMessage, "Error: First Name is required");
    }
    @Test(dataProvider = "infoCustomerData")
    public void testLastNameNull(Map<String, String> rowData) {
        rowData.put("Last Name", ""); // Đặt Last Name trống
        fillForm(rowData);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error-message-container error']/h3[@data-test='error' and text()='Error: Last Name is required']")));
        String actualMessage = errorMessage.getText();
        Assert.assertEquals(actualMessage, "Error: Last Name is required");
    }
    @Test(dataProvider = "infoCustomerData")
    public void testZipCodeNull(Map<String, String> rowData) {
        rowData.put("Zip Code", ""); // Đặt Zip Code trống
        fillForm(rowData);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error-message-container error']/h3[@data-test='error' and text()='Error: Postal Code is required']")));
        String actualMessage = errorMessage.getText();
        Assert.assertEquals(actualMessage, "Error: Postal Code is required");
    }

    @AfterMethod
    public void tearDown() {
            driver.quit();
    }
}