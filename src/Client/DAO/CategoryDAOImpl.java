package Client.DAO;
import ProductManagement.Category;
import javax.persistence.EntityManager;



public class CategoryDAOImpl extends GenericDaoHibImpl<Category> implements CategoryDAO {
	public CategoryDAOImpl(EntityManager entityManager ) { 
		super(entityManager);
	}
}
