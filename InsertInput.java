package Jdbcjavasql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertInput {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement=null;
		//ResultSet resultset=null;
		String url="jdbc:mysql://localhost:3306/mallik";
		String username="root";
		String password="1234";
		Scanner sc= new Scanner(System.in);
		System.out.println("please enter roll no");
		int srollno=sc.nextInt();
		System.out.println("please enter name");
		String sname=sc.next();
		System.out.println("please enter branch");
		String sbranch=sc.next();
		connection=DriverManager.getConnection(url, username, password);
		try {
			if(connection!=null) {
			
			statement=connection.createStatement();
			if(statement!=null);
			{
				String insertQuery=String.format("insert into student(rollno,name,branch) values('%d','%s','%s')", srollno,sname,sbranch);
				int result=statement.executeUpdate(insertQuery);
				System.out.println("no of rows executed " + result);
			}
		}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		finally {
			if(statement!=null) {
				statement.close();
			}
			if(connection!=null)
			{
				connection.close();
			}
		}
		
		

	}

}
