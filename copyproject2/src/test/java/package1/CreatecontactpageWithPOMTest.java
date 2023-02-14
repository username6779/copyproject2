package package1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import GenericLibrary.Excelsheetlibrary;
import GenericLibrary.JavaLibrary;
import GenericLibrary.PropertyfileLibrary;
import GenericLibrary.WebdriverLibrary;
import ObjectRepository.ContactInformationPage;
import ObjectRepository.ContactPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.HomePage;
import ObjectRepository.LogInPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatecontactpageWithPOMTest {

	@Test(groups="regression")
	public void createcontactpomtest() throws IOException {
	
		// TODO Auto-generated method stub
PropertyfileLibrary pf=new PropertyfileLibrary();
		
		String BROWSER = pf.readdatefrompropertyfile("browser");
		String URL= pf.readdatefrompropertyfile("url");
		String USERNAME = pf.readdatefrompropertyfile("username");
		String PASSWORD = pf.readdatefrompropertyfile("password");
		
		Excelsheetlibrary esl=new Excelsheetlibrary();
		
		String contactname = esl.readdatafromeexcelsheet("contact", 2, 3);
		
		JavaLibrary jlb=new JavaLibrary();
		
		int rn = jlb.random();
		
		String ctc=contactname+rn;
	//Launching browser	
		 WebDriver driver=null;
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
		     WebDriverManager.chromedriver().setup();
		     driver=new ChromeDriver();
		     System.out.println(BROWSER+" launched");
			}
			else if(BROWSER.equalsIgnoreCase("edge"))
		    {
		    WebDriverManager.edgedriver().setup();
		    driver=new EdgeDriver();	
		    System.out.println(BROWSER+" launched");
		    }
		    else 
		    {
		    System.out.println("The browser is not stable");	
		    }
			WebdriverLibrary wbl=new WebdriverLibrary();
			
		    wbl.maximisewindow(driver);
		    
		    wbl.waitforpageload(driver);
		    
			driver.get(URL);
			
			//LOGIN OPERATION
			
		     LogInPage lip=new LogInPage(driver);	
		        lip.loginpage(USERNAME, PASSWORD);
		        
            //Click on contact in homepage
		        
			HomePage hp=new HomePage(driver);
		    hp.contact();
            
		    //Click on contact lookupimage in contactpage.

			ContactPage cp=new ContactPage(driver);
            cp.contactlookupimg();
            
			//Click on lastname to give contact name and save
			
		    CreateContactPage ccp=new CreateContactPage(driver);
	           ccp.createcontact(ctc);
	        //Click on contactheader for validation
	          
	           ContactInformationPage cip=new ContactInformationPage(driver);
	            String contactheading= cip.contactheader();
	           if(contactheading.contains(ctc))
	           {
	        	   System.out.println("script pass");
	           }
	           else
	           {
	        	   System.out.println("script fail");
	           }
		
	        
	        
	        //signout the application
	        
	       hp.signout(driver);
	        

	}

}
