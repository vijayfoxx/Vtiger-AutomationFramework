package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
public String readDataFromPropertyFile(String key) throws IOException{
	FileInputStream file=new FileInputStream(ConstantsUtility.PropFilePath);
	Properties prop=new Properties();
	prop.load(file);
	String property = prop.getProperty(key);
	return property;
}
}
