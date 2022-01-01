package pl.coderslab.seleniumcourse;
//Zadanie 3
//Metody nawigacyjne
//W tym zadaniu nauczymy się poruszać po stronach. Wykorzystamy do tego metody nawigacyjne:
//
//⬅️ navigate.back()
//➡️navigate.forward()
//🔄 navigate.refresh()
//
//Pełna lista metod dostępna jest pod linkiem
//
//Przykład kod do użycia w zadaniu:
//
//   driver.get("https://www.google.com");
//   driver.get("https://coderslab.pl/pl");
//   driver.navigate().back();
//   driver.navigate().forward();
//
//Przygotuj następującą sekwencję poruszania się po stronach z wykorzystaniem powyższych metod:
//
//Wejdź na stronę: https://www.google.com
//Wejdź na stronę: https://coderslab.pl/pl
//Cofnij się do strony: https://www.google.com
//Wejdź na stronę: https://mystore-testlab.coderslab.pl/index.php
//Cofnij się do strony: https://www.google.com
//Powróć do strony: https://mystore-testlab.coderslab.pl/index.php
//Odśwież stronę: https://mystore-testlab.coderslab.pl/index.php

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class zad3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.get("https://coderslab.pl/pl");
        driver.navigate().back();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

    }
}
