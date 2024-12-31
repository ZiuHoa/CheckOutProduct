package UI.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

class MultiCheckboxTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/radio.html");

        //Them checkbox vao danh sach
        List<WebElement> checkboxes = new ArrayList<>();
        checkboxes.add(driver.findElement(By.id("vfb-6-0")));
        checkboxes.add(driver.findElement(By.id("vfb-6-1")));
        checkboxes.add(driver.findElement(By.id("vfb-6-2")));

        //Click vao checkbox trong danh sach va in gia tri
        for (WebElement checkbox : checkboxes){
            checkbox.click();
            System.out.println("Checkbox value selected: " + checkbox.getAttribute("value"));
        }
        driver.quit();
    }
}
