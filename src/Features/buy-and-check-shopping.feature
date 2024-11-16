Feature: Log in, buy and order sweater

  Scenario: User can buy and order sweater
    Given I'm on the shop main page
    When I'm sign in
    And I choose and enter Hummingbird Printed Sweater
    And I choose size
    And I choose quantity
    And I'm go to the checkout option
    And I choose address
    And I'm choose pickup method
    And I'm choose payment method
    Then I'm take a screenshot of the order confirmation and the amount
    And I'm close browser
