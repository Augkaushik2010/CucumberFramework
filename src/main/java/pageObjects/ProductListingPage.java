package pageObjects;

import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
 
public class ProductListingPage {
 
 public ProductListingPage(WebDriver driver) {
 PageFactory.initElements(driver, this);
 }
 
 @FindBy(how = How.CSS, using = "button.single_add_to_cart_button") 
 private WebElement btn_AddToCart;
 
 @FindBy(how = How.XPATH, using = "//*[contains(@class,'woocommerce-result-count')]")
 private static WebElement txt_ResultsCount;
 
 @FindBy(how = How.XPATH, using = "//*[@id='pa_color']")
 private WebElement Select1;
 
 @FindBy(how = How.XPATH, using = "//*[@id='pa_size']")
 private WebElement Select2;
 
 @FindBy(how=How.XPATH, using = "//*[@id='color']")
 private WebElement Color;
 
 @FindBy(how = How.XPATH, using = "//*[@id='color']")
 private WebElement Select3;
 
 @FindBy(how = How.XPATH, using = "//*[@id='size']")
 private WebElement size;
 
 @FindBy(how = How.XPATH, using = "//*[@id='size']")
 private WebElement Select4;
 /*@FindAll(@FindBy(how = How.CSS, using = ".noo-product-inner"))
 private List<WebElement> prd_List; */
 
 @FindAll (@FindBy(how=How.XPATH, using = "//*[@class='noo-product-inner']"))
 private List<WebElement> prd_List;
 
 
 @FindAll(@FindBy(how=How.XPATH, using = "//*[@class='button product_type_variable add_to_cart_button']"))
 private List<WebElement> prod_List;
 
 public void clickOn_AddToCart() {
 btn_AddToCart.click();
 }
 
 public void select_Product(int productNumber) {
 prd_List.get(productNumber).click();
 prod_List.get(productNumber).click();
 }
 
 public void select_color() {
	 
	 Select dropdown = new Select(Select1);
	 dropdown.getOptions().get(1).click();
 }
 
 public void select_size() {
	 Select dropdown1 = new Select(Select2);
	 dropdown1.getOptions().get(1).click();
 }
 
 public void select_Last_Product() {
	int noOfItemsInTheList = prd_List.size();
	prd_List.get(noOfItemsInTheList-1).click();
	//prod_List.get(noOfItemsInTheList-1).click();
 }
 
 public void click_color() {
	 Color.click();
	 Select dropdown2 = new Select(Select3);
	 dropdown2.selectByIndex(1);
	
 }
 public void click_size() {
	 size.click();
	 Select dropdown3 = new Select(Select3);
	 dropdown3.selectByIndex(1);
 }
 
 public static int count_results() {
	 System.out.println("text displayed: "+txt_ResultsCount.getText());
	 String[] countTextarray = txt_ResultsCount.getText().split("Showing all ");
	 System.out.println("after show all the text is:"+countTextarray[1]);
	 String[] countText = countTextarray[1].split(" ");
	 System.out.println("the count after split is:"+countText[0]);
	 int ResCount = Integer.parseInt(countText[0]);
	 return ResCount;
 }
 
 public void compareCounts() {
	 int ResCnt = prd_List.size();
	 System.out.println("ResCnt ="+ResCnt);
	 int ResCount = ProductListingPage.count_results();
	 System.out.println("ResCount ="+ResCount);
	 
	 if(ResCnt == ResCount) {
		 System.out.println("Showing results count matched with the no.of items in the page");
	 }
	 
 }
 
}