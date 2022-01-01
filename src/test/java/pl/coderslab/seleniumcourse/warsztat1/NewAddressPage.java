package pl.coderslab.seleniumcourse.warsztat1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddressPage {
    private WebDriver driver;
    @FindBy (css = "#content > div > div > form > section > div:nth-child(5) > div.col-md-6 > input")
    private WebElement aliasInput;

    @FindBy (xpath = "//*[@id=\"content\"]/div/div/form/section/div[6]/div[1]/input")
    private WebElement addressInput;

    @FindBy (css = "#content > div > div > form > section > div:nth-child(12) > div.col-md-6 > input")
    private WebElement zipInput;

    @FindBy (css = "#content > div > div > form > section > div:nth-child(13) > div.col-md-6 > input")
    private WebElement cityInput;

    @FindBy (css = "#content > div > div > form > section > div:nth-child(14) > div.col-md-6 > select")
    private WebElement countryInput;
    @FindBy (css = "#content > div > div > form > section > div:nth-child(14) > div.col-md-6 > select > option:nth-child(2)")
    private WebElement ukSelect;

    @FindBy (css = "#content > div > div > form > section > div:nth-child(15) > div.col-md-6 > input")
    private WebElement phoneInput;

    @FindBy (css = "#content > div > div > form > footer > button")
    private WebElement saveBtn;

    public NewAddressPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    public void fillForm(String alias, String address, String zip, String city, String phone) {



        aliasInput.sendKeys(alias);
        addressInput.sendKeys(address);
        zipInput.sendKeys(zip);
        cityInput.sendKeys(city);
        countryInput.click();
        ukSelect.click();
        phoneInput.sendKeys(phone);
    }

    public void saveBtn(){
        saveBtn.click();
    }


}