package pl.coderslab.seleniumcourse.warsztat1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.seleniumcourse.cucumber.pageobject.CreateAnAccountPage;
import pl.coderslab.seleniumcourse.cucumber.pageobject.UserData;
import pl.coderslab.seleniumcourse.cucumber.pageobject.zad4.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StoreLogAndFillAddressSteps {

    private WebDriver driver;
    private LandingPage landingPage;
    private LogInPage logInPage;
    private MyAccountPage myAccountPage;
    private MyAddressesPage myAddressesPage;
    private NewAddressPage newAddressPage;


    @Given("^User registered but logged out on web page (.*)$")
    public void openMainPage(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        this.driver.get(url);
    }

    @When("^click 'Sign In' Btn on main page$")
    public void clickSignIn() {
        this.landingPage = new LandingPage(driver);
        landingPage.clickSignIn();
    }

    @And("^fill email input(.*)$")
    public void enterEmail(String email) {
        this.logInPage = new LogInPage(driver);
        logInPage.enterEmail(email);
    }

    @And("^fill password input(.*)$")
    public void enterPassword(String password) {
        logInPage.enterPassword(password);
    }

    @And("^confirm by click 'Sign In' Btn$")
    public void signInConfirm() {
        logInPage.signInConfirm();
    }

    @And("^click on 'Add First Address' Btn$")
    public void addFirstAddressBtn() {
        this.myAccountPage = new MyAccountPage(driver);
        myAccountPage.addFirstAddressBtn();
    }

    @And("^fill fields (.*),(.*),(.*),(.*),(.*),(.*)$")
    public void fillForm(String alias, String address, String zip, String city, String country, String phone) {
        this.newAddressPage = new NewAddressPage(driver);
        newAddressPage.fillForm(alias, address, zip, city, phone);
    }

    @And("^confirm by 'save' Btn$")
    public void saveBtn() {
        newAddressPage.saveBtn();
    }

    @Then("^Addresses list is displayed on (.*) page$")
    public void urlCheck(String confirmUrl) {
        this.myAddressesPage = new MyAddressesPage(driver);
        myAddressesPage.urlConfirm(confirmUrl);
    }

    @And ("^with(.*)message$")
    public  void messageCheck(String confirmMessage) {
        myAddressesPage.systemMessageConfirm(confirmMessage);
    }

    @And("^with correct data (.*),(.*),(.*),(.*),(.*),(.*)$")
    public void dataCheck(String alias, String address, String zip, String city, String country, String phone){
        myAddressesPage.dataCheck(alias,address,zip,city,country,phone);
    }

    @And("^clear data by 'delete' btn, check (.*) msg and sign out$")
    public void clearData(String successMessage) {
        this.myAddressesPage = new MyAddressesPage(driver);
        myAddressesPage.clearData(successMessage);
    }

}