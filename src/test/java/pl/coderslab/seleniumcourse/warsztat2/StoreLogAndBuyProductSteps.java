package pl.coderslab.seleniumcourse.warsztat2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.util.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.seleniumcourse.warsztat1.MyAddressesPage;
import pl.coderslab.seleniumcourse.warsztat1.NewAddressPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;

public class StoreLogAndBuyProductSteps {

    private WebDriver driver;
    private LandingPage landingPage;
    private LogInPage logInPage;
    private MyAccountPage myAccountPage;
    private SearchResultsPage searchResultsPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private PersonalInfoPage personalInfoPage;
    private HistoryPage historyPage;
    private OrderConfirmationPage orderConfirmationPage;
    private addressesPage addressesPage;
    private String orderId;
    private String totalPrice;


//    private NewAddressPage newAddressPage;



    @Given("^User registered on web page (.*)$")
    public void openMainPage(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        this.driver.get(url);
    }

    @When("^click 'Sign In' Btn$")
    public void clickSignIn() {
        this.landingPage = new LandingPage(driver);
        landingPage.clickSignIn();
    }

    @And("^fill email(.*)$")
    public void enterEmail(String email) {
        this.logInPage = new LogInPage(driver);
        logInPage.enterEmail(email);
    }

    @And("^fill password(.*)$")
    public void enterPassword(String password) {
        logInPage.enterPassword(password);
    }

    @And("^confirm by 'Sign In' Btn$")
    public void signInConfirm() {
        logInPage.signInConfirm();
    }

    @And ("^search (.*)$")
    public void searchProduct(String productName) {
        this.myAccountPage = new MyAccountPage(driver);
        myAccountPage.searchProduct(productName);

    }
    @And ("^open Product Page$")
    public void openProductPage(){
        this.searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.openProductPage();
    }
    @And ("^check discount (.*) %$")
    public void checkDiscount(String quote){
        this.productPage = new ProductPage(driver);
        productPage.checkDiscount(quote);
    }

    @And ("^choose size (.*)$")
    public void chooseSize(String size){
        productPage.chooseSize(size);
    }

    @And ("^choose (.*) quantum$")
    public void chooseAmount(String amount){
        productPage.chooseAmount(amount);
    }

    @And("^add products to cart$")
    public void addToCart(){
        productPage.addToCart();
    }

    @And("^click 'proceed to checkout' btn$")
    public void proceedToBtn(){
        productPage.proceedToBtn();
    }

    @And("^click 'proceed to checkout' btn on Cart Page$")
    public void proceedToBtn2(){
        this.cartPage = new CartPage(driver);
        cartPage.proceedToBtn2();
    }

    @And("^fill required fields (.*),(.*),(.*)$")
    public void fillForm(String address, String zip, String city) {
        this.personalInfoPage = new PersonalInfoPage(driver);
        personalInfoPage.fillForm(address, zip, city);
    }

    @And("^confirm by click 'continue' btn$")
    public void saveBtn() {
        personalInfoPage.continueBtn();
    }

    @And("^choose 'presta shop' delivering method, confirm by click 'continue' btn$")
    public void shippingMethod() {
        personalInfoPage.choosePrestaShopDelivery();
    }

    @And("^choose 'Pay by Check' payment method, mark agreement, confirm by click 'order with...' btn$")
    public void paymentMethod() {
        personalInfoPage.choosePaymentMethod();
    }

    @Then("^make a confirm screenshot$")
    public void takeScreenshot() throws IOException {
        this.orderConfirmationPage = new OrderConfirmationPage(driver);
         orderId = orderConfirmationPage.getOrderId();
         totalPrice =orderConfirmationPage.getTotalPrice();

        TakesScreenshot screenshot = (TakesScreenshot)driver;
//Take screenshot (will be saved in default location) and automatically removed after test
        File tmpScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
//Copy the screenshot to desired location
//Path to the location to save screenshot
//(directory for screenshots MUST exist: C:\test-evidence) e.g.:
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(), Paths.get("C:", "confirm screenshots", "order"+currentDateTime+".png"));
    }

    @And("^Go to Order History$")
    public void orderHistory(){
        personalInfoPage.customerAccount();
        myAccountPage.goToHistoryPage();
    }

    @And("^check order (.*)$")
    public void checkOrderStatus(String orderStatus){

        this.historyPage = new HistoryPage(driver);
        historyPage.checkOrderId(orderId.substring(17));
        historyPage.checkStatus(orderStatus);
        historyPage.checkPrice(totalPrice);
    }

    @And("^clear addresses data, log out$")
    public void clearData() {
        personalInfoPage.customerAccount();
        myAccountPage.goToAddressesPage();
        this.addressesPage = new addressesPage(driver);
        addressesPage.clearData();
    }

}