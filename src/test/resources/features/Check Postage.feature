Feature: Postage Calculation
  Scenario:  Calculate the Postage Cost
    Given I store one postcode from state "NSW" with suburb name "Quakers"
    And I store another postcode from state "NSW" with suburb name "Schofields"
    When I search and store price for dimension "22:16:7" with weight "2" for service type "AUS_PARCEL_EXPRESS_SATCHEL_1KG"
    Then I verify the total cost to be "15.95"


