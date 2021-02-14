Feature: Fillr login Page design Project
As an end user I want to verify the valid credentials on the login page via API and verify the authentication

Background:
Given the user enters a valid email address in the emailid field
	
	Scenario: POST email and password post request
		
		And user enters a valid password in the password field
  When the app server call the Create Session Login Token API and pass it the email and password
  And passes the user’s OneLogin subdomain value
  Then the call to the Create Session Login Token API is a success
  And the HTTP response code is "200"
  And the status is "Authenticated"
  And returns session token "session token"
  And the login page builds the end point url "https://{your_subdomain}.onelogin.com/session_via_api_token" and posts the token to Create Session
  
  
  Scenario: POST email and password Failure with Unauthorised 401
  
  And the user enters invalid password in the password field
  When the app server call the Create Session Login Token API and pass it the email and password
  And passes the user’s OneLogin subdomain value
  Then the call to the Create Session Login Token API is a failure
  And the HTTP response code is "401"
  And the status is "Unauthorised"
  And the status is "Unauthorised"