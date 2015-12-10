package Client;

import java.util.*;

import javax.persistence.EntityManager;

public interface GenericDao<T> {
	void persist(T entity);
	void update(T entity);
	T findById(int id);
	void delete(T entity);
	List<T> findAll();
	void deleteAll();
	EntityManager open();
	EntityManager openTransaction();
	void close();
	void closeTransaction();
}
