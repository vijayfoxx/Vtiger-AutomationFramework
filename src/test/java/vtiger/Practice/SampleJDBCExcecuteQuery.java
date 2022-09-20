package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;import com.mysql.cj.protocol.x.ResultCreatingResultListener;

public class SampleJDBCExcecuteQuery {
	public static void main(String[] args) throws SQLException {
	Driver driverref=new Driver();
	DriverManager.registerDriver(driverref);
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
	Statement State = con.createStatement();
	ResultSet result = State.executeQuery("select * from customerinfo");
	while(result.next()) {
		System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
	}
	con.close();
	}
}
