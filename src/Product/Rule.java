package Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.stringtemplate.v4.ST;

import ProductManagement.BusinessRuleType;
import ProductManagement.Operator;

@Entity
@Table(name = "RULE")
public class Rule {
	@Id
	@Column(name = "RULE_ID")
	private int ruleId;
	@Column(name = "CUSTOMCODE")
	private String customCode;
	@Column(name = "FAILMESSAGE")
	private String failuremessage;
	@Column(name = "SELECTED")
	private String selected;
	@OneToMany
	@JoinColumn(name = "RULE_RULE_ID")
	private List<Value> values = new ArrayList<Value>();
	@OneToMany
	@JoinColumn(name = "RULE_RULE_ID")
	private List<Kolom> kolommen = new ArrayList<Kolom>();
	@ManyToOne
	@JoinColumn(name="BUSINESSRULETYPE_BRT_ID")
	private BusinessRuleType brt;
	@ManyToOne
	@JoinColumn(name="OPERATOR_OPERATOR_ID", nullable = true)
	private Operator op;
	
	
	public BusinessRuleType getBrt() {
		return brt;
	}

	public void setBrt(BusinessRuleType brt) {
		this.brt = brt;
	}

	public Operator getOp() {
		return op;
	}

	public void setOp(Operator op) {
		this.op = op;
	}

	public String getCodeTemplate() {
		return brt.getTemplate().getCode();
	}

	public List<Kolom> getKolommen() {
		Collections.sort(kolommen);
		return kolommen;
	}

	public void setKolommen(List<Kolom> kolommen) {
		this.kolommen = kolommen;
	}

	public Rule() {
	}
	public String getCustomCode() {
		return customCode;
	}

	public void setCustomCode(String customCode) {
		this.customCode = customCode;
	}

	public List<Value> getValues() {
		Collections.sort(values);
		return values;
	}

	public void setValues(ArrayList<Value> values) {
		this.values = values;
	}

	public String getFailuremessage() {
		return failuremessage;
	}

	public void setFailuremessage(String failuremessage) {
		this.failuremessage = failuremessage;
	}

	public String getSelected() {
		return selected;
	}

	public int getValueAmount() {
		
		int values = 0;

		for (int i = 0; i < getCodeTemplate().length(); i++) {
			String checkValue = "<VALUE" + i + ">";
			if (getCodeTemplate().contains(checkValue)) {
				values++;
			}
		}
		return values;
	}

	public boolean hasOperator() {

		boolean operator = false;
		if (getCodeTemplate().contains("<OPERATOR>")) {
			operator = true;
		}
		return operator;
	}

	public int getColumnAmount() {
		
		int columns = 0;
		for (int i = 0; i < getCodeTemplate().length(); i++) {
			String checkColumn = "<COLUMN" + i + ">";
			if (getCodeTemplate().contains(checkColumn)) {
				columns++;
			}
		}
		return columns;

	}

	public boolean hasValueList() {
		
		boolean hasValueList = false;
		for (int i = 0; i < getCodeTemplate().length(); i++) {
			String checkColumn = "<VALUELIST>";
			if (getCodeTemplate().contains(checkColumn)) {
				hasValueList = true;
			}
		}
		return hasValueList;
	}

	public int getTableAmount() {
		
		int tables = 0;
		for (int i = 0; i < getCodeTemplate().length(); i++) {
			String checkTable = "<TABLE" + i + ">";
			if (getCodeTemplate().contains(checkTable)) {
				tables++;
			}
		}
		return tables;
	}

	
	public void setSelected(String selected) {
		this.selected = selected;
	}

	public int getRuleId() {
		return ruleId;
	}

	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}

	
}
