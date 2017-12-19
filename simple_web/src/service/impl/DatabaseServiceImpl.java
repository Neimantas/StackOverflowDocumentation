package service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import service.IDatabaseService;

public class DatabaseServiceImpl implements IDatabaseService {
	public void connection() {
		// TODO Auto-generated method stub
		 Connection conn = null;
	        try {
	            // db parameters
	            String url = "jdbc:sqlite:C:/sqlite/stackoverflow.db";
	            // create a connection to the database
	            conn = DriverManager.getConnection(url);
	            
	            System.out.println("Connection to SQLite has been established.");
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } finally {
	            try {
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException ex) {
	                System.out.println(ex.getMessage());
	            }
	        }
	}

}
