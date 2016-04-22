/**
 * 
 */
package fi.csc.avaa.khl.csvdb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Hashtable;

/**
 * @author pj
 *
 */
public class ReadCSV {
	
    static final String KANTA = "vanhatkirjat";
    static final String INSERT = "INSERT INTO "+KANTA+" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?,"+
                    " ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?)";

	private static final char SEPARATOR = ';';
	private static final int beginLine = 1;
	private static final char quoteChar = '"';
	private static final int KUNTANUM = 0;
	private static final int KUNTANIMI = 1;
	private static final int LOMAKENUM = 2;
	private static final int PÄIVÄYS  = 3;
	private static final int KARTKOHDE = 4;
	private static final int TEKIJÄ = 5;
	private static final int TEOKNIMI = 6;
	private static final int PAINOVUOSI = 7;
	private static final int PAINOPAIKKA = 8;
	private static final int KIRJAPAINO = 9;
	private static final int PAINOSMERK = 10;
	private static final int KIELI = 11;
	private static final int KIELESTÄ = 12;
	private static final int IMPRIMATUR = 13;
	private static final int KUVITUS = 14;
	private static final int KARTAT = 15;
	private static final int LIITTEITÄ = 16;
	private static final int JULKLAJI = 17;
	private static final int SIDONTA = 18;
	private static final int KUNTO = 19;
	private static final int PUUTTEET = 20;
	private static final int NIMIKIRJ = 21;
	private static final int SINETTI = 22;
	private static final int LEIMA = 23;
	private static final int EXLIBRIS  = 24;
	private static final int HINTAMERK = 25;
	private static final int OMISTE = 26;
	private static final int REUNAMERK = 27;
	private static final int TEOSPK = 28;
	private static final int LISÄTIETO = 29;
	private static final int YKSKIRJASTO = 30;
	private static final int LÄHOSOITE = 31;
	private static final int LÄHEMAIL = 32;
	  static final int TYHJÄ = 999;

    static Hashtable<String, Integer> htm = new Hashtable<String, Integer>();
    static Hashtable<String, Integer> htk = new Hashtable<String, Integer>();
    static Hashtable<String, Integer> htkm = new Hashtable<String, Integer>();
    static Hashtable<String, Integer> htkieli = new Hashtable<String, Integer>();
    static Hashtable<String, Integer> htkielesta = new Hashtable<String, Integer>();
    static Hashtable<String, Integer> htkohde = new Hashtable<String, Integer>();
    static Hashtable<String, Integer> puute = new Hashtable<String, Integer>();
    static Hashtable<String, Integer> kunto = new Hashtable<String, Integer>();
    static Hashtable<String, Integer> sidonta = new Hashtable<String, Integer>();
    static Hashtable<String, Integer> teospk = new Hashtable<String, Integer>();
    static Hashtable<String, Integer> julkaisulaji = new Hashtable<String, Integer>();
    static int[] amaakunta = new int[449]; //kuntien lkm + 1: 0 will not used
    static int[] akunta = new int[449];  //kuntanumeroille
    static Connection read; 
	
	public static void main( String[] args ) throws UnknownHostException {
        double alkuaika = System.currentTimeMillis();
        for (int i = 0 ; i < amaakunta.length ; i++) {
                amaakunta[i] = TYHJÄ;
                akunta[i] = TYHJÄ;
        }
        /*htkm.put(88, 16); //088 (Heinola) (ennen kuntaliitosta 1997)
        htkm.put(190, 6); //HÄMEENLINNA
        htkm.put(173,2); //Joutseno ->  lappeenranta
        htkm.put(175,3); //Jurva -> Kurikka -> Etelä-pohjanmaa (Kiitos Aleksi)
        htkm.put(180, 8); //YVÄSKYLÄN MLK 
        htkm.put(219, 19); //KARINAINEN -> Pöytyä  -> varsinaissuomi ( Kiitos wikipedia!)
        htkm.put(220, 18); //KARJAA -> Raasepori > uusimaa
        htkm.put(222, 18); //karjalohja
        htkm.put(228, 12); //KRUUNUPYY  toinen kuntano 288!!!
        htkm.put(243, 19);   //KEMIÖ
        htkm.put(247, 14);   //KESTILÄ
        htkm.put(246, 4);//KERIMÄKI -> Savonlinna -> Etelä-savo
        htkm.put(251, 13);  //KIIHTELYSVAARA joensuu
        htkm.put(258, 19);  //KOSKI TL toinen kuntano 284!!!
        htkm.put(259, 19);  //KISKO Salo
        htkm.put(262, 17);  //KIUKAINEN Eura        
        htkm.put(427, 18); //lohja
        htkm.put(429, 7); //lohtaja > KOKKOLA -> Keski-Pohjanamaa
        htkm.put(431, 19); //Loimaa
        htkm.put(431, 11); //LUOPIOINEN > PÄLKÄNE
        htkm.put(439, 11); //LUOPIOINEN ??
        htkm.put(479, 12); //MAKSAMAA > VÖYRI
        htkm.put(501, 19); //MUURLA
        htkm.put(531, 15); //NAKKILA
        htkm.put(534, 15); //NILSIÄ ??
        htkm.put(559, 12); //ORAVAINEN vöyri
        htkm.put(567, 14); //OULUNSALO
        htkm.put(573, 19); // PARAINEN ??
        htkm.put(594, 4); //PIEKSÄMÄKI MLK
        htkm.put(602, 19); //PIIKKIÖ -> Kaarina
        htkm.put(606, 18); //POHJA -> Raasepori > uusimaa
        htkm.put(612, 18); //Porvoo ???
        htkm.put(682, 14); ///RANTSILA SIIKALATVA
        htkm.put(696, 4); // RISTIINA > Mikkeli
        htkm.put(708, 14); ///Rukkii -> SIIKAJOKI
        htkm.put(730, 11); //SAHALAHTI -> Kangasala
        htkm.put(737, 18); //Sammatti -> lohja
        htkm.put(772, 11); //SUODENNIEMI-> Sastamala -> pirkanmaa 
        htkm.put(855, 6);  //TUULOS  HÄMEENLINNA
        htkm.put(912, 11); //Vammala -> Sastamala -> pirkanmaa 
        htkm.put(926, 14); //Vihanti -> Raahe -> Pohoispohjanmaa
        htkm.put(928, 11); //VIIALA -> AKAA
        htkm.put(944, 12); //VÖYRI ???
        htkm.put(971,3); //YLIHÄRMÄ -> Kauhava -> Etelä-pohjanmaa
        htkm.put(973, 14); //Yli-kiimonki -> Oulu */
        //Tämä on tarpeetonta, mutta olkoon dokumentoinnin vuoksi
        htkohde.put("Kirjasto", 1);
        htkohde.put("Museo", 2);
        htkohde.put("Koulu", 3);
        htkohde.put("Seurakunta", 4);
        htkohde.put("Liikelaitos", 5);
        htkohde.put("Yhdistys", 6);
        htkohde.put("Kartano", 7);
        htkohde.put("Yksityinen", 8);
        htkohde.put("Muu", 9);  
        sidonta.put("Sidottu", 2);
        sidonta.put("Nidottu", 1);
                
		CSVReader csvReader = null;		
		try {		
			read = PSQLyhteys.getConnection();
	        readtable("kuntainfo", "capitalkuntanimi", "kuntaid",  htk);
	        readtable("kuntainfo", "capitalkuntanimi", "maakuntaid", htkm);
	        readtable("maakuntainfo", "maakunta", "maakuntaid", htm);
	        readtable("kieliinfo", "kieli", "kieliid", htkieli);
	        readtable("kielesta", "kieli", "kieliid", htkielesta);
	        readtable("julklajiinfo", "julklaji", "julklajiid", julkaisulaji); 
			BufferedReader inputReader = new BufferedReader(new FileReader("/home/pj/tyo/kirjakartoitus/tuotanto/vanhatkirjat.csv"));
			csvReader = new CSVReader(inputReader, SEPARATOR, quoteChar, beginLine);
			String [] line  = null;
            Connection write = PSQLyhteys.getConnection();
            write.setAutoCommit(false);
            PreparedStatement psd =write.prepareStatement(INSERT);
            int id = 0;
			while((line = csvReader.readNext()) != null) {									
                psd.setInt(1, id++); //id
                //psd.setInt(2, rs.getInt(2));  //kuntanum
                monimutkainen(psd, line[KUNTANUM], line[KUNTANIMI]);  //kuntanimi
                //psd.setInt(3, line[4));  //maakunta
                psd.setInt(4, Integer.parseInt(line[LOMAKENUM]));  //lomak
                paivays(psd, 5, line[PÄIVÄYS]); //päiväys
                yritetään(psd, 6, line[KARTKOHDE], htkohde); //kartkohde
                psd.setString(7, line[TEKIJÄ]); //tekijä
                psd.setString(8, line[TEOKNIMI]); //teoknimi
                try {
                	String v = line[PAINOVUOSI];
                	if (null == v || v.isEmpty() || v.equals("")) {
                		psd.setNull(9, Types.INTEGER);
                	} else { //kentässä on jotain
                		String vuosi = v;
                		int kysäri = v.indexOf("?");
                		if ( kysäri > 0) {
                			vuosi = v.substring(0, kysäri);
                		}
                		psd.setInt(9, Integer.parseInt(vuosi)); //painovuosi
                	}
                } catch (java.lang.NumberFormatException e) {
                	System.out.println("Tuntematon vuosi: "+line[PAINOVUOSI]);
                	psd.setNull(9, Types.INTEGER);
                }
                psd.setString(10, line[PAINOPAIKKA]); //painopaikka
                psd.setString(11, line[KIRJAPAINO]); // kirjapaino
                tosi(psd, 12, line[PAINOSMERK]);  //painosmerk  
                tosi(psd, 13, line[IMPRIMATUR]); // imprimatur
                tosi(psd, 14, line[KUVITUS]); // kuvitus
                tosi(psd, 15, line[KARTAT]);  //kartat  
                tosi(psd, 16, line[LIITTEITÄ]);  //liitteitä
                psd.setString(17, line[NIMIKIRJ]); 
                tosi(psd, 18, line[SINETTI]);
                tosi(psd, 19, line[LEIMA]);
                tosi(psd, 20, line[EXLIBRIS]);
                tosi(psd, 21, line[HINTAMERK]);
                psd.setString(22, line[OMISTE]); 
                psd.setString(23, line[REUNAMERK]);
                psd.setString(24, line[LISÄTIETO]);      
                psd.setString(25, line[LÄHOSOITE]);
                psd.setString(26, line[LÄHEMAIL]); 
                psd.setInt(27, 1); //status
                yritetään(psd, 28, line[KIELI], htkieli ); //kieli
                yritetään(psd,29, line[KIELESTÄ], htkielesta); //kielestä   
                yritetään(psd,30, line[JULKLAJI], julkaisulaji);       
                yritetään(psd,31, line[KUNTO], kunto);
                yritetään(psd, 32, line[PUUTTEET], puute);
                yritetään(psd,33, line[TEOSPK], teospk);
                yritetään(psd,34, line[SIDONTA], sidonta);
                if ((null != line[YKSKIRJASTO]) && !line[YKSKIRJASTO].isEmpty() && !line[YKSKIRJASTO].equals("")) { 
                	psd.setString(36, line[YKSKIRJASTO]);
                	if (line[YKSKIRJASTO].equals("NILS GUSTAF MALMBERGIN KIRJASTO") )
                			psd.setInt(35, 2);
                	else if (line[YKSKIRJASTO].equals("KLEOFAS HYVÄMÄEN KIRJASTO") )
                			psd.setInt(35, 3);
                	else {
                		System.out.println("Tuntematon yksityiskirjasto: "+line[YKSKIRJASTO]);
                		psd.setNull(35, Types.INTEGER);
                		
                	}
                } else {
                	psd.setNull(35, Types.INTEGER);
                	psd.setNull(36, Types.VARCHAR);
                }	
                //psd.setInt(34, 1); 

				psd.executeUpdate();

			}
			write.commit();
			write.close();
		}	catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}  catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error reading CSV file");
		}   finally {
			if(csvReader != null) {
				try {
					csvReader.close();
				} catch (IOException e) {
					System.err.println("Unable to close CSV reader");
				}

			}
		}
			double aika = System.currentTimeMillis()-alkuaika;
			System.out.println(aika/1000+" sekuntia.");

		
	}

	/**
	 * Lulee tietokantataulun ja muuttaa sen hajautustauluksi
	 * @param taulu String tietokantataulu
	 * @param  s String hastable key
	 * @param id  String database table id, hastable value
	 * @param ht Hashtable<String, Integer> tulos
	 */
	static void readtable(String taulu, String s, String id, Hashtable<String, Integer> ht) {

		Statement pstmt;
		try {
			pstmt = read.createStatement();

			ResultSet prs  = pstmt.executeQuery("SELECT * FROM "+taulu);
			while (prs.next()) {
				ht.put(prs.getString(s), prs.getInt(id)); 
			}
			prs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Lulee tietokantataulun ja muuttaa sen hajautustauluksi
	 * @param taulu String tietokantataulu
	 * @param  s int hastable key
	 * @param id  String database table id, hastable value
	 * @param ht Hashtable<Integer, Integer> tulos
	 */
	/*static void readinttable(String taulu, String s, String id, Hashtable<Integer, Integer> ht) {

		Statement pstmt;
		try {
			pstmt = read.createStatement();

			ResultSet prs  = pstmt.executeQuery("SELECT * FROM "+taulu);
			while (prs.next()) {
				ht.put(prs.getInt(s), prs.getInt(id)); 
			}
			prs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

    static void tosi(PreparedStatement ps, int i, String s ) {
        try {
                if (null == s || s.isEmpty() || s.equals(""))   {
                        ps.setInt(i, -1);
                        return;
                }
                if (s.equals("FALSE")) {
                        ps.setInt(i, 0);
                        return;
                }
                if (s.equals("TRUE")) {
                        ps.setInt(i, 1);
                        return;
                }
        } catch (SQLException e) {
                System.out.println(i+s);
                e.printStackTrace();
                return; //!!
        }

        System.out.println("mites tänne päädyttiin?"+i+s);
}


	
    private static void yritetään(PreparedStatement ps, int sarake, String kohde, Hashtable<String, Integer> ht ) {
    	try {
    		if (null == kohde || kohde.isEmpty() || kohde.equals(""))       {
    			ps.setNull(sarake, Types.INTEGER );
    			return;
    		} else {
    			try {
    				int j = Integer.parseInt(kohde);
    				ps.setInt(sarake, j);
    				return;
    			} catch (Exception e) {
    				System.out.println("Numeron parsintavirhe: "+ kohde);
    				//ps.setNull(sarake, Types.INTEGER );
    			}
    			Integer i = ht.get(kohde); //tää ei ainakaan yleisesti onnistu
    			if (null != i) {         
    				ps.setInt(sarake, i);
    				return;
    			} else {                                

    				System.out.println("Kohde virhe: "+ kohde);
    				ps.setNull(sarake, Types.INTEGER );
    			}

    			ps.setNull(sarake, Types.INTEGER );
    		}
    	}catch (SQLException e) {
    		System.out.println("Kohde poikkeus: "+kohde);
    		e.printStackTrace();
    		return; //!!
    	}
    }

/**
 * Kopio edelisestä: eli käsittelee tyhjät merkkijonot -> kirjoittaa kantaa NULL
 * @param ps PreparedStatement 
 * @param i int
 * @param e String
 
private static void merkkijono(PreparedStatement ps, int i, String e) {
        try {
                if (null == e || e.isEmpty() || e.equals(""))   {
                        ps.setNull(i, Types.OTHER );
                } else {
                                ps.setString(i, e);
                }
        } catch (SQLException e2) {
                System.out.println("Enum Poikkeus: "+e);
                e2.printStackTrace();
                return; //!!
        }
}
*/

	
    static void paivays(PreparedStatement ps, int i, String s ) {
        try {
                if (null == s || s.isEmpty() || s.equals(""))   {
                        ps.setNull(i, Types.TIMESTAMP);
                        return;
                }               
                String[] sa = s.split("\\.");
                if (3 == sa.length) {
                        int päivä = Integer.parseInt(sa[0]);
                        int kk = Integer.parseInt(sa[1]);
                        int vuosi = Integer.parseInt(sa[2]);
                        LocalDateTime ldt = LocalDateTime.of(vuosi, kk, päivä, 0, 0);
                        ps.setTimestamp(i, new Timestamp(ldt.toEpochSecond(ZoneOffset.UTC)*1000));
                } else {
                        System.out.println(sa.length+" "+s);
                        ps.setNull(i, Types.TIMESTAMP); 
                }
        } catch (SQLException e) {
                System.out.println(i+s);
                e.printStackTrace();
        }
}
    /**
     * Kaikki tarkistetaan, luodaan kunnan ja maakunnan yhteys
     * 
     * @param psd PreparedStatement
     * @param kuntano String On siis (tämä on CSV lukija) oikeasti kunnan numero eikä ID!!!
     * @param kunta String kunnan nimi
     */
    private static void monimutkainen(PreparedStatement psd, String kuntanos, String kunta) {
    		int kuntano = Integer.parseInt(kuntanos);
            Integer maakuntaid = htkm.get(kunta);
            if ((null == maakuntaid) || 0 == maakuntaid) {
                    System.out.println("Maakunta tuntematon: "+ kuntanos+kunta);
            } else {  
                    try {            
                            psd.setInt(3,  maakuntaid);
                    } catch (SQLException e) {
                            System.out.println(kuntano+kunta+maakuntaid);
                            e.printStackTrace();
                    }
            } 
            Integer kuntaidht = htk.get(kunta);
            if (null == kuntaidht) {
                    System.out.println("Tuntematon kunta: "+ kunta);
            } else {
                    try {
                            psd.setInt(2, kuntaidht);
                    } catch (SQLException e) {
                            System.out.println(kuntano+kunta+kuntaidht);
                            e.printStackTrace();
                    }
            }
          
            // Kaikki hyvin: yhdisteään kunta ja maakunta
            if (TYHJÄ == amaakunta[kuntaidht]) {
                    amaakunta[kuntaidht] = maakuntaid;
            } else {
                    if (amaakunta[kuntaidht] != maakuntaid) {
                            System.out.println(kuntaidht+"Maakunta-kuntaliitos ongelma: "+amaakunta[kuntaidht]+" "+maakuntaid);
                    }
            }
    }

}
