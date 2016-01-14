package Client;
import java.util.ArrayList;

import org.stringtemplate.v4.*;

import Product.Kolom;
import Product.ProductFacade;
import Product.Tabel;
import ProductManagement.BusinessRuleType;
import ProductManagement.ProductManagementFacade;
import Product.Value;

//to interface -> pl_sql implements it, to generate rules in any language
public class Template_builder {
	private static int nr = 0;
	
	public String GenerateAttributeRangeRule(Tabel t, Kolom k, ArrayList<Value> lst, BusinessRule_Type b){
		
		String ruleCode = "ARNG"+(nr+1);
		ProductFacade pf = new ProductFacade();
		ProductManagementFacade pmf = new ProductManagementFacade();
		
		ST code = new ST("create or replace TRIGGER <rulecode> before insert or update on <tabel> declare error1 exception; begin if :new.<knaam> <operator> <val1> and <val2> then raise error1; end if; exception when error1 then raise_application_error(-20002, '<failuremsg>');end;");
		code.add("rulecode", ruleCode);
		code.add("tabel", t.getTabelNaam());
		code.add("knaam", k.getkolomNaam());
		code.add("operator", "Between");
		code.add("val1", lst.get(0).getValueWaarde());
		code.add("val2", lst.get(1).getValueWaarde());
		code.add("failuremsg", b.getFailureMessage());
		String out = code.render();
		System.out.println(out);
		//String code = "create or replace TRIGGER" + ruleCode;
		
		return out;
	}
	public String GenerateAttributeCompareRule()
	{
		String out = "";
		return out;
	}

}
