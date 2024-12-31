package UI.submitDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageUITest {
    public PageUITest(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    public WebElement inputUser() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement inputPass() {
        return driver.findElement(By.id("password"));
    }

    public WebElement loginButton() {
        return driver.findElement(By.id("login-button"));
    }

    public WebElement productBackpack(){ return driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));}
    public WebElement productBike(){ return driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));}
    public WebElement productTshirt(){ return driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));}



    public WebElement getCheckCartIcon() { return driver.findElement(By.id("shopping_cart_container"));}

    public WebElement checkOutButton() { return driver.findElement(By.id("checkout"));}

    public WebElement  checkOutFirstName() { return driver.findElement(By.id("first-name"));}

    public WebElement  checkOutLastName() { return driver.findElement(By.id("last-name"));}

    public WebElement  checkOutPostalCode() { return driver.findElement(By.id("postal-code"));}
    public WebElement checkOutCancelButton() {return driver.findElement(By.id("cancel"));}

    public WebElement  checkOutContinueButton() { return driver.findElement(By.id("continue"));}

    public WebElement  checkOutFinishButton() { return driver.findElement(By.id("finish"));}

    public WebElement  backToProductsButton() { return driver.findElement(By.id("back-to-products"));}


}
