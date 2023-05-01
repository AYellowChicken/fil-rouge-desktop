package dao;

import java.util.List;

import model.Emprunt;

public interface EmpruntDao {
	void findById(int id);

	List<Emprunt> findAll() throws Exception;

	void save(int a, int b);

	void update();

	void delete(Emprunt emprunt);
}
