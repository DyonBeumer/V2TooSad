package Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

import org.stringtemplate.v4.ST;

import ProductManagement.BusinessRuleType;
import ProductManagement.ProductManagementFacade;

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
	@Column(name = "BUSINESSRULETYPE_BRT_ID")
	private int brtid;
	@Column(name = "OPERATOR_OPERATOR_ID")
	private int oprid;

	public int getOprid() {
		return oprid;
	}

	public void setOprid(int oprid) {
		this.oprid = oprid;
	}

	// public ArrayList<Kolom> kolommen = new ArrayList<Kolom>();
	public String getCodeTemplate() {
		ProductManagementFacade pmf = new ProductManagementFacade();
		return pmf.getCode(brtid);
	}

	public int getBrtid() {
		return brtid;
	}

	public void setBrtid(int brtid) {
		this.brtid = brtid;
	}

	public List<Kolom> getKolommen() {
		return kolommen;
	}

	public void setKolommen(List<Kolom> kolommen) {
		this.kolommen = kolommen;
	}

	public Rule() {
	}

	public Rule(ArrayList<Value> vl, /* ArrayList<Kolom> kolom, */String cc) {
		values = vl;
		/* kolommen = kolom; */
		customCode = cc;
	}

	public String getCustomCode() {
		return customCode;
	}

	public void setCustomCode(String customCode) {
		this.customCode = customCode;
	}

	public List<Value> getValues() {
		return values;
	}

	public void setValues(ArrayList<Value> values) {
		this.values = values;
	}

	/*
	 * public ArrayList<Kolom> getKolommen() { return kolommen; } public void
	 * setKolommen(ArrayList<Kolom> kolommen) { this.kolommen = kolommen; }
	 */
	public String getFailuremessage() {
		return failuremessage;
	}

	public void setFailuremessage(String failuremessage) {
		this.failuremessage = failuremessage;
	}

	public String getSelected() {
		return selected;
	}

	public int getValueAmount(String ct) {
		int values = 0;

		for (int i = 0; i < ct.length(); i++) {
			String checkValue = "<VALUE" + i + ">";
			if (ct.contains(checkValue)) {
				values++;
			}
		}
		return values;
	}

	public boolean hasOperator(String ct) {
		boolean operator = false;
		if (ct.contains("<OPERATOR>")) {
			operator = true;
		}
		return operator;
	}

	public int getColumnAmount(String ct) {
		int columns = 0;
		for (int i = 0; i < ct.length(); i++) {
			String checkColumn = "<COLUMN" + i + ">";
			if (ct.contains(checkColumn)) {
				columns++;
			}
		}
		return columns;

	}

	public boolean hasValueList(String ct) {
		boolean hasValueList = false;
		for (int i = 0; i < ct.length(); i++) {
			String checkColumn = "<VALUELIST>";
			if (ct.contains(checkColumn)) {
				hasValueList = true;
			}
		}
		return hasValueList;
	}

	public int getTableAmount(String ct) {
		int tables = 0;
		for (int i = 0; i < ct.length(); i++) {
			String checkTable = "<TABLE" + i + ">";
			if (ct.contains(checkTable)) {
				tables++;
			}
		}
		return tables;
	}

	public String generateCode(String ct, String operator) {
		ST st = new ST(ct);
		int valueint = getValueAmount(ct);
		System.out.println(valueint);
		int columnint = getColumnAmount(ct);
		System.out.println(columnint);
		int tableint = getTableAmount(ct);
		boolean hasOperator = hasOperator(ct);
		if (!hasValueList(ct)) {
			Collections.sort(values);
			for (int i = 1; i <= valueint; i++) {
				
				st.add(("VALUE" + i), values.get((i - 1)).getValueWaarde());
				System.out.println(values.get((i - 1)).getValueWaarde());
			}
		}
		else if(hasValueList(ct)){
			String valueList ="";
			Collections.sort(values);
			for(int i = 0; i < values.size(); i++){
				valueList = valueList + values.get(i).getValueWaarde()+ ", ";
				
			}
			valueList = valueList.substring(0,valueList.length()-2);
			System.out.println("kaas");
			st.add("VALUELIST", valueList);
		}
		ArrayList<String> hulp = new ArrayList<String>();
		for (int i = 1; i <= tableint; i++) {
			for (int i2 = 1; i2 <= columnint; i2++) {
				if (!hulp.contains(kolommen.get(i2 - 1).getTabel()
						.getTabelNaam())) {
					hulp.add(kolommen.get(i2 - 1).getTabel().getTabelNaam());
				}
			}
			st.add(("TABLE" + i), hulp.get(i - 1));
			System.out.println("adding: Tabel" + i + " = " + hulp.get(i - 1));
		}
		if (operator != null) {
			st.add("OPERATOR", operator);
		}
		if (customCode != null) {
			st.add("CUSTOMCODE", customCode);
		}
		for (int i = 1; i <= columnint; i++) {
			st.add(("COLUMN" + i), kolommen.get(i - 1).getkolomNaam());

		}
		st.add(("FAILMESSAGE"), failuremessage);
		System.out.println(st.render());
		return st.render();

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

	public String determineRule() {
		return new String(
				"create or replace TRIGGER ATTRIBUUTRANGERULE BEFORE INSERT OR UPDATE ON <TABLE> for each row declar error1 EXCEPTION; BEGIN IF :new.<KOLOM> <OPERATOR> <VALUE1> and <VALUE2> THEN RAISE error1; end if; EXCEPTION when error1 then raise_application_error(-20002, '<FAILMESSAGE>'); END;");
	}

	public void generateAttributeRangeRule(String codetemplate, String operator) {
		ST code = new ST(codetemplate);
		code.add("TABLE", kolommen.get(0).getTabel().getTabelNaam());
		code.add("KOLOM", kolommen.get(0).getkolomNaam());
		code.add("OPERATOR", operator);
		code.add("VALUE1", values.get(0).getValueWaarde());
		code.add("VALUE2", values.get(1).getValueWaarde());
		code.add("FAILMESSAGE", failuremessage);
		// System.out.println(code.render());
	}

	public void generateAttributeCompareRule(String codetemp, String operator) {
		ST code = new ST(codetemp);
		code.add("TABLE", kolommen.get(0).getTabel().getTabelNaam());
		code.add("KOLOM", kolommen.get(0).getkolomNaam());
		code.add("OPERATOR", operator);
		code.add("VALUE1", values.get(0).getValueWaarde());
		code.add("FAILMESSAGE", failuremessage);
		// System.out.println(code.render());
		Map<String, Object> test = new HashMap<String, Object>();
		test = code.getAttributes();
		System.out.println("kaas");
		test.values().toString();

	}
}
