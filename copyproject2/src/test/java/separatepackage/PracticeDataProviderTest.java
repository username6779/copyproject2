package separatepackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PracticeDataProviderTest {
	
	@Test(dataProvider="givedata")
	public void pdataprovidertest(String name, int age, String occupation) {
	
	System.out.println("name "+name+" age "+age+" occupation "+occupation);	
		
	}
	
	@DataProvider
    public Object[][] givedata() {
		
		Object[][] md=new Object[3][3];	
		   
		md[0][0]="aswin";
		md[0][1]= 29;
		md[0][2]="superstar";
		
		md[1][0]="sriram";
		md[1][1]=32;
		md[1][2]="sachivalayam emp";
		
		md[2][0]="sai";
		md[2][1]= 26;
		md[2][2]="software employe";
		
		return md;
	}

}
