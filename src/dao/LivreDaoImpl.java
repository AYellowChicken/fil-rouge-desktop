package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import model.Connexion;
import model.Livre;

public class LivreDaoImpl implements LivreDao {

	@Override
	public List<Livre> findByAuthorName(String authorName) throws Exception {

		Connection conn = Connexion.connexion();

		PreparedStatement ps = conn.prepareStatement("SELECT ISBNLivre, titre, livre.numauteur, editeur, nbrepages FROM auteur INNER JOIN livre "
		+ "ON auteur.numauteur = livre.numauteur" + " WHERE nomau LIKE '" + authorName + "'");
		
		ResultSet rs = ps.executeQuery();

		List<Livre> ll = new ArrayList<Livre>();

		while (rs.next()) {
			int isbnLivre = rs.getInt(1);
			String titre = rs.getString(2);
			int numAuteur = rs.getInt(3);
			String editeur = rs.getString(4);
			int nmbrePages = rs.getInt(5);

			Livre livre = new Livre(isbnLivre, titre, numAuteur, editeur, nmbrePages);
			ll.add(livre);
		}

		return ll;
	}

	@Override
	public List<Livre> findByTitle(String title) throws Exception {

		Connection conn = Connexion.connexion();

		PreparedStatement ps = conn.prepareStatement("SELECT ISBNLivre, titre, livre.numauteur, editeur, nbrepages FROM auteur INNER JOIN livre "
		+ "ON auteur.numauteur = livre.numauteur" + " WHERE titre LIKE '" + title + "'");

		ResultSet rs = ps.executeQuery();

		List<Livre> ll = new ArrayList<Livre>();

		while (rs.next()) {
			int isbnLivre = rs.getInt(1);
			String titre = rs.getString(2);
			int numAuteur = rs.getInt(3);
			String editeur = rs.getString(4);
			int nmbrePages = rs.getInt(5);

			Livre livre = new Livre(numAuteur, titre, isbnLivre, editeur, nmbrePages);
			ll.add(livre);
		}

		return ll;
	}

	@Override
	public List<Livre> findByIsbn(int isbn) throws Exception {
		Connection conn = Connexion.connexion();

		PreparedStatement ps = conn.prepareStatement("SELECT ISBNLivre, titre, livre.numauteur, editeur, nbrepages FROM auteur INNER JOIN livre "
		+ "ON auteur.numauteur = livre.numauteur" + " WHERE ISBNLivre =" + isbn);

		ResultSet rs = ps.executeQuery();

		List<Livre> ll = new ArrayList<Livre>();

		while (rs.next()) {
			int isbnLivre = rs.getInt(1);
			String titre = rs.getString(2);
			int numAuteur = rs.getInt(3);
			String editeur = rs.getString(4);
			int nmbrePages = rs.getInt(5);

			Livre livre = new Livre(numAuteur, titre, isbnLivre, editeur, nmbrePages);
			ll.add(livre);
		}

		return ll;
	}

	@Override
	public void findAll() throws Exception {

		Connection conn = Connexion.connexion();

		PreparedStatement ps = conn.prepareStatement("SELECT * FROM livre");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.printf("ISBN:%d,\nTitre:%s,\nNuméroAuteur:%d, \nEditeur:%s, \nNmbrePages:%d\n\n", rs.getInt(1),
					rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
		}
	}

/**
 * This Java function executes a SQL query to retrieve a list of Livre based on given criteria, with
 * a maximum of 3 retries in case of failure.
 * 
 * @param criteres A HashMap containing search criteria for querying the database table "livre". The
 * keys of the HashMap represent the column names of the table, and the values represent the search
 * terms to be matched. The method builds an SQL query based on these criteria and returns a list of
 * Livre objects that match the search
 * @return The method is returning a list of Livre objects that match the given criteria.
 */
	@Override
	public List<Livre> consulte(HashMap<String, String> criteres) {
		Connection conn = Connexion.connexion();
		
		// Build SQL query
		String sqlRequest = "SELECT isbnlivre, titre, numauteur, editeur, nbrepages FROM livre";
		if (!criteres.isEmpty()) {
			sqlRequest += " WHERE ";

			Iterator<Map.Entry<String, String>> iterator = criteres.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, String> entry = iterator.next();
				if (entry.getKey().equals("isbnlivre") || entry.getKey().equals("numauteur") || entry.getKey().equals("nbrepages")){ 
					sqlRequest += entry.getKey() + " = " + entry.getValue();
				} else {
					sqlRequest += "LOWER(" + entry.getKey() + ") LIKE LOWER('%" + entry.getValue() + "%')";
				}

				// Check if there is a next element
				if (iterator.hasNext()) {
					sqlRequest += " AND ";
				}
			}
		}

		// Execute SQL query (maximum of 3 times)
		int maxRetries = 3;
		int retries = 0;
		boolean success = false;
		List<Livre> listLivre = new ArrayList<Livre>();
		while(!success && retries < maxRetries) {
			try {
				PreparedStatement ps = conn.prepareStatement(sqlRequest);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					int isbnLivre = rs.getInt("isbnlivre");
					String titre = rs.getString("titre");
					int numauteur = rs.getInt("numauteur");
					String editeur = rs.getString("editeur");
					int nbrepages = rs.getInt("nbrepages");

					Livre livre = new Livre(isbnLivre, titre, numauteur, editeur, nbrepages);
					listLivre.add(livre);
				}
				success = true;

			} catch (SQLException e) {
				retries++;
				if (retries == maxRetries) {
					System.err.println("Query failed after " + maxRetries + " retries");
					e.printStackTrace();
					System.exit(-1);
				} else {
					System.err.println("Query failed, retrying (" + retries + " of " + maxRetries + ")");
					try {
						Thread.sleep(1000); // Wait for 1 second before retrying
					} catch (InterruptedException ie) {
						Thread.currentThread().interrupt(); // Restore interrupted status and continue
					}
				}
			}
		}

		return listLivre;
	}


	@Override
	public void save(Livre book) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		Connection conn = Connexion.connexion();
		Scanner sc = new Scanner(System.in);
		Scanner scInt = new Scanner(System.in);
		
		System.out.println("Entrez N° isbnLivre: ");
		int isbnLivre = scInt.nextInt();
		//int isbnLivre = input.nextInt();
		System.out.println("Modifier titre Livre: ");
		//sc.useDelimiter("\n");
		String titre = sc.nextLine();
		System.out.println("Modifier nom editeur LIvre: ");
		String editeur = sc.nextLine();
		System.out.println("Modifier nbrePages LIvre: ");
		int nbrePages = scInt.nextInt();
		try {
			
			
			PreparedStatement pstmt = conn.prepareStatement("UPDATE livre SET titre = ?, editeur = ?, nbrePages =?  WHERE isbnLivre = ?");
			
			pstmt.setString(1, titre);
			pstmt.setString(2, editeur);
			pstmt.setInt(3, nbrePages);
			
			pstmt.setInt(4, isbnLivre); // Update the record with id = numAuteur
			
			int rowsUpdated = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public void delete() {
		
		// TODO Auto-generated method stub
		Connection conn = Connexion.connexion();

		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez le N° de isbnlivre à supprimer");
		int isbnLivre = sc.nextInt();
		
		//String sqlRequest = "DELETE FROM livre WHERE numabonne = "+ isbnLivre;
		try {
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM livre WHERE isbnlivre = ?");
			pstmt.setInt(1, isbnLivre);
			int rowsDeleted = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update(Livre book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Livre book) {
		// TODO Auto-generated method stub
		
	}
}
