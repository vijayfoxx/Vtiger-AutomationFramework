package vtiger.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import vtiger.GenericUtility.ExcelUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		JavaUtility ju=new JavaUtility();
		ExcelUtility eu=new ExcelUtility();
		PropertyUtility pu=new PropertyUtility();
		ju.getRandomNumber();
		System.out.println(ju.getSystemDate());
		System.out.println(ju.getSystemDateInFormat());
		eu.writeDataIntoExcel("Orgonization", 4, 6, "vijay");
		eu.readDataFromExcel("Orgonization", 1, 2);
	
	}

}
