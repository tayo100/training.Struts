/**
 * 
 */
package org.iita.trainingunit.chartUtil;

/**
 * @author ken
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
//import java.util.ResourceBundle;
import java.io.InputStream;

public class DataAccessObject 
{
	private static Properties configProp = new Properties();
	//InputStream in = this.getClass().getResourceAsStream("/net/viralpatel/resources/config.properties");
	InputStream in = this.getClass().getClassLoader().getResourceAsStream("org/iita/trainingunit/resources/dataconfig.properties");
	//static ResourceBundle rBundle = ResourceBundle.getBundle("/WEB-INF/classes/application.properties");
	public DataAccessObject(){
		//Properties properties = new Properties();
		//properties.load(ServletContext.getResourceAsStream("/WEB-INF/foo.properties"));
		//rBundle.getString("database.url");
		System.out.println("KENNETH TEST LINE: " + configProp.getProperty("database.driver"));
	}
	
	private static Connection dbConnection = null;
	private static final String dbDriver = "com.mysql.jdbc.Driver";//configProp.getProperty("database.driver");//
	//private static final String dbUrl = "jdbc:mysql://localhost/training?useUnicode=true&amp;connectionCollation=utf8_general_ci&amp;characterSetResults=utf8&amp;characterEncoding=utf8";
	private static final String dbUrl = "jdbc:mysql://mysql1.iita.cgiarad.org/training?useUnicode=true&amp;connectionCollation=utf8_general_ci&amp;characterSetResults=utf8&amp;characterEncoding=utf8";
	
	private static final String dbUser = "root";
	//configProp.getProperty("database.username");//
	private static final String dbPassword = "mysql";
	//configProp.getProperty("database.password");//
	
	public static Connection getConnection() {
		if (dbConnection != null)
			return dbConnection;
		else {
			try 
			{
				Class.forName(dbDriver);
			}
			catch (ClassNotFoundException e) 
			{
				System.out
						.println("Add MySQL JDBC Driver in classpath ");
				e.printStackTrace();
			}

			try 
			{
			dbConnection = DriverManager.getConnection(dbUrl, dbUser,dbPassword);
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}

			if (dbConnection == null) 
			{
				System.out.println("Failed to make connection!");
			}
		}
		return dbConnection;
	}
}