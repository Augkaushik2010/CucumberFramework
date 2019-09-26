package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataHelper {
	//public static void main (String [] args) throws IOException{
        //I have placed an excel file 'SelTemp.xlsx' in my C Driver 
	public String ReturnDay(int rowNum) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Selenium_Projects\\cucumberpojTestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(rowNum+1);
		Cell cell = row.getCell(0);
		System.out.println(cell);
		return cell.toString();
        //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
        //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
		//int TotalRows = sheet.getLastRowNum();
		
       //System.out.println(cell);
       //System.out.println(sheet.getRow(0).getCell(0));
       //for(int i=1;i<TotalRows;i++) {
    	 //  System.out.println(sheet.getRow(i).getCell(0));
    	   
       //}
	}
	
	public String ReturnHours(int rowNum) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Selenium_Projects\\cucumberpojTestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		//System.out.println(sheet.getRow(rowNum+1).getCell(0));
		//return sheet.getRow(rowNum+1).getCell(1);
		Row row = sheet.getRow(rowNum+1);
		Cell cell = row.getCell(1);
		System.out.println(cell);
		return cell.toString();
	}
	
}