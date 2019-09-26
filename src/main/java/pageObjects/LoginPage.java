package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

//import cucumber.TestContext;
import managers.FileReaderManager;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;
	String uName = FileReaderManager.getInstance().getConfigReader().getUserName();
	String pword = FileReaderManager.getInstance().getConfigReader().getPassword();
	//public TestContext testContext;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//configFileReader= new ConfigFileReader();
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='username']")
	 private static WebElement LoginPage_UserName;
	@FindBy(how = How.XPATH, using = "//*[@id='password']")
	 private static WebElement LoginPage_Password;
	@FindBy(how = How.XPATH, using = "//*[@name='login']")
	 private static WebElement LoginButton;
	@FindBy(how = How.XPATH, using = "//*[text()='Log out']")
	 private static WebElement LogOutLink;
	@FindBy(how = How.XPATH, using = "//*[@class='woocommerce-MyAccount-content']")
	private static WebElement welcomeText;
	@FindBy(how = How.XPATH, using = "//*[@class='noo-opening-time']")
	private static WebElement OpenHrsText;
	
	public void Enter_userNameAndPwd_And_Login() {
		LoginPage_UserName.sendKeys(uName);
		LoginPage_Password.sendKeys(pword);
		LoginButton.click();
	}
	
	public boolean logout_link_displayed() {
		if(LogOutLink.isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void verifyUserNamePresentInWelcomeText() {
		String WlcmTxt = welcomeText.getText();
		if(WlcmTxt.contains(uName)) {
			System.out.println("Welcome Text has the username: "+uName);
		}
		else {
			System.out.println("Welcome Text doesn't have the user name: "+uName);
		}
	}
	
	public void verifyOpeningHoursMonFri(String hours) {
		String hoursText = OpenHrsText.getText();
		if(hoursText.contains("Mon - Fri: "+hours)) {
			System.out.println("Monday to Friday opening hours are: "+hours);
		}
		else{
			System.out.println("Monday to Friday opening hours are not matched."+hours);
		}
	}
	
	public void verifyOpeningHoursSat(String hours) {
		String hoursText = OpenHrsText.getText();
		if(hoursText.contains("Sat: "+hours)) {
			System.out.println("Saturday opening hours are: "+hours);
		}
		else{
			System.out.println("Saturday opening hours are not matched."+hours);
		}
	}
	
	public void VerifyClosedMessageOnSun() {
		String hoursText = OpenHrsText.getText();
		if(hoursText.contains("Sun: Closed")) {
			System.out.println("Sunday closed.");
		}
		else{
			System.out.println("Sunday closed text is not displayed.");
		}
	}
	
	
	
	
	
	
	
	public void logoutAndCloseTheApplication() {
		LogOutLink.click();
		//testContext.getWebDriverManager().closeDriver();
		driver.close();
		driver.quit();
	}
}
