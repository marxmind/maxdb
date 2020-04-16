package com.italia.marxmind;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Properties;

/**
 * 
 * @author Mark Italia
 * @since 2020/4/3
 * @version 1.0
 *
 */
public class Conf {
	
	private String CONFIG_FILE_NAME = "dbconf.max";
	private static volatile Conf conf;
	private String databaseName;
	private String databasePort;
	private String databaseUrl;
	private String databaseDriver;
	private String databaseSSL;
	private String databaseTimeZone;
	private String databaseUserName;
	private String databasePassword;
	
	private Conf() {
		System.out.println("initializing database information...");
	}
	
	public static Conf getInstance() {
		
		if(conf == null) {
			synchronized(Conf.class) {
				if(conf ==  null) {
					conf = new Conf();
					conf.readConf();//reading configuration on dbconf
				}
			}
		}
		
		return conf;
	}
	
	private void readConf() {
		try {
			//URL path = ConnectDB.class.getResource(CONFIG_FILE_NAME);
			
			File file = new File(InitDB.getInstance().getPathFileLocation());
			Properties prop = new Properties();
			prop.load(new FileInputStream(file));
			
			String u_name = SecureChar.decode(prop.getProperty("DATABASE_UNAME"));
			   u_name = u_name.replaceAll("mark", "");
			   u_name = u_name.replaceAll("rivera", "");
			   u_name = u_name.replaceAll("italia", "");
			String pword =  SecureChar.decode(prop.getProperty("DATABASE_PASSWORD"));
			   pword = pword.replaceAll("mark", "");
			   pword = pword.replaceAll("rivera", "");
			   pword = pword.replaceAll("italia", "");   
			conf.setDatabaseName(prop.getProperty("DATABASE_NAME"));
			conf.setDatabaseDriver(prop.getProperty("DATABASE_DRIVER"));
			conf.setDatabaseUrl(prop.getProperty("DATABASE_URL"));
			conf.setDatabasePort(prop.getProperty("DATABASE_PORT"));
			conf.setDatabaseSSL(prop.getProperty("DATABASE_SSL"));
			conf.setDatabaseTimeZone(prop.getProperty("DATABASE_SERVER_TIME_ZONE"));
			conf.setDatabaseUserName(u_name);
			conf.setDatabasePassword(pword);
			
		}catch(Exception e) {
			System.out.println("Configuration file was not set. To set configuration file call the class InitDB.getInstance.setPathFileLocation('your file configuration')");
		}
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getDatabasePort() {
		return databasePort;
	}

	public void setDatabasePort(String databasePort) {
		this.databasePort = databasePort;
	}

	public String getDatabaseUrl() {
		return databaseUrl;
	}

	public void setDatabaseUrl(String databaseUrl) {
		this.databaseUrl = databaseUrl;
	}

	public String getDatabaseDriver() {
		return databaseDriver;
	}

	public void setDatabaseDriver(String databaseDriver) {
		this.databaseDriver = databaseDriver;
	}

	public String getDatabaseSSL() {
		return databaseSSL;
	}

	public void setDatabaseSSL(String databaseSSL) {
		this.databaseSSL = databaseSSL;
	}

	public String getDatabaseUserName() {
		return databaseUserName;
	}

	public void setDatabaseUserName(String databaseUserName) {
		this.databaseUserName = databaseUserName;
	}

	public String getDatabasePassword() {
		return databasePassword;
	}

	public void setDatabasePassword(String databasePassword) {
		this.databasePassword = databasePassword;
	}

	public String getDatabaseTimeZone() {
		return databaseTimeZone;
	}

	public void setDatabaseTimeZone(String databaseTimeZone) {
		this.databaseTimeZone = databaseTimeZone;
	}
}
