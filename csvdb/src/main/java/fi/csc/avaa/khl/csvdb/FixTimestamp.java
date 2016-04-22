/**
 * 
 */
package fi.csc.avaa.khl.csvdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 * Korjaa tietokannan timestamp virheen kertomalla 1000 (unohtui javan millisekunnit)
 * 
 * @author pj
 *
 */
public class FixTimestamp {

	static final String QUERY = "SELECT vkid, paivays FROM vanhatkirjat WHERE paivays IS NOT NULL";
	static final String UPDATE = "UPDATE vanhatkirjat SET paivays=? WHERE vkid=?";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {		

			Connection read = PSQLyhteys.getConnection();
			Connection write = PSQLyhteys.getConnection();
			write.setAutoCommit(false);
	        PreparedStatement psd =write.prepareStatement(UPDATE);
	        Statement qstmt = read.createStatement();
            ResultSet rs =  qstmt.executeQuery(QUERY);
            while (rs.next()) {
            	psd.setTimestamp(1, new Timestamp(rs.getTimestamp(2).getTime()*1000-10800000)); //3h=10800000 oikaisu
            	psd.setInt(2, rs.getInt(1));
            	if (1 != psd.executeUpdate()) {
            		System.err.println("psd.execute epäonnsitui: "+psd.getWarnings().getMessage());
            	}
            }
			write.commit();
			write.close();
		}	catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}  catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
