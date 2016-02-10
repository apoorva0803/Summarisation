package DAOFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.h2.tools.Server;

public class H2DAOFactory {

	Connection conn = null; 
	public static final String DRIVER = "org.h2.Driver";

	String path = H2DAOFactory.class.getProtectionDomain().getCodeSource().getLocation().getPath();

	public static final String DBURL = "jdbc:h2:~/Summarisation;AUTO_SERVER=TRUE";
	public static final String DBUSER = "nlp";
	public static final String DBPASS = "nlp";


	// method to create H2 connections
	static Server server = null;
	public static Connection createH2Connection() throws SQLException, ClassNotFoundException
	{	
		Connection conn=null;
		try {
			server = Server.createTcpServer("-tcpAllowOthers").start();
			Class.forName(DRIVER);		
			conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);				
		}
		catch (ClassNotFoundException ce) 
		{
			throw ce;
		}
		catch (SQLException se) 
		{
			throw se;
		}
		return conn;
	}
}
