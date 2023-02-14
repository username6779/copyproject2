package GenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverLibrary {

	  /**
	    * This method will maximize the window
	    * @param driver
	    */
		public void maximisewindow(WebDriver driver) {
			driver.manage().window().maximize();
		}
		public void waitforpageload(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		}
		/**
		 * This method will wait for 10 seconds for element to be visible
		 * @param driver
		 * @param element
		 */
	/*	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10L));
			wait.until(ExpectedConditions.visibilityOfAllElements(element));
		}
		/**
		 * This method will wait for 10 seconds for the element to be clickable
		 * @param driver
		 * @param element
		 */
	/*	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10L));
		  wait.until(ExpectedConditions.elementToBeClickable(element));
		  
		}
		
		/**
		 * 
		 * @param element
		 * @throws InterruptedException 
		 */
		public void WaitAndClickonElement(WebElement element) throws InterruptedException {
			int count=0;
					while(count<10)
					{
						try
						{
			        element.click();
					 break;
		}
			catch(Exception e)	
				{
				Thread.sleep(1000);
				count++;
				
		}		
		}
		}

    /**
     * This method will handle drop-down through select data by index
     * @param element
     * @param index
     */
	   public void handleDropDown(WebElement element, int index) {
		   Select s=new Select(element);
		   s.selectByIndex(index);
	   }
	   /**
	    * This method will handle drop-down through select class and select data by value
	    * @param element
	    * @param value
	    */
	   public void handleDropDown(WebElement element, String value) {
		   Select s =new Select(element);
		   s.selectByValue(value);
	   }
	   /**
	    * This method will handle drop-down through select class and select data by visible text
	    * @param text
	    * @param element
	    */
	   public void handleDropDown(String text, WebElement element) {
	   
     Select s=new Select(element);
     s.selectByVisibleText(text);
	   }
	   /**
	    * This method will perform mouse hover action
	    * @param driver
	    * @param element
	    */
	   public void mouseHoveron(WebDriver driver, WebElement element){
		   Actions act=new Actions(driver);
		   act.moveToElement(element).perform();
	   }
	   /**
	    * This method will perform right click on the web page
	    * @param driver
	    */
	   public void rightClickOn(WebDriver driver) {
		   Actions act=new Actions(driver);
		   act.contextClick().perform();
	   }
	   /**
	    * This method will perform right click on a particular web element
	    * @param driver
	    * @param element
	    */
	   public void rightClickOn(WebDriver driver, WebElement element)
	   {
		   Actions act=new Actions(driver);
		   act.contextClick(element).perform();
	   }
	   /**
	    * This method will perform double click on webpage
	    * @param driver
	    */
	   public void doubleClickOn(WebDriver driver)
	   {
		 Actions act=new Actions(driver);
		 act.doubleClick().perform();
	   }
	   /**
	    * This method will perform double click on a particular web element
	    * @param driver
	    * @param element
	    */
	   public void doubleClickon(WebDriver driver, WebElement element) {
		   Actions act=new Actions(driver);
		   act.doubleClick(element).perform();
	   }
	   /**
	    * This method will drag and drop from source element to destination element
	    * @param driver
	    * @param srcElement
	    * @param dstElement
	    */
	   public void dragAndDropOn(WebDriver driver, WebElement srcElement,WebElement dstElement) {
		   Actions act=new Actions (driver);
		   act.dragAndDrop(srcElement, dstElement).perform();
		   }
	   /**
	    * This is method will mouse hover using offset value for x and y co-ordinates
	    * @param driver
	    * @param xoff
	    * @param yoff
	    */
	   public void mouuseHoveron(WebDriver driver, int xoff,int yoff) {
		   Actions act=new Actions(driver);
		   act.moveByOffset(xoff,yoff).perform();
		   }
	   /**
	    * This method will switch to frame based on index
	    * @param driver
	    * @param index
	    */
	   public void SwitchToFrame(WebDriver driver, int index) {
		   driver.switchTo().frame(index);
	   }
	   /**
	    * This method will switch to frame based on name or id
	    * @param driver
	    * @param nameorId
	    */
	   public void switchToFrame(WebDriver driver, String nameorId) {
		   driver.switchTo().frame(nameorId);
	   }
	   /**
	    * This method will switch to frame based on element
	    * @param driver
	    * @param element
	    */
	   public void switchToFrame(WebDriver driver, WebElement element) {
		   driver.switchTo().frame(element);
	   }
	   /**
	    * This method will switch from current frame immediate parent
	    * @param driver
	    */
	   public void switchToParentFrame(WebDriver driver) {
		   driver.switchTo().parentFrame();
		}
	   /**
	    * This method will switch from current frame to default frame
	    * @param driver
	    */
	   public void switchToDefaultFrame(WebDriver driver) {
		   driver.switchTo().defaultContent();
	   }
	   /**
	    * This method will click accept in alert popup
	    * @param driver
	    */
	   public void acceptAlert(WebDriver driver) {
		   driver.switchTo().alert().accept();
	   }
	   /**
	    * This method will click on cancel in alert popup
	    * @param driver
	    */
	   public void dismisAlert(WebDriver driver) {
		   driver.switchTo().alert().dismiss();
	   }
	   /**
	    * This method will return the text fo alert popup
	    * @param driver
	    * @return
	    */
	   public String getAlertText(WebDriver driver) {
		   String alertText=driver.switchTo().alert().getText();
		   return alertText;
	   }
	   public void pressEnter() throws AWTException {
		   Robot r=new Robot();
		   r.keyPress(KeyEvent.VK_ENTER);
		   r.keyRelease(KeyEvent.VK_ENTER);   
	   }
	   public void switchToWindow(WebDriver driver, String partialWindowTitle) {
		 //step 1:get all the window handles
		Set<String> windowIds = driver.getWindowHandles(); 
		//step2:iterate through all the window ids ----similar to foreach loop
		    Iterator<String> it = windowIds.iterator();
		//step3:navigate to each window and chech the title
		    while(it.hasNext())
		    {
		 //Step4:capture the individual window id
		    	String winID = it.next();
		 //Step5:switch to that window and capture tthe title
		  String currentTitle = driver.switchTo().window(winID).getTitle();  
		  //step6:compate current title with partial title
		  if(currentTitle.contains(partialWindowTitle))
		  {
			  break;
		  }
		  }
		    }
	   /**
	    * This method gives screeshot
	    * @param driver
	    * @param screenshotname
	    * @return
	    * @throws IOException
	    */
	   
	   public String takeScreenShot(WebDriver driver, String screenshotname) throws IOException
	   {
		   TakesScreenshot ts=(TakesScreenshot) driver;
		   File src=ts.getScreenshotAs(OutputType.FILE);
		  File dst= new File(".\\ScreenShots\\"+screenshotname+".png");
		  
		  FileUtils.copyFile(src, dst); //from commons io dependency
		  
		  return dst.getAbsolutePath(); // used for extends reports
	   }
	   /**
	    *This method will scroll down forr 500 units 
	    * @param driver
	    */
	   
	     public void scrollAction(WebDriver driver) {
	      JavascriptExecutor js=(JavascriptExecutor) driver;
	      js.executeScript("window.scrollBy(0,500)", "");
	     }
	     public void scrollActions(WebDriver driver,WebElement element) {
	      JavascriptExecutor js=(JavascriptExecutor) driver;
	      //js.executeScript("arguments[0].scrollIntoview();", element);
	      int y=element.getLocation().getY();
	      js.executeScript("window.scrollBy(0,"+y+")", element);
	      
	   
	
	
	     }
	
	     }
