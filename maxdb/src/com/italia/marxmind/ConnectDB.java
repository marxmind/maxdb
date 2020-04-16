package com.italia.marxmind;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author mark italia
 * @since 09/27/2016
 *
 */
public class ConnectDB {
	
	public static Connection getConnection(){
		
		Connection conn = null;
		Conf conf = Conf.getInstance();
		try {	
			Class.forName(conf.getDatabaseDriver());
			String db_url = conf.getDatabaseUrl();
			String port = conf.getDatabasePort();
			String url = db_url + ":" + port + "/" +conf.getDatabaseName()+ "?"+conf.getDatabaseTimeZone()+"&" + conf.getDatabaseSSL();
			String u_name = conf.getDatabaseUserName();
			String pword =  conf.getDatabasePassword();	   
			conn = DriverManager.getConnection(url, u_name, pword);
		}catch(ClassNotFoundException e) { 
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
		return conn;
		
	}	
	
	public static void close(Connection conn){
		try{
			if(conn!=null){
				conn.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
