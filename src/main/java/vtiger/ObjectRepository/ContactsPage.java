package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	//Decleration
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContactimg;
	
	//Initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization

	public WebElement getCreateContactimg() {
		return createContactimg;
	}
	//Business library
	/**
	 * This method is used to click on create new contact img
	 */
	public void clickOnCreateNew() {
		createContactimg.click();
	}
}
