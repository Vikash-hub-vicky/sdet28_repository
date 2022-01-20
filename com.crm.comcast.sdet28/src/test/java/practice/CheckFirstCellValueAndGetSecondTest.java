package practice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CheckFirstCellValueAndGetSecondTest {
// if first cell has expected value fetch second cell data
	public static void main(String[] args) throws Throwable {
		
		 FileInputStream fis = new FileInputStream("./src/test/resources/VtigerTestData.xlsx");
		
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		
		String cellData = "Create Organization";
		
		int rowNo = sheet.getLastRowNum();
		 
		 for(int i=1; i<=rowNo; i++) {
			 Row row = sheet.getRow(i);
			 String firstCellData = row.getCell(0).getStringCellValue();
			 
		if(firstCellData.equals(cellData)) {
				String secondCellValue = row.getCell(1).getStringCellValue();
				System.out.println(secondCellValue);
			 }
			 
		 }
		/*Row row1 = sheet.getRow(1);
		String name = row1.getCell(0).getStringCellValue();
		System.out.println(name);
		if(cellData.equalsIgnoreCase(name))
		{
			String value = row1.getCell(1).getStringCellValue();
			System.out.println(value);
		}*/
		
		
			 workbook.close();
		 }		 

	}



