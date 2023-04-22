package bibliotheque;

import java.util.List;

public interface LivreDao {
	void findAll() throws Exception;

	void save(Livre book);

	void update(Livre book);

	void delete(Livre book);

	List<Livre> findByAuthorName(String authorName) throws Exception;

	List<Livre> findByTitle(String title) throws Exception;

	List<Livre> findByIsbn(int isbn) throws Exception;
}
