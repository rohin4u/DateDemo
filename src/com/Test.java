package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException {
		
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="system";
		String pwd="password";
		Class.forName(driver);
		
		
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Person Name:");
		String uname=sc.next();
		System.out.println("Enter DOP(dd-mm-yyyy):");
		String dop=sc.next();
		
		 SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
		 
		 java.util.Date udate=sdf.parse(dop);
		 
		 long l = udate.getTime();
		 
		 java.sql.Date sdate= new java.sql.Date(l);
		 String sqlQuery="insert into users values(?,?)";
		 PreparedStatement ps = con.prepareStatement(sqlQuery);
		 ps.setString(1,uname);
		 ps.setDate(2,sdate);
		 int rc =ps.executeUpdate();
		 if(rc==0)
		 System.out.println("Record Not inserted");
		 else
		 System.out.println("Record inserted");
		
		 con.close();
		

	}

}
