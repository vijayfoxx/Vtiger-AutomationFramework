package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//rule 1:create seperate class  for every page
	//rule 2:Identify the elements using annotations
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	//rule 3:create a constructor to initialize
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//rule4: provide getters to access the elements
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//rule5: business library
	/**
	 * This method will login to the apploication with username and passsword
	 * @author Vijay
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username,String password) {
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}

}

