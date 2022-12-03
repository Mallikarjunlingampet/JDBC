package Jdbcjavasql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class HighlevelJdbc {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection=null;
		Statement statement=null;
		ResultSet resultset=null;
		String url="jdbc:mysql://localhost:3306/mallik";
		String username="root";
		String password="1234";
		connection=DriverManager.getConnection(url, username, password);
		
		if(connection!=null) 
		{
			statement=connection.createStatement();
			if(statement!=null) 
			{
				
			String selectQuery="insert into student(rollno,name,branch) values(9,'vamshi','EEE')";
			int result=statement.executeUpdate(selectQuery);
			System.out.println("no of excuted " + result);
			
		}
			
		}
		
		if(connection!=null)
		{
			statement=connection.createStatement();
			if(statement!=null)
			{
				String Query="select * from student";
				 resultset=statement.executeQuery(Query);
				if(resultset!=null)
				{
					while(resultset.next())
					{
						String branch=resultset.getString("branch");
						String name=resultset.getString("name");
						int rollno=resultset.getInt("rollno");
						System.out.println(rollno + "\t" + name + "\t" + branch);
					}
				}
				
			}
		}
		
		resultset.close();
		statement.close();
		connection.close();

		

	}

}
