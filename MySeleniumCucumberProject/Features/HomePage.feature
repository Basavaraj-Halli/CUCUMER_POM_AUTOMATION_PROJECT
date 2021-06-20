Feature: Login

 Background: User-Login (These are the common staps before every scenario)
	Given User launch chrome browser and opens URL , clicks on login link 
	When User Enters the username as "basavaraj5396@gmail.com" and password as "basu9611" 
	And User click on login button 
	Then User lands on homepage 

Scenario Outline: Naukri-profile update
	 When User clicks on EDIT PROFILE under MY NAUKRI Link
	 Then User enters name as "<newname>" and mobile number as "<newmobileNO>"
	 And User Clicks on save
	 When User clicks on Logout link, user lands on Login page
	 Then User Close the browser
	   Examples:
	         |   newname | newmobileNO |
	         |   Basavaraj Halli | 9148379066 |
	         
Scenario: Naukri-profile update
	 When  User clicks on EDIT PROFILE under MY NAUKRI Link
	 Then  User uploads new resume by clicking on UPDATE RESUME button 
	 And  User clicks on Logout link, user lands on Login page
	 Then  User Close the browser