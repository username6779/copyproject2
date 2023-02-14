package package1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericLibrary.Excelsheetlibrary;
import GenericLibrary.JavaLibrary;
import GenericLibrary.PropertyfileLibrary;
import GenericLibrary.WebdriverLibrary;
import ObjectRepository.ContactInformationPage;
import ObjectRepository.ContactPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.CreateOrganizationpom;
import ObjectRepository.HomePage;
import ObjectRepository.LogInPage;
import ObjectRepository.OrganizationInformationpage;
import ObjectRepository.Organizationpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOganizationWithIndustrytest {

	
   PropertyfileLibrary pf=new PropertyfileLibrary();
   Excelsheetlibrary esl=new Excelsheetlibrary();
   JavaLibrary jlb=new JavaLibrary();
   WebdriverLibrary wbl=new WebdriverLibrary();

	@Test(dataProvider="getdata")
	public void createcontactpomtest(String orgname, String indtype) throws IOException, InterruptedException {
	
		// TODO Auto-generated method stub

		String BROWSER = pf.readdatefrompropertyfile("browser");
		String URL= pf.readdatefrompropertyfile("url");
		String USERNAME = pf.readdatefrompropertyfile("username");
		String PASSWORD = pf.readdatefrompropertyfile("password");
		
		
		
		
		
		int rn = jlb.random();
		
		String orgnm=orgname+rn;
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
			
		    wbl.maximisewindow(driver);
		    
		    wbl.waitforpageload(driver);
		    
			driver.get(URL);
			
			//LOGIN OPERATION
			
		     LogInPage lip=new LogInPage(driver);	
		        lip.loginpage(USERNAME, PASSWORD);
		        
            //Click on contact in homepage
		        
			HomePage hp=new HomePage(driver);
		    hp.organization();
            
		    //Click on organization lookupimage in contactpage.

            Organizationpage op=new Organizationpage(driver);
            
            op.organizationlookup();
            
			//Click on orgname with industry and save
			
		    CreateOrganizationpom cop=new CreateOrganizationpom(driver);
		    cop.createorgwithindustry(orgnm, indtype);
		 
	        //Click on organizationheader for validation
	          
	          OrganizationInformationpage oip=new OrganizationInformationpage(driver); 
	         String orghead = oip.organizationhead();
	         
	         System.out.println(orghead);
	         
	           if(orghead.contains(orgnm))
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
	
	@DataProvider()
	public Object[][] getdata() throws EncryptedDocumentException, IOException{
		
	Object[][] obj = esl.writemultipledataintoexcel("Multipleorganization");
	
	   return obj;
	}
}
