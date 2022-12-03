package jdbcadvance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

public class Advancejdbc {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//1 Load and register the driver
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//2 Establish Connection
		String url="jdbc:mysql://localhost:3306/mallik?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true";
		String user="root";
		String password="1234";
		
		Connection connection = DriverManager.getConnection(url, user, password);

		//3 Creation of Statement object to move to the location
		java.sql.Statement statement=  connection.createStatement();
		
		//4 Using statement Object execute the Query
		String sqlSelectQuery="select rollno,name,branch from student";
		ResultSet resultset=statement.executeQuery(sqlSelectQuery);
		
		//5 process the resultset to get the data
		while(resultset.next()) {
			int course_id=resultset.getInt("rollno");
			String course_name=resultset.getString("name");
			String course_time=resultset.getString("branch");
			System.out.println(course_id +"\t" + course_name+"\t" + course_time);
			
			
		}
		
		//closing 
		resultset.close();
		statement.close();
		connection.close();
		
		
	}

}
