package stepDefinitions;
 
import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.ProductListingPage;
 
public class ProductPageSteps {
 
 TestContext testContext;
 ProductListingPage productListingPage;
 
 public ProductPageSteps(TestContext context) {
 testContext = context;
 productListingPage = testContext.getPageObjectManager().getProductListingPage();
 }
 
 @When("^choose to buy the first item$")
 public void choose_to_buy_the_first_item() {
 productListingPage.select_Product(0);
 productListingPage.select_color();
 productListingPage.select_size();
 productListingPage.clickOn_AddToCart(); 
 }
 
 @When("^choose to buy the last item$")
 public void choose_to_buy_the_last_item() {
	 productListingPage.select_Last_Product();
	 productListingPage.click_color();
	 productListingPage.click_size();
	 productListingPage.clickOn_AddToCart();
 }
 
 @Then("^validate results count matched$")
 public void validate_results_count_matched() {
	 productListingPage.compareCounts();
	 testContext.getWebDriverManager().closeDriver();
 }
 
}