package Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.stringtemplate.v4.ST;

public class PLSQLGenerator implements GeneratorService{

	@Override
	public String generateCode(Rule r) {
			Collections.sort(r.getKolommen());
			String ct = r.getBrt().getTemplate().getCode();
			ST st = new ST(ct);
			List<Value> values = r.getValues();
			st.add("NAME", generateName(r));
			int valueint = r.getValueAmount();
			int columnint = r.getColumnAmount();
			int tableint = r.getTableAmount();
			List<Kolom> kolommen = r.getKolommen();
			boolean hasOperator = r.hasOperator();
			if (!r.hasValueList()) {
				Collections.sort(values);
				for (int i = 1; i <= valueint; i++) {
					st.add(("VALUE" + i), values.get((i - 1)).getValueWaarde());
				}
			}
			else if(r.hasValueList()){
				String valueList ="";
				Collections.sort(values);
				for(int i = 0; i < values.size(); i++){
					valueList = valueList + values.get(i).getValueWaarde()+ ", ";
					
				}
				valueList = valueList.substring(0,valueList.length()-2);
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
			}
			if (r.getOp() != null) {
				st.add("OPERATOR", r.getOp().getOperatorNaam());
			}
			
			if (r.getCustomCode() != null) {
				st.add("CUSTOMCODE", r.getCustomCode());
			}
			for (int i = 1; i <= columnint; i++) {
				st.add(("COLUMN" + i), kolommen.get(i - 1).getkolomNaam());

			}
			st.add(("FAILMESSAGE"), r.getFailuremessage());
			System.out.println(st.render());
			return st.render();
		}
	

	@Override
	public String generateName(Rule r) {
		return "BRG_" + r.getBrt().getAfkorting() + "_" + r.getKolommen().get(0).getTabel().getTabelNaam().substring(0, 3) + "_" + r.getRuleId();
	}

	
}
