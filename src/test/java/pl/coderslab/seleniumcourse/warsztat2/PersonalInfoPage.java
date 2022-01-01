package pl.coderslab.seleniumcourse.warsztat2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfoPage {

    private WebDriver driver;
    @FindBy (css = "#delivery-address > div > section > div:nth-child(9) > div.col-md-6 > input")
    private WebElement addressInput;
    @FindBy (css = "#delivery-address > div > section > div:nth-child(11) > div.col-md-6 > input")
    private WebElement zipInput;
    @FindBy (css = "#delivery-address > div > section > div:nth-child(12) > div.col-md-6 > input")
    private WebElement cityInput;
    @FindBy (css = "#delivery-address > div > section > div:nth-child(13) > div.col-md-6 > select")
    private WebElement countryInput;
    @FindBy (css = "#delivery-address > div > section > div:nth-child(13) > div.col-md-6 > select > option:nth-child(2)")
    private WebElement ukSelect;
    @FindBy (css = "#checkout-addresses-step > div > div > form > footer > button")
    private WebElement continueBtn;
    @FindBy (css = "#js-delivery > div > div.delivery-options > div:nth-child(1) > div > span > span")
    private WebElement prestaShopRadio;
    @FindBy (css = "#js-delivery > button")
    private WebElement continueDeliveryBtn;
    @FindBy (id = "payment-option-1")
    private WebElement payByCheckRadio;
    @FindBy (id = "conditions_to_approve[terms-and-conditions]")
    private WebElement tosAgreeRadio;
    @FindBy (css = "#payment-confirmation > div.ps-shown-by-js > button")
    private WebElement orderWithBtn;


    public PersonalInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillForm(String address, String zip, String city) {
        addressInput.sendKeys(address);
        zipInput.sendKeys(zip);
        cityInput.sendKeys(city);
        countryInput.click();
        ukSelect.click();
    }
    public void continueBtn(){
        continueBtn.click();
    }

    public void choosePrestaShopDelivery(){
        prestaShopRadio.click();
        continueDeliveryBtn.click();
    }

    public void choosePaymentMethod(){
        payByCheckRadio.click();
        tosAgreeRadio.click();
        orderWithBtn.click();
    }

}
