package Jdbcjavasql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JdbcSqlJava1 {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		//Load and register
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		
		//Establish Connection
		String url="jdbc:mysql://localhost:3306/mallik?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true";
		String user="root";
		String password="1234";
		Connection connection=DriverManager.getConnection(url, user, password);
		
		//Creation of statement
		Statement statement=connection.createStatement();
		
		//execute query
		String selectQuery="Select * from student";
		ResultSet resultset=statement.executeQuery(selectQuery);
		
		while(resultset.next()) {
			int rollno=resultset.getInt("rollno");
			String name=resultset.getString("name");
			String course=resultset.getString("branch");
			System.out.println(rollno +"\t" +name +"\t" + course);
		}
		
		
		resultset.close();
		statement.close();
		connection.close();
		
		
		
		
	}

}
