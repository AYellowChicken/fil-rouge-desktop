package bibliotheque;

import java.util.HashMap;
import java.util.List;

public interface AbonneDao {
	Abonne findById(int id);

	List<Abonne> findAll();

	List<Abonne> consulte(HashMap<String, String> criteres) ;

	void save(Abonne abonne);

	void update(Abonne abonne);

	void delete(Abonne abonne);
}
