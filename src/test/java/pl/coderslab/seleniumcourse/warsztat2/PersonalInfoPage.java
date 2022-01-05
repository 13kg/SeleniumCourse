package pl.coderslab.seleniumcourse.warsztat2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfoPage {

    private WebDriver driver;
    @FindBy (name = "address1")
    private WebElement addressInput;
    @FindBy (name = "postcode")
    private WebElement zipInput;
    @FindBy (name = "city")
    private WebElement cityInput;
    @FindBy (name = "id_country")
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
    @FindBy (css = "#_desktop_user_info > div > a.account")
    private WebElement customerBtn;

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

    public void customerAccount(){
        customerBtn.click();
    }
}
