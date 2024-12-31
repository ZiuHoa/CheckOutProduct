package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginDemoFindUI {
    private WebDriver driver;

    public void LoginPageUI(WebDriver driver) {
        this.driver = driver;
    }

    public LoginDemoFindUI(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findLabelBook() {
        return driver.findElement(By.xpath("//span[contains(text(),'Book')]"));
    }
    public WebElement findLabelEmail() {
        return driver.findElement(By.xpath("//label[text()='Business Email:']"));
    }
    public WebElement findInputEmail() {
        return driver.findElement(By.xpath("//input[@id='Email']"));
    }
    public WebElement findInputFirstName() {
        return driver.findElement(By.xpath("//input[@id='FirstName']"));
    }
    public WebElement findInputLastName() {
        return driver.findElement(By.xpath("//input[@id='LastName']"));
    }
    public WebElement findLabelCompany() {
        return driver.findElement(By.xpath("//label[@id='LblCompany']"));
    }
    public WebElement findInputCompany() {
        return driver.findElement(By.xpath("//input[@id='Company']"));
    }
    public WebElement findInputPhoneNumber() {
        return driver.findElement(By.xpath("//input[@id='Phone']"));
    }
    public WebElement findSelectCountry() {
        return driver.findElement(By.xpath("//select[@id='Country']"));
    }
    public WebElement findCountry() {
        return driver.findElement(By.xpath("//option[@value='Angola']"));
    }
    public WebElement findLabelInterest() {
        return driver.findElement(By.xpath("//label[text()='Interest:']"));
    }
    public WebElement findSelectInterest() {
        return driver.findElement(By.xpath("//select[@id='Solution_Interest__c']"));
    }
    public WebElement findInterest() {
        return driver.findElement(By.xpath("//option[@value='Test Analytics']"));
    }
    public WebElement findLabelComments() {
        return driver.findElement(By.xpath("//label[@id='LblSales_Contact_Comments__c']"));
    }
    public WebElement findInputComments() {
        return driver.findElement(By.xpath("//textarea[@id='Sales_Contact_Comments__c']"));
    }
    public WebElement findCheckboxPolicy() {
        return driver.findElement(By.xpath("//label[@id='LblmktoCheckbox_44280_0']"));
    }
    public WebElement findButtonLetsTalk() {
        return driver.findElement(By.xpath("//button[contains(text(),'Talk')]"));
    }
}
