package bibliotheque;

import java.util.List;

public interface LivreDao {
	Livre findById(int id);
    void findAll() throws Exception;
    void save(Livre book);
    void update(Livre book);
    void delete(Livre book);
}
