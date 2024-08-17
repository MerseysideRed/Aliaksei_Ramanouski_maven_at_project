Feature: Tooltips tests

  Scenario: Test currency tooltip value
    Given I open booking main page
    When I navigate to "currency" tooltip
    Then I see correct value of "currency" tooltip

  Scenario: Test language tooltip value
    Given I open booking main page
    When I navigate to "language" tooltip
    Then I see correct value of "language" tooltip

