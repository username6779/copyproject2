package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibrary.WebdriverLibrary;

public class HomePage extends WebdriverLibrary {

	@FindBy(xpath="//a[@href='index.php?module=Accounts&action=index']")
	private WebElement organizationlink;
	
	@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
	private WebElement contactlink;
	
	@FindBy(xpath="//a[@href='index.php?module=Potentials&action=index']")
	private WebElement opportunitieslink;
	
	@FindBy(xpath="//a[@href='index.php?module=Products&action=index']")
	private WebElement productslink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorlink;
	
	@FindBy(xpath="//a[@href='index.php?module=Users&action=Logout']")
	private WebElement signoutlink;
	
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrganizationlink() {
		return organizationlink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}

	public WebElement getOpportunitieslink() {
		return opportunitieslink;
	}

	public WebElement getProductslink() {
		return productslink;
	}

	public WebElement getAdministratorlink() {
		return administratorlink;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}
	/**
	 * This method will click on organization link on homepage
	 */
	public void organization() {
		
		organizationlink.click();
	}
	/**
	 * This method will click on contact link on homepage
	 */
	public void contact() {
		
		contactlink.click();
	}
	/**
	 * This method will click on opportunities link on homepage
	 */
	public void opportunities() {
		
		opportunitieslink.click();
	}
	/**
	 * This method will click on products link on homepage
	 */
	public void products() {
		productslink.click();
	}
	/**
	 * This method will perform moushoveraction and click on signoutlink on homepage
	 * @param driver
	 */
	public void signout(WebDriver driver) {
    mouseHoveron(driver, administratorlink);
	 signoutlink.click();
	}
}
