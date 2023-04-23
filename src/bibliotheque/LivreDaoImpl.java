package bibliotheque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
