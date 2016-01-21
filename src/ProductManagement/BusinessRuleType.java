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
	private CodeTemplate template;
	@Column(name = "AFKORTING")
	private String afkorting;
//	@ManyToOne
//	@JoinColumn(name="CATEGORY_CATEGORY_ID")
//	private Category category;
//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}

	public String getAfkorting() {
		return afkorting;
	}

	public void setAfkorting(String afkorting) {
		this.afkorting = afkorting;
	}

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
		
	}
	
	
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

	
}