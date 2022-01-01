package pl.coderslab.seleniumcourse.cucumber.pageobject.zad2;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.coderslab.seleniumcourse.cucumber.pageobject.UserData;

import java.util.UUID;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void enterEmail(){
        WebElement emailInput = driver.findElement(By.id("email_create"));
        final int lenghtEmail = 5;
        String shortEmail = RandomStringUtils.randomAlphabetic(lenghtEmail) + "@niepodam.pl";
        emailInput.sendKeys(shortEmail);
    }

    public void confirmEmail() {
        WebElement createAccountBtn = driver.findElement(By.id("SubmitCreate"));
        createAccountBtn.click();
    }
    public void enterSpecificEmail(UserData userData) {
        WebElement emailInput = driver.findElement(By.id("email_create"));
        emailInput.sendKeys(userData.getEmail());
    }




//    public void fillCreateAnAccountRandomEmail() {
//        WebElement emailInput = driver.findElement(By.id("email_create"));
//        String randomEmail = UUID.randomUUID() + "@mail.pl";
//        emailInput.clear();
//        emailInput.sendKeys(randomEmail);
//    }
//
//    public void fillCreateAnAccountEmail(String email) {
//        WebElement emailInput = driver.findElement(By.id("email_create"));
//        emailInput.clear();
//        emailInput.sendKeys(email);
//    }
//
//    public void loginAsTestUser() {
        //     test123@mail.pl superPassword123
 //   }
}