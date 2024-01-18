package com.example.mysql_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
	     	   
	     	   //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	     	   Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","root");
	 		   System.out.println("done."+connection);
	 	} catch (SQLException e) {
	 		// TODO: handle exception
	 		e.printStackTrace();
	 	}
    }
}
