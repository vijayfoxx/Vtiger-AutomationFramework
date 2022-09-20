package vtiger.ContactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyUtility;
import vtiger.GenericUtility.WebdriverUtility;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactsPage;
import vtiger.ObjectRepository.CreateNewOrgonizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrgonizationInfoPage;
import vtiger.ObjectRepository.OrgonizationsPage;

/**
 * @author Vijay Mahendran
 */
@Listeners(vtiger.GenericUtility.ListenerImplementationClass.class)
public class CreateContactWithOrgonizationTest extends BaseClass {
	@Test(groups = "SmokeSuite" ,retryAnalyzer = vtiger.GenericUtility.RetryAnalyserImplementation.class)
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException{
		//Read all the required data
		String fname = eu.readDataFromExcel("contacts", 1, 0)+ju.getRandomNumber();
		String lname = eu.readDataFromExcel("Contacts", 1, 1);
		String orgName = eu.readDataFromExcel("Orgonization", 7, 2)+ju.getRandomNumber();
		HomePage hp=new HomePage(driver);
		OrgonizationsPage op=new OrgonizationsPage(driver);
		OrgonizationInfoPage oip=new OrgonizationInfoPage(driver);
		CreateNewOrgonizationPage cnp=new CreateNewOrgonizationPage(driver);
		ContactsPage cp=new ContactsPage(driver);
		CreateNewContactsPage cnc=new CreateNewContactsPage(driver);
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		//Navigate to Organizations link
		hp.clickOnOrgLink();
		Reporter.log("Organization link clicked", true);
		// Create Organization with mandatory fields
		op.clickOnCreateNew();
		cnp.createNewOrg(orgName);
		Reporter.log("New Organization created", true);
		//Validate
		String orgHeader = oip.getOrgHeader();
		System.out.println(orgHeader);
		Assert.assertTrue(orgHeader.contains(orgName));
		//Navigate to Contacts link
		hp.clickOnContsctsLink();
		Reporter.log("Contacts link clicked", true);
		//Navigate to create contcts img
		cp.clickOnCreateNew();
		Reporter.log("create Contact Look Up image clicked", true);
		//Create contact with org details
		cnc.createContact(lname, driver, orgName);
		Reporter.log("new contact with organization created", true);
		//validate
		String ch = cip.getContactHeader();
		System.out.println(ch);
	    Assert.assertEquals(ch.contains(lname), true);
	}



}
