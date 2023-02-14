package package1;

import java.io.IOException;

import javax.naming.directory.SearchControls;

import org.openqa.selenium.SearchContext;

import GenericLibrary.Excelsheetlibrary;
import GenericLibrary.JavaLibrary;
import GenericLibrary.PropertyfileLibrary;

public class practice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
   JavaLibrary jlib=new JavaLibrary();
   int rd = jlib.random();
   System.out.println(rd);
   
   String date = jlib.date();
   
   System.out.println(date);

   String edt = jlib.dateedited();
   
   System.out.println(edt);
   
   PropertyfileLibrary pf=new PropertyfileLibrary();
   
   String value = pf.readdatefrompropertyfile("browser");
   
   System.out.println(value);
  String value1 = pf.readdatefrompropertyfile("username");
   
  System.out.println(value1);

   Excelsheetlibrary esl=new Excelsheetlibrary();
   
   String org = esl.readdatafromeexcelsheet("organization", 2, 3);
   System.out.println(org);

   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
	}
 
  
}
