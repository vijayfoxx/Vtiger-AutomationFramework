package vtiger.OrgonizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ConstantsUtility;
import vtiger.GenericUtility.ExcelUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyUtility;
import vtiger.GenericUtility.WebdriverUtility;
import vtiger.ObjectRepository.CreateNewOrgonizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrgonizationInfoPage;
import vtiger.ObjectRepository.OrgonizationsPage;
import vtiger.Practice.CreateOrgonizationWithIndustryAndType;

@Listeners(vtiger.GenericUtility.ListenerImplementationClass.class)
public class CreateMultipleOrgWithIndustryTest extends BaseClass {
	@Test(dataProvider="orgData",groups = "SmokeSuite" ,retryAnalyzer = vtiger.GenericUtility.RetryAnalyserImplementation.class)
	public void createOrgonizationTest(String OrgName, String industryType) throws EncryptedDocumentException, IOException {

		String Org = OrgName+ju.getRandomNumber();
		HomePage hp=new HomePage(driver);
		OrgonizationsPage op=new OrgonizationsPage(driver);
		OrgonizationInfoPage oip=new OrgonizationInfoPage(driver);
		CreateNewOrgonizationPage onp=new CreateNewOrgonizationPage(driver);
		hp.clickOnOrgLink();
		Reporter.log("Organization link clicked", true);
		op.clickOnCreateNew();
		onp.createNewOrg(Org, industryType);
		Reporter.log("New Organization created", true);
		String orgHeader = oip.getOrgHeader();
		System.out.println(orgHeader);
		Assert.assertTrue(orgHeader.contains(Org));

	}
	@DataProvider(name="orgData")
	public Object[][]getData() throws EncryptedDocumentException, IOException{
		Object[][] data=eu.readMultipleDataFromExcel("MultipleOrg");
		return data;

	}

}
