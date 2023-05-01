package dao;

import java.util.HashMap;
import java.util.List;

import model.Abonne;

public interface AbonneDao {
	Abonne findById(int id);

	List<Abonne> findAll();

	List<Abonne> consulte(HashMap<String, String> criteres) ;

	void save(Abonne abonne);

	void update(Abonne abonne);

	void delete(Abonne abonne);

	void update();

	void delete();
}
