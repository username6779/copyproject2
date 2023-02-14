package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationpage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgheader;
	
	public OrganizationInformationpage (WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
     
	public WebElement getOrgheader() {
		return orgheader;
	}

	/**
	 * This method giver contact header 
	 * @return
	 */
	public String organizationhead() {
	  return orgheader.getText();
	}
}
