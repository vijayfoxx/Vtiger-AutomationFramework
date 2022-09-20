package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//1.load file into fileinputstream
		FileInputStream file=new FileInputStream("./src/test/resources/testdata.xlsx");
		//2.create workbookfactory
		Workbook wb = WorkbookFactory.create(file);
		//3.navigate to respective sheet
		Sheet sheet = wb.getSheetAt(0);
		//4.navigate to row
		Row row = sheet.getRow(1);
		//5.navigate to cell
		Cell cell = row.getCell(2);
		//6.read the cell value
		String value = cell.getStringCellValue();
		System.out.println(value);
	}

}
