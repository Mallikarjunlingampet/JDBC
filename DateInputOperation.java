package Jdbcjavasql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class DateInputOperation {

	public static void main(String[] args) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		String url="jdbc:mysql://localhost:3306/mallik";
		String username="root";
		String password="1234";
		Scanner sc= new Scanner(System.in);
		System.out.print("Please enter name  :: ");
		String sname=sc.next();
		System.out.println("Please enter addr :: ");
		String saddress=sc.next();
		System.out.println("please enter gender:: ");
		String sgender=sc.next();
		System.out.println("please enter Dob   :: ");
		String sdob=sc.next();
		System.out.println("please enter doj   :: ");
		String sdoj=sc.next();
		System.out.println("please enter dom  :: ");
		String sdom=sc.next();
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat sdf1= new SimpleDateFormat("MM-dd-yyyy");
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date Ddob=sdf.parse(sdob);
		java.util.Date Ddoj=sdf1.parse(sdoj);
		java.util.Date Ddom=sdf2.parse(sdom);
		
		long t=Ddob.getTime();
		long t1=Ddoj.getTime();
		long t2=Ddom.getTime();
		
		java.sql.Date d=new Date(t);
		java.sql.Date d1= new Date(t1);
		java.sql.Date d2= new Date(t2);
		
		Connection connection=null;
		PreparedStatement psmt=null;
		PreparedStatement psmt1=null;
		ResultSet resultset=null;
		String insertQuery="insert into employe(name,address,gender,dob,doj,dom) values(?,?,?,?,?,?)";
		String SelectQuey="select * from employe where name=?";
		try {
			connection=DriverManager.getConnection(url, username, password);
			if(connection!=null) {
				psmt=connection.prepareStatement(insertQuery);
				psmt1=connection.prepareStatement(SelectQuey);
				if(psmt!=null)
				{
					psmt.setString(1, sname);
					psmt.setString(2, saddress);
					psmt.setString(3, sgender);
					psmt.setDate(4, d);
					psmt.setDate(5, d1);
					psmt.setDate(6, d2);
					int result=psmt.executeUpdate();
					System.out.println("No of rows affected " + result);
				}
				if(psmt1!=null)
				{
					psmt1.setString(1, sname);
					resultset=psmt1.executeQuery();
					
				}
				if(resultset!=null)
				{
					while(resultset.next()) {
					String Empname=resultset.getString(1);
					String Empaddres=resultset.getString(2);
					String Empgender=resultset.getString(3);
					java.sql.Date Q=resultset.getDate(4);
					java.sql.Date w=resultset.getDate(5);
					java.sql.Date e= resultset.getDate(6);
					SimpleDateFormat v=new SimpleDateFormat("dd-MM-yyy");
					SimpleDateFormat v1= new SimpleDateFormat("MM-dd-yyyy");
					SimpleDateFormat v2= new SimpleDateFormat("yyyy-MM-dd");
					String EmpD= v.format(Q);
					String EmpD1=v1.format(w);
					String EmpD2=v2.format(e);
					
					System.out.println(Empname + "\t" + Empaddres + "\t" + Empgender + "\t" + EmpD + "\t" + EmpD1 + "\t" + EmpD2);
					}
					
					
				}
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			if(psmt!=null)
			{
				psmt.close();
			}
			if(resultset!=null)
			{
				resultset.close();
			}
			if(connection!=null)
			{
				connection.close();
			}
		}
		
		

	}

}
