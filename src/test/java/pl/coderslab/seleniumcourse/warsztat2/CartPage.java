package pl.coderslab.seleniumcourse.warsztat2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    @FindBy (css = "#main > div > div.cart-grid-right.col-xs-12.col-lg-4 > div.card.cart-summary > div.checkout.cart-detailed-actions.card-block > div > a")
    private WebElement proceedBtn;


    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void proceedToBtn2() {
        proceedBtn.click();
    }
}
