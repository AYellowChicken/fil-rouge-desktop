package bibliotheque;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;

public class LivreDaoImpl implements LivreDao {

	@Override
	public List<Livre> findByAuthorName(String authorName) throws Exception {

		Connection conn = Connexion.connexion();

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery(
				"SELECT ISBNLivre, titre, livre.numauteur, editeur, nbrepages FROM auteur INNER JOIN livre "
						+ "ON auteur.numauteur = livre.numauteur" + " WHERE nomau like '" + authorName + "'");

		List<Livre> ll = new ArrayList();

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

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery(
				"SELECT ISBNLivre, titre, livre.numauteur, editeur, nbrepages FROM auteur INNER JOIN livre "
						+ "ON auteur.numauteur = livre.numauteur" + " WHERE titre like '" + title + "'");

		List<Livre> ll = new ArrayList();

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

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery(
				"SELECT ISBNLivre, titre, livre.numauteur, editeur, nbrepages FROM auteur INNER JOIN livre "
						+ "ON auteur.numauteur = livre.numauteur" + " WHERE ISBNLivre =" + isbn);

		List<Livre> ll = new ArrayList();

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

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM livre");

		while (rs.next()) {
			System.out.printf("ISBN:%d,\nTitre:%s,\nNuméroAuteur:%d, \nEditeur:%s, \nNmbrePages:%d\n\n", rs.getInt(1),
					rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
		}
	}

	@Override
	public void save(Livre book) {
		// TODO Auto-generated method stub

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
