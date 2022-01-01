package pl.coderslab.seleniumcourse.warsztat1;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.coderslab.seleniumcourse.cucumber.pageobject.UserData;


public class LogInPage {
    private WebDriver driver;
    private String email;
    private String password;
    @FindBy(css ="#login-form > section > div:nth-child(2) > div.col-md-6 > input")
    private WebElement emailInput;
    @FindBy(css ="#login-form > section > div:nth-child(3) > div.col-md-6 > div > input")
    private  WebElement passwordInput;
    @FindBy(css = "#submit-login")
    private WebElement signInBtn;


    public LogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void signInConfirm(){
        signInBtn.click();
    }


}
