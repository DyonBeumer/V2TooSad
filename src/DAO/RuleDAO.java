package DAO;

import java.util.List;

import Product.Rule;

public interface RuleDAO extends GenericDao<Rule> {
	List<Rule> findAllToBeGenerated();

}
