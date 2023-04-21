package bibliotheque;

import java.util.List;

public interface EmpruntDao {
	Emprunt findById(int id);
    List<Emprunt> findAll();
    void save(Emprunt emprunt);
    void update(Emprunt emprunt);
    void delete(Emprunt emprunt);
}
