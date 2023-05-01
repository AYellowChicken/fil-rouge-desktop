package dao;

import java.util.HashMap;
import java.util.List;

import model.Livre;

public interface LivreDao {
	void findAll() throws Exception;

	List<Livre> consulte(HashMap<String, String> criteres);
	
	void save();

	void update();

	void delete();

	List<Livre> findByAuthorName(String authorName) throws Exception;

	List<Livre> findByTitle(String title) throws Exception;

	List<Livre> findByIsbn(int isbn) throws Exception;


}
