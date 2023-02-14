package package1;

import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

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
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganizationTest {

	    @Test
	    public void createcontactwithoganizationtest() throws IOException {
		// TODO Auto-generated method stub
     
		PropertyfileLibrary pfl=new PropertyfileLibrary();
	   
		String BROWSER = pfl.readdatefrompropertyfile("browser");
		String URL = pfl.readdatefrompropertyfile("url");
		String USERNAME = pfl.readdatefrompropertyfile("username");
		String PASSWORD= pfl.readdatefrompropertyfile("password");
       
		Excelsheetlibrary esl=new Excelsheetlibrary();
		
		String contatnm = esl.readdatafromeexcelsheet("contact", 3, 3);
		String orgname = esl.readdatafromeexcelsheet("contact", 3, 4);
		WebdriverLibrary wbdl=new WebdriverLibrary();
		
		JavaLibrary jlb=new JavaLibrary();
		int rd = jlb.random();

		 String contactname=contatnm+rd;
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
			
			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
			
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		    

			driver.findElement(By.id("submitButton")).click();
		    


		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();   

		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(contactname);
         
		driver.findElement(By.xpath("//input[@name='account_id'] /following-sibling::img[@title='Select']")).click();
		
		wbl.switchToWindow(driver,"Accounts");
		 driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgname);
	      
	       driver.findElement(By.xpath("//input[@name='search']")).click();
	       
	       driver.findElement(By.xpath("//a[text()='Aswinnew1']")).click();
	      
	      wbl.switchToWindow(driver, "Contact");
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();

		String contactpage = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
          if(contactpage.contains(contactname))
          {
       	   System.out.println("script pass");
          }
          else
          {
       	   System.out.println("script fail");
          }
		 WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
       
       wbl.mouseHoveron(driver, element);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
       
		

	}

}
