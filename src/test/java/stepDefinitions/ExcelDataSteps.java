package stepDefinitions;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.en.Then;
import pageObjects.DataHelper;
import stepDefinitions.LoginPageSteps;

public class ExcelDataSteps extends DataHelper{
	public WebDriver driver;
    //DataHelper dataHelper;
    LoginPageSteps loginPgSteps;
    @Then("^Verify opening hours with excel row \"(.*?)\" dataset$")
    public void Verify_opening_hours_with_excel_row_dataset(String arg1) throws Throwable {
    	int RowNumber = Integer.parseInt(arg1);
    	String dayToVerify = ReturnDay(RowNumber);
    	String hoursToVerify = ReturnHours(RowNumber);
    	switch(dayToVerify) {
    	case "Mon":
    		loginPgSteps.Verify_opening_hours_from_MonFri(hoursToVerify);
    		break;
    	case "Tue":
    		loginPgSteps.Verify_opening_hours_from_MonFri(hoursToVerify);
    		break;
    	case "Wed":
    		loginPgSteps.Verify_opening_hours_from_MonFri(hoursToVerify);
    		break;
    	case "Thu":
    		loginPgSteps.Verify_opening_hours_from_MonFri(hoursToVerify);
    		break;
    	case "Fri":
    		loginPgSteps.Verify_opening_hours_from_MonFri(hoursToVerify);
    		break;
    	case "Sat":
    		loginPgSteps.Verify_opening_hours_on_Sat(hoursToVerify);
    		break;
    	case "Sun":
    		loginPgSteps.Verify_closed_message_on_Sun();
    		break;
    	default:
    		System.out.println("Proper output not found.");
    	}
    }
}