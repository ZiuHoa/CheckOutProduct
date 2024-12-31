package UI.saucedemo;

import UI.submitDemo.PageUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ExcelUtils;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class AddToCartTest {
    public WebDriver driver;
    WebDriverWait wait;
    double totalPrice = 0.0;
    double totalPriceNew = 0.0;
    public PageUITest pageUITest;
    String productData = "productData.xlsx";


    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @BeforeMethod
    public void login() {
        driver.get("https://saucedemo.com");
        pageUITest = new PageUITest(driver);
        pageUITest.inputUser().sendKeys("standard_user");
        pageUITest.inputPass().sendKeys("secret_sauce");
        pageUITest.loginButton().click();
    }
    @Test
    public void addToCartSuccess() {

        //Duyet qua tung ban ghi trong du lieu
        List<Map<String, String>> excelData = ExcelUtils.readExcelData(productData, "Sheet3");
        for
        (Map<String, String> rowData : excelData) {
            System.out.println("Du lieu hang: " + rowData);
            String product = rowData.get("Product"); //Lay gia tri cot product
            driver.findElement(By.xpath("//div[contains(text(),'" + product + "')]/ancestor::div[@class='inventory_item_description']/descendant::button")).click();
            //Tim gia san pham
            WebElement productPriceElement = driver.findElement(By.xpath("//div[contains(@class, 'inventory_item_name') and text()='" + product + "']/ancestor::div[contains(@class, 'inventory_item')]//div[contains(@class, 'inventory_item_price')]"));
            double productPrice = Double.parseDouble(productPriceElement.getText().replace("$", ""));
            totalPrice += productPrice;
            System.out.println("Tong gia san pham trong gio hang: $ " + totalPrice);
            WebElement cartCountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")));
            int cartCount = Integer.parseInt(cartCountElement.getText());
            System.out.println("So luong san pham trong gio hang: " + cartCount);
        }
    }
    @Test
    public void removeProductSuccess() {

        // Doc Excel
        List<Map<String, String>> excelData = ExcelUtils.readExcelData(productData, "Sheet3");


        // Duyet qua tung ban ghi trong du lieu
        for (Map<String, String> rowData : excelData) {
            String product = rowData.get("Product"); // Lay du lieu tu Product
            // Remove san pham
            try {
                WebElement removeButton = driver.findElement(By.xpath("//div[contains(text(),'" + product + "')]/ancestor::div[@class='inventory_item_description']/descendant::button"));
                removeButton.click();
                System.out.println("San pham duoc remove: " + product);
                // Lay gia moi
                WebElement productPriceElement = driver.findElement(By.xpath("//div[contains(@class, 'inventory_item_name') and text()='" + product + "']/ancestor::div[contains(@class, 'inventory_item')]//div[contains(@class, 'inventory_item_price')]"));
                double productPrice = Double.parseDouble(productPriceElement.getText().replace("$", ""));
                totalPriceNew = totalPrice - productPrice;
                System.out.println("Gia san pham con lai: $" + totalPriceNew);
                WebElement cartCountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")));
                int cartCount = Integer.parseInt(cartCountElement.getText());
                System.out.println("So luong san pham trong gio hang: " + cartCount);
                break;
            } catch (Exception e) {
                System.out.println("Loi khong thay san pham: " + product);
            }
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}