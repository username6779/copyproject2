package GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyfileLibrary {

	public String readdatefrompropertyfile(String key) throws IOException {
		
		FileInputStream fis=new FileInputStream(Iconstants.propertyfilepath);
		
		Properties p=new Properties();
		p.load(fis);
		
		String value = p.getProperty(key);
		return value;
		
	}
	
	
}
