@selenium
Feature: Checkout items on My Store

	As a user, I want to create an account so that I can sign in to purchase items. 
	
	Background:
		Given the user is logged in
		
	Scenario: Should succesfully purchase items
	  When the user creates an account
		And the user searches for Summer dresses
		Then a purchase verification should appear on the screen saying "THANK YOU FOR YOUR ORDER"