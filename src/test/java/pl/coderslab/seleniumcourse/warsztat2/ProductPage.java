package pl.coderslab.seleniumcourse.warsztat2;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private WebDriver driver;
    @FindBy(xpath = "/html/body/main/section/div/div/section/div[1]/div[2]/div[1]/div[2]/div/span[2]")
    private WebElement discountQuote;
    @FindBy(id = "group_1")
    private  WebElement chosenSize;
    @FindBy(id = "quantity_wanted")
    private WebElement chosenAmount;
    @FindBy(css = "#add-to-cart-or-refresh > div.product-add-to-cart > div > div.add > button")
    private WebElement addToCartBtn;
    @FindBy(css = "#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > div > a")
    private WebElement proceedToBtn;



    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void checkDiscount(String quote){
        String currentDiscount =(discountQuote.getText());
        Assertions.assertEquals(currentDiscount,quote);
    }

    public void chooseSize(String size) {
        chosenSize.sendKeys(size);
    }

    public void chooseAmount(String amount) {
        chosenAmount.clear();
        chosenAmount.sendKeys(amount);
    }

    public void addToCart(){
        addToCartBtn.click();
    }

    public void proceedToBtn(){
        proceedToBtn.click();
    }


}
