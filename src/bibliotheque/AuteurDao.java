package bibliotheque;

import java.util.List;

public interface AuteurDao {
	
	List<Livre> findByName(String name) throws Exception;
	
    void findAll();
    void save(Auteur auteur);
    void update(Auteur auteur);
    void delete(Auteur auteur);
}
