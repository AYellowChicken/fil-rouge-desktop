package bibliotheque;

import java.util.List;

public interface AuteurDao {
	
	Auteur findByName(String name) throws Exception;
	
    void findAll();
    void save(Auteur auteur);
    void update(Auteur auteur);
    void delete(Auteur auteur);
}
