package stepDefinitions;
 
import cucumber.TestContext;
import cucumber.api.java.en.When;
import pageObjects.CheckoutPage;
 
public class CheckoutPageSteps {
 TestContext testContext;
 CheckoutPage checkoutPage;
 
 public CheckoutPageSteps(TestContext context) {
 testContext = context;
 checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
 }
 
 @When("^enter personal details on checkout page$")
 public void enter_personal_details_on_checkout_page(){
 checkoutPage.fill_PersonalDetails(); 
 }
 
 @When("^select same delivery address$")
 public void select_same_delivery_address(){
 //checkoutPage.check_ShipToDifferentAddress(false);
	 System.out.println("ship to different address checkbox is not available");
 }
 
 @When("^select payment method as \"([^\"]*)\" payment$")
 public void select_payment_method_as_payment(String arg1){
 //checkoutPage.select_PaymentMethod("CheckPayment");
	 System.out.println("select payment method as payment element is not available");
 }
 
 @When("^place the order$")
 public void place_the_order() {
 checkoutPage.check_TermsAndCondition(true);
 checkoutPage.clickOn_PlaceOrder(); 
 testContext.getWebDriverManager().closeDriver();
 } 
 
}