package pl.coderslab.seleniumcourse;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.UUID;


public class HomeWorkDay4 {
    WebDriver driver;

//Zadanie 1
//Nawigacja
//Na stronie https://mystore-testlab.coderslab.pl/index.php wykonaj następującą sekwencję kroków:
//
//Wejdź na stronę główną.
//Przejdź do opcji 'Sign in'
//Wybierz opcję 'No account? Create on here'
//Za pomocą metod nawigacyjnych przejdź do strony głównej.

    @Test
    public void zad1() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        WebElement signInBtn = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span"));
        signInBtn.click();
        WebElement noAccountLink = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
        noAccountLink.click();
        driver.navigate().to("https://mystore-testlab.coderslab.pl/index.php");

    }


//    Zadanie 2
//    Inna przeglądrka
//    Ściągnij inny sterownik przeglądarki i spróbuj uruchomić dowolny test na innej przeglądarce.

//Zadanie 3
//Wyszukiwanie elementów - formularz
//Pod linkiem https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html dostępny jest formularz, którego wypełnianie i wysyłanie należy zautomatyzować.
//
//Wypełnij dane w formularzu:
//
//First name: Karol
//Last name: Kowalski
//Gender: Male
//Date of birth: 05/22/2010
//Address: Prosta 51
//
//Email: karol.kowalski@mailinator.com
//Password: Pass123
//Company: Coders Lab
//Comment: To jest mój pierwszy automat testowy
//
//Zatwierdź formularz - SUBMIT
//
//
//
//💁‍♂️ Wskazówki:
//
//Pamiętaj o odpowiednich komentarzach. Tak, aby móc w przyszłości wrócić do tego skryptu.
//Pamiętaj, aby każdy element był poprawnie i jednoznacznie zlokalizowany.
//Staraj się pracować krok po kroku. Zlokalizuj pierwszy element, sprawdź, czy skrypt poprawnie go rozpoznaje, następnie kolejny i kolejny.

    @Test
    public void zad3() {
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("Karol");
        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Kowalski");
        WebElement genderMale = driver.findElement(By.xpath("//*[@id=\"infoForm\"]/div[3]/div/div/label[1]/input"));
        genderMale.click();
        WebElement dob = driver.findElement(By.id("dob"));
        dob.sendKeys("05/22/2010");
        WebElement address = driver.findElement(By.id("address"));
        address.sendKeys("Prosta 51");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("karol.kowalski@mailinator.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Pass123");
        WebElement company = driver.findElement(By.id("company"));
        company.sendKeys("Coders Lab");
        WebElement comment = driver.findElement(By.id("comment"));
        comment.sendKeys("To jest mój pierwszy automat testowy");
        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();

    }

//Zadanie 6 dodatkowe
//Rejestracja użytkownika
//Ważną funkcjonalnością sklepu jest możliwość zarejestrowania nowego użytkownika.
// W tym celu przygotuj skrypt, który będzie miał możliwość tworzenie dowolnej liczby użytkowników w sklepie
// https://mystore-testlab.coderslab.pl/index.php .
//
//Po stworzeniu użytkownika uzupełnij również jego dane adresowe (Your Account / Addresses).
// Postaraj się, aby dane były w jak największym stopniu losowe.
//
//💁‍♂️ Wskazówki:
//
//Skrypt powinien mieć możliwość zdefiniowania dowolnej liczby użytkowników, którą chcemy utworzyć.
//Zwróć uwagę na komunikat: "The email is already used, please choose another one or sign in."
//Stwórz kilka tablic, które będą zawierały poszczególne dane wymagane do wypełnienia adresu, a następnie dla każdego z użytkowników losuj dowolny element z danej tablicy.
//Wykorzystaj losowanie liczb i dodawaj losowe liczby do adresów e-mail.



    @Test
    public void zad6() {

        driver.get("https://mystore-testlab.coderslab.pl/index.php");

        WebElement signInBtn = driver.findElement(By.cssSelector("#_desktop_user_info > div > a > span"));
        signInBtn.click();
        WebElement createAcount = driver.findElement(By.cssSelector("#content > div > a"));
        createAcount.click();

        WebElement firstName = driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(3) > div.col-md-6 > input"));
        firstName.clear();
        final int lenghtName = 5;
        String randomName = RandomStringUtils.randomAlphabetic(lenghtName);
        firstName.sendKeys(randomName);

        WebElement lastName = driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(4) > div.col-md-6 > input"));
        lastName.clear();
        final int lenghtLastName = 5;
        String randomLastName = RandomStringUtils.randomAlphabetic(lenghtLastName) + "ski";
        lastName.sendKeys(randomLastName);

        WebElement emailInput = driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(5) > div.col-md-6 > input"));
        emailInput.clear();
        final int lenghtEmail = 5;
        String shortEmail = RandomStringUtils.randomAlphabetic(lenghtEmail) + "@niepodam.pl";
        emailInput.sendKeys(shortEmail);

        WebElement password = driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(6) > div.col-md-6 > div > input"));
        password.clear();
        password.sendKeys("Test123");



        WebElement saveBtn = driver.findElement(By.cssSelector("#customer-form > footer > button"));
        saveBtn.click();

    }


    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        this.driver = new FirefoxDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
    }

}
