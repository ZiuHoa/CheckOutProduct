package UI.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class JavaScriptExecutor {
    private WebDriver driver;
    public void dropdownSelectExampleTest(WebDriver driver) {
        this.driver = driver;
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/request-demo");
        WebElement interestDropdown = driver.findElement(By.name("Solution_Interest__c"));

        //Tao doi tuong JavaExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Thuc thi doan ma, thay doi gia tri option
        js.executeScript("arguments[0].value='Visual Testing';", interestDropdown);

        //Kiem tra gia tri duoc chon

        //driver.quit();
    }
}
