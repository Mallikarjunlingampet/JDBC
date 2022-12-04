package Jdbcjavasql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class DateOperation {

	public static void main(String[] args) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		String url="jdbc:mysql://localhost:3306/Mallik";
		String username="root";
		String password="1234";
		Connection connection=null;
		PreparedStatement psmt=null;
		Scanner sc= new Scanner(System.in);
		System.out.print("please enter name ::");
		String sname=sc.next();
		System.out.println("please enter DOB ::");
		String sdob=sc.next();
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date udate=sdf.parse(sdob);
		long t= udate.getTime();
		java.sql.Date sqldate=new java.sql.Date(t);
		System.out.println(sqldate);
		String insertQuery="insert into user(name,dob) values (?,?)";
		try {
			connection=DriverManager.getConnection(url, username, password);
			if(connection!=null)
			{
				
				psmt=connection.prepareStatement(insertQuery);
				if(psmt!=null) {
					psmt.setString(1, sname);
					psmt.setDate(2, sqldate);
				int result=psmt.executeUpdate();
				System.out.println("No of rows affected "+ result);
			}
		}}
		catch(SQLException se) {
			se.printStackTrace();
		}
		finally {
			if(psmt!=null) {
				psmt.close();
			}
			if(connection!=null)
				connection.close();
		}
		
		
		
		
		

	}

}
