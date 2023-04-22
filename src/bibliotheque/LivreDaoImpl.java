package bibliotheque;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class LivreDaoImpl implements LivreDao {

	@Override
	public Livre findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void findAll() throws Exception {

		Connection conn = Connexion.connexion();

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM livre");

		while (rs.next()) {
			System.out.printf("ISBN:%d,\nTitre:%s,\nNuméroAuteur:%d, \nEditeur:%s, \nNmbrePages:%d\n\n", rs.getInt(1), rs.getString(2),
					rs.getInt(3), rs.getString(4), rs.getInt(5));
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
