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

import model.Abonne;
import model.Connexion;

public class AbonneDaoImpl implements AbonneDao {

	@Override
	public Abonne findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Abonne> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * * This Java function executes a SQL query to retrieve a list of Abonne based
	 * on given criteria, with a maximum of 3 retries in case of failure.
	 * 
	 * @param criteres A HashMap containing search criteria for querying the
	 *                 database table "abonne". The keys of the HashMap represent
	 *                 the column names of the table, and the values represent the
	 *                 search terms to be matched. The method builds an SQL query
	 *                 based on these criteria and returns a list of Abonne objects
	 *                 that match the search
	 * @return The method is returning a list of Abonne objects that match the given
	 *         criteria.
	 */
	@Override
	public List<Abonne> consulte(HashMap<String, String> criteres) {
		Connection conn = Connexion.connexion();

		// Build SQL query
		String sqlRequest = "SELECT numabonne, nomab, prenomab, adresseab, telephoneab FROM abonne";

		if (!criteres.isEmpty()) {
			sqlRequest += " WHERE ";
			Iterator<Map.Entry<String, String>> iterator = criteres.entrySet().iterator();

			while (iterator.hasNext()) {

				Map.Entry<String, String> entry = iterator.next();

				if (entry.getKey().equals("numabonne")) {
					sqlRequest += entry.getKey() + " = " + entry.getValue();
				} else if (entry.getKey().equals("telephoneab")) {
					sqlRequest += entry.getKey() + " LIKE '%" + entry.getValue() + "%'";
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
		
		List<Abonne> listAbonne = new ArrayList<Abonne>();
		
		while (!success && retries < maxRetries) {
			try {
				PreparedStatement ps = conn.prepareStatement(sqlRequest);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					int numabonne = rs.getInt("numabonne");
					String nomab = rs.getString("nomab");
					String prenomab = rs.getString("prenomab");
					String adresseab = rs.getString("adresseab");
					String telephoneab = rs.getString("telephoneab");

					Abonne abonne = new Abonne(numabonne, nomab, prenomab, adresseab, telephoneab);
					listAbonne.add(abonne);
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

		return listAbonne;
	}

	@Override
	public void save(Abonne abonne) {
		// TODO Auto-generated method stub


	}

	@Override
	public void update(Abonne abonne) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Abonne abonne) {
		// TODO Auto-generated method stub

	}
}
