package Client.DAO;

import javax.persistence.EntityManager;

import Product.Rule;

	public class RuleDAOImpl extends GenericDaoHibImpl<Rule> implements RuleDAO {
		
		public RuleDAOImpl(EntityManager entityManager ) { 
			super(entityManager);
		}
	}
