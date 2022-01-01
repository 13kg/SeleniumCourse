package pl.coderslab.seleniumcourse.cucumber.pageobject.zad4;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MyAddressesPage {
    private WebDriver driver;

    public MyAddressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addAddressBtn() {
        WebElement addAddressBtn = driver.findElement(By.cssSelector("#center_column > div > a > span"));
        addAddressBtn.click();
    }

    public String correctTitle() {
        WebElement listNamePanel = driver.findElement(By.cssSelector("#center_column > div.addresses > div > div > ul > li:nth-child(1) > h3"));
        return listNamePanel.getText();
    }

    public void clearData() {
        WebElement deleteBtn = driver.findElement(By.cssSelector("#center_column > div.addresses > div > div > ul > li.address_update > a:nth-child(2) > span"));
        deleteBtn.click();
        driver.switchTo().alert().accept();
        WebElement logMenu = driver.findElement(By.id("user_info_acc"));
        logMenu.click();
        WebElement logOutBtn = driver.findElement(By.cssSelector("#header > div:nth-child(3) > div > div > div.nav_menu_padding.header_user_info.pull-right.hidden-xs > ul > li > ul > li:nth-child(3) > a"));
        logOutBtn.click();
    }
}
