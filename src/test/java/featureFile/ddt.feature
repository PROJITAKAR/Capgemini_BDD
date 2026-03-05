# Author: your.email@your.domain.com
# Sample Feature Definition Template
Feature: Data driven Testing

  Background:
    Given As a user I want to Launch the browser
    And load the URL as "https://www.saucedemo.com/"
    When login page is displayed enter username "standard_user"
    And enter password as "secret_sauce"
    And Click on Login button
    Then Validate for Home Page

  @Smoke
  Scenario: Add Product to Cart
    Given Click on a Product "Sauce Labs Backpack"
    And Click on add product to cart button
    When Cart is updated navigate to cart button
    And capture product details
    Then I validate the product name with "Sauce Labs Backpack"

  @Regression
  Scenario Outline: add multiple products to Cart
    Given Click on the Product "<name>"
    When Product page is displayed click on add to cart
    Then Navigate to Cart page
    And Validate for the product "<name>"

    Examples:
      | name                  |
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |
