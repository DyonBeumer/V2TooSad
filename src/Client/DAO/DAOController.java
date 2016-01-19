package Client.DAO;



import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import oracle.jdbc.dcn.DatabaseChangeEvent;
import Client.ConnectionInterface;
import Client.OracleConnection;
import Product.Rule;
import ProductManagement.BusinessRuleType;
import ProductManagement.Operator;

public class DAOController {

	private static EntityManagerFactory entityManagerFactory;
	
	public void run() {
		EntityManager em = null;
		try {
			entityManagerFactory = HibernateUtil.getEntityManagerFactory();
			em = entityManagerFactory.createEntityManager();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		
		ConnectionInterface connection = new OracleConnection();
		Connection c = connection.getConnection();
		RuleDAO rdao = new RuleDAOImpl(em);
		BusinessRuleTypeDAO brtdao = new BusinessRuleTypeDAOImpl(em);
		OperatorDAO odao = new OperatorDAOImpl(em);
		List<Operator> olijst = odao.findAll();
		List<BusinessRuleType> lijst = brtdao.findAll();
		
		
		for(Rule r : rdao.findAll()){
			if(r.getSelected().equals("Y")){
				Collections.sort(r.getKolommen());
				int zoek = r.getBrtid();
				int zoekop=0;
				if(r.getOprid() != null){
					zoekop = r.getOprid();
				}
				
				String rulenaam="BRG_";
				String code="";
				String operator="";
				
				for(BusinessRuleType brt : lijst){
					if(brt.getBusinessRuleTypeID()==zoek){
						code = brt.getTemplate().getCode();
						rulenaam = rulenaam + brt.getAfkorting() + "_";
					}
				}
				rulenaam = rulenaam + r.getKolommen().get(0).getTabel().getTabelNaam().substring(0, 3) + "_" +r.getRuleId();
				for(Operator o : olijst){
					if(o.getOperatorID() == zoekop){
						operator = o.getOperatorNaam();
					}
				}
				if (operator != null){
				
					connection.sendQuery(c,r.generateCode(code,operator, rulenaam));
					
				}
				else {
					connection.sendQuery(c,r.generateCode(code,null, rulenaam));}
				
			
				
				
			}
		}
		
		
	}


}
