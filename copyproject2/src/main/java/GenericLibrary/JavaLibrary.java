package GenericLibrary;

import java.util.Date;
import java.util.Random;

/**
 * This class contains methods related to java.
 * @author aswin
 *
 */
public class JavaLibrary {
/**
 * This method return random numbers.
 */
	
  public int random() {
	
	Random ran=new Random();
	
	int value = ran.nextInt();
	
	return value;
  }	
  /**
   * This method returns date.
   * @return
   */
public String date() {
	
 Date d=new Date();
 String sd = d.toString();
 return sd;
}

public String dateedited() {
	
	Date d=new Date();
	String[] ed = d.toString().split(" ");
	
	  String day = ed[0];                                          //Fri Jan 27 12:20:47 IST 2023
	  String date = ed[2];
	  String year = ed[5];
	  String time = ed[3].replace(':', '-');
	  
	  String dtformate= day+" "+date+" "+year+" "+time;
	  return dtformate;
}
  }
  

