package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/FitnessTracker";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
	
    public static Connection getConnection()throws SQLException{
    	return DriverManager.getConnection(URL,USER,PASSWORD);
    }
//    if(getConnection!=null) {
//    	System.out.println("Connected");
//    }
}
