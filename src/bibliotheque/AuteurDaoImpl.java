package bibliotheque;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class AuteurDaoImpl implements AuteurDao {

	@Override
	public List<Livre> findByName(String name) throws Exception {
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

	@Override
	public void findAll() {
		// TODO Auto-generated method stub
	}

	@Override
	public void save(Auteur auteur) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Auteur auteur) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Auteur auteur) {
		// TODO Auto-generated method stub

	}
}
