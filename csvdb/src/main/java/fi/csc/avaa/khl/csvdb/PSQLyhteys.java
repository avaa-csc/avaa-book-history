/**
 * 
 */
package fi.csc.avaa.khl.csvdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @author pj
 *
 */
public class PSQLyhteys {
	
	  static Connection getConnection()
              throws SQLException ,ClassNotFoundException {
Class.forName("org.postgresql.Driver");
String string = "jdbc:postgresql:vk";
String user = "pj";
String passwd = "tämäeioleoikea";
Connection connection = DriverManager.getConnection(string, user, passwd);
return connection;

  }

}
