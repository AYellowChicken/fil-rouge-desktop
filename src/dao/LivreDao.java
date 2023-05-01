package dao;

import java.util.HashMap;
import java.util.List;

import model.Livre;

public interface LivreDao {
	void findAll() throws Exception;

	List<Livre> consulte(HashMap<String, String> criteres);
	
	void save(Livre book);

	void update(Livre book);

	void delete(Livre book);

	List<Livre> findByAuthorName(String authorName) throws Exception;

	List<Livre> findByTitle(String title) throws Exception;

	List<Livre> findByIsbn(int isbn) throws Exception;

	void update();

	void delete();
}
