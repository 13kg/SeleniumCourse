Feature: Warsztat2

#  Zadanie
#  warsztatowe 2
#  Zadanie warsztatowe 2 (dowolny sposób)
#  Napisz skrypt, który:

#  zaloguje się na tego samego użytkownika z zadania 1,
#  wybierze do zakupu Hummingbird Printed Sweater (opcja dodatkowa: sprawdzi czy rabat na niego wynosi 20%),
#  wybierze rozmiar M (opcja dodatkowa: zrób tak żeby można było sparametryzować rozmiar i wybrać S,M,L,XL),
#  wybierze 5 sztuk według parametru podanego w teście (opcja dodatkowa: zrób tak żeby można było sparametryzować liczbę sztuk),
#  dodaj produkt do koszyka,
#  przejdzie do opcji - checkout,
#  potwierdzi address (możesz go dodać wcześniej ręcznie),
#  wybierze metodę odbioru - PrestaShop "pick up in store",
#  wybierze opcję płatności - Pay by Check,
#  kliknie na "order with an obligation to pay",
#  zrobi screenshot z potwierdzeniem zamówienia i kwotą.

#  Dodatkowe kroki dla chętnych:

#  Wejdź w historię zamówień i detale (najpierw kliknij w użytkownika zalogowanego, później kafelek),
#  sprawdź czy zamówienie znajduje się na liście ze statusem "Awaiting check payment" i kwotą taką samą jak na zamówieniu dwa kroki wcześniej.

  Scenario Outline: Log in and process shopping flow on https://mystore-testlab.coderslab.pl

    Given User registered on web page https://mystore-testlab.coderslab.pl
    When  click 'Sign In' Btn
    And fill email<email>
    And fill password<password>
    And confirm by 'Sign In' Btn
    And search <product>
    And open Product Page
    And check discount <quote> %
    And choose size <S, M, L or XL>
    And choose <amount> quantum
    And add products to cart
    And click 'proceed to checkout' btn
    And click 'proceed to checkout' btn on Cart Page
    And fill required fields <address>,<zip>,<city>
    And confirm by click 'continue' btn
    And choose 'presta shop' delivering method, confirm by click 'continue' btn
    And choose 'Pay by Check' payment method, mark agreement, confirm by click 'order with...' btn
    Then make a confirm screenshot
    And Go to Order History
    And check order <status>
    And clear addresses data, log out

    Examples:
      |email            |password|product                    |quote    |S, M, L or XL|amount|address        |zip  |city  |status                |
      |haja@niepodam.pl |Haja123 |Hummingbird Printed Sweater|SAVE 20% |M            |5     |Hennesy Street |66420|London|Awaiting check payment|

