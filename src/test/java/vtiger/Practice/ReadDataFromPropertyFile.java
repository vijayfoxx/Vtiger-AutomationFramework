package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		//1.load file into fileinputstream
		FileInputStream file=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		//2.create properties object from java
		Properties prop=new Properties();
		//3.load the file into property obj
		prop.load(file);
        //4.read the dada thru key
		String property = prop.getProperty("Browser");
		System.out.println(property);
	}

}
