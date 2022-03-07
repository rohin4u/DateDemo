package com;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;


public class Test2 {

	public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException {
		
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="system";
		String pwd="password";
		Class.forName(driver);
		
		
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		
		PreparedStatement statement = con.prepareStatement("select * from users");
		
		ResultSet rSet = statement.executeQuery();
		
		
		
		while(rSet.next()) {
			
			System.out.println("Name : "+rSet.getString(1));
			
			Date date = rSet.getDate(2);
			System.out.println(date);
			
			
		}
		
		con.close();
		

	}

}
