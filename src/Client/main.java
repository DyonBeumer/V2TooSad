package Client;

import java.util.ArrayList;

import Product.*;
import ProductManagement.*;

public class main {

	public static void main(String[] args) {
		
		//product
		//ProductController p = new ProductController();
		
		Tabel T = new Tabel("Customers");
		Kolom k = new Kolom("Leeftijd");
		Value v1 = new Value("1",0);
		Value v2 = new Value("10",1);
		
		ProductFacade pf = new ProductFacade();
		
//		Rule r = new Rule(tlist,klist,"");
		
		
		//productmanagement
		BusinessRule_Type b = new BusinessRule_Type("AttribuutCompareRangeRule", "Invalid input", new PL_SQL());
		Operator o = new Operator("Between");
		b.addOp(o);
		ProductManagementFacade f = new ProductManagementFacade();
		
		f.maakCategory(f.maakRuleTypeList(b), "Static Data Constraint Rules");
		//System.out.println(f.voegOperatorToe(b, o).getOplst());
		
		Template_builder t = new Template_builder();
		ArrayList<Value> lst = pf.maakValuelijst(v1);
		t.GenerateAttributeRangeRule(T,k,pf.voegValueToe(lst, v2), b);
		
		
		
	}

}
