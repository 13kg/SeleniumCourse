package pl.coderslab.seleniumcourse.cucumber.pageobject.zad4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void myAddressBtn(){
        WebElement myAddressesBtn = driver.findElement(By.cssSelector("#center_column > div > div > ul > li:nth-child(4) > a > span"));
        myAddressesBtn.click();
    }

}
