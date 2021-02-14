Feature: Fillr login Page design Project
As an end user I want open the login Page of the Real Estate Web Application and validate the negative conditons to sign in to the application

  Background: User is Logged In
    Given the user is on the Login Page of the real Estate Application
      And The emailid field and the password field is visible to the user
  
  @RealEsNegSce1
  Scenario: Verify if the user is getting alert message on leaving the email and password fields blank
     When user hits on the "Sign in" button
     Then "Please enter a valid email address" message appears
  
  @RealEsNegSce2
  Scenario: Checking if the alert message appears if user enters valid email and leaves password field blank
     When the user enters a valid email address in the emailid field
      And user hits on the "Sign in" button
     Then "Please enter a password" message appears
  
  @RealEsNegSce3
  Scenario: Verify if the user is getting alert message on entering invalid email address
     When user enters a valid password in the password field
      And the user enters invalid email address in the emailid field
     Then "Please enter a valid email address" message appears
  
  @RealEsNegSce4
  Scenario: Verify if the user is getting alert message on entering invalid password
     When the user enters a valid email address in the emailid field
      And the user enters invalid password in the password field
  
  @RealEsNegSce5
  Scenario: Action 3 - verifying invalid login
  Scenario Outline: enter invalid credentials  	
     When the user enters a <random valid email> in the emailid field
      And the user enters a <random password> in the password field
      And hits on the "Sign in" button
     Then "Those details didn't work" message appears
    Examples: 
      | random valid email | random password | 
      | abc@dddd.com       | "SHDca*0888"    | 
      | testemail.fffh.com | "FludfbTT77@"   | 
  
  @RealEsNegSce6
  Scenario: Action 2 - enter valid password while resetting
      And the user enters a valid email address in the emailid field
      And the user clicks on "Forgot your password" link
      And the user successfully lands on the "Forgot your password" page
      And the user enters alternate email in the emailid field
      And hits on the "Reset my password" button
      And the user successfully lands on the "Update your password" page
      And Enters the verification code sent to his alternate mail
     When user enters password with "Less than 8" characters
     Then "Password must contain at least 8 characters" message appears
      And the user erases the password and retypes a password that does not cater to the policy standards
      And "Password does not meet policy standards, please enter a different password" message appears
  
  @RealEsNegSce7
  Scenario: Checking the email and password fields in create account page
     When the user clicks on "Create an account" link
      And the user successfully lands on the "Create account" page
      And user enters a valid password in the password field
      And the user enters invalid email address in the emailid field
     Then "Please enter a valid email address" message appears     
  
  @RealEsNegSce8
  Scenario: Checking if the user cannot create account with duplicate email addresses
     When the user clicks on "Create an account" link
      And the user successfully lands on the "Create account" page
      And enters an already existing email address in the emailid field
      And user enters a valid password in the password field
      And user hits on the "Sign in" button
     Then "You can't use this email address, because it has already been used to create an account" message appears 