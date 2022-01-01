package pl.coderslab.seleniumcourse.cucumber.pageobject.zad4;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.seleniumcourse.cucumber.pageobject.UserData;


import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Zad4Steps {
    private WebDriver driver;
    private LandingPage landingPage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private MyAddressesPage myAddressesPage;
    private YourAddressesPage yourAddressesPage;
    private String title;


    @Given("^User registered but not logged in on web page (.*)$")
    public void openMainPage(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        this.driver.get(url);

    }

    @When("^click 'Siggn In' Btn on main page$")
    public void clickSignIn() {
        this.landingPage = new LandingPage(driver);
        landingPage.clickSignIn();
    }

    @And("^fill correct email (.*)$")
    public void enterSpecificEmail(String email) {
        this.loginPage = new LoginPage(driver);
        loginPage.enterSpecificEmail(email);
    }

    @And("^fill correct password (.*)$")
    public void enterSpecificPswd(String password) {
        loginPage.enterSpecificPswd(password);
    }

    @And("^confirm by click 'Sign In' blue Btn$")
    public void signInConfirm() {
        loginPage.signInConfirm();
    }

    @And("^click on 'My Addresses' Btn$")
    public void myAddressBtn() {
        this.myAccountPage = new MyAccountPage(driver);
        myAccountPage.myAddressBtn();
    }

    @And("^'Add a new address' Btn$")
    public void addAddressBtn() {
        this.myAddressesPage = new MyAddressesPage(driver);
        myAddressesPage.addAddressBtn();
    }

    @And("^fill required fields (.*) (.*) (.*) (.*) (.*)$")
    public void fillForm(String address, String zip, String city, String mobile, String title) {
        this.yourAddressesPage = new YourAddressesPage(driver);
        yourAddressesPage.fillForm(address, zip, city, mobile, title);
    }

    @And("^confirm by click 'save' Btn$")
    public void saveBtn() {
        yourAddressesPage.saveBtn();
    }

    @Then("^Addresses list is displayed on https://hotel-testlab.coderslab.pl/en/addresses page with (.*)$")
    public void isCorrectTitle(String title) {
        this.myAddressesPage = new MyAddressesPage(driver);
        Assertions.assertEquals(myAddressesPage.correctTitle(), title.toUpperCase());
    }

    @And("^clear data$")
    public void clearData() {
        myAddressesPage.clearData();
    }


}