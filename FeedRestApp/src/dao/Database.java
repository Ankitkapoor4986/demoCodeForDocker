package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	public Connection Get_Connection() throws Exception
	{
		try
		{
		String connectionURL = "jdbc:database:thin:@localhost:1521:xe";
		Connection connection = null;
		Class.forName("oracle.jdbc.OracleDriver").newInstance();
		connection = DriverManager.getConnection(connectionURL, "WORKINGBRAIN_", "WORKINGBRAIN_");
	    return connection;
		}
		catch (SQLException e)
		{
			System.out.println(e);
		throw e;	
		}
		catch (Exception e)
		{
			System.out.println(e);
		throw e;	
		}
	}

}
