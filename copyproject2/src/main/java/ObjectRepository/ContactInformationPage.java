package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactheader;
	
	public ContactInformationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactheader() {
		return contactheader;
	}
	/**
	 * This method giver contact header 
	 * @return
	 */
	public String contactheader() {
	  return contactheader.getText();
	}
	

}
