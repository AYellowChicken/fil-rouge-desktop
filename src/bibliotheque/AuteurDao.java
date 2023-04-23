package bibliotheque;

import java.util.HashMap;
import java.util.List;

public interface AuteurDao {

	List<Auteur> findByName(String name) throws Exception;

	void findAll();

	List<Auteur> consulte(HashMap<String, String> criteres) ;

	void save(Auteur auteur);

	void update(Auteur auteur);

	void delete(Auteur auteur);
}
