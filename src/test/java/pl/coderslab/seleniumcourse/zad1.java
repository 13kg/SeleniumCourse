package pl.coderslab.seleniumcourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class zad1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://duckduckgo.com/");
        WebElement searachInput = driver.findElement(By.name("q"));
        searachInput.sendKeys("kurs java");
        searachInput.submit();

    }
}
