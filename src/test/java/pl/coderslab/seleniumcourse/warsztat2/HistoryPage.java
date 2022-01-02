package pl.coderslab.seleniumcourse.warsztat2;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HistoryPage {
    private WebDriver driver;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section/table/tbody/tr[1]/th")
    private WebElement lastOrderReference;
    @FindBy (xpath = "/html/body/main/section/div/div/section/section/table/tbody/tr[1]/td[4]/span")
    private WebElement lastOrderStatus;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section/table/tbody/tr[1]/td[2]")
    private WebElement lastTotalPrice;


    public HistoryPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    public void checkOrderId(String orderId){
        Assertions.assertEquals(lastOrderReference.getText(), orderId);
    }

    public void checkStatus(String orderStatus) {
        Assertions.assertEquals(lastOrderStatus.getText(),orderStatus);
    }

    public void checkPrice(String totalPrice) {
        Assertions.assertEquals(lastTotalPrice.getText(),totalPrice);
    }

}
