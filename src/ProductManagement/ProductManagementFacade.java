package ProductManagement;

import java.util.ArrayList;

public class ProductManagementFacade {
	/*
	public CodeStrategy getCodeTemplate(CodeStrategy cs){
		if(cs instanceof PL_SQL){
			PL_SQL code = (PL_SQL)cs;
			return code;
		}
		else{
			return null;
		}
	}
	*/
	public Category maakCategory(ArrayList<BusinessRule_Type> ls, String nm){
		return new Category(ls,nm);
	}
	
	public ArrayList<BusinessRule_Type> maakRuleTypeList(BusinessRule_Type b){
		ArrayList<BusinessRule_Type> lst = new ArrayList<BusinessRule_Type>();
		lst.add(b);
		return lst;
	}
	public ArrayList<BusinessRule_Type> voegBRTypeToe(ArrayList<BusinessRule_Type> lst, BusinessRule_Type b){
		if(!lst.contains(b)){
			lst.add(b);
		}
		return lst;
	}
	public BusinessRuleType voegOperatorToe(BusinessRuleType b, Operator o){
		ArrayList<Operator> lst = b.getOplst();
		lst.add(o);
		return b;
		
	}

	public Operator createOperator(String string) {
		return new Operator();
	}

	public ArrayList<Operator> createOperatorList(Operator createOperator) {
		ArrayList<Operator> list = new ArrayList<Operator>();
		list.add(createOperator);
		return list;
	}

	public BusinessRuleType createBusinessRuleType(String string, String string2, ArrayList<Operator> createOperatorList) {
		return new BusinessRuleType();		
	}

	public String getCode(int brtid) {
		return null;
		
	}
	
	
	
	
}