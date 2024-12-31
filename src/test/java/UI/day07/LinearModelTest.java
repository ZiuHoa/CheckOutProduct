package UI.day07;

import UI.submitDemo.PageUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LinearModelTest {
    public WebDriver driver;
    WebDriverWait wait;
    public PageUITest pageUITest;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://saucedemo.com");

    }

    @BeforeMethod
    public void setUrl() {
        driver.get("https://saucedemo.com");
        pageUITest = new PageUITest(driver);
    }

    //Su dung module cach 2
    public void InputData(String user, String pass) {
        pageUITest.inputUser().sendKeys(user);
        pageUITest.inputPass().sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void logInSuccess() {
        //Su dung module cach 2
        InputData("standard_user", "secret_sauce");
        clickLogin();
    }

    @Test
    public void logInInvalidUsername() {
        InputData("standard", "secret_sauce");
        clickLogin();
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@data-test=\"error\"]")));
        String actualMessage = errorMessage.getText();
        Assert.assertEquals(actualMessage, "Epic sadface: Username and password do not match any user in this service", "Error message does not match " + "expected.");
    }

    @Test
    public void logInInvalidPassword() {
        //Su dung tuong minh cach 1
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret");
        driver.findElement(By.id("login-button")).click();
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@data-test=\"error\"]")));
        String actualMessage = errorMessage.getText();
        Assert.assertEquals(actualMessage, "Epic sadface: Username and password do not match any user in this service", "Error message does not match " + "expected.");
    }

    @Test
    public void logInSubmitInvalidInfo() {
        driver.findElement(By.id("user-name")).sendKeys("standard");
        driver.findElement(By.id("password")).sendKeys("secret");
        driver.findElement(By.id("login-button")).click();
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@data-test=\"error\"]")));
        String actualMessage = errorMessage.getText();
        Assert.assertEquals(actualMessage, "Epic sadface: Username and password do not match any user in this service", "Error message does not match " + "expected.");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}