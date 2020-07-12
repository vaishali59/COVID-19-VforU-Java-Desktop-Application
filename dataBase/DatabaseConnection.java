package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private Connection conn;
	private static DatabaseConnection singletonDB = new DatabaseConnection();

	


	private DatabaseConnection() {
		this.conn = createConnection();
	}
	
	public static DatabaseConnection getInstance() {
		
		return singletonDB;
	}
	
	public Connection getConnection() {
		return this.conn;
	}

	
	private static Connection createConnection() {
		try 
        { 
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
        } 
		catch (ClassNotFoundException cnfe) {
			// TODO: handle exception
			System.out.println("Error loading driver: "+cnfe);
		}
		String host = "localhost";
		String dbName = "XE";
		int port = 1521;
		String oracleURL = "jdbc:oracle:thin:@" + host + ":" + port + ":" + dbName;
		String username = "system"; 
		String password = "oracle";
		Connection connection=null;
		try {
			connection = DriverManager.getConnection(oracleURL, username, password);
			System.out.println("Connected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQLException:"+e.getMessage()+"   No Connection");
		}
		return connection;
	}
	
	public void closeConnection(Connection connection) {
		try {
			connection.close();
			System.out.println("Closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

}