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
		List<BusinessRuleType> lijst = brtdao.findAll();
		for(BusinessRuleType brt : lijst){
			System.out.println(brt.getTypeNaam());
			System.out.println(brt.template);
			System.out.println(brt.getTemplate().getCode());
		}
		
		//Rule r = rdao.findById(40);
		//r.generateAttributeRangeRule(r.determineRule(), );
		
		/*
		for(Rule r : rdao.findAll()){
			if(r.getSelected().equals("Y")){
				int zoek = r.getBrtid();
				String code="";
				for(BusinessRuleType brt : lijst){
					if(brt.getBusinessRuleTypeID()==zoek){
						code = brt.getCode();
					}
				}
				r.generate(brtdao.findAll());
			}
			System.out.println("Ruleinfo "+ r.getKolommen().get(0).getkolomNaam());
			System.out.println("test: "+ r.getKolommen().get(0).getTabellen().get(0).getTabelNaam());
			for(Value v : r.getValues()){
				System.out.println("Values: " + v.getValueWaarde());
				
			}
			
		}
		*/
		
		
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
