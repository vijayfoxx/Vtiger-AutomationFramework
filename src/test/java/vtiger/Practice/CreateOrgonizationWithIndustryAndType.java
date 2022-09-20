package vtiger.Practice;

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
import org.openqa.selenium.support.ui.Select;

public class CreateOrgonizationWithIndustryAndType {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver;
		//1.Read the necessary data
		FileInputStream file=new FileInputStream("./src/test/resources/CommonData.properties");
		Properties prop=new Properties();
		prop.load(file);
		String browser = prop.getProperty("Browser");
		String url = prop.getProperty("Url");
		String un = prop.getProperty("Username");
		String pw = prop.getProperty("password");
		//Excel sheet
		FileInputStream file1=new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wbook = WorkbookFactory.create(file1);
		Sheet sheet = wbook.getSheetAt(0);
		Row row = sheet.getRow(7);
		Cell cell = row.getCell(2);
		String orgname = cell.getStringCellValue();
		System.out.println(orgname);
		//2.Open the Browser
	/*	if(browser.equalsIgnoreCase("chrome")) {
	   driver=new ChromeDriver();
	   System.out.println("------chrome is launched successfully-------");
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			System.out.println("-------firefox is launched successfully-------");
		}
		else {
			System.out.println("Invalid browser name");
			driver=new ChromeDriver();
			   System.out.println("------chrome is launched successfully-------");
		}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(url);
//3.login to the app
	driver.findElement(By.name("user_name")).sendKeys(un);
	driver.findElement(By.name("user_password")).sendKeys(pw);
	driver.findElement(By.id("submitButton")).click();
//4.navigate to orgonizations
	driver.findElement(By.linkText("Organizations")).click();
//5.create orgonization with mandatory fields
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys(orgname);
	WebElement drop = driver.findElement(By.xpath("//select[@name='industry']"));
	Select select=new Select(drop);
	select.selectByValue("Electronics");
	WebElement type = driver.findElement(By.xpath("//select[@name='accounttype']"));
	Select select1=new Select(type);
	select1.selectByValue("Investor");
	//6.save
	driver.findElement(By.name("button")).click();
//7.logout
	WebElement out = driver.findElement(By.xpath("(//td[@class='small']//img)[1]"));
	Actions actions=new Actions(driver);
	actions.moveToElement(out).perform();
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();*/

}
}
