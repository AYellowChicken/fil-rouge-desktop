package bibliotheque;

import java.util.List;

public interface LivreDao {
	Livre findById(int id);
    List<Livre> findAll();
    void save(Livre book);
    void update(Livre book);
    void delete(Livre book);
    
}
