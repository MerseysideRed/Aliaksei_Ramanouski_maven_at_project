Feature: Correct rate of property card test

  Scenario Outline: Test correct property rate in stars
    Given I open booking main page
    When I fill search <city> field
    And set first date plus <plusDaysFromFirstDay> days and second date plus <plusDaysFromSecondDay> days
    And set quantity adults with value "4" and quantity rooms with value "2"
    And click to search button
    And select "Hotels" as type of property
    And choose property with "5 stars" stars
    And wait until 5 rate label will be displayed
    And click to dropdown sorting list
    And click to low to high option of dropdown sorting list
    Then see correct rate of 1 property card order number
    Examples:
      | city        | plusDaysFromFirstDay | plusDaysFromSecondDay |
      | "Paris"     |          3           |         10            |
      | "Berlin"    |          5           |         12            |
      | "Amsterdam" |          2           |         7             |

  Scenario Outline: Test correct property score rate
    Given I open booking main page
    When I fill search <city> field
    And set first date plus 4 days and second date plus 7 days
    And set quantity adults with value "4" and quantity rooms with value "2"
    And click to search button
    And select "Hotels" as type of property
    And activate score rate checkbox with value "Wonderful: 9+"
    And wait until score rate label "review_score=90" will be displayed
    And click to image of 1 property card
    And switch to 1 tab
    Then I see correct value equal or more than 9 of score property rate
    Examples:
      | city     |
      | "Prague" |
      | "Madrid" |
      | "Lisbon" |