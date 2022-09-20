package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	//decleration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement header;
	//initialization
	public ContactsInfoPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getHeader() {
		return header;
	}
	//business library
	/**
	 * This method will return the header text
	 * @return
	 */
	public String getContactHeader() {
		return header.getText();
	}
}
