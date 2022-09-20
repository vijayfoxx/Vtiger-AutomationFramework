package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This method will provide random number
 * @author Vijay
 *
 */
public class JavaUtility {
	public int getRandomNumber() {
		Random ran=new Random();
		int Int = ran.nextInt();
		System.out.println(Int);
		return Int;
	}
	/**
	 * This mwthod will generate the system date and return the value
	 * @return
	 */
	public String getSystemDate() {
		Date date=new Date();
		String dat = date.toString();
		return dat;
	}
	/**
	 * This method will generate the date and return the value inparticular format
	 * @return
	 */
	public String getSystemDateInFormat(){
		Date date=new Date();
		String[] dat = date.toString().split(" ");
		String DATE = dat[2];
		String month=dat[1];
		String year=dat[5];
		String time = dat[3].replace(":","-");
		String currentDateAndTime = DATE+" "+month+" "+year+" "+"  "+time;
		return currentDateAndTime;
	}
			
}
