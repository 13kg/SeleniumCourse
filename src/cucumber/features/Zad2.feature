Feature: Zad2
#Zadanie 2 Cucumber
#Cucumber
#Z wykorzystaniem Cucumber przygotuj test, który będzie zakładał konto na stronie https://hotel-testlab.coderslab.pl/.
#
#Wykonana powinna być następująca sekwencja kroków:
#
#strona główna
#przycisk 'Sign in'
#przycisk Create an account
#wypełnienie formularza
#przycisk Register

  #Zadanie 3 Cucumber
  #Cucumber - parametryzacja
  #Do zadania 2 należy dodać parametry w następujących polach w formularzu:
  #
  #first name
  #last name
  #email (pole e-mail wykorzystywane jest już na ekranie 'Sign in')
  #password
  #Dodanie parametrów pozwoli tworzyć wielu użytkowników w ramach jednego skryptu testowego.

  Scenario Outline: Create an account on https://hotel-testlab.coderslab.pl/

    Given Web page <main page> opened in browser, user not logged in
    When User click 'Sign In' Btn on page opened in browser, user not logged in
    And User type unregistered <email> in 'create account' section
    And User click 'Create an account'
    And User fill all required data in form: <firstName>, <lastName>, <password>
    And User confirm register by click 'Register' Btn
   Then Confirm message is displayed on https://hotel-testlab.coderslab.pl/en/my-account
    Examples:
      |firstName|lastName  |email           |password    | main page|
      |jan      |   nowak  |  ks@npd.pl     |   test123  |https://hotel-testlab.coderslab.pl/|
      |anna      |   nowak  |  ns@npd.pl     |   test123  |https://hotel-testlab.coderslab.pl/|
      |janina      |   nowak  |  ps@npd.pl     |   test123  |https://hotel-testlab.coderslab.pl/|
