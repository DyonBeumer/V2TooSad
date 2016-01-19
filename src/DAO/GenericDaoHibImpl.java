package DAO;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;

public abstract class GenericDaoHibImpl<T> implements GenericDao<T> {
	private EntityManager em;
	private Class<T> type;

	@SuppressWarnings("unchecked")
	public GenericDaoHibImpl(EntityManager entityManager) {
		this.em = entityManager;
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<T>) pt.getActualTypeArguments()[0];
	}

	@Override
	public void persist(T entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	@Override
	public void update(T entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}

	@Override
	public T findById(int id) {
		T entity = (T) em.find(type, id);
		return entity;
	}

	@Override
	public void delete(T entity) {
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		List<T> entities = (List<T>) em.createQuery("from "+type.getName()).getResultList();
		return entities;
	}

	@Override
	public void deleteAll() {
		List<T> entityList = findAll();
		for (T entity : entityList) {
			delete(entity);
		}
	}

}
