package vtiger.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.GenericUtility.ExcelUtility;

public class DataProviderPractice {
	@Test(dataProvider = "wishlist")
	public void addProductToCartTest(String orgname, String industryType) {
		System.out.println(orgname+"-"+industryType);	
	}
	@DataProvider(name="product")
	public Object [][] getData() {
		Object[][] d=new Object[4][5];
		d[0][0]="samsung";
		d[0][1]="S20";
		d[0][2]=80000;
		d[0][3]="camera";
		d[0][4]=1;
		
		d[1][0]="iphone";
		d[1][1]="13 pro";
		d[1][2]=100000;
		d[1][3]="RAM";
		d[1][4]=2;
		
		d[2][0]="nokia";
		d[2][1]="1100";
		d[2][2]=20000;
		d[2][3]="Processor";
		d[2][4]=3;
		
		d[3][0]="sony";
		d[3][1]="j30";
		d[3][2]=30000;
		d[3][3]="Memory";
		d[3][4]=4;
		
		return d;
	}
	@DataProvider(name="wishlist")
	public Object[][] getDatas() throws EncryptedDocumentException, IOException {
		ExcelUtility eu=new ExcelUtility();
		Object[][] data = eu.readMultipleDataFromExcel("MultipleOrg");
		return data;
	}
}
