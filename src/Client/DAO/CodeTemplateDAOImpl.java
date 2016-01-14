package Client.DAO;

import ProductManagement.CodeTemplate;

import javax.persistence.EntityManager;



public class CodeTemplateDAOImpl extends GenericDaoHibImpl<CodeTemplate> implements CodeTemplateDAO {
	public CodeTemplateDAOImpl(EntityManager entityManager ) { 
		super(entityManager);
	}
}
