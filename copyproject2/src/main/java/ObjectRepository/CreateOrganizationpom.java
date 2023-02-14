package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibrary.WebdriverLibrary;

public class CreateOrganizationpom extends WebdriverLibrary {
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement organizationlink;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industrytype;
	
	@FindBy(xpath="//div[@align='center']/input[1]")
	private WebElement savebutton;
	
	public CreateOrganizationpom(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationlink() {
		return organizationlink;
	}

	public WebElement getIndustrytype() {
		return industrytype;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	
	public void createorganization(String orgname) {
		
		organizationlink.sendKeys(orgname);
		savebutton.click();
	}
	
	public void createorgwithindustry(String orgname, String indtype) {
		
		organizationlink.sendKeys(orgname);

		handleDropDown(industrytype, indtype);
		savebutton.click();
     
	}
}
	