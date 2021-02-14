Feature: Fillr login Page design Project
As an end user I want open the login Page of the Real Estate Web Application and validate the various conditons to sign in to the application

  Background: User is Logged In
    Given the user is on the Login Page of the real Estate Application
      And The emailid field and the password field is visible to the user
  
  @RealEsSce1
  Scenario: Verify that the login screen contains elements such as Username, Password
  
     When the user cofirms he is on the login page
     Then the "Forgot your password" link is available
      And the "Sign in" button is visible to the user
      And the "Create an account" link is available
  
  @RealEsSce2
  Scenario: successful login
  
     When the user enters a valid email address in the emailid field
      And user enters a  valid password in the password field
      And user hits on the "Sign in" button
     Then the user successfully lands on the "Home" page
  

  
  @RealEsSce3
  Scenario: verifying forgot password functionality
      And the user enters a valid email address in the emailid field
      And the user clicks on "Forgot your password" link
      And the user successfully lands on the "Forgot your password" page
      And the user enters alternate email in the emailid field
      And user hits on the "Reset my password" button
      And the user successfully lands on the "Update your password" page
      And Enters the verification code sent to his alternate mail
     When user enters the new password details on the "New password" field
      And user enters the new password details on the "Confirm new password" field
      And user hits on the "Change Password" button
     Then user sees a success message on the password change
  
  @RealEsSce4
  Scenario: verify if the user is able to login with a new password
     When the user enters a valid email address in the emailid field
      And the user clicks on "Forgot your password" link
      And successfully changes the password
      And the user successfully lands on the "Sign in" page
     Then the user is able to successfully login with the email id and new password
  
  @RealEsSce5
  Scenario: verifying data in the password field is visible as bullet signs
     And the user enters a valid email address in the emailid field
      And user enters a valid password in the password field
     And the string appears as bullets in the password field
     When the user clicks on "Show" link
     Then the user is able to see the password as string 
  
  @RealEsSce6
  Scenario: Verify that the logout link is redirected to login/home page
  
      And the user enters a valid email address in the emailid field
      And user enters a valid password in the password field
      And the user successfully lands on the home page
     When the user signs out of the application
     Then the user successfully lands on the "Home" page
      And the "Sign in" button is visible to the user
  
  
  @RealEsSce7
  Scenario: Verify the sign in through other accounts
  Scenario Outline: enter the corresponding sign in options  
  When the <Other Account Sign in options> is displayed on the Sign in page
  And the user clicks on <Other Account Sign in options>
  Then the user lands on the <Other Account Sign in options> sign in page
       Examples: 
      | Other Account Sign in options   | 
      | "Continue with Google"     		  |
      | "Continue with Facebook"        |
  		|"Continue with Apple"			      |
  
  
  @RealEsSce8
   Scenario: Verify the create Account
   When the user clicks on "Create an account" link
   Then the user successfully lands on the "Create account" page
   And The emailid field and the password field is visible to the user
