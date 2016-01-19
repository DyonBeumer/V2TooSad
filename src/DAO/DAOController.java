package DAO;



import java.sql.Connection;
import java.util.Collections;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


import Client.ConnectionInterface;
import Client.OracleConnection;
import Product.PLSQLGenerator;
import Product.Rule;

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
		PLSQLGenerator gen = new PLSQLGenerator();
		Connection c = connection.getConnection();
		RuleDAO rdao = new RuleDAOImpl(em);
		
		for(Rule r : rdao.findAll()){
			if(r.getSelected().equals("Y")){
				Collections.sort(r.getKolommen());
				connection.sendQuery(c,gen.generateCode(r));}
		}
	}
}
