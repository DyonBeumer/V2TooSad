package Client.DAO;

import javax.persistence.EntityManager;
import Product.Kolom;

public class KolomDAOImpl extends GenericDaoHibImpl<Kolom> implements KolomDAO {
	
	public KolomDAOImpl(EntityManager entityManager ) { 
		super(entityManager);
	}

}
