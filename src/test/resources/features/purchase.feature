@Regression @Purchase
Feature: Purchase
  As a user i want to purchase one of the item

  Scenario Outline: Pick one item from inventory
    Given User open the saucedemo website
    When User input "standard_user" as a userName "secret_sauce" as a password
    Then User redirected to inventory page
    When User sort product by "Price (high to low)"
    And User click add to cart button for "<itemTitle>"

    Examples:
      | itemTitle                         |
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |