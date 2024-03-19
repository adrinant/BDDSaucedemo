@Login-Purchase
Feature: Login and Purchase
  As a user i want purchase one of the product

  Scenario: Login, Adding 2 item to cart, remove 1 from cart and then finish the checkout process
    Given User open the saucedemo website
    When User input "standard_user" as a userName "secret_sauce" as a password
    Then User redirected to inventory page
    When User sort product by "Price (low to high)"
    And User click add to cart button for "Sauce Labs Onesie"
    And User click add to cart button for "Sauce Labs Bike Light"
    And User click shopping cart badge
    Then User redirected to shopping cart page
    When User remove "Sauce Labs Bike Light" from shopping cart
    And User click Checkout button
    Then User redirected to Checkout Step One page
    When User input "Franklin" as FirstName "Richards" as LastName "123456" as ZipCode
    And User click Continue button
    Then User redirected to Checkout Step Two page
    When User click Finish button
    Then User redirected to Checkout Complete page