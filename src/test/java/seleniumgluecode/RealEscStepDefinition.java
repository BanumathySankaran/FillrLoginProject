package seleniumgluecode;

import ElementUtil.ElementUtilOperations;
import PageObjects.RealEsHomePage;
import PageObjects.RealEsLoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RealEscStepDefinition extends ElementUtilOperations {
	ElementUtilOperations browserLaunching;
	RealEsLoginPage loginPage;
	RealEsHomePage homePage;
	
	
	
	@Given("^the user is on the Login Page of the real Estate Application$")
	public void launch_browser() throws Throwable {
		browserLaunching = new ElementUtilOperations();
		browserLaunching.launchSite("firefox");
		loginPage.checkIfOnLoginPage();
	}
	
	@Given("^The emailid field and the password field is visible to the user$")
	public void checkingEmailAndPassFields() throws Throwable {
		loginPage.checkIfemailPassFieldsVisible();
	}
	
	@When("^the user enters a valid email address in the emailid field$")
	public void userEntersValidEmail() throws Throwable {
		String email = loginPage.readJsonAndGetCred("email_Address");

		loginPage.enterEmail(email);
	}
	
	@When("^user enters a  valid password in the password field$")
	public void userEntersPasswd() throws Throwable {
		String passWd = loginPage.readJsonAndGetCred("password");
		loginPage.enterPass(passWd);
	}
	
	@When("^user hits on the \"([^\"]*)\" button$")
	public void userHitsOnTheButton(String arg1) throws Throwable {
		loginPage.hitOnButton(arg1);
	}
	
	@Then("^the user successfully lands on the \"([^\"]*)\" page$")
	public void userLandsOnPg(String arg1) throws Throwable {
		homePage = new RealEsHomePage(driver);
		homePage.assertIfOnHomePage(arg1);
	}
}
