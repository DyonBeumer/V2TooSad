package Client.DAO;

import javax.persistence.EntityManager;
import ProductManagement.Operator;

public class OperatorDAOImpl extends GenericDaoHibImpl<Operator> implements OperatorDAO {
	
	public OperatorDAOImpl(EntityManager entityManager ) { 
		super(entityManager);
	}
}
