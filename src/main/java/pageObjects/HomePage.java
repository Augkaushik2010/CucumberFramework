package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
//import dataProvider.ConfigFileReader;
import managers.FileReaderManager;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class HomePage {
	WebDriver driver;
	//ConfigFileReader configFileReader;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//configFileReader= new ConfigFileReader();
	}
	
	public void perform_Search(String search) {
		driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationUrl() + "/?s=" + search + "&post_type=product");
	}
	
	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}
	
	@FindBy(how = How.XPATH, using="//a[text()='Dismiss']")
	private static WebElement DismissLink;
	
	@FindBy(how = How.XPATH, using = "//a[text()='My Account']")
	 private static WebElement MyAccountLink;
	
	public void perform_Click_MyAccountLink() {
		DismissLink.click();
		MyAccountLink.click();
	}

}