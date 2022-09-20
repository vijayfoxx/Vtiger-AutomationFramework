package vtiger.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Driver driverRef;
	Connection con=null;
	/**
	 * This method will  establish connection with db
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException {
		driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection(ConstantsUtility.DBUrl, ConstantsUtility.DbUsername, ConstantsUtility.DBPassword);
		
	}
	/**
	 * This method will close the DB connection
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		con.close();
	}
public String executeTheQueryAndVerifyTheData(String query,int colIndex,String expData) throws SQLException {
	boolean flag=false;
	ResultSet result = con.createStatement().executeQuery(query);
	while(result.next()) {
		String actData = result.getString(colIndex);
		if(actData.equals(expData)) {
			flag=true; //flag rising event
			break;
		}
	}
	if(flag) {
		System.out.println("Data present "+expData);
		return expData;
	}
	else {
		System.out.println("Data not present");
	}
	return " ";
}
}
