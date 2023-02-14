package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibrary.WebdriverLibrary;

public class CreateContactPage extends WebdriverLibrary {
	
	@FindBy(xpath="//input[@name='lastname']")
    private WebElement lastname;
	
	@FindBy(xpath="//select[@name='leadsource']")
	private WebElement leadsource;
	
	@FindBy(xpath="//input[@name='account_id']/following-sibling::img[@title='Select']")
	private WebElement addindustry ;
	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement searchIndustry;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchbutton;
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement savebutton ;
	
	public CreateContactPage(WebDriver deiver) {
	 PageFactory.initElements(deiver, this);
		
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getLeadsource() {
		return leadsource;
	}

	public WebElement getAddindustry() {
		return addindustry;
	}

	public WebElement getSearchIndustry() {
		return searchIndustry;
	}

	public WebElement getSearchbutton() {
		return searchbutton;
	}
	
	
	public WebElement getSavebutton() {
		return savebutton;
	}
    /**
     * This method clicks on savebutton
     * @param savebutton
     */
	public void setSavebutton(WebElement savebutton) {
		this.savebutton = savebutton;
	}
   /**
    * this gives contact name and saves.
    * @param contactname
    */
	public void createcontact(String contactname) {
		lastname.sendKeys(contactname);
		savebutton.click();
	}
	/**
	 * This method gives contactname and selects lead type.
	 * @param contactname
	 * @param leadtype
	 */
	public void createcontact(String contactname, String leadtype) {
		lastname.sendKeys(contactname);
		handleDropDown(leadtype, leadsource);
		savebutton.click();

	}
	/**
	 * This method gives createcontact along organization name.
	 * @param contactname
	 * @param driver
	 * @param partialwindowTitle
	 * @param Organization
	 */
	public void createcontact(String contactname, WebDriver driver,String orgname) {
      lastname.sendKeys(contactname);
	  addindustry.click();
	  switchToWindow(driver, "Accounts");
	  searchIndustry.sendKeys(orgname);
	  searchbutton.click();
	  driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
	  switchToWindow(driver, "Contacts");
		savebutton.click();
      
}
}
