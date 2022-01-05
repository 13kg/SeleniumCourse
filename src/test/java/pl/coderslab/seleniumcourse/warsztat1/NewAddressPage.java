package pl.coderslab.seleniumcourse.warsztat1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddressPage {
    private WebDriver driver;
    @FindBy (name = "alias")
    private WebElement aliasInput;
    @FindBy (name = "address1")
    private WebElement addressInput;
    @FindBy (name = "postcode")
    private WebElement zipInput;
    @FindBy (name = "city")
    private WebElement cityInput;
    @FindBy (name = "id_country")
    private WebElement countryInput;
    @FindBy (css = "#content > div > div > form > section > div:nth-child(14) > div.col-md-6 > select > option:nth-child(2)")
    private WebElement ukSelect;
    @FindBy (name = "phone")
    private WebElement phoneInput;
    @FindBy (xpath = "/html/body/main/section/div/div/section/section/div/div/form/footer/button")
    private WebElement saveBtn;

    public NewAddressPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    public void fillForm(String alias, String address, String zip, String city, String phone) {

        aliasInput.sendKeys(alias);
        addressInput.sendKeys(address);
        zipInput.sendKeys(zip);
        cityInput.sendKeys(city);
        phoneInput.sendKeys(phone);
        countryInput.click();
        ukSelect.click();
    }

    public void saveBtn(){
        saveBtn.click();
    }


}