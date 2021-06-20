Feature: Login

Scenario Outline: User-Login with valid Credentials
	 Given User launch chrome browser and opens URL , clicks on login link
	 When User Enters the username as "<email>" and password as "<password>"
	 And User click on login button 
	 Then User lands on homepage
	 When User clicks on Logout link, user lands on Login page
	 Then User Close the browser
	   Examples:
	         |   email | password |
	         |   ENTER_YOUR_NAUKRI_ACCOUNT_USERNAME | ENTER_YOUR_NAUKRI_ACCOUNT_PASSWORD |
