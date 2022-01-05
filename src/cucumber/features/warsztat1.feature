Feature: Warsztat1

#Zadanie warsztatowe 1 - Selenium WebDriver + Cucumber
#Utwórz użytkownika manualnie na stronie https://mystore-testlab.coderslab.pl.
#Możesz wykorzystać tymczasowego maila do utworzenia użytkownika: https://10minutemail.com/.

#Napisz skrypt, który:

#będzie logować się na tego stworzonego użytkownika,
#wejdzie klikając w kafelek Addresses po zalogowaniu (adres, na którym powinniśmy się znaleźć to: https://mystore-testlab.coderslab.pl/index.php?controller=addresses ),
#kliknie w + Create new address,
#wypełni formularz New address - dane powinny być pobierane z tabeli Examples w Gherkinie (alias, address, city, zip/postal code, country, phone),
#sprawdzi czy dane w dodanym adresie są poprawne.

#  Dodatkowe kroki dla chętnych:

#  Wejdź w historię zamówień i detale (najpierw kliknij w użytkownika zalogowanego, później kafelek),
#  sprawdź czy zamówienie znajduje się na liście ze statusem "Awaiting check payment" i kwotą taką samą jak na zamówieniu dwa kroki wcześniej.

  Scenario Outline: Log in and fill address form on https://mystore-testlab.coderslab.pl

    Given User registered but logged out on web page https://mystore-testlab.coderslab.pl
    When  click 'Sign In' Btn on main page
    And fill email input<email>
    And fill password input<password>
    And confirm by click 'Sign In' Btn
    And click on 'Add First Address' Btn
    And fill fields <alias>,<address>,<zip>,<city>,<country>,<phone>
    And confirm by 'save' Btn
    Then Addresses list is displayed on <confirmUrl> page
    And with<confirm>message
    And with correct data <alias>,<address>,<zip>,<city>,<country>,<phone>
    And clear data by 'delete' btn, check <success> msg and sign out

    Examples:
      |email            |password|alias  |address           |zip   |city   |country        |phone     |confirm                     |success                       |confirmUrl|
      |haja@niepodam.pl |Haja123 |HaSz   |Ballantine Street |44100 |London |United Kingdom |123456789 |Address successfully added! |Address successfully deleted! |https://mystore-testlab.coderslab.pl/index.php?controller=addresses|
