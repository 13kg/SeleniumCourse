package pl.coderslab.seleniumcourse.warsztat2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    private WebDriver driver;
    @FindBy(css = "#address-link > span > i")
    private WebElement addFirstAddressBtn;
    @FindBy(css = "#search_widget > form > input.ui-autocomplete-input")
    private WebElement fillSearchInput;
    @FindBy(id = "history-link")
    private WebElement orderHistoryBtn;
    @FindBy(id ="addresses-link")
    private WebElement addressesBtn;


    public MyAccountPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    public void addFirstAddressBtn(){

        addFirstAddressBtn.click();
    }

    public void searchProduct(String productName){
        fillSearchInput.sendKeys(productName);
        fillSearchInput.submit();        ;
    }

    public void goToHistoryPage(){
        orderHistoryBtn.click();
    }

    public void goToAddressesPage() {
        addressesBtn.click();
    }
}
