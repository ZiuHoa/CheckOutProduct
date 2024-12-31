package UI.submitDemo;

import UI.LoginDemoFindUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SubmitRequestDemoSuccessTest {
    private WebDriver driver;
    private static LoginDemoFindUI loginDemoFindUI;
    public SubmitRequestDemoSuccessTest(WebDriver driver) {
        this.driver = driver;
        this.loginDemoFindUI = new LoginDemoFindUI(driver);
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/request-demo");
        SubmitRequestDemoSuccessTest submitSuccess = new SubmitRequestDemoSuccessTest(driver);
        submitSuccess.loginDemoFindUI.findInputEmail().sendKeys("duyhoa.ic29@gmail.com");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //submitSuccess.loginDemoFindUI.findInputFirstName().sendKeys("FirstName");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='FirstName']")));
        emailField.sendKeys("FirstName");
        submitSuccess.loginDemoFindUI.findInputLastName().sendKeys("LastName");
        submitSuccess.loginDemoFindUI.findInputCompany().sendKeys("ABCompany");
        submitSuccess.loginDemoFindUI.findInputPhoneNumber().sendKeys("+84123456789");
        submitSuccess.loginDemoFindUI.findSelectCountry().click();
        submitSuccess.loginDemoFindUI.findCountry().click();
        submitSuccess.loginDemoFindUI.findSelectInterest().click();
        submitSuccess.loginDemoFindUI.findInterest().click();
        submitSuccess.loginDemoFindUI.findInputComments().sendKeys("Comments");
        submitSuccess.loginDemoFindUI.findCheckboxPolicy().click();
        submitSuccess.loginDemoFindUI.findButtonLetsTalk().click();
        Thread.sleep(5000);
        driver.quit();
    }
}
