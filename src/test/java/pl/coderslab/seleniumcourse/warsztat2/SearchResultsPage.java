package pl.coderslab.seleniumcourse.warsztat2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
    private WebDriver driver;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[3]/div/div[1]/article[1]/div/div[1]")
    private WebElement goToProduct;




    public SearchResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void openProductPage(){
        goToProduct.click();
    }

}
