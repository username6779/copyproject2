package separatepackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import GenericLibrary.Excelsheetlibrary;
import GenericLibrary.JavaLibrary;
import GenericLibrary.PropertyfileLibrary;
import GenericLibrary.WebdriverLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeExceldataprovder {
	
	PropertyfileLibrary pf=new PropertyfileLibrary();
	Excelsheetlibrary esl=new Excelsheetlibrary();
	JavaLibrary jlb=new JavaLibrary();

	@Test
	public void createorgwithindtest() throws IOException {
	
	
	String BROWSER = pf.readdatefrompropertyfile("browser");
	String URL= pf.readdatefrompropertyfile("url");
	String USERNAME = pf.readdatefrompropertyfile("username");
	String PASSWORD = pf.readdatefrompropertyfile("password");
	
	int rn = jlb.random();
	
	String org=orgname+rn;
	
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
	    

		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	    

		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    

		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(org);
	    

		driver.findElement(By.xpath("//input[@name='button']")).click();
		
		WebElement webelement = driver.findElement(By.xpath("//select[@name='industry']"));
    
        wbl.handleDropDown(webelement, 4);
           
	    driver.findElement(By.xpath(" //div[@align='center' ]/input[1]")).click();
	
	    String headtext = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	
	if(headtext.contains(org))
	{
	System.out.println("script pass");
	}
	else
	{
	System.out.println("script fail");
	}
    Thread.sleep(4000);
	WebElement mact= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	wbl.mouseHoveron(driver, mact);
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
    

}
}
