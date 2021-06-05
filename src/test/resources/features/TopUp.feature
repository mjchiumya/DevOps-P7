Feature: TopUp Account
  This feature describes various scenarios for users adding funds to their revolut account(s)

  #As a user, I can topup my Revolut account using my debit card

  Scenario: Add money to Revolut account using debit card
    Given Danny has 10 euro in his euro Revolut account
    And Danny selects 100 euro as the topUp amount
    And  Danny selects his DebitCard as his topUp method
    #And  Danny selects his BankAccount as his topUp method
    When Danny tops up
    Then The new balance of his euro account should now be 110


  Scenario: Add money to Revolut account using bank account
    Given Danny has 20 euro in his euro Revolut account
    And Danny selects 230 euro as the topUp amount
    And  Danny selects his BankAccount as his topUp method
    #And  Danny selects his BankAccount as his topUp method
    When Danny tops up
    Then The new balance of his euro account should now be 250



  #ToDo implement the remaining scenarios listed below

  #To implement this scenario you will need to use data tables
    # https://cucumber.io/docs/cucumber/api/
  Scenario: Add various amounts to Revolut account

    Given Danny has a starting balance of
                                          | 0|
                                          |14|
                                          |23|

    And Danny selects his DebitCard as his topUp method

    When Danny now tops up by
      |  100|
      |   20|
      |  300|

    Then The balance in his euro account should be
      | 100|
      |  34|
      |  53|


  #Rule: The account balance shouldn't change if the topup payment request is rejected by the payment service

    #The scenarios below will need a payment service that accepts or rejects a request to add funds
    Scenario: Payment service rejects the request
        Given  Danny has 20 euro in his euro Revolut account
        And Danny selects his PayPal as his topUp method
        And Danny selects 30 euro as the topUp amount
        When Danny tops up
        When Topup should not be successful
        Then The new balance of his euro account should now be 20

    Scenario: Payment service accepts the request
      Given  Danny has 20 euro in his euro Revolut account
      And Danny selects his BitCoin as his topUp method
      And Danny selects 30 euro as the topUp amount
      When Danny tops up
      Then The new balance of his euro account should now be 50
