package pl.coderslab.seleniumcourse.cucumber.pageobject.zad4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignIn() {
        WebElement signInBtn = driver.findElement(By.cssSelector("#header > div:nth-child(3) > div > div > div.nav_menu_padding.header_user_info.pull-right.hidden-xs > ul > li > a > span"));
        signInBtn.click();
    }

}