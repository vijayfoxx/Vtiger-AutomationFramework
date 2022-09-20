package vtiger.GenericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

/**
 * This class contains the configuration annotations for common functionalities
 * @author Vijay
 *
 */

public class BaseClass {
	public DatabaseUtility du=new DatabaseUtility();
	public JavaUtility ju=new JavaUtility();
	public WebdriverUtility wu=new WebdriverUtility();
	public ExcelUtility eu=new ExcelUtility();
	public PropertyUtility pu=new PropertyUtility();
	public WebDriver driver;
	static WebDriver sdriver;
	@BeforeSuite
	public void bsConfig() throws SQLException {
		//du.connectToDB();
		Reporter.log("---Database connected successfully---",true);
	}
	@BeforeClass
	public void bcConfig() throws IOException {
		String Browser = pu.readDataFromPropertyFile("browser");
		String url = pu.readDataFromPropertyFile("Url");
		if(Browser.equalsIgnoreCase("CHROME")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("FIREFOX")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Invalid Browser name");
		}
		sdriver=driver;
		Reporter.log("---Browser"+Browser+" is launched",true);
		wu.windowMaximize(driver);
		wu.waitForElementstoLoadInDOM(driver);
		driver.get(url);
	}
	@BeforeMethod
	public void bmConfig() throws IOException {
		String un = pu.readDataFromPropertyFile("Username");
		String pw = pu.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(un, pw);
		Reporter.log("---Login successfull---",true);
	}
	@AfterMethod
	public void amConfig() {
		HomePage hp=new HomePage(driver);
		hp.signOutOfApp(driver);
		Reporter.log("---Sign out successfull---",true);
		}
	@AfterClass
	public void acConfig() {
		driver.close();
		Reporter.log("---Browser closed successfully---",true);
	}
	@AfterSuite
	public void asConfig() throws SQLException {
		//du.closeDB();
		Reporter.log("---Database closed successfully---",true);
	}
	}

