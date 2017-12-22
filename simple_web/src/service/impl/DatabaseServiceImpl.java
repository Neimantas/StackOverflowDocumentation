package service.impl;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import models.java_models.Topic;
import service.IDatabaseService;
import service.IFileService;

public class DatabaseServiceImpl implements IDatabaseService {
	
	
	
	public Connection connection() {
		// TODO Auto-generated method stub
		 Connection conn = null;
	        try {
	            // db parameters
	            String url = "jdbc:sqlite:C:\\sqlite\\sqliteTest.db";
	            
	            // create a connection to the database
	            conn = DriverManager.getConnection(url);
	            
	            System.out.println("Connection to SQLite has been established.");
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } 
//	        finally {
//	            try {
//	                if (conn != null) {
//	                    conn.close();
//	                }
//	            } catch (SQLException ex) {
//	                System.out.println(ex.getMessage());
//	            }
//	        }
	        return conn;
	}
	
	public <T> void dataToSqlite(List<T> list) throws Exception {
		Connection connection = connection();
		Statement statement = connection.createStatement();
		String table = list.get(0).getClass().getSimpleName();
		//String tempfields = "";
		String tempvalues = "";
		for(int i=0; i<list.size(); i++) {
			Field[] propfields = list.get(i).getClass().getDeclaredFields();
				for(int j=0; j< propfields.length; j++) {    
					propfields[j].setAccessible(true);
					Object c = (Object) list.get(i);
					  try {
						Object value = propfields[j].get(list.get(i));
						if(value == null || value.toString().isEmpty()) {
							tempvalues += "NULL,";
						}
						else if(value instanceof String && !value.toString().isEmpty() 
								|| value instanceof Date)tempvalues += "'" + value.toString().replace("'","\"") + "',";
						
						else tempvalues += value + ", ";
						
						
					} catch (IllegalArgumentException | IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	


				}
				  System.out.println(i);
					tempvalues = tempvalues.substring(0, tempvalues.length()-1);
					System.out.println(tempvalues);
					statement.execute("insert into "+table.toLowerCase()+" VALUES (" 
							+ tempvalues + ");");
					tempvalues = "";
		}
		
		
		if(connection != null) {
			connection.close();
		}
	
	}

}
