Feature: My Account page Automation scripts
Description: Validation of My Account page after login to application

Scenario: Verify the opening hours of the Site using excel data
		  Given user is on Home Page
		  When user navigate to MyAccount Page
		  When login to the application
		  Then Verify opening hours with excel row "1" dataset
		  Scenario Outline: Data driven with excel and data sets
		  And logout plus close the application
		  Examples:
		  	|row_index|
		  	|2|
		  	|3|
		  	|4|
		  	|5|
		  	|6|
		  	|7|
		  	|8|
		  	
Scenario: Login to the application and verify user name displayed
		  Given user is on Home Page
		  When user navigate to MyAccount Page
		  When login to the application
		  Then Verify Logout link displayed
		  And Verify the user name
		  And logout plus close the application
		  

Scenario: Verify the opening hours of the Site
		  Given user is on Home Page
		  When user navigate to MyAccount Page
		  When login to the application
		  Then Verify opening hours from MonFri "8AM - 10PM"
		  And Verify opening hours on Sat "9AM-8PM"
		  And Verify closed message on Sun
		  And logout plus close the application
		  

		  