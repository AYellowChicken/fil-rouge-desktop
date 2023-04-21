package bibliotheque;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.*;

public class Login {

	public static void main(String[] args) throws Exception {
		// demander le numéro d'abonné à l'utilisateur
		System.out.println("Veuillez renseigner votre numéro d'abonné");

		// instancier scanner
		java.util.Scanner sc = Scanner.getSc();

		// definir saisie utilisateur
		int saisie = sc.nextInt();

		// appel de la méthode connexion() de l'objet Connexion
		Connection con = Connexion.connexion();

		// création du statement
		Statement stmt = con.createStatement();

		// préparation de la requête
		ResultSet rs = stmt.executeQuery("SELECT count(numabonne) FROM abonne WHERE numabonne=" + saisie);

		rs.next();

		if (rs.getInt(1) != 1) {
			System.out.println("Vous n'existez pas");
			System.exit(0);
		} else {
			System.out.println("Bonjour");
		}
		
	}

}
