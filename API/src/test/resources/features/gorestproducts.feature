@GorestProducts @Regression
Feature: Gorest Products

  @test1
  Scenario: Create a product and get product details
    When the following product has been created
      | name    | description    | image                          | price | discountAmount | status |
      | my name | my description | https://lorempixel.com/250/250 | 200   | 50             | true   |
    Then a status code 200 is returned
    And the following product has been returned
      | name    | description    | image                          | price | discountAmount | status |
      | my name | my description | https://lorempixel.com/250/250 | 200   | 50             | true   |
    When the product details has been requested
    Then a status code 200 is returned
    And the following product has been returned
      | name    | description    | image                          | price | discountAmount | status |
      | my name | my description | https://lorempixel.com/250/250 | 200   | 50             | true   |