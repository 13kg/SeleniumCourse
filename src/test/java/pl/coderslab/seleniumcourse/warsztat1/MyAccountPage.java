package pl.coderslab.seleniumcourse.warsztat1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    private WebDriver driver;
    @FindBy(css = "#address-link > span > i")
    private WebElement addFirstAddressBtn;


    public MyAccountPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    public void addFirstAddressBtn(){

        addFirstAddressBtn.click();
    }

}
