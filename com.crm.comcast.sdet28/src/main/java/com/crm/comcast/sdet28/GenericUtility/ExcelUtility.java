package com.crm.comcast.sdet28.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author VIKASH PRATAP SINGH
 *
 */



public class ExcelUtility {
	/**
	 * 
	 * @param sheetname
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */
	public String getStringCellData(String sheetname, int rowNo, int cellNo) throws Throwable {
		FileInputStream file = new FileInputStream(IPathConstants.EXCEL_FILEPATH);
		  Workbook workbook = WorkbookFactory.create(file);
		  Sheet sheet = workbook.getSheet(sheetname);
		  Row row = sheet.getRow(rowNo);
		  Cell cell = row.getCell(cellNo);
		  return cell.getStringCellValue();
		
		
	}
	/**
	 * this method will return numeric value from excel sheet
	 * @param sheetname
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */


	public double getNumbericalData(String sheetname, int rowNo,int cellNo) throws Throwable {
		FileInputStream file = new FileInputStream(IPathConstants.EXCEL_FILEPATH);
		Workbook workbook = WorkbookFactory.create(file);
		return workbook.getSheet(sheetname).getRow(rowNo).getCell(cellNo).getNumericCellValue();
	
	
	}
	/**
	 * this method will return multiple data from excel sheet
	 * @param sheetname
	 * @throws Throwable
	 */
	public Object[][] getMultipleData(String sheetname) throws Throwable {
		FileInputStream file = new FileInputStream(IPathConstants.EXCEL_FILEPATH);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetname);
	    int rowNo = sheet.getLastRowNum();
	    short cellNo = sheet.getRow(0).getLastCellNum();
	    Object[][] data = new Object[rowNo][cellNo];
	    for(int i=0;i<rowNo;i++) {
		for(int j=0;j<cellNo;j++) {
		data[i][j]=sheet.getRow(i).getCell(j).toString();
			
		}
	}
	
	return data;
	}
	/**
	 * this method to use write data to excel file
	 * @param sheetname
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 * @throws Throwable
	 */

	public void writeDataIntoExcel(String sheetname,int rowNo,int cellNo, String value) throws Throwable {
		FileInputStream readfile = new FileInputStream(IPathConstants.EXCEL_FILEPATH);
		Workbook workbook = WorkbookFactory.create(readfile);
		workbook.createSheet(sheetname).createRow(rowNo).createCell(cellNo).setCellValue(value);
		
		FileOutputStream writefile = new FileOutputStream(IPathConstants.EXCEL_FILEPATH);
		workbook.write(writefile);
		
		workbook.close();
	
		
	}
	
	}
	

		
	
