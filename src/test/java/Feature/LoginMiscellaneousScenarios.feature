Feature: Fillr login Page design Project
As an end user I want open the login Page of the Real Estate Web Application and validate the miscellaneous scenarios related to browser
  Background: User is Logged In
    Given the user is on the Login Page of the real Estate Application
      And The emailid field and the password field is visible to the user
  @RealEsmisc1
  Scenario: checking if the user is able to duplicate the signed in tab after signing in
      And the user enters a valid email address in the emailid field
      And user enters a  valid password in the password field
      And user hits on the "Sign in" button
      And the user successfully lands on the "Home" page
     When the user copies the signed in url and pastes it in a new tab
     Then the user remains as signed in
  
  @RealEsmisc2
  Scenario: checking if the user is able to copy and paste password from text box
     When the user copies the password from the text file
      And pastes the password in the password field
     Then the password is successfully entered in the password field 
  
  @RealEsmisc3
  Scenario: checking if the user is unable to enter email address in upper case
     When the user enters a valid email address in upper case in the emailid field
      And user enters a  valid password in the password field
      And user hits on the "Sign in" button
     Then "Those details didn't work. Sign in using a different option below, or tap the 'forgot your password' link to continue" message appears
  
  @RealEsmisc4
  Scenario: checking if the user's account gets locked after 3 attempts of invalid credentials
     When the user enters valid email address in the emailid field
      And the user enters invalid password in the emailid field
      And hits on the "Sign in" button
     Then "Sign in using a different option below, or tap the 'forgot your password' link to continue" message appears
      And the user repeats entering invalid password twice
     Then the user account gets locked 
      And "User Account locked please contact support desk" message appears
  
  @RealEsmisc5
  Scenario: checking if the user is able to open the sign in page in a different browser after signing in on another browser
  Scenario Outline: checking on different browsers  
     When the user signs in <browser1>
      And the user copies and pastes the signed in URL on <browser2>
     Then the user is able to launch a new sign in page
      And user is able to see the email and password fields in <browser2>
    Examples: 
      | browser1 | browser2  | 
      | "chrome" | "firefox" | 
  
  @RealEsmisc6
  Scenario: checking if the user resets the password after every 45 days
     When the user enters valid email address in the emailid field
      And user enters a  valid password in the password field after the 45th day of account creation
     Then the user successfully lands on the "Update password" page
      And the user is able to reset the password successfully
  
  @RealEsmisc7
  Scenario: checking if the user resets is unable to reset password that is has already been used
      And the user enters a valid email address in the emailid field
      And the user clicks on "Forgot your password" link
      And the user successfully lands on the "Forgot your password" page
      And the user enters alternate email in the emailid field
      And user hits on the "Reset my password" button
      And the user successfully lands on the "Update your password" page
      And Enters the verification code sent to his alternate mail
     When user enters an already used password on the "New password" field 
     Then And "This doesn't work, this user is trying to reuse the old password" message appears
  
  @RealEsmisc8
  Scenario: checking if the user automatically signs out of the page when the session has been inactive for more than 10 minutes
      And the user enters a valid email address in the emailid field
      And user enters a  valid password in the password field
      And user hits on the "Sign in" button
      And the user successfully lands on the "Home" page
     When the user is inactive in the page for more than 10 minutes
     Then the user is automatically signed out of the application 
      And the user successfully lands on the "Login" page 
  
