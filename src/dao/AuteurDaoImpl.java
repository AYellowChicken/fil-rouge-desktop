package dao;

import java.sql.Connection;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Auteur;
import model.Connexion;

import java.util.Iterator;

public class AuteurDaoImpl implements AuteurDao {

	@Override
	public List<Auteur> findByName(String name) throws Exception {
		Connection conn = Connexion.connexion();

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("SELECT nomAu,  FROM auteur WHERE nomAu=" + name);

		rs.next();

		if (rs.getInt(1) != 1) {
			System.out.println("Vous n'existez pas");
			System.exit(0);
		} else {
			System.out.println("Bonjour");
		}

		return null;
	}

/**
 * This Java function executes a SQL query to retrieve a list of authors based on given criteria, with
 * a maximum of 3 retries in case of failure.
 * 
 * @param criteres A HashMap containing search criteria for querying the database table "auteur". The
 * keys of the HashMap represent the column names of the table, and the values represent the search
 * terms to be matched. The method builds an SQL query based on these criteria and returns a list of
 * Auteur objects that match the search
 * @return The method is returning a list of Auteur objects that match the given criteria.
 */
	@Override
	public List<Auteur> consulte(HashMap<String, String> criteres) {
		Connection conn = Connexion.connexion();
		
		// Build SQL query
		String sqlRequest = "SELECT numauteur, nomau, prenomau, nationaliteau FROM auteur";
		if (!criteres.isEmpty()) {
			sqlRequest += " WHERE ";

			Iterator<Map.Entry<String, String>> iterator = criteres.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, String> entry = iterator.next();
				if (entry.getKey().equals("numauteur")){ 
					sqlRequest += entry.getKey() + " = " + entry.getValue();
				} else {
					sqlRequest += "LOWER(" + entry.getKey() + ") LIKE LOWER('" + entry.getValue() + "')";
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
		List<Auteur> listAuteur = new ArrayList<Auteur>();
		while(!success && retries < maxRetries) {
			try {
				PreparedStatement ps = conn.prepareStatement(sqlRequest);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					int numauteur = rs.getInt("numauteur");
					String nomau = rs.getString("nomau");
					String prenomau = rs.getString("prenomau");
					String nationaliteau = rs.getString("nationaliteau");

					Auteur auteur = new Auteur(numauteur, nomau, prenomau, nationaliteau);
					listAuteur.add(auteur);
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

		return listAuteur;
	}


	@Override
	public void findAll() {
		// TODO Auto-generated method stub
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		Connection conn = Connexion.connexion();
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez N° auteur: ");
		int numAuteur = sc.nextInt();
		System.out.println("Entrez Nom auteur: ");
		String nomAuteur = sc.next();
		System.out.println("Entrez Prénom auteur: ");
		String prenomAuteur = sc.next();
		System.out.println("Entrez Nationalité auteur: ");
		String nationaliteAuteur = sc.next();
	
			String sqlRequest = "INSERT INTO auteur VALUES("+numAuteur+",'"+ nomAuteur+"','" +prenomAuteur + "','" +nationaliteAuteur+"')" ;
			try {
				PreparedStatement st = conn.prepareStatement(sqlRequest);
				ResultSet result = st.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		Connection conn = Connexion.connexion();
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez N° auteur: ");
		int numAuteur = sc.nextInt();
		System.out.println("Modifier Nom auteur: ");
		String nomAuteur = sc.next();
		System.out.println("Modifier Prénom auteur: ");
		String prenomAuteur = sc.next();
		System.out.println("Modifier Nationalité auteur: ");
		String nationaliteAuteur = sc.next();
		try {
			
			
			PreparedStatement pstmt = conn.prepareStatement("UPDATE auteur SET nomau = ?, prenomau = ?, nationaliteau =?  WHERE numauteur = ?");
			
			pstmt.setString(1, nomAuteur);
			pstmt.setString(2, prenomAuteur);
			pstmt.setString(3, nationaliteAuteur);
			
			pstmt.setInt(4, numAuteur); // Update the record with id = numAuteur
			
			int rowsUpdated = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete() {
		Connection conn = Connexion.connexion();
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez le N° de l'auteur à supprimer");
		int numAuteur = sc.nextInt();
		
		//String sqlRequest = "DELETE FROM auteur WHERE numauteur = "+ numAuteur;
		try {
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM auteur WHERE numauteur = ?");
			pstmt.setInt(1, numAuteur);
			int rowsDeleted = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public void update(Auteur auteur) {
		// TODO Auto-generated method stub
		
	}
}
