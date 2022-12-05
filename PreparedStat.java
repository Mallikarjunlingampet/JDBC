package Jdbcjavasql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class PreparedStat {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		String url="jdbc:mysql://localhost:3306/mallik";
		String username="root";
		String password="1234";
		Scanner sc= new Scanner(System.in);
		System.out.println("Please enter name :: ");
		String uname=sc.next();
		System.out.println("please enter rollno :: ");
		int urollno=sc.nextInt();
		System.out.println("please enter branch ::");
		String ubranch=sc.next();
		String insertQuery="insert into student(rollno,name,branch) values(?,?,?)";
		String updateQuery="update student set name='akash' where rollno=?";
		String SelectQuery="Select * from student where rollno=?";
		Connection connection=null;
		PreparedStatement psmt=null;
		PreparedStatement psmt1=null;
		PreparedStatement psmt2=null;
		ResultSet resultset=null;
		
		try {
			connection=DriverManager.getConnection(url, username, password);
			if(connection!=null) {
				psmt= connection.prepareStatement(insertQuery);
				
				if(psmt!=null)
				{
					psmt.setInt(1, urollno);
					psmt.setString(2,uname);
					psmt.setString(3, ubranch);
					int result=psmt.executeUpdate();
					System.out.println("No of rows affected " + result);
				}
				
				psmt1=connection.prepareStatement(updateQuery);
				if(psmt1!=null)
				{
					psmt1.setInt(1, urollno);
					int result2=psmt1.executeUpdate();
					System.out.println("No of rows affected " + result2);
					
				}
				psmt2=connection.prepareStatement(SelectQuery);
				if(psmt2!=null)
				{
					psmt2.setInt(1, urollno );
					resultset=psmt2.executeQuery();
					
					if(resultset!=null)
					{
						while(resultset.next())
						{
							int qwe=resultset.getInt("rollno");
							String qwer=resultset.getString("name");
							String qwert=resultset.getString(3);
							System.out.println(qwe + "\t" + qwer + "\t" + qwert);
						}
					}
				}
				
			}
			
		}catch(SQLException se)
		{
			se.printStackTrace();
		}
		finally {
			if(resultset!=null)resultset.close();
			if(psmt!=null)psmt.close();
			if(connection!=null)connection.close();
		}
		
	}

}
