package ProductManagement;

import java.util.ArrayList;

import Product.ProductFacade;

public class BusinessRule_Type {
	private String typeNaam;
	private String failureMessage;
	private ArrayList<Operator> oplst;
	//public CodeStrategy codeTemplate;
	
	
	public BusinessRule_Type(String typeNaam, String failureMessage, ArrayList<Operator> list/*, CodeStrategy codeTemplate*/) {
		super();
		this.typeNaam = typeNaam;
		this.failureMessage = failureMessage;
		oplst = list;
		//this.codeTemplate = codeTemplate;
	}
	
	
	/*public BusinessRule_Type(String string, String string2,
			ArrayList<Operator> createOperatorList) {
		this.typeNaam = string;
		this.failureMessage = string2;
		oplst = createOperatorList;
	}*/


	public String getFailureMessage() {
		return failureMessage;
	}
	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}
	
	public String getTypeNaam() {
		return typeNaam;
	}
	public void setTypeNaam(String typeNaam) {
		this.typeNaam = typeNaam;
	}
	

	public ArrayList<Operator> getOplst() {
		if(oplst != null){
		return oplst;
		}
		else{
			return new ArrayList<Operator>();
		}
	}
	public void addOp(Operator o){
		if(oplst != null){
		oplst.add(o);
		}
	}

	public void setOplst(ArrayList<Operator> oplst) {
		this.oplst = oplst;
	}
	

}