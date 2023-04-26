/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dc.bot.dcbot.util;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author vako
 */
public class JDBCUtils {
	
	private static BasicDataSource datasource = new BasicDataSource();
	
	//initialize static variables, executed when class is loaded into memory
	static {
		
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		//setTimeZone fix
		datasource.setUrl("jdbc:mysql://localhost:3306/eazybank");
		
		//username into database
		datasource.setUsername("root"); //username to db goes here
		
		//db pass
		datasource.setPassword("password123"); //user password goes here
		
		//max # of connections at one time
		//datasource.setMaxActive(10);
		
		//max number of connections that can remain idle
		datasource.setMaxIdle(5);
		
		//min number of connections that can remain idle
		datasource.setMinIdle(2);
		
		//size of initial connection pool
		datasource.setInitialSize(10);
		
	}
	
	//return DataSource object 
	public static BasicDataSource getDataSource() {
		return datasource;
	}

}