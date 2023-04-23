package bibliotheque;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

	final static String DRIVER = "org.postgresql.Driver";
	final static String URL = "jdbc:postgresql://localhost:5432/FilRougeBibliotheque";
	final static String USR = "postgres";
	final static String PWD = "admin";
	static Connection conn;

	public static Connection connexion() throws Exception {
		if (conn == null) {
			try {
				// charger la classe de driver
				Class.forName(DRIVER);

				// créer l'objet de connexion
				conn = DriverManager.getConnection(URL, USR, PWD);

			} catch (SQLException e) {
				e.printStackTrace();
				System.exit(-2); // TODO : add retries?
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}

		return conn;
	}
}
