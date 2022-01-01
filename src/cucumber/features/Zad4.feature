Feature: Zad4

#Zadanie 4 Cucumber
#Cucumber
#Stwórz dodatkowe testy dla portalu https://hotel-testlab.coderslab.pl/en/, które umożliwi sprawdzanie funkcjonalności dodania pierwszego adresu do utworzonego już konta użytkownika.
#
#Sekwencja kroków:
#
#logowanie do systemu
#zakładka Accounts (rozwiń nazwę użytkownika)
#przycisk My addresses
#przycisk Add new address
#wypełnienie i zapisanie formularza.

  Scenario Outline: Log in and fill address form on https://hotel-testlab.coderslab.pl/

    Given User registered but not logged in on web page https://hotel-testlab.coderslab.pl/
    When  click 'Siggn In' Btn on main page
    And fill correct email <email>
    And fill correct password <password>
    And confirm by click 'Sign In' blue Btn
    And click on 'My Addresses' Btn
    And 'Add a new address' Btn
    And fill required fields <address> <zip> <city> <mobile> <title>
    And confirm by click 'save' Btn
    Then Addresses list is displayed on https://hotel-testlab.coderslab.pl/en/addresses page with <title>
    And clear data
    Examples:
      |email               |password|address     |zip      |city       |mobile      |title   |
      |testtest@niepodam.pl|test123 | słoneczna  |44100    |gdynia      | 666666666  | dom    |
