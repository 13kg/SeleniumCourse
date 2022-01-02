package pl.coderslab.seleniumcourse.warsztat2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {

    private WebDriver driver;
    @FindBy (xpath ="/html/body/main/section/div/div/section/section[2]/div/div/div[2]/ul/li[1]")
    private WebElement orderId;
    @FindBy (xpath = "/html/body/main/section/div/div/section/section[2]/div/div/div[1]/div/table/tbody/tr[3]/td[2]")
    private WebElement totalPrice;


    public OrderConfirmationPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    public String getOrderId() {
       return orderId.getText();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }
}
