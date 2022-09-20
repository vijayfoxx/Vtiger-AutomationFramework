package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.WebdriverUtility;
import vtiger.ObjectRepository.CreateNewOrgonizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrgonizationsPage;

public class POMPractice {
	@Test
	public void pomPracTest() {
		
		//launch the browser
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		WebdriverUtility wd=new WebdriverUtility();
		wd.waitForElementstoLoadInDOM(driver);
		driver.get("http://localhost:8888");
		//login
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		OrgonizationsPage op=new OrgonizationsPage(driver);
		CreateNewOrgonizationPage cno=new CreateNewOrgonizationPage(driver);
		lp.loginToApp("admin", "admin");
		hp.clickOnOrgLink();
		op.clickOnCreateNew();
		cno.createNewOrg("IndusLand", "Banking", "Analyst");
	
}
}
