package ProductManagement;

import javax.persistence.*;

@Entity
@Table(name = "BUSINESSRULETYPE")
public class BusinessRuleType {
	@Column(name = "TYPENAAM")
	private String typeNaam;
	@Id
	@Column(name = "BUSINESSRULETYPE_ID")
	private int BusinessRuleTypeID;
	@OneToOne(mappedBy = "businessruletype")
	public CodeTemplate template;
	//public CodeStrategy codeTemplate;
	
	public CodeTemplate getTemplate() {
		return template;
	}

	public void setTemplate(CodeTemplate template) {
		this.template = template;
	}

	public BusinessRuleType(){}
	
	public BusinessRuleType(String typeNaam, String failureMessage) {
		super();
		this.typeNaam = typeNaam;
		//this.codeTemplate = codeTemplate;
	}
	
	
	/*public BusinessRule_Type(String string, String string2,
			ArrayList<Operator> createOperatorList) {
		this.typeNaam = string;
		this.failureMessage = string2;
		oplst = createOperatorList;
	}*/


	public String getTypeNaam() {
		return typeNaam;
	}
	public void setTypeNaam(String typeNaam) {
		this.typeNaam = typeNaam;
	}


	public int getBusinessRuleTypeID() {
		return BusinessRuleTypeID;
	}


	public void setBusinessRuleTypeID(int businessRuleTypeID) {
		BusinessRuleTypeID = businessRuleTypeID;
	}

	public String getCode() {
		return new String("");
	}
}