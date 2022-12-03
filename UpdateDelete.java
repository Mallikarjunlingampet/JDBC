package Jdbcjavasql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateDelete {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driver= new Driver();
		
		DriverManager.registerDriver(driver);
		Connection connection=null;
		Statement statement=null;
		ResultSet resultset=null;
		String url="jdbc:mysql://localhost:3306/Mallik";
		String username="root";
		String password="1234";
		try {
			connection=DriverManager.getConnection(url, username, password);
			if(connection!=null)
			{
				statement=connection.createStatement();
				if(statement!=null) 
				{
					String UpdateQuery="update student set name='krishna' where rollno=2";
					String DeleteQuery="Delete from student where rollno=4";
					String SelectQuery="select * from student";
				int result=statement.executeUpdate(UpdateQuery);
				int result2=statement.executeUpdate(DeleteQuery);
				resultset=statement.executeQuery(SelectQuery);
				System.out.println("no of row Executed " + result);
				System.out.println("no of rows Executed " + result2);
				while(resultset.next()) {
					String name=resultset.getString("name");
					String branch=resultset.getString("branch");
					String rollno=resultset.getString("rollno");
					System.out.println(rollno+"\t"+name+"\t"+ branch);
				}
				
				}
				
				
			}
			
		}catch(SQLException se) { se.printStackTrace();}
		catch(Exception e) { e.printStackTrace();}
		finally{
			if(resultset!=null)
				resultset.close();
			if(statement!=null)
			statement.close();
			if(connection!=null)
				connection.close();
		}
		
		

	}

}
