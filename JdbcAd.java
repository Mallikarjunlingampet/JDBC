package Jdbcjavasql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class JdbcAd {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
	
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection=null;
		String url="jdbc:mysql://localhost:3306/mallik";
		String username="root";
		String password="1234";
		connection=DriverManager.getConnection(url, username, password);
		Statement statement=connection.createStatement();
		String selectQuery="select * from student";
		ResultSet resultset=statement.executeQuery(selectQuery);
		while(resultset.next())
		{
			String name=resultset.getString("name");
			String branch=resultset.getString("branch");
			int rollno=resultset.getInt("rollno");
			System.out.println(rollno + "\t" +name + "\t" + branch);
		}
		resultset.close();
		statement.close();
		connection.close();

	}

}
