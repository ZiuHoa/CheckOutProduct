package UI.day05;

import UI.checkoutProduct.Inventory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ExcelUtils;

import java.util.List;
import java.util.Map;


public class AddToCartTest {
    private static WebDriver driver;

    public AddToCartTest(WebDriver driver) {
        this.driver = driver;
    }

    public static void main(String[] args) throws NullPointerException {
        //Đường dan excel
        String excelFilePath = "productData.xlsx";
        String sheetName = "Sheet3";

        //Doc du lieu tu file excel
        List<Map<String, String>> excelData = ExcelUtils.readExcelData(excelFilePath, sheetName);


        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("standard_user");

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();

        try {
            //Duyet qua tung ban ghi trong du lieu
            for (Map<String, String> rowData : excelData) {
                System.out.println("Du lieu hang: " + rowData);
                String product = rowData.get("Product"); //Lay gia tri cot product
                WebElement addToCart = driver.findElement(By.xpath("//div[contains(text(),'" + product + "')]/ancestor::div[@class='inventory_item_description']/descendant::button"));
                WebElement addToCart1 = addToCart;
                addToCart1.click();
            }
        } finally {
            WebElement shoppingCart = driver.findElement(By.className("shopping_cart_link"));
            shoppingCart.click();

            WebElement buttonCheckout = driver.findElement(By.id("checkout"));
            buttonCheckout.click();

            WebElement inputFirstName = driver.findElement(By.id("first-name"));
            inputFirstName.sendKeys("Hoang Thai");

            WebElement inputLastName = driver.findElement(By.id("last-name"));
            inputLastName.sendKeys("Ha");

            WebElement inputZip = driver.findElement(By.id("postal-code"));
            inputZip.sendKeys("123456");

            WebElement buttonContinue = driver.findElement(By.id("continue"));
            buttonContinue.click();

            WebElement buttonFinish = driver.findElement(By.id("finish"));
            buttonFinish.click();

            WebElement messageComplete = driver.findElement(By.xpath("//span[@class='title']"));
            System.out.println("Message: " + messageComplete.getText());

            WebElement backToProductsButton = driver.findElement(By.id("back-to-products"));
            backToProductsButton.click();

            driver.quit();
        }
    }
}