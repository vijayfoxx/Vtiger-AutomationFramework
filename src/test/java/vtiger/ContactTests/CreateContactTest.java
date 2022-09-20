package vtiger.ContactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactsPage;
import vtiger.ObjectRepository.HomePage;

@Listeners(vtiger.GenericUtility.ListenerImplementationClass.class)
public class CreateContactTest extends BaseClass {
	@Test(groups = "RegressionSuite",retryAnalyzer = vtiger.GenericUtility.RetryAnalyserImplementation.class)
	public void createContactTest() throws EncryptedDocumentException, IOException  {
		String fname = eu.readDataFromExcel("contacts", 1, 0)+ju.getRandomNumber();
		String lname = eu.readDataFromExcel("Contacts", 1, 1);
		HomePage hp=new HomePage(driver);
		ContactsPage cp=new ContactsPage(driver);
		CreateNewContactsPage cnc=new CreateNewContactsPage(driver);
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		hp.clickOnContsctsLink();
		Reporter.log("Contact link clicked", true);
		cp.clickOnCreateNew();
		cnc.createContact(lname);
		Reporter.log("New Contact created", true);
		String ch = cip.getContactHeader();
		System.out.println(ch);
		Assert.assertEquals(ch.contains(lname), true);
	}
}
