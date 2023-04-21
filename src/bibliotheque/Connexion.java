package bibliotheque;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connexion {

	public static void connexion() throws Exception {
		try {
			// étape 1: charger la classe de driver

			Class.forName("org.postgresql.Driver");
			// étape 2: créer l'objet de connexion

			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/FilRougeBibliotheque", "postgres", "admin");
			// étape 3: créer l'objet statement

			Statement stmt = conn.createStatement();
			// étape 4: exécuter la requête

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deconnexion(Connection conn) throws Exception {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
