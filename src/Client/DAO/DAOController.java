package Client.DAO;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import ProductManagement.*;
import Product.*;

public class DAOController {

	private static EntityManagerFactory entityManagerFactory;
	
	public static void main(String[] args) {
		
		EntityManager em = null;
		try {
			entityManagerFactory = HibernateUtil.getEntityManagerFactory();
			em = entityManagerFactory.createEntityManager();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		
		/*
		KolomDAO kdao = new KolomDAOImpl(em);
		List<Kolom> kolommen = kdao.findAll();
		for(Kolom k : kolommen){
			System.out.println(" : " + k.getkolomNaam() + " pos: "+ k.getPositie());
		}
		*/
		/*
		ValueDAO vdao = new ValueDAOImpl(em);
		List<Value> values = vdao.findAll();
		for(Value v : values){
			System.out.println("value : " + v.getValueID() + v.getValueWaarde() + v.getPositie());
		}
		*/
		
		RuleDAO rdao = new RuleDAOImpl(em);
		BusinessRuleTypeDAO brtdao = new BusinessRuleTypeDAOImpl(em);
		OperatorDAO odao = new OperatorDAOImpl(em);
		List<Operator> olijst = odao.findAll();
		List<BusinessRuleType> lijst = brtdao.findAll();
		
		//Rule r = rdao.findById(40);
		//r.generateAttributeRangeRule(r.determineRule(), );
		
		
		for(Rule r : rdao.findAll()){
			if(r.getSelected().equals("Y")){
				int zoek = r.getBrtid();
				int zoekop = r.getOprid();
				String ruletype="";
				String code="";
				String operator="";
				for(BusinessRuleType brt : lijst){
					if(brt.getBusinessRuleTypeID()==zoek){
						code = brt.getTemplate().getCode();
						ruletype = brt.getTypeNaam();
					}
				}
				for(Operator o : olijst){
					if(o.getOperatorID() == zoekop){
						operator = o.getOperatorNaam();
					}
				}
				
					r.generateCode(code);
				
			
				
				
			}
		}
		
		
		
		/*OperatorDAO odao = new OperatorDAOImpl(em);
		List<Operator> operators = odao.findAll();
		for (Operator op : operators) {
			System.out.print("Id: " + op.getOperatorID());
			System.out.print(", First Name: " + op.getOperatorNaam() + "\n");	
		}*/
		
		
		/*
		CategoryDAO cdao = new CategoryDAOImpl(em);
		List<Category> cats = cdao.findAll();
		for(Category c : cats){
			System.out.println(" : "+c.getCategoryNaam());
		}
		*/
		
		
	}

}
