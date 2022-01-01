package pl.coderslab.seleniumcourse.cucumber.pageobject.zad4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class YourAddressesPage {
    private WebDriver driver;

    public YourAddressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(String address, String zip, String city, String mobile, String title) {

        WebElement addressInput = driver.findElement(By.id("address1"));
        WebElement zipInput = driver.findElement(By.id("postcode"));
        WebElement cityInput = driver.findElement(By.id("city"));
        WebElement mobileInput = driver.findElement(By.id("phone_mobile"));
        WebElement titleInput = driver.findElement(By.id("alias"));

        addressInput.sendKeys(address);
        zipInput.sendKeys(zip);
        cityInput.sendKeys(city);
        mobileInput.sendKeys(mobile);
        titleInput.clear();
        titleInput.sendKeys(title);
    }

    public void saveBtn(){
        WebElement saveBtn = driver.findElement(By.id("submitAddress"));
        saveBtn.click();
    }


}