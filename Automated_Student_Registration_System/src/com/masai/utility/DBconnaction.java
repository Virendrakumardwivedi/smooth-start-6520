/**
 * 
 */
package com.masai.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnaction {

	  public DBconnaction() {
	    }

	    public static Connection connect() {
	        Connection conn = null;

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
	        }

	        String url = "jdbc:mysql://localhost:3306/ mini_studentapp";

	        try {
	            conn = DriverManager.getConnection(url, "root", "sqlmotovicky");
	        } catch (SQLException se) {
	            se.printStackTrace();
	        }

	        return conn;
	    }

		
	

}
