package pl.coderslab.seleniumcourse.cucumber.pageobject.zad2;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.coderslab.seleniumcourse.cucumber.pageobject.UserData;

public class CreateAccountPage {

    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;
    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;
    @FindBy(id = "passwd")
    private WebElement passwordInput;
    @FindBy(id = "submitAccount")
    private WebElement registerButton;


    public CreateAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void fillForm(){

        final int lenghtName = 3;
        String randomName = "Maja" + RandomStringUtils.randomAlphabetic(lenghtName) +"a";
        firstNameInput.sendKeys(randomName);

        final int lenghtLastName = 2;
        String randomLastName = "Majko" + RandomStringUtils.randomAlphabetic(lenghtLastName) + "ska";
        lastNameInput.sendKeys(randomLastName);

        passwordInput.sendKeys("Test123");
    }

    public void fillFormSpecific(UserData userData){

        firstNameInput.sendKeys(userData.getFirstName());
        lastNameInput.sendKeys(userData.getLastName());
        passwordInput.sendKeys(userData.getPassword());

    }

    public void confirmRegister(){
        registerButton.click();
    }

}
