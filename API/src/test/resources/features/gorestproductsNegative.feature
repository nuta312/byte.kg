Feature: Gorest Products - NEGATIVE

  @createProductWithDiscountAmountGreaterThanPrice
  Scenario: Create a product with discount amount greater than price
    When the following product has been created
      | name    | description    | image                          | price | discountAmount | status |
      | my name | my description | https://lorempixel.com/250/250 | 200   | 50             | true   |
    Then a status code 422 is returned