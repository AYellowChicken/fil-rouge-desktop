package bibliotheque;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.Statement; 
import java.sql.ResultSet; 


public class TestConnexion {
	public static void main(String args[]) { 
		try { 
			// étape 1: charger la classe de driver 
			
			Class.forName("org.postgresql.Driver"); 
			// étape 2: créer l'objet de connexion 
			
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/FilRougeBibliotheque", "postgres", "admin"); 
			// étape 3: créer l'objet statement 
			
			Statement stmt = conn.createStatement(); 
			// étape 4: exécuter la requête 
			
			ResultSet res = stmt.executeQuery("SELECT * FROM abonne"); 
			while (res.next()) System.out.println(res.getInt(1) + " " + res.getString(2) + " " + res.getString(3) + " " + res.getString(4) + " " + res.getString(5)); 
			
			// étape 5: fermez l'objet de connexion 
			
			conn.close(); } catch (Exception e) { System.out.println(e); } 
		} 
	}
		


 