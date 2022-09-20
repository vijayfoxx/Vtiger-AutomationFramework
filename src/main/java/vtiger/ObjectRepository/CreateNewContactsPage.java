package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebdriverUtility;

public class CreateNewContactsPage extends WebdriverUtility {
	//Decleration
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstname;
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastName;
	@FindBy(xpath="//input[@name='account_id']//following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement orgNamebtn;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	@FindBy(id="search_txt")
	private WebElement searchOrg;
	@FindBy(name="search")
	private WebElement searchBtn;
	@FindBy(name="leadsource")
	private WebElement leadsourceDropdown;
	//initialization
	
	public CreateNewContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getSearchOrg() {
		return searchOrg;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	//Utilization
	public WebElement getFirstname() {
		return firstname;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getOrgNamebtn() {
		return orgNamebtn;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	//Bussiness library
	/**
	 * This method will create contact with lastname
	 * @param lname
	 */
	public void createContact(String lname) {
		lastName.sendKeys(lname);
		savebtn.click();
	}
	/**
	 * This method is used to create contact with leadsource type
	 * @param lname
	 * @param leadsourceType
	 */
	public void createContact(String lname,String leadsourceType) {
		lastName.sendKeys(lname);
		handleDropdown(leadsourceType, leadsourceDropdown);
		savebtn.click();
	}
	/**
	 * This method will create contat with orgname
	 * @param lname
	 * @param driver
	 * @param industryType
	 */
	public void createContact(String lname, WebDriver driver, String industryType) {
		lastName.sendKeys(lname);
		orgNamebtn.click();
		switchToWindows(driver, "Accounts");
		searchOrg.sendKeys(industryType);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+industryType+"']")).click();
		switchToWindows(driver, "Contacts");
		savebtn.click();
		
	}
}
