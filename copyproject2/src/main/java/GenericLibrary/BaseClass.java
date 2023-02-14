package GenericLibrary;
/**
 * This class is for basic configuration
 */
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.HomePage;
import ObjectRepository.LogInPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	//Here database is lauched
	
	@BeforeSuite(groups="regression")
	public void bfsuite() {
	System.out.println("Database related action");	
	}
	
	public PropertyfileLibrary pf=new PropertyfileLibrary();
	  public Excelsheetlibrary esl=new Excelsheetlibrary();
	  public JavaLibrary jlb=new JavaLibrary();
	  public WebdriverLibrary wbl=new WebdriverLibrary();
	   
	   public WebDriver driver=null;
	   public static WebDriver sderiver=null;
    //Here browser is lauched 
	//@Parameters("browser")   
	@BeforeTest
	//@BeforeClass(groups="regression")
	public void bfclass(/*String BROWSER*/) throws IOException {
		
   String BROWSER = pf.readdatefrompropertyfile("browser");	
   
   if(BROWSER.equalsIgnoreCase("chrome")) {
	   
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  System.out.println(BROWSER+" got launched");
   }
   else if(BROWSER.equalsIgnoreCase("edge")) {
	   
	  WebDriverManager.edgedriver().setup();
	  driver=new EdgeDriver();
	  System.out.println(BROWSER+" got launched");

   }
   else
   {
	   System.out.println("Invalid browser");
   }
   String URL= pf.readdatefrompropertyfile("url");	
      sderiver=driver;
      driver.get(URL);
      wbl.maximisewindow(driver);
      wbl.waitforpageload(driver);
	}
	
	//here Login operation is performed
	@BeforeMethod(groups="regression")
	public void bfmethod() throws IOException {
		
	 String USERNAME = pf.readdatefrompropertyfile("username");	
     String PASSWORD = pf.readdatefrompropertyfile("password");	

		LogInPage lip=new LogInPage(driver);
		lip.loginpage(USERNAME, PASSWORD);
	}
	
	//here Logout operation is performed
	@AfterMethod(groups="regression")
	public void afmethod() {
	
		HomePage hp=new HomePage(driver);
		hp.signout(driver);
	}
	
	//Here window is closed
	@AfterTest
	//@AfterClass(groups="regression")
	public void afclass() {
		driver.quit();
		System.out.println("browser was closed");
	}
	
	//here database is closed
    @AfterSuite(groups="regression")
    public void afsuite() {
    	System.out.println("Database is closed");	
	
    }
}
