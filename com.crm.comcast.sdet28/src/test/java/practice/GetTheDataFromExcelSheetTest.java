package practice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

       public class GetTheDataFromExcelSheetTest {
	           
                        //get string cell value using apache poi
	   public static void main(String[] args) throws Throwable {
		
	                    //java object representation for physical file object 
	  FileInputStream fis = new FileInputStream("./src/test/resources/VtigerTestData.xlsx");
	 
	                   //create a work book for physical file object representation
	    Workbook workbook = WorkbookFactory.create(fis);
	    
	                   //get the control of sheet
	    Sheet sheet = workbook.getSheet("Sheet1");
	    
	                  //get the control of row
	    Row row = sheet.getRow(1);
	    
	                  //get the control of cell
	    Cell cell = row.getCell(2);
	    
	                 //fetch the value from the cell
	    String orgName = cell.getStringCellValue();
	    System.out.println(orgName);
	    
	                //close the workbook
	    workbook.close();
	    
	    

	}

	
}
