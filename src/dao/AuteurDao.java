package dao;

import java.util.HashMap;
import java.util.List;

import model.Auteur;

public interface AuteurDao {

	List<Auteur> findByName(String name) throws Exception;

	void findAll();

	List<Auteur> consulte(HashMap<String, String> criteres) ;

	void save();

	void update(Auteur auteur);

	void delete();
}
