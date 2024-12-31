package UI.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

class RightClickTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement button = driver.findElement(By.xpath("//span[@class=\"context-menu-one btn btn-neutral\"]"));

        //Tao doi tuong de action double click
        Actions actions = new Actions(driver);
        //Double click vao button
        actions.contextClick(button).perform();
        Thread.sleep(3000);

        WebElement select = driver.findElement(By.xpath("//span[contains(text(),'Edit')]"));
        select.click();
        //Xu ly arlert xuat hien sau double click
        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert text after double click: " + alertText);
        //Dong alert
        driver.switchTo().alert().accept();
        //driver.quit();
    }
}