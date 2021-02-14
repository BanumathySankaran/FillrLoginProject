package ElementUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;




public class ElementUtilOperations {
	static Logger logger = Logger.getLogger(ElementUtilOperations.class.getName());
	public static final int WAIT_TIME = 10;

	public static WebDriver driver;

	public ElementUtilOperations() {
		PageFactory.initElements(driver, this);
	}
	
	public String chromeDriverPath;
	public String fireFoxDriverPath;
	public String IEDriverPath;
	public final String URL = "https://accounts.realestate.com.au/login?client_id=2fb06dqab95hci46dgldph0382&redirect_uri=https://www.realestate.com.au/auth&response_type=code&state=lwHqEfUMxlnMJZAJFj7xLUvByQSbeP3FYcOGunuxMIro7I7TRvfqFD4tJPAEa76CBs_hnW2eQORRj4bRTFSqyPl_vfAVzVmHHTzouehtiJW_skJS55fFqCXa9pczOw4lcKg_ppSMoED0g3rQIds6uvaRX15XEhGEr7Ut-B81IRqItGoJ";
	
	public String getAppProperties(String key) throws IOException {
		String value = "";
		try {
			FileInputStream fileInputStream = new FileInputStream("data.properties");
			Properties property = new Properties();
			property.load(fileInputStream);
			value = property.getProperty(key);
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	
	public void launchSite(String browser) throws Exception {
		if (browser.equalsIgnoreCase("chrome")) {
	this.chromeDriverPath = getAppProperties("chromeDriverPath");
	System.setProperty("webdriver.chrome.driver", this.chromeDriverPath);
	System.setProperty("webdriver.chrome.silentOutput", "true");
	java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--no-sandbox");
	options.addArguments("-incognito");
	options.addArguments("--disable-dev-shm-usage");
	options.addArguments("--remote-debugging-port=9222");
	options.setBinary("C:\\Program Files\\Google\\chromedriver.exe");// Bypass OS security model
	driver = new ChromeDriver(options);
	driver.get(URL);
	driver.manage().window().maximize();
	System.out.println("chrome started");
} 
else if (browser.equalsIgnoreCase("firefox")) {
	this.fireFoxDriverPath = getAppProperties("firefoxDriverXpath");
	System.setProperty("webdriver.gecko.driver", this.fireFoxDriverPath);
	FirefoxOptions options = new FirefoxOptions();
	options.setBinary("C:\\Program Files\\Mozilla Firefox\\geckodriver.exe");
	System.out.println("came here");
	driver = new FirefoxDriver();
	driver.get(URL);
	driver.manage().window().maximize();
	System.out.println("firefox started");
}
else if (browser.equalsIgnoreCase("IE")) {
	DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
	caps.setCapability("ie.ensureCleanSession", true);
	caps.setCapability("ignoreProtectedModeSettings", true);
	caps.setCapability("enableElementCacheCleanup", true);
	this.IEDriverPath = getAppProperties("ieDriverPath");
	System.setProperty("webdriver.ie.driver", this.IEDriverPath);
	System.out.println("ie driver");
	driver = new InternetExplorerDriver();
	driver.get(URL);
	driver.manage().window().maximize();
}
	}

	public void scrollDownAPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
	}

	public void scrollUntilTheElement(WebElement Element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}

	public void ScrollToTheEndOfPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	
	public void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	
	public void clickOnElement(WebElement ele) {
		implicitWait(5);
		ele.click();
	}
	
	public void typeInField(String xpath, String value){
	    String val = value; 
	    WebElement element = driver.findElement(By.xpath(xpath));
	    element.clear();

	    for (int i = 0; i < val.length(); i++){
	        char c = val.charAt(i);
	        String s = new StringBuilder().append(c).toString();
	        element.sendKeys(s);
	    }  
	}
	

	public void waitOnVisible(By locator,int sec) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void selectOPtionByVisibleText(WebElement e, String text) throws InterruptedException {
		Thread.sleep(5000L);
		e.click();
		Select sl = new Select(e);
		sl.selectByVisibleText(text);
	}

	public void selectOPtionByIndex(WebElement e, int value) throws InterruptedException {
		Thread.sleep(3000L);
		Select sl = new Select(e);
		sl.selectByIndex(value);

}
	
	
	public boolean checkIfElementIsDisplayed(WebElement ele) {
		implicitWait(10);
		logger.info("Verify if Element is Displayed : " + ele.getText());
		return ele.isDisplayed();		
	}
	
	public boolean isElementDisplayed(int sec, By locator, String element) throws Exception {
		boolean result = false;
		logger.info("Verify is Element Displayed : " + element);
		implicitWait(10);
		try {
			return result = driver.findElement(locator).isDisplayed();
		} catch (Exception exception) {
			return result;
		}
	}
	
	public boolean isElementSelected(By locator, String element) throws Exception {
		boolean result = false;
		System.out.println("Verify is Element Selected : " + element);
		try {
			return result = driver.findElement(locator).isSelected();
		} catch (Exception exception) {
			return result;
		}
	}
	
	public void clickOnElementUsingActions(WebElement ele) {
		implicitWait(10);
		Actions action = new Actions(driver);
		action.click(ele).build().perform();
	}
	
	public void clickByJse(WebElement e, String elementName) throws Exception {
			JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", new Object[] { e });
		}
	
	public void scrollUpAPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-250)");
	}
	
	public void assertEquals(String expected, String actual) throws Exception {
		if (expected == null && actual == null)
			return;
		if (expected != null && expected.equals(actual))
			return;
		throw new Exception("Strings are not matched...Excepted is :" + expected + " but actual is :" + actual);
	}
	
	public void assertTrue(String expected,String actual) throws Exception {
		Assert.assertEquals(expected, actual);
		logger.info("The result is equal");
		
	}

	public Boolean checkIfElemIsDisplayed(WebElement ele) throws InterruptedException {
		implicitWait(5);
		Boolean checkElementPresence = ele.isDisplayed();
		logger.info("Check if Element is displayed" + ele.getText());
		return checkElementPresence;
	}

	
	public String fetchTextValFromElement(WebElement ele) {
		String valueFromEle = ele.getText();
		return valueFromEle;
	}
	
	public void enterTextInfieldsAtOnce(WebElement ele,String textVal) {
		logger.info("Enter the text value: ");
		ele.sendKeys(textVal);
	}
	
	public int assertIfElementIsDisplayed(List<WebElement> ele) throws InterruptedException {
		for(WebElement singleEle:ele)
			{
			Assert.assertTrue(ele.size()>0);
			logger.info("Element is displayed: " +singleEle.getText());
			}
		implicitWait(10);
		return ele.size();
	}
	
	public void assertIfTheElementIsNotDisplayed(By locator) {
		logger.info("Assert if the size of the element is 0 so that element is not found");
		Assert.assertEquals(0, driver.findElements(locator).size());
		logger.info("The size of the element is 0 ; element is not present");
	}
	
	public String generateRandom(int length) {
		String randString = UUID.randomUUID().toString();
		randString = randString.substring(0, Math.min(randString.length(), length));
		return randString;
	}
}
