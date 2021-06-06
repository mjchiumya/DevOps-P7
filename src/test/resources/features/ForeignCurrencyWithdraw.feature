Feature: ForeignCurrencyWithdraw
  This feature describes various scenarios for taking funds using different currency than euro from their revolut account(s)

  #As a user, I can withdraw funds from my Revolut account in a different currency

  Scenario: Transfer money from EU Revolut account to US currency
    Given Danny has 1 euro in his euro Revolut account
    And  Danny selects his CreditCard as his topUp method
    When Danny withdraws 1 dollars
    Then The new balance of his euro account should now be 0.5

  #Scenario: TopUp money to Revolut account using U.S currency
    # Given Danny has 00 euro in his euro Revolut account
     #And Danny selects his CreditCard as his topUp method
     #When Danny topup 1 dollars
     #Then The new balance of his euro account should now be 1.5