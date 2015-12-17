package Product;
import java.util.ArrayList;

public class Rule {
	private String customCode;
	public ArrayList<Value> values = new ArrayList<Value>();
	public ArrayList<Kolom> kolommen = new ArrayList<Kolom>();
	public Rule(ArrayList<Value> vl, ArrayList<Kolom> kolom, String cc){
		values = vl;
		kolommen = kolom;
		customCode = cc;
	}
	public String getCustomCode() {
		return customCode;
	}
	public void setCustomCode(String customCode) {
		this.customCode = customCode;
	}
	public ArrayList<Value> getValues() {
		return values;
	}
	public void setValues(ArrayList<Value> values) {
		this.values = values;
	}
	public ArrayList<Kolom> getKolommen() {
		return kolommen;
	}
	public void setKolommen(ArrayList<Kolom> kolommen) {
		this.kolommen = kolommen;
	}

	
}