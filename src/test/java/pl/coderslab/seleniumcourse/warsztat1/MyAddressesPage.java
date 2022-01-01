package pl.coderslab.seleniumcourse.warsztat1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MyAddressesPage {
    private WebDriver driver;
    @FindBy(css ="#notifications > div > article > ul > li" )
    private WebElement systemMessage;
    @FindBy(xpath="/html/body/main/section/div/div/section/section/div[1]/article/div[2]/a[2]/span" )
    private WebElement deleteBtn;
    @FindBy(css = "#_desktop_user_info > div > a.logout.hidden-sm-down")
    private WebElement logOutBtn;

    public MyAddressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void urlConfirm(String url){
        String currentUrlText = (driver.getCurrentUrl());
        assertEquals(url, currentUrlText);
    }

    public String systemMessageConfirm() {
        return systemMessage.getText();
    }

    public void clearData() {
        deleteBtn.click();
        logOutBtn.click();
    }
}
