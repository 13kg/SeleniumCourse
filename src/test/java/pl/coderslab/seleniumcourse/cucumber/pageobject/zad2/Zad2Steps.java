package pl.coderslab.seleniumcourse.cucumber.pageobject.zad2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pl.coderslab.seleniumcourse.cucumber.pageobject.CreateAnAccountPage;
import pl.coderslab.seleniumcourse.cucumber.pageobject.UserData;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Zad2Steps {
    private WebDriver driver;
    private LandingPage landingPage;
    private LoginPage loginPage;
    private CreateAccountPage createAccountPage;
    private AccountPage accountPage;


    @Given("^Web page (.*) opened in browser, user not logged in$")
    public void openMainPage(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        this.driver.get(url);
    }

    @When("^User click 'Sign In' Btn on page opened in browser, user not logged in$")
    public void clickSignIn() {
        this.landingPage = new LandingPage(driver);
        landingPage.clickSignIn();
    }

    @When("^User type unregistered (.*) in 'create account' section$")
//    public void enterEmail() {
//        this.loginPage = new LoginPage(driver);
//        loginPage.enterEmail();
//
//    }
    public void enterSpecificEmail(String email) {
        pl.coderslab.seleniumcourse.cucumber.pageobject.UserData userData = new UserData()
                .setEmail(email);

        this.loginPage = new LoginPage(driver);
        loginPage.enterSpecificEmail(userData);


    }

    @And("^User click 'Create an account'$")
    public void confirmEmail() {
        loginPage.confirmEmail();
    }

    @And("^User fill all required data in form: (.*), (.*), (.*)$")

    public void fillFormSpecific(String firstName, String lastName, String password){
        pl.coderslab.seleniumcourse.cucumber.pageobject.UserData userData = new UserData()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPassword(password);


        this.createAccountPage = new CreateAccountPage(driver);
        createAccountPage.fillFormSpecific(userData);
    }


//    public void fillForm() {
//        this.createAccountPage = new CreateAccountPage(driver);
//        createAccountPage.fillForm();
//    }

    @And("^User confirm register by click 'Register' Btn$")
    public void confirmRegister() {
        createAccountPage.confirmRegister();
    }


    @Then("^Confirm message is displayed on https://hotel-testlab.coderslab.pl/en/my-account$")
    public void checkConfirmMessage() {

        this.accountPage = new AccountPage(driver);
        accountPage.checkConfirmMessage();

        }




    }






