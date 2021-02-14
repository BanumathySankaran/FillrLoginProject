package PageObjects;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import ElementUtil.ElementUtilOperations;



public class RealEsLoginPage extends ElementUtilOperations{
	static Logger logger = Logger.getLogger(RealEsLoginPage.class.getName());
	
	@FindBy(how = How.XPATH, using  ="/html/body/div[1]/div/div[1]/div[1]/div/img")
	List<WebElement> realEslogo;
	@FindBy(how = How.ID, using  ="username")
	List<WebElement> emailField;
	@FindBy(how = How.ID, using  ="password")
	List<WebElement> passwordField;
	
	@FindBy(how = How.ID, using  ="username")
	WebElement emailField1;
	
	@FindBy(how = How.ID, using  ="password")
	WebElement passwordField1;
	
	
	
	public RealEsLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void checkIfOnLoginPage() throws InterruptedException {
		implicitWait(10);
		this.assertIfElementIsDisplayed(realEslogo);
		logger.info("Real Es Logo is displayed");
	}
	
	public void checkIfemailPassFieldsVisible() throws InterruptedException {
		implicitWait(10);
		logger.info("Check if the email ans password fields are displayed");
		this.assertIfElementIsDisplayed(emailField);
		logger.info("Email field is displayed");
		this.assertIfElementIsDisplayed(passwordField);
		logger.info("Password field is displayed");
	}
	
	public String readJsonAndGetCred(String key) throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		JsonParser parser = new JsonParser();
		Object obj = parser.parse(new FileReader("C:\\Users\\vikir\\OneDrive\\project_Trial\\eclipse-workspace\\trialproj\\credentials.json"));
		JsonArray array = (JsonArray) obj;
		JsonObject jsonObject = (JsonObject) array.get(0);
		String emailAdd = jsonObject.get(key).toString();
		return emailAdd;
	}
	
	public void enterEmail(String email) {
		this.enterTextInfieldsAtOnce(emailField1, email);
		logger.info("Email is entered");
	}
	
	public void enterPass(String pass) {
		this.enterTextInfieldsAtOnce(passwordField1, pass);
		logger.info("Password is entered");
	}
	
	public void hitOnButton(String buttonName) {
		String signInBtn = "//button[contains(text(),'"+buttonName+"')]";
		WebElement signIn = driver.findElement(By.xpath(signInBtn));
		this.clickOnElement(signIn);
		logger.info("click on Sign In Button");
	}
	
}
