package separatepackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class HardcodeDataProvider {
	
	

@Test(dataProvider="givedata")
public void hardcode(String orgname, String industry) {
	
	
}
	
	@DataProvider
    public Object[][] givedata() {
		
		Object[][] md=new Object[5][2];	
		   
		md[0][0]="aswin";
		md[0][2]="Banking";
		
		md[1][0]="sir";
		md[1][2]="Chemicals";
		
		md[2][0]="sai";
		md[2][2]="Communication";
		
		md[2][0]="lak";
		md[2][2]="Construction";
		
		md[2][0]="core";
		md[2][2]="Healthcare";
		
		return md;

}
}
