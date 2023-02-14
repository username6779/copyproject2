package separatepackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericLibrary.BaseClass;
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

@Listeners(GenericLibrary.ITtestListnersImplementationLibrary.class)
public class CreateContactWithOrganizationwithBaseTest extends BaseClass {
	
	   @Test(groups="regression")
	    public void createcontactwithoganizationtest() throws IOException {
		// TODO Auto-generated method stub
		String orgname=esl.readdatafromeexcelsheet("contact", 3, 4);
		String contactname = esl.readdatafromeexcelsheet("contact", 3, 3);
		
		
		int rn = jlb.random();
		
		String ctc=contactname+rn;
		
	
            //Click on contact in homepage
		        
			HomePage hp=new HomePage(driver);
		    hp.contact();
            
		    //Click on contact lookupimage in contactpage.
			ContactPage cp=new ContactPage(driver);
            cp.contactlookupimg();
            
			//Click on lastname to give contact name select orgname and save
            

		    CreateContactPage ccp=new CreateContactPage(driver);
	           ccp.createcontact(ctc, driver, orgname);
	          
	           
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
		  
	}
	   
	 @Test(groups="regression")
	 public void abajabadabatest() {
		 
		 System.out.println("mundu adhi cheppu gadidha");
	 }
	 @Test(groups="regression")
	 public void jabajdbatest() {
		 
		 System.out.println("nenandhi me fan ni");
	 }   

}
