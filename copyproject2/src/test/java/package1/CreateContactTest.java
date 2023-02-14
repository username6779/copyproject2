package package1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import GenericLibrary.Excelsheetlibrary;
import GenericLibrary.JavaLibrary;
import GenericLibrary.PropertyfileLibrary;
import GenericLibrary.WebdriverLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest {

	@Test
	public void createcontacttest() throws InterruptedException, IOException {
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

		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(ctc);
          
		driver.findElement(By.xpath("//input[@name='button']")).click();
        
		String contactpage = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
           if(contactpage.contains(ctc))
           {
        	   System.out.println("script pass");
           }
           else
           {
        	   System.out.println("script fail");
           }
		/*	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
        Thread.sleep(3000);
		WebElement element2=driver.findElement(By.xpath("//a[text()='Sign Out']"));
        Actions act =new Actions(driver);
		act.moveToElement(element2);
		act.click();
		act.perform();*/
		
           


	}

}
