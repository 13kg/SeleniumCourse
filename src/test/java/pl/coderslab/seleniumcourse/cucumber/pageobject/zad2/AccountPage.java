package pl.coderslab.seleniumcourse.cucumber.pageobject.zad2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountPage {
    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkConfirmMessage (){

        WebElement successMessage = driver.findElement(By.cssSelector(".alert-success"));
        String successMessageText = successMessage.getText();

        assertEquals("Your account has been created.", successMessageText);

        System.out.println(driver.getCurrentUrl());
        String newUrlText = driver.getCurrentUrl();
        assertEquals("https://hotel-testlab.coderslab.pl/pl/moje-konto", newUrlText);
  //      this.driver.quit();

    }
}