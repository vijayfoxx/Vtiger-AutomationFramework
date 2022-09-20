package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		Statement State = con.createStatement();
		String query="insert into customerinfo values('praveen','18','dvk')";
		int result=State.executeUpdate(query);
		if(result==1) {
			System.out.println("inserted");
		}
		else
		{
			System.out.println("not inserted");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		finally {
		con.close();
		System.out.println("data is closed");
	}

	}

}
