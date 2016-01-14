package Client.DAO;

import javax.persistence.EntityManager;
import Product.Value;

public class ValueDAOImpl extends GenericDaoHibImpl<Value> implements ValueDAO {
	
	public ValueDAOImpl(EntityManager entityManager ) { 
		super(entityManager);
	}
}
