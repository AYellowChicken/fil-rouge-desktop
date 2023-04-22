package bibliotheque;

import java.util.List;

public interface AbonneDao {
	Abonne findById(int id);

	List<Abonne> findAll();

	void save(Abonne abonne);

	void update(Abonne abonne);

	void delete(Abonne abonne);
}
