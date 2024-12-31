package UI.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class DropdownSelectExampleTest {
        private WebDriver driver;
        public void dropdownSelectExampleTest(WebDriver driver) {
            this.driver = driver;
        }

public static void main(String[] args) throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://saucelabs.com/request-demo");
    WebElement interestDropdown = driver.findElement(By.name("Solution_Interest__c"));
    Select select = new Select(interestDropdown);
    //select.selectByValue("Replace DIY (In-house) Testing");
    //select.selectByIndex(6);
    select.selectByVisibleText("CI/CD Pipeline Optimization ");
    driver.quit();
        }
}
