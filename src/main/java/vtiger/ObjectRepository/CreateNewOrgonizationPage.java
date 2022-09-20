package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebdriverUtility;

public class CreateNewOrgonizationPage extends WebdriverUtility {
	@FindBy(name="accountname")
	private WebElement orgonizationName;
	@FindBy(name="industry")
	private WebElement industryDropDown;
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	//initialization
	public CreateNewOrgonizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getOrgonizationName() {
		return orgonizationName;
	}
	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}
	public WebElement getTypeDropDown() {
		return typeDropDown;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	//Business library
	/**
	 * This method will create orgonization with org name name
	 * @param orgname
	 */
	public void createNewOrg(String orgname) {
		orgonizationName.sendKeys(orgname);
		saveBtn.click();
	}
	/**
	 * This method will create orgonization with name and industry type
	 * @param orgname
	 * @param industryType
	 */
	public void createNewOrg(String orgname,String industryType) {
		orgonizationName.sendKeys(orgname);
		handleDropdown(industryDropDown, industryType);
		saveBtn.click();

	}
	/**
	 * This method will create orgonization with type and industry
	 * @param orgname
	 * @param industryType
	 * @param type
	 */
	public void createNewOrg(String orgname,String industryType,String type) {
		orgonizationName.sendKeys(orgname);
		handleDropdown(industryDropDown, industryType);
		handleDropdown(typeDropDown, type);
		saveBtn.click();
	}
}
