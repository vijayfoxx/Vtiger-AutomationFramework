package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebdriverUtility;

public class HomePage extends WebdriverUtility {
	//decleration
	@FindBy(linkText="Organizations")
	private WebElement orgonizationsLink;
	@FindBy(linkText="Contacts")
	private WebElement contactslink;
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLink;
	@FindBy(linkText="Products")
	private WebElement productsLink;
	@FindBy(linkText="Leads")
	private WebElement leadsLink;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	@FindAll({@FindBy(linkText="Sign Out"),@FindBy(xpath="//a[@href='index.php?module=Users&action=Logout']")})
	private WebElement signoutBtn;

	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getOrgonizationsLink() {
		return orgonizationsLink;
	}

	public WebElement getContactslink() {
		return contactslink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignoutBtn() {
		return signoutBtn;
	}

	//business library
	/**
	 * This method will perform signout action
	 * @param driver
	 */
	public void signOutOfApp(WebDriver driver) {
		mouseHoverOn(driver, adminImg);
		signoutBtn.click();
	}
	/**
	 * This method will click on org link
	 */
	public void clickOnOrgLink() {
		orgonizationsLink.click();
		
	}
	/**
	 * This method will click on contacts link
	 */
	public void clickOnContsctsLink() {
		contactslink.click();
	}
}
