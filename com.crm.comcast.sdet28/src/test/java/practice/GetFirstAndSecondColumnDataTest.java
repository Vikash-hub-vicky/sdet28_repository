package practice;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetFirstAndSecondColumnDataTest {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/VtigerTestData.xlsx");

		Workbook workbook = WorkbookFactory.create(fis);
		
		Sheet sheet = workbook.getSheet("Sheet1");
		
		int rowNo = sheet.getLastRowNum();
		
		for(int i=1; i<=rowNo; i++) {
			Row row = sheet.getRow(i);
			String firstColumnData = row.getCell(0).getStringCellValue();
			String secondcolumnData = row.getCell(1).getStringCellValue();
			System.out.println(firstColumnData+ "\t"+ secondcolumnData);
		}
		workbook.close();
		
	}

}
