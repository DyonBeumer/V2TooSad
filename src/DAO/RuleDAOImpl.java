package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Product.Rule;

	public class RuleDAOImpl extends GenericDaoHibImpl<Rule> implements RuleDAO {
		private EntityManager em;
		public RuleDAOImpl(EntityManager entityManager ) { 
			super(entityManager);
			this.em = entityManager;
		}

		
		@Override
		public List<Rule> findAllToBeGenerated() {
			//Query query = em.createQuerty();
			return null;
		}
		
	}
