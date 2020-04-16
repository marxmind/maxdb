package com.italia.marxmind;

public class InitDB {
	private static volatile InitDB init;
	private InitDB() {}
	private String pathFileLocation;
	
	/**
	 * Use this class to setup database configuration file location
	 * @param pathFileLocation
	 * @return
	 */
	public static InitDB getInstance() {
		
		if(init == null) {
			synchronized(InitDB.class) {
				if(init ==  null) {
					init = new InitDB();
				}
			}
		}
		return init;
	}
	public String getPathFileLocation() {
		return pathFileLocation;
	}
	public void setPathFileLocation(String pathFileLocation) {
		this.pathFileLocation = pathFileLocation;
	}
	
}
