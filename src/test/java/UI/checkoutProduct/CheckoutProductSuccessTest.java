package UI.checkoutProduct;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckoutProductSuccessTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://saucedemo.com");
        WebElement loginCredentials = driver.findElement(By.xpath("//*[@id=\"login_credentials\"]"));
        String userNames = loginCredentials.getText();
        String[] listUserName = userNames.split("\n");
        String userName1 = listUserName[1];
        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys(userName1);
        WebElement passwordCredentials = driver.findElement(By.xpath("//div[@class = 'login_password']"));
        String passWords = passwordCredentials.getText();
        String[] listpassWords = passWords.split("\n");
        String passWord1 = listpassWords[1];
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys(passWord1);
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement addBackpack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addBackpack.click();
        WebElement addBikeLight = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        addBikeLight.click();
        WebElement addTShirt = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        addTShirt.click();
        WebElement checkCartIcon = driver.findElement(By.id("shopping_cart_container"));
        checkCartIcon.click();
        WebElement checkOutButton = driver.findElement(By.id("checkout"));
        checkOutButton.click();
        WebElement checkOutFirstName = driver.findElement(By.id("first-name"));
        checkOutFirstName.sendKeys("FirstName");
        WebElement checkOutLastName = driver.findElement(By.id("last-name"));
        checkOutLastName.sendKeys("FirstName");
        WebElement checkOutPostalCode = driver.findElement(By.id("postal-code"));
        checkOutPostalCode.sendKeys("0000");
        WebElement checkOutContinueButton = driver.findElement(By.id("continue"));
        checkOutContinueButton.click();
        WebElement checkOutFinishButton = driver.findElement(By.id("finish"));
        checkOutFinishButton.click();
        WebElement backToProductsButton = driver.findElement(By.id("back-to-products"));
        backToProductsButton.click();
        Thread.sleep(3000);
        driver.quit();
    }
}