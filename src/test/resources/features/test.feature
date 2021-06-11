Feature: Personal Loan

  Scenario Outline: as a user(Happy path)
    Given User navigate the loan page
    Then User enter the borrow of amount
    Then User enter the months
    Then User enter the "<reason>" for loan
    And User enter personal information "over 18"
    Then user enter address info
    And User should be able to see "Thank you for your application" message
    Examples:
      | reason             |
      | Car finance        |
#      | Debt consoildation |
#      | Holiday/Vacation   |
#      | Refurbishment      |
#      | Wedding finance    |

  Scenario Outline: as a user(Negative)
    Given User navigate the loan page
    Then User enter the borrow of amount
    Then User enter the months
    Then User enter the "<reason>" for loan
    And User enter personal information "under 18"
    Then user enter address info
    And User shouldn't be able to see "Thank you" message
    Examples:
      | reason             |
      | Car finance        |
#      | Debt consoildation |
#      | Holiday/Vacation   |
#      | Refurbishment      |
#      | Wedding finance    |

























