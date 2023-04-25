package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import model.Connexion;
import model.Emprunt;
import model.Login;

public class EmpruntDaoImpl implements EmpruntDao {

	@Override
	public void findById(int id) {
		// TODO Auto-generated method stub
	}

	@Override
	// permet de retrouver tous les emprunts en cours de l'abonné
	public List<Emprunt> findAll() throws Exception {

		// récupérer l'id de l'abonné connecté
		int id = Login.getId();

		Connection conn = Connexion.connexion();

		PreparedStatement st = conn.prepareStatement("SELECT * FROM emprunt WHERE numabonne =" + id);

		ResultSet rs = st.executeQuery();

		List<Emprunt> le = new ArrayList<Emprunt>();

		while (rs.next()) {
			int numAbonne = rs.getInt(1);
			int IsbnLivre = rs.getInt(2);
			Date emprunteLe = rs.getDate(3);
			Date aRendreLe = rs.getDate(4);
			Date renduLe = rs.getDate(5);

			Emprunt emprunt = new Emprunt(numAbonne, IsbnLivre, emprunteLe, aRendreLe, renduLe);
			le.add(emprunt);
		}

		return le;
	}

	@Override
	public void save(Emprunt emprunt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Emprunt emprunt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Emprunt emprunt) {
		// TODO Auto-generated method stub

	}
}
