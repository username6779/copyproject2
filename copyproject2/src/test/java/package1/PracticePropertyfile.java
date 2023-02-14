package package1;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticePropertyfile {

	public static void main() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
   FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
   
   Properties p=new Properties();
    p.load(fis);
    
    String BROWSER = p.getProperty("browser");
    String URL = p.getProperty("url");
    String USERNAME = p.getProperty("username");
    String PASSWORD= p.getProperty("password");

    FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
    Workbook wb = WorkbookFactory.create(fis1);
    Sheet sh = wb.getSheet("organization");
    Row rw = sh.getRow(2);
    Cell cl = rw.getCell(3);
    String value = cl.getStringCellValue();
    Random ran=new Random();
    int value1 = ran.nextInt(100);
    String org=value+value1;
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
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(URL);
	
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
	
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
    

	driver.findElement(By.id("submitButton")).click();
    

	/*driver.findElement(By.xpath("//a[text()='Organizations'][1]")).click();
    

	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
    

	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(org);
    

	driver.findElement(By.xpath("//input[@name='button']")).click();
    
    Thread.sleep(4000);
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
    
	WebElement element=driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']"));
    Actions act =new Actions(driver);
	act.moveToElement(element);
	act.click();
	act.perform();*/
    
	}

	
	

}
