Feature: Automated E2E tests
Description: The purpose of this feature is to test E2E integration.

Scenario: customer place an order by purchasing an item from search
		Given user is on Home Page
		When he search for "dress"
		And choose to buy the first item
		And moves to checkout from mini cart
		And enter personal details on checkout page
		And select same delivery address
		And select payment method as "check" payment
		And place the order
		

Scenario: customer place an order by purchasing last item from search
		  Given user is on Home Page
		  When he search for "dress"
		  And choose to buy the last item
		  And moves to checkout from mini cart
		  And enter personal details on checkout page
		  And place the order
		  
Scenario: validate the count of search results match with items displayed
		  Given user is on Home Page
		  When he search for "dress"
		  Then validate results count matched
		  
		  