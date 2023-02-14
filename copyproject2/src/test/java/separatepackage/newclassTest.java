package separatepackage;

import java.io.IOException;

import org.testng.annotations.Test;




public class newclassTest {
	
	@Test()
	public void newclasstest() throws IOException {
		
	
	
	String BROWSER=System.getProperty("browser");
	String USERNAME=System.getProperty("username");
	
	System.out.println(BROWSER);
	System.out.println(USERNAME);

	}

}
