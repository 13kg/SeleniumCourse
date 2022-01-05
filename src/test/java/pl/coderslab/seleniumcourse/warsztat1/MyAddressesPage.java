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
    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[1]/article/div[1]/h4")
    private WebElement aliasSaved;
    @FindBy (xpath = "/html/body/main/section/div/div/section/section/div[1]/article/div[1]/address")
    private WebElement wholeAddressSaved;
//    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[1]/article/div[1]/address/text()[1]")
//    private WebElement fullNameSaved;
//    @FindBy(xpath = "//*[@id=\"address-19326\"]/div[1]/address/text()[2]")
//    private WebElement streetSaved;
//    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[1]/article/div[1]/address/text()[3]")
//    private WebElement citySaved;
//    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[1]/article/div[1]/address/text()[4]")
//    private WebElement zipSaved;
//    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[1]/article/div[1]/address/text()[5]")
//    private WebElement countrySaved;
//    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[1]/article/div[1]/address/text()[6]")
//    private WebElement phoneSaved;

    public MyAddressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void urlConfirm(String url){
        String currentUrlText = (driver.getCurrentUrl());
        assertEquals(url, currentUrlText);
    }

    public void systemMessageConfirm(String message) {
        String currentMessage = (systemMessage.getText());
        assertEquals(currentMessage,message);

    }

    public void dataCheck(String alias, String address, String zip, String city, String country, String phone){
        String aliasCheck = (aliasSaved.getText());
        assertEquals(aliasCheck, alias);
//        String addressCheck = (streetSaved.getText());
//        assertEquals(addressCheck, address);
//        String zipCheck = (zipSaved.getText());
//        assertEquals(zipCheck, zip);
//        String cityCheck = (citySaved.getText());
//        assertEquals(cityCheck, city);
//        String phoneCheck = (phoneSaved.getText());
//        assertEquals(phoneCheck, phone);
        String allAddressData = (wholeAddressSaved.getText());
        System.out.println(allAddressData);
        String joinedAddressData =("Haja Sznaps\n" + address+"\n" +city+"\n"+ zip+"\n" + country+"\n" + phone);
        System.out.println(joinedAddressData);
        assertEquals(joinedAddressData,allAddressData);
    }


    public void clearData(String message) {
        deleteBtn.click();
        String currentMessage =(systemMessage.getText());
        assertEquals(currentMessage,message);
        logOutBtn.click();
    }
}
