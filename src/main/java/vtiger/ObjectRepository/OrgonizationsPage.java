package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebdriverUtility;

public class OrgonizationsPage {
	//decleration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgLink;
	//initialization
	public OrgonizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getCreateOrgLink() {
		return createOrgLink;
	}
	//bussiness library
	/**
	 * This mrthod will create new orgonization
	 */
	public void clickOnCreateNew() {
		createOrgLink.click();
	}

}
