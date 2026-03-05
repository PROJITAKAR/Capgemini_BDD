Feature:Add to cart functionality
Scenario:User adds a product to the cart successfully
Given User is on the home page
When User searches for Headphones
And User selects the first product
And User clicks on Add to Cart button
Then Product should be added to the cart-verify text of added to cart using isDisplayed