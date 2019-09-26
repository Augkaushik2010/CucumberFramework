package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import managers.FileReaderManager;
import pageObjects.LoginPage;

public class LoginPageSteps {
	TestContext testContext;
	LoginPage loginPage;
	
	
	
	public LoginPageSteps(TestContext context) {
		 testContext = context;
		 loginPage = testContext.getPageObjectManager().getLoginPage();
	}
	
	@When("^login to the application$")
	public void login_to_the_application() {
		loginPage.Enter_userNameAndPwd_And_Login();
	}
	
	@Then("^Verify Logout link displayed$")
	public void Verify_Logout_link_displayed() {
		if(loginPage.logout_link_displayed()) {
			System.out.println("Log in successful");
		}
		else {
			System.out.println("Login not successful");
		}
	}
	
	@Then("^Verify the user name$")
	public void Verify_the_user_name() {
		loginPage.verifyUserNamePresentInWelcomeText();
	}
	@Then("^logout plus close the application$")
	public void logout_plus_close_the_application() {
		loginPage.logoutAndCloseTheApplication();
	}
	
	@Then("^Verify opening hours from MonFri \"([^\"]*)\"$")
	public void Verify_opening_hours_from_MonFri(String hours){
		loginPage.verifyOpeningHoursMonFri(hours);
	}
	
	@Then("^Verify opening hours on Sat \"([^\"]*)\"$")
	public void Verify_opening_hours_on_Sat(String hours) {
		loginPage.verifyOpeningHoursSat(hours);
	}
	
	@Then("^Verify closed message on Sun$")
	public void Verify_closed_message_on_Sun() {
		loginPage.VerifyClosedMessageOnSun();
	}
	
}
