package com.empmanagment;

import java.sql.*;

public class DBConnection {
	static String classname="com.mysql.cj.jdbc.Driver";
    static String url="jdbc:mysql://localhost:3306/employeedb";
	static String user="root";
	static String pw="admin";
	static Connection con ;
	
	public static Connection createDBConnection()
	{
		
		try
		{
			//load Driver Class
			Class.forName(classname);
		    con=DriverManager.getConnection(url,user,pw);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		return con;
	}

}
