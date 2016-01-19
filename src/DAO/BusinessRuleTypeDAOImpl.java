package DAO;
import javax.persistence.EntityManager;

import ProductManagement.BusinessRuleType;

public class BusinessRuleTypeDAOImpl extends GenericDaoHibImpl<BusinessRuleType> implements BusinessRuleTypeDAO {
	public BusinessRuleTypeDAOImpl(EntityManager entityManager ) { 
		super(entityManager);
	}
}
