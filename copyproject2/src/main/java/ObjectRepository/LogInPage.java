package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

	@FindBy(xpath="//input[@name='user_name']")
	private WebElement usernamepom;
	
	@FindBy(name="user_password")
	private WebElement passwordpom;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	private WebElement loginpom;
	
	public LogInPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernamepom() {
		return usernamepom;
	}

	public WebElement getPasswordpom() {
		return passwordpom;
	}

	public WebElement getLoginpom() {
		return loginpom;
	}
	/**
	 * This method performs login operation.
	 * @param username
	 * @param password
	 */
	public void loginpage(String username,String password) {
		
		usernamepom.sendKeys(username);
		
		passwordpom.sendKeys(password);
		
		loginpom.click();
	}
}

  