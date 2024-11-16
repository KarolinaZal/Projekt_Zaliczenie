Feature: Log in and create new address

  Scenario Outline: User can create a new address
    Given I'm on shop main page
    When I sign in
    And I enter a bottom Addresses
    And I enter create a new address
    And I enter <alias> <address> <city> <postal> <country> <phone>
    Then I can see success message with text "Address successfully added!"
    And I verify created address <alias> <address> <city> <postal> <country> <phone>
    And I'm delete created address

    Examples:
      | alias  | address      | city     | postal | country        | phone     |
      | "Nick"   | "Warszawska"   | "Lodz"     | "91234"  | "United Kingdom" | "123456789" |
      | "Lola"   | "Stefaniowska" | "Warszawa" | "14253"  | "United Kingdom" | "147258369" |
      | "Daniel" | "Kozlowska"    | "Radom"    | "12385"  | "United Kingdom" | "147258369" |
