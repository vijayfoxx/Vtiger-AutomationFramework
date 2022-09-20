package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgonizationInfoPage {
	//declare
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;
	//initialize
	public OrgonizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}
	//business library
	/**
	 * This method will get the header text
	 * @return
	 */
	public String getOrgHeader() {
		String orgHeader = orgHeaderText.getText();
		return orgHeader;
	}

}
