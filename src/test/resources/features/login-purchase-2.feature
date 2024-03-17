@Login-Purchase-2
Feature: Purchase
  As a user i want to ATC 2 items but only checkout 1 item by removing 1

  Scenario: Login, ATC 2 items, Remove 1 from Cart then finish the checkout process
    Given User is logged in and on the inventory page
    When User sorts products by "Price (low to high)"
    And User adds "Sauce Labs Onesie" and "Sauce Labs Bike Light" to the cart
    Then User click shopping cart badge to go to shopping cart
    And User removes "Sauce Labs Bike Light" from the cart
    Then User clicks the Checkout button
    And User fill the information needed to Continue
    Then User redirected to Overview and Checkout Complete page