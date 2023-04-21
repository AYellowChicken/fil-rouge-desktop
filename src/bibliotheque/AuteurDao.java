package bibliotheque;

import java.util.List;

public interface AuteurDao {
	Auteur findById(int id);
    List<Auteur> findAll();
    void save(Auteur auteur);
    void update(Auteur auteur);
    void delete(Auteur auteur);
}
