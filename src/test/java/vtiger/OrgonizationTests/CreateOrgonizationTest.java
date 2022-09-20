package vtiger.OrgonizationTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.CreateNewOrgonizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrgonizationInfoPage;
import vtiger.ObjectRepository.OrgonizationsPage;
@Listeners(vtiger.GenericUtility.ListenerImplementationClass.class)
public class CreateOrgonizationTest extends BaseClass {
	@Test(groups = "SmokeSuite" ,retryAnalyzer = vtiger.GenericUtility.RetryAnalyserImplementation.class)
	public void createOrgonizationTest() throws EncryptedDocumentException, IOException {
		String org = eu.readDataFromExcel("Orgonization", 1, 2)+ju.getRandomNumber();
		HomePage hp=new HomePage(driver);
		OrgonizationsPage op=new OrgonizationsPage(driver);
		OrgonizationInfoPage oip=new OrgonizationInfoPage(driver);
		CreateNewOrgonizationPage onp=new CreateNewOrgonizationPage(driver);
		hp.clickOnOrgLink();
		Reporter.log("Organization link clicked", true);
		op.clickOnCreateNew();
		onp.createNewOrg(org);
		Reporter.log("New Organization created", true);
		String orgHeader = oip.getOrgHeader();
		System.out.println(orgHeader);
		Assert.assertTrue(orgHeader.contains(org));

	}
}
