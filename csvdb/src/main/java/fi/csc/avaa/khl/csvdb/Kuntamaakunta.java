package fi.csc.avaa.khl.csvdb;

import java.io.File;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.sql.Statement;
import java.util.Hashtable;

/**
 * @author pj
 *
 */
public class Kuntamaakunta {
	static final String KANTA = "kuntainfo";
	static final String UPDATE = "UPDATE "+KANTA+" SET maakuntaid=? WHERE capitalkuntanimi=?"; 
	static Hashtable<String, Integer> htmk = new Hashtable<String, Integer>();

	public static void main(String[] args) throws Exception {
		double alkuaika = System.currentTimeMillis();

		File f = new File("/home/pj/tyo/kirjakartoitus/maakunnat/kuntamaakunta.php");
		String[][] rivit = Files.lines(f.toPath()).filter(s ->!s.isEmpty()).map(s -> s.trim()).map(s -> s.split("=>")).toArray(size -> new String[size][]);
		Connection read = PSQLyhteys.getConnection();
		Statement stmt = read.createStatement();
		ResultSet rs  = stmt.executeQuery("select maakunta, maakuntaid from maakuntainfo");
		while (rs.next()) {
			htmk.put(rs.getString(1), rs.getInt(2)); 
		}
		rs.close();
		stmt.close();
		Connection pconn = PSQLyhteys.getConnection();
		PreparedStatement psd = pconn.prepareStatement(UPDATE);
		pconn.setAutoCommit(false);
		PreparedStatement pstmt = read.prepareStatement("select maakuntaid, kuntaid from "+KANTA+ " WHERE  capitalkuntanimi=?");
		for (int i = 0; i < rivit.length; i++) {
			pstmt.setString(1, rivit[i][0]);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int maakuntaid = htmk.get(rivit[i][1]);
				if (rs.getInt(1) != maakuntaid) { 
					psd.setInt(1, maakuntaid);
					psd.setString(2, rivit[i][0]);  
					psd.executeUpdate();
					System.out.println("Päivitetty: "+rs.getInt(2));
				} //muuten kaikki täsmäsi
			} else {			
				System.out.println("Ei kannassa"+rivit[i][0]+" "+rivit[i][1]);
			}
			rs.close();
		}
		pconn.commit();
		pconn.close();	  
		double aika = System.currentTimeMillis()-alkuaika;
		System.out.println(aika/1000+" sekuntia.");

	}
}
