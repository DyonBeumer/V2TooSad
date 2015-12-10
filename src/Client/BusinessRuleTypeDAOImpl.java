package Client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class BusinessRuleTypeDAOImpl implements BusinessRuleTypeDAO {
	
private EntityManagerFactory entityManagerFactory;
	
	public BusinessRuleTypeDAOImpl(EntityManagerFactory entityManagerFactory ) { 
		this.entityManagerFactory = entityManagerFactory;
	}
	
	@Override
	public void persist(Object entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Object entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Object entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public EntityManager open() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityManager openTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeTransaction() {
		// TODO Auto-generated method stub

	}

}
