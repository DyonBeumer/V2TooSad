package Client;

import java.util.ArrayList;

import Product.ProductFacade;
import Product.Value;
import ProductManagement.PL_SQL;
import ProductManagement.ProductManagementFacade;


public class Client {

		public static void main(String[] args) {
	
			ProductFacade pf = new ProductFacade();
			ProductManagementFacade f = new ProductManagementFacade();
			
			//simulatie input vanuit database
			Template_builder t = new Template_builder();
			ArrayList<Value> list = pf.maakValuelijst(pf.createValue("1",0));
			list.add(pf.createValue("10", 1));
			
			t.GenerateAttributeRangeRule(
					pf.createTabel("Customers"),
					pf.createKolom("Leeftijd"),list,
					f.createBusinessRuleType("AttributeRangeRule","Invalid input", 
							f.createOperatorList(f.createOperator("Between")
							)
						)
					);
			
			/*
			//product
			ProductController p = new ProductController();
			Tabel T = new Tabel("Customers");
			Kolom k = new Kolom("Leeftijd");
			Value v1 = new Value("1",0);
			Value v2 = new Value("10",1);
			Rule r = new Rule(tlist,klist,"");
			//productmanagement
			BusinessRule_Type b = new BusinessRule_Type("AttribuutCompareRangeRule", "Invalid input", new PL_SQL());
			Operator o = new Operator("Between");
			b.addOp(o);
			f.maakCategory(f.maakRuleTypeList(b), "Static Data Constraint Rules");
			System.out.println(f.voegOperatorToe(b, o).getOplst());
			Template_builder t = new Template_builder();
			ArrayList<Value> lst = pf.maakValuelijst(v1);
			t.GenerateAttributeRangeRule(T,k,pf.voegValueToe(lst, v2), b);
			*/
		}

	}

