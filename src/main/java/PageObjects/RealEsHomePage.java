package PageObjects;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import ElementUtil.ElementUtilOperations;

public class RealEsHomePage extends ElementUtilOperations{
	static Logger logger = Logger.getLogger(RealEsHomePage.class.getName());

	@FindBy(how = How.XPATH, using  ="//*[@title='Real estate and property for sale']")
	List<WebElement> homePageTitle;
	public RealEsHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void assertIfOnHomePage(String homePg) throws InterruptedException {
		implicitWait(10);
		this.assertIfElementIsDisplayed(homePageTitle);
		logger.info("Successfully landed on home page");
	}
}
