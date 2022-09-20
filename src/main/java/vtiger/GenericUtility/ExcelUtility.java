package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * This method will write the data in excel sheet
	 * @param sheet
	 * @param row
	 * @param cel
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheet,int row,int cel,String value) throws EncryptedDocumentException, IOException{
		FileInputStream file=new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wbook = WorkbookFactory.create(file);
		Sheet sheet2 = wbook.getSheet(sheet);
		Row row2 = sheet2.getRow(row);
		Cell Cell = row2.createCell(cel);
		Cell.setCellValue(value);
		FileOutputStream file2=new FileOutputStream(ConstantsUtility.ExcelFilePath);
		wbook.write(file2);
		wbook.close();
	}
	/**
	 * This method will read the data from excel
	 * @param value
	 * @param rw
	 * @param cl
	 * @return 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String value,int rw,int cl) throws EncryptedDocumentException, IOException {
		FileInputStream file=new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(value);
		Row row = sheet.getRow(rw);
		Cell cell = row.getCell(cl);
		String stringCellValue = cell.getStringCellValue();
		System.out.println(stringCellValue);
		return stringCellValue;
	}
	/**
	 * This method is used to execute same script with multiple set of data
	 * Hence it will return Object[][],so that it can be directly used in dataprovider
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int lr = sheet.getLastRowNum();
		short lc = sheet.getRow(0).getLastCellNum();
		
		Object[][] data=new Object [lr][lc];
		for(int i=0;i<lr;i++) {
			for(int j=0;j<lc;j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}
