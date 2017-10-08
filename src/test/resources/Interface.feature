Feature: User interface on Index page and Different elements page
  Scenario: Log scenario
    When I open Index page
    And I login as epam/1234
    Then I am loginned
    And all interface elements on login page are correct and available
    And service menus are correct

    When I open Different elements page
    Then all elements are available

    When I select WIND
    And I select WATER
    Then WIND is selected
    And Log has info that Wind is true
    And WATER is selected
    And Log has info that Water is true
    When I unselect WIND
    Then WIND is unselected
    And Log has info that Wind is false

    When I select SELEN
    Then SELEN is selected
    And Log has info that metal value changed to Selen

    When I choose Yellow color
    Then Log has info that color value changed to Yellow