package pl.coderslab.seleniumcourse.warsztat2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    @FindBy(css = "#_desktop_user_info > div > a > span")
    private WebElement signInBtn;
    private WebDriver driver;

    public LandingPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    public void clickSignIn() {
        signInBtn.click();
    }

}