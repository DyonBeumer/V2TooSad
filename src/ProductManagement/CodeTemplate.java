package ProductManagement;

import javax.persistence.*;

@Entity
@Table(name="CODE_TEMPLATE")
public class CodeTemplate {
	
	@Column(name="CODE")
	private String code;
	@Column(name ="LANGUAGE")
	private String language;
	@Id
	@Column(name="CODETEMPLATE_ID")
	private int CodeTemplateID;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "BRT_BRT_ID", referencedColumnName = "BUSINESSRULETYPE_ID")
	private BusinessRuleType businessruletype;
	
	
	
	public BusinessRuleType getBusinessruletype() {
		return businessruletype;
	}
	public void setBusinessruletype(BusinessRuleType businessruletype) {
		this.businessruletype = businessruletype;
	}
	public CodeTemplate(){}
	public int getCodeTemplateID() {
		return CodeTemplateID;
	}
	public void setCodeTemplateID(int codeTemplateID) {
		CodeTemplateID = codeTemplateID;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
