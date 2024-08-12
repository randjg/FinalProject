@web
  Feature: Checkout a product

    @valid-checkout
    Scenario: Checkout a product and fill all information fields
      Given user is on start page
      When user click login button
      Then user input login username with "rjg12345"
      Then user input login password with "12345"
      When user click log in button
      Then user should see logout button
      When user click a product
      When user click add to cart button
      Then user should see pop-up message "Product added."
      Then user should dismiss the alert
      When user click cart button
      Then user should see page title "Products"
      When user click place to order button
      Then user should see modal with title "Place order"
      Then user input name field with "Randy"
      Then user input country field with "Indonesia"
      Then user input city field with "Jakarta"
      Then user input credit card number with a dynamic value
      Then user input month with "08"
      Then user input year with "2024"
      When user click purchase button
      Then user should see modal with title "Thank you for your purchase!"
      Then user should dismiss the alert

    @invalid-checkout
    Scenario: Checkout a product without fill all information fields
      Given user is on start page
      When user click login button
      Then user input login username with "rjg12345"
      Then user input login password with "12345"
      When user click log in button
      Then user should see logout button
      When user click a product
      When user click add to cart button
      Then user should see pop-up message "Product added."
      Then user should dismiss the alert
      When user click cart button
      Then user should see page title "Products"
      When user click place to order button
      Then user should see modal with title "Place order"
      When user click purchase button
      Then user should see pop-up message "Please fill out Name and Creditcard."
      Then user should dismiss the alert


