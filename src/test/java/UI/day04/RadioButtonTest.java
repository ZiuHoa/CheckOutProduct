package UI.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

class RadioButtonTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/radio.html");
 WebElement radioButton = driver.findElement(By.id("vfb-7-2"));
 radioButton.click();

 //Lay gia tri va trang thai cua radio button
        String value = radioButton.getAttribute("value");
        boolean isSelected = radioButton.isSelected();
        System.out.println("Radio button value is: " + value);
        System.out.println("Radio button is selected: " + isSelected);
        driver.quit();
    }
}